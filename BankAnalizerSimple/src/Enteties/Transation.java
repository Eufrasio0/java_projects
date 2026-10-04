package Enteties;

import java.util.Date;

public class Transation {
    private Date data;
    private double payment;
    private String LocalPayment;

    public Transation(Date data, double payment) {
        this.data = data;
        this.payment = payment;
    }

    public Date getData() {
        return data;
    }

    public double getPayment() {
        return payment;
    }

    public String getLocal() {
        return LocalPayment;
    }

    public void setLocal(String LocalPayment) {
        this.LocalPayment = LocalPayment;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    // ---------------------------- methods -----------------------------


    
}
