package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Enteties.BankStatement;
import Enteties.Transation;


public class ReadBankStatementCSVParser {

    private final Path path;



    public ReadBankStatementCSVParser(String filePath) {
        this.path = Paths.get(filePath);
    }

    //-----------------Funcao de gerar objeto transacao a partir de um arquivo CSV-----------------

        private String[] parseCSVLine(String line) {

        List<String> columns = new ArrayList<>();
        StringBuilder column = new StringBuilder();

        boolean insideQuotes = false;

        for (char c : line.toCharArray()) {

            if (c == '"') {
                insideQuotes = !insideQuotes;
            }
            else if (c == ',' && !insideQuotes) {
                columns.add(column.toString());
                column.setLength(0);
            }
            else {
                column.append(c);
            }
        }

        columns.add(column.toString());

        return columns.toArray(new String[0]);
    }

    public void ChargeBankStatement( BankStatement bankStatement) throws IOException, ParseException {

    List<String> lines = Files.readAllLines(path);

    if (lines.isEmpty()) {
        System.out.println("O arquivo está vazio.");
        return;
    }

    SimpleDateFormat formatter =
        new SimpleDateFormat("yyyy-MM-dd");

    // Começa em 1 para ignorar o cabeçalho
    for (int i = 1; i < lines.size(); i++) {

        String line = lines.get(i);

        String[] columns = parseCSVLine(line);

        Date data = formatter.parse(columns[0]);

        String hour = columns[1];

        String type = columns[2];

        String localPayment = columns[3];

        String paymentString = columns[4]
            .replaceAll("[^0-9,.-]", "")
            .replace(",", ".");
        double payment = Double.parseDouble(paymentString);
        

        Transation transation = new Transation(
            data,
            hour,
            payment,
            type,
            localPayment
        );

        bankStatement.addTransation(transation);
    }
    }
}
