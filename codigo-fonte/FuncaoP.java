package ed_aps;

/**
 * Classe que manipula uma pilha, usada para a operação de conversão de decimal
 * para binário.
 */
public class FuncaoP {

    private int quantidade;
    private Celula topo;

    /**
     *
     */
    public FuncaoP() {
        this.quantidade = 0;
        this.topo = null;
    }

    /**
     * Método que recebe um dígito do valor decimal que o usuário digitou, o
     * colocando numa pilha.
     *
     * @param valor
     */
    public void empilha(long valor) {
        Celula aux = this.topo;
        this.topo = new Celula(valor);
        this.topo.setProximoPL(aux);
        this.quantidade++;
    }

    /**
     * Método que desempilha os valores da pilha.
     *
     * @return o valor.
     */
    public long desempilha() {
        long valor = this.topo.getValorPL();
        this.topo = this.topo.getProximoPL();
        this.quantidade--;
        return valor;
    }

}