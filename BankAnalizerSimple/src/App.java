import Service.BankStatement;
import Service.BankStatementCSVParser;



public class App {

    public static void main(String[] args) {
        BankStatementCSVParser statement = new BankStatementCSVParser("src/Repositories/ExtratoBancarioExemplo.csv");
        statement.analyzeStatement();
        statement.PrintStatement();
    }
}
