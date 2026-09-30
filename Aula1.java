package Aula;
import java.util.Locale;
import java.util.Scanner;

import util.CurrencyConverter;

public class Aula1 {
    public static void main( String[] args){
        Locale.setDefault(Locale.US);
        Scanner Var = new Scanner(System.in);
        int esc = -1;
        while (esc != 0) {
        System.out.println("Digite 0 para finalizar, caso contrario outro valor");
        esc = Var.nextInt();
        System.out.println("Digite o preço atual do dollar");
        double dollarPrice = Var.nextDouble();
        System.out.println("Quantos dollares voce ira querer?");
        double dollarRequeret = Var.nextDouble();
        double finalPrice = CurrencyConverter.converteDollar(dollarPrice, dollarRequeret);
        System.out.println("Voce devera pagar (Taxas ja inclusas):");
        System.out.printf("%.2f %n", finalPrice);
        }
        Var.close();
    }
    
}


