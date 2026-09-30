import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class App {
    public static void main(String[] args){
        int tam = 0;
        Scanner sc = new Scanner(System.in);
        List<Funcionario> lista = new ArrayList<>();
        System.out.println("Digite o numero de funcionarios: ");
        do{
            try{
                tam = sc.nextInt();
                if(tam <=0){
                System.out.println("Entrada inválida. Por favor, digite um número inteiro positivo.");
            }
            }catch(Exception e){
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                sc.nextLine();
            }
        }while(tam <= 0);

        while(tam != lista.size()){
            System.out.println("Funcionario tercerizado? (s/n)");
            try{
                String resposta = sc.next();
                if(resposta.equalsIgnoreCase("s")){
                    System.out.println("Digite o nome do funcionario: ");
                    String nome = "";
                    try{
                        nome = sc.next();
                    } catch(Exception e){
                        System.out.println("Erro, digite um dado do tipo string");
                        sc.nextLine();
                    }
                    System.out.println("Digite o numero de horas trabalhadas: ");
                    int horas = sc.nextInt();
                    System.out.println("Digite o valor por hora: ");
                    double valorPorHora = sc.nextDouble();
                    System.out.println("Digite a taxa adicional: ");
                    double taxaAdicional = sc.nextDouble();
                    FuncionarioTercerizado funcionario = new FuncionarioTercerizado(nome, horas, valorPorHora, taxaAdicional);
                    lista.add(funcionario);

                }
                else if(resposta.equalsIgnoreCase("n")){
                    System.out.println("Digite o nome do funcionario: ");
                    String nome = "";
                    try{
                        nome = sc.next();
                    } catch(Exception e){
                        System.out.println("Erro, digite um dado do tipo string");
                        sc.nextLine();
                    }
                    System.out.println("Digite o numero de horas trabalhadas: ");
                    int horas = sc.nextInt();
                    System.out.println("Digite o valor por hora: ");
                    double valorPorHora = sc.nextDouble();
                    Funcionario funcionario = new Funcionario(nome, horas, valorPorHora);
                    lista.add(funcionario);
                }
            } catch(Exception e){
                System.out.println("Erro, digite um dado do tipo string");
                sc.nextLine();
            }
            
        }
        for(Funcionario funcionario : lista){
            System.out.println(funcionario.toString());
        }
        sc.close();
        
        String caminhoArquivo = "C:\\Users\\Eufrasio\\OneDrive\\Desktop\\Java\\funcionario.txt";
        File arquivo = new File(caminhoArquivo);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            for (Funcionario funcionario : lista) {
                writer.write(funcionario.toString());
                writer.newLine();
            }
            System.out.println("Arquivo criado com sucesso em: " + caminhoArquivo);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
        }


    }
}
