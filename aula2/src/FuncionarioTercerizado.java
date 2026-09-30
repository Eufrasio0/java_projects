public class FuncionarioTercerizado extends Funcionario {
    private double taxaAdicional;
    
    public FuncionarioTercerizado() {
        super("", 0, 0);
        this.taxaAdicional = 0;
    }

    public FuncionarioTercerizado(String nome, int horas, double valorPorHora, double taxaAdicional) {
        super(nome, horas, valorPorHora);
        this.taxaAdicional = taxaAdicional;
    }


    @Override
    public double pagamento() {
        return super.pagamento() + 1.1 * taxaAdicional;
    }

    public double getTaxaAdicional() {
        return taxaAdicional;
    }

    @Override
    public String toString() {
        return super.toString() + " (Tercerizado) - Taxa Adicional: R$ " + String.format("%.2f", taxaAdicional);
    }
}
