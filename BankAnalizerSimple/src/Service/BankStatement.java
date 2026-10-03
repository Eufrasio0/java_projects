package Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankStatement {

    Date date;
    double Payment;
    String LocalPayment;

    List<BankStatement> bankStatements;

    public BankStatement(){
        this.bankStatements = new ArrayList<>();
    }

    public BankStatement(Date date, double Payment, String LocalPayment) {
        this();
        this.date = date;
        this.Payment = Payment;
        this.LocalPayment = LocalPayment;
    }

    public void AddBankStatement(Date date, double Payment, String LocalPayment) {
        this.bankStatements.add(new BankStatement(date, Payment, LocalPayment));
    }

    public void PrintStatement() {
        for (BankStatement statement : bankStatements) {
            System.out.println("-----------------------------");
            System.out.println("Data: " + statement.date);
            System.out.println("Pagamento: " + statement.Payment);
            System.out.println("Local de Pagamento: " + statement.LocalPayment);

        }
    }
    
}
