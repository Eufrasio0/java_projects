package Enteties;

import java.util.Date;

public class Transation {
    private Date data;
    private String hour;
    private double payment;
    private String type;
    private String localPayment;


    public Transation(Date data, String hour, double payment, String type, String localPayment) {
        this.data = data;
        this.hour = hour;
        this.payment = payment;
        this.type = type;
        this.localPayment = localPayment;
    }


    public Date getData() {
        return data;
    }

    public double getPayment() {
        return payment;
    }

    public String getLocal() {
        return localPayment;
    }

    public void setLocal(String localPayment) {
        this.localPayment = localPayment;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String toString() {
        return "Transation{" +
                "data=" + data +
                ", payment=" + payment +
                ", type='" + type + '\'' +
                ", localPayment='" + localPayment + '\'' +
                '}';
    }

    // ---------------------------- methods -----------------------------


    
}
