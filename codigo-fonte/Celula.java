package ed_aps;

public class Celula {

    private double valorLC;
    private Celula proximoLC;
    private Celula anteriorLC;

    private long valorPL;
    private Celula proximoPL;

    public double getValorLC() {
        return this.valorLC;
    }

    public Celula getProximoLC() {
        return this.proximoLC;
    }

    public void setProximoLC(Celula proximo) {
        this.proximoLC = proximo;
    }

    public Celula(double valor) {
        this.valorLC = valor;
        this.proximoLC = null;
        this.anteriorLC = null;
    }

    @Override
    public String toString() {
        // Converte inteiro para String
        return String.valueOf(this.getValorLC());
    }

    /**
     * @return the anterior
     */
    public Celula getAnteriorLC() {
        return anteriorLC;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnteriorLC(Celula anterior) {
        this.anteriorLC = anterior;
    }

    public Celula(long valor) {
        this.valorPL = valor;
        this.proximoPL = null;
    }

    /**
     * @return the valor
     */
    public long getValorPL() {
        return valorPL;
    }

    /**
     * @return the proximo
     */
    public Celula getProximoPL() {
        return proximoPL;
    }

    /**
     * @param proximo the proximo to set
     */
    public void setProximoPL(Celula proximo) {
        this.proximoPL = proximo;
    }

}
