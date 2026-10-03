import Service.BankStatement;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {
        BankStatement newStatement = new BankStatement();
        /*List<String> linhas = Files.readAllLines(Paths.get("arquivo.csv"));
        for (String linha : linhas) {
            String[] campos = linha.split(";"); // ou "," dependendo do separador
            System.out.println(campos[0] + " - " + campos[1]);
        }*/



        while(true) {
            System.out.println("Digite 1 para adicionar um novo extrato bancário ou 2 para sair:");
            int opcao = new java.util.Scanner(System.in).nextInt();

            if (opcao == 1) {
                System.out.println("Digite a data do extrato (formato: dd/MM/yyyy):");
                String dataStr = new java.util.Scanner(System.in).nextLine();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.util.Date data = sdf.parse(dataStr);

                System.out.println("Digite o valor do pagamento:");
                double pagamento = new java.util.Scanner(System.in).nextDouble();

                System.out.println("Digite a descricao do pagamento:");
                String descricao = new java.util.Scanner(System.in).nextLine();
                newStatement.AddBankStatement(data, pagamento, descricao);
            } else if (opcao == 2) {
                newStatement.PrintStatement();
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
