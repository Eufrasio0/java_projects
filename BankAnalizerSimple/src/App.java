import Service.BankStatement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class App {

    public static void main(String[] args) {

        String[] meses = {
            "Janeiro", "Fevereiro", "Março", "Abril",
            "Maio", "Junho", "Julho", "Agosto",
            "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        double[] totalPorMeses = new double[12];

        BankStatement newStatement = new BankStatement();

        Path path = Paths.get("src/Repositories/ExtratoBancarioExemplo.csv");

        try {

            List<String> lines = Files.readAllLines(path);

            if (lines.isEmpty()) {
                System.out.println("O arquivo está vazio.");
                return;
            }

            double total = 0;
            for (String line : lines) {

                String[] coluna = line.split(",");

                double pagamento = Double.parseDouble(coluna[1]);

                String[] data = coluna[0].split("-");
                int mes = Integer.parseInt(data[1]) - 1;

                totalPorMeses[mes] += pagamento;

                total += pagamento;
            }

            System.out.println("Total: " + total);

            System.out.println("Detalhamento por mês:");

            for (int i = 0; i < 12; i++) {
                System.out.println(meses[i] + ": " + totalPorMeses[i]);
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
