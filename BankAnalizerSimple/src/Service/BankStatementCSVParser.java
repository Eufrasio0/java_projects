package Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementCSVParser implements BankStatement {

    private final Path path;
    private double totality = 0.0;

    public BankStatementCSVParser(String filePath) {
        this.path = Paths.get(filePath);
    }

    public void analyzeStatement() {
        try {
            List<String> lines = Files.readAllLines(path);

            if (lines.isEmpty()) {
                System.out.println("O arquivo está vazio.");
                return;
            }

            for (String line : lines) {
                String[] columns = line.split(",");

                double payment = Double.parseDouble(columns[1]);
                totality += payment;
            }

            System.out.println("Total: " + totality);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: um valor do arquivo não é numérico.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: uma linha do CSV não possui as colunas esperadas.");
        }
    }

    public void PrintStatement(){
        try {
            List<String> lines = Files.readAllLines(path);

            if(lines.isEmpty()) {
                System.out.println("O arquivo está vazio.");
                return;
            }
            System.out.println("-----------------------------");
            System.out.println("|      Extrato Bancario:    |");
            System.out.println("-----------------------------");


            for (String line : lines) {
                 String[] columns = line.split(",");
                 System.out.println("-----------------------------");
                System.out.println("Data: " + (columns[0]));
                System.out.println("Valor: " + Double.parseDouble(columns[1]));
                System.out.println("Descricao: " + (columns[2]));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
