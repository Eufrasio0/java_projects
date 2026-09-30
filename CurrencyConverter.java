package util;

public class CurrencyConverter {

    public static final double Taxa = 1.06;

    public static double converteDollar(double valorAtual, double valorDesejado){
        return (valorAtual * valorDesejado) * Taxa;

    }

}

