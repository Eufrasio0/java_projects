package Services;

public class Geratriz {

    private final int numerador;
    private final int denominador;

    public Geratriz(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }
}