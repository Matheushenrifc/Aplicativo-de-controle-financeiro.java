package src.model;

public class MetasFinanceiras {
    private double objetivoEconomia;
    private double objetivoDespesas;

    public MetasFinanceiras(double objetivoEconomia, double objetivoDespesas) {
        this.objetivoEconomia = objetivoEconomia;
        this.objetivoDespesas = objetivoDespesas;
    }

    public double getObjetivoEconomia() {
        return objetivoEconomia;
    }

    public double getObjetivoDespesas() {
        return objetivoDespesas;
    }
}
