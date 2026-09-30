package util;

public class Conta {

    private static int ID = 0;

    private String name;
    private double saldo;
    private int number;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getSaldo(){
        return saldo;
    }

    public int getNumber(){
        return number;
    }

    public Conta(){
        this.number = ID++;
    }

    public Conta(String name, double saldo){
        this.name = name;
        this.saldo = saldo;
        this.number = ID++;
    }

    public boolean saque(double saque){
        if(saldo - saque < -5){
            return false;
        }
        saldo -= (saque + 5);
        return true;
    }

    public boolean deposito(double deposito){
        if(deposito <= 0){
            return false;
        }
        saldo += deposito;
        return true;
    }
}
