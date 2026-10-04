package Enteties;

import java.util.List;
import java.util.ArrayList;

public class BankStatement {

    private double totality = 0.0;
    private List<Transation> transations = new ArrayList<>();

    public BankStatement(){

    }

  public BankStatement(Transation transation) {
        this.transations.add(transation);

        if ("Pix enviado".equals(transation.getType())) {
            totality -= transation.getPayment();
        } else {
            totality += transation.getPayment();
        }
    }
    
    public List<Transation> getTransations() {
        return transations;
    }

    public void setTransations(List<Transation> transations) {
        this.transations = transations;
    }
    
    public void addTransation(Transation transation) {
        this.transations.add(transation);
        if ("Pix enviado".equals(transation.getType())) {
            totality -= transation.getPayment();
        } else {
            totality += transation.getPayment();
        }
    }

    public double getTotality() {
        return totality;
    }

    public void setTotality(double totality) {
        this.totality = totality;
    }
}
