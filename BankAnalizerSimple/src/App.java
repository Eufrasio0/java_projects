import java.io.IOException;
import java.text.ParseException;

import Service.BankStatementServices;
import Service.ReadBankStatementCSVParser;
import Enteties.BankStatement;



public class App {

    public static void main(String[] args) throws IOException, ParseException {

        BankStatement bankStatement = new BankStatement();
        ReadBankStatementCSVParser statement = new ReadBankStatementCSVParser("C:\\Users\\Eufrasio\\OneDrive\\Desktop\\Java\\BankAnalizerSimple\\src\\Repositories\\ExtratoRealPicPay.csv");
        statement.ChargeBankStatement(bankStatement);
        BankStatementServices bankStatementServices = new BankStatementServices();
        bankStatementServices.PrintStatement(bankStatement);
    }

}
