package ed_aps;

/**
 * Classe que manipula uma lista circular duplamente encadeada, usada para o
 * histórico de resultados das operações matemáticas.
 */
public class FuncaoLC {

    private Celula cabeca;
    private Celula cauda;
    private Celula c;

    /**
     *
     */
    public FuncaoLC() {
        this.cabeca = null;
        this.cauda = null;
    }

    /**
     * Método que adiciona no fim de uma lista circular duplamente encadeada um
     * valor.
     *
     * @param valor
     */
    public void adicionaNoFim(double valor) {
        Celula novo = new Celula(valor);
        if (this.getCabeca() == null) {
            this.setCabeca(novo);
            this.setCauda(novo);
        } else {
            Celula temp = this.getCauda();
            temp.setProximoLC(novo);
            this.setCauda(novo);
            novo.setAnteriorLC(temp);
        }
        this.getCauda().setProximoLC(this.getCabeca());
        this.getCabeca().setAnteriorLC(this.getCauda());
    }

    /**
     * Método que apaga todo o histórico da lista circular.
     */
    public void apagaHistorico() {
        this.cabeca = null;
        this.cauda = null;
    }

    /**
     * Método que move para frente o histórico de resultados anteriores. Caso
     * chegue no final, volta para o início.
     *
     * @return o valor de C.
     */
    public double moveFrente() {
        if (this.getC() == null) {
            setC(this.getCabeca());
            return getC().getValorLC();
        } else {
            setC(getC().getProximoLC());
            return getC().getValorLC();
        }
    }

    /**
     * Método que move para trás o histórico de resultados anteriores. Caso
     * chegue no começo, volta para o final.
     *
     * @return o valor de C.
     */
    public double moveAtras() {

        if (getC() == null) {
            setC(this.getCauda());
            setC(getC().getAnteriorLC());
            return getC().getValorLC();
        } else {
            setC(getC().getAnteriorLC());
            return getC().getValorLC();
        }
    }

    /**
     * @return the cabeca
     */
    public Celula getCabeca() {
        return cabeca;
    }

    /**
     * @param cabeca the cabeca to set
     */
    public void setCabeca(Celula cabeca) {
        this.cabeca = cabeca;
    }

    /**
     * @return the cauda
     */
    public Celula getCauda() {
        return cauda;
    }

    /**
     * @param cauda the cauda to set
     */
    public void setCauda(Celula cauda) {
        this.cauda = cauda;
    }

    /**
     * @return the c
     */
    public Celula getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Celula c) {
        this.c = c;
    }

}
