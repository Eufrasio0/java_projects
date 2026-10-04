package Service;
import java.text.SimpleDateFormat;

import Enteties.BankStatement;
import Enteties.Transation;

public class BankStatementServices implements BankStatementAnalyzer{

    public void PrintStatement(BankStatement bankStatement) {
         SimpleDateFormat formatter =
        new SimpleDateFormat("dd/MM/yyyy");
        for(Transation transation : bankStatement.getTransations()){
            System.out.println("--------------------------------------------");
            System.out.println("Date: " + formatter.format(transation.getData())); 
            System.out.println("Hour: " + transation.getHour()); 
        
            System.out.printf("Payment: %.2f%n", transation.getPayment());
            System.out.println("Type: " + transation.getType()); 
            System.out.println("Local: " + transation.getLocal()); 
        }
        System.out.println("--------------------------------------------");
        System.out.printf("Total: %.2f%n", bankStatement.getTotality());
        System.out.println("--------------------------------------------");
    }

    public void analyzeStatement(BankStatement bankStatement) {
        for(Transation transation : bankStatement.getTransations()){
            if("Pix enviado" == transation.getType()){
                bankStatement.setTotality(bankStatement.getTotality() - transation.getPayment());
            } else {
                bankStatement.setTotality(bankStatement.getTotality() + transation.getPayment());
            }
        }
    }

}
