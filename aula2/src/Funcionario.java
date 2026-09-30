public class Funcionario {
    private String nome;
    private int horas;
    private double valorPorHora;

    public Funcionario(String nome, int horas, double valorPorHora){
        this.nome = nome;
        this.horas = horas;
        this.valorPorHora = valorPorHora;
    }

    // GETTERS E SETTERS

    public double pagamento(){
        return horas * valorPorHora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
    //---------------------------------------------------------------------
    public String toString() {
        return nome + " - R$ " + String.format("%.2f", pagamento());
    }

}