package ed_aps;
import javax.swing.JOptionPane;

public class ED_APS {

    public static void main(String[] args) {

        String[] operacoes = {"+", "-", "X", "÷", "Histórico", "Outros", "Sair"};
        String[] historico = {"<-", "->", "Sair"};
        String[] conversao = {"dec -> bit", "bit -> dec", "√", "^", "Apagar Histórico", "Sair"};
        String[] escolha = {"Apagar", "Cancelar"};

        int opcao;
        int opcaoHistorico;
        int opcaoConversao;
        int opcaoEscolha;
        long numero;
        double valor = 0;
        String convertendo;

        Funcoes calculadora = new Funcoes();
        FuncaoLC l = new FuncaoLC();

        do {
            opcao = JOptionPane.showOptionDialog(null, "Qual operação deseja realizar?",
                    "Calculadora de dois números", 0, 3, null, operacoes, null);

            switch (opcao) {
                case 0:
                    valor = calculadora.soma();
                    JOptionPane.showMessageDialog(null, "Resultado da soma: \n" + valor, "Total", 1);
                    l.adicionaNoFim(valor);
                    break;

                case 1:
                    valor = calculadora.subtracao();
                    JOptionPane.showMessageDialog(null, "Resultado da subtração: \n" + valor, "Total", 1);
                    l.adicionaNoFim(valor);
                    break;
                case 2:
                    valor = calculadora.multiplicacao();
                    JOptionPane.showMessageDialog(null, "Resultado da multiplicação: \n" + valor, "Total", 1);
                    l.adicionaNoFim(valor);
                    break;
                case 3:
                    valor = calculadora.divisao();
                    valor = Math.round(valor * 100);
                    valor = valor / 100;

                    JOptionPane.showMessageDialog(null, "Resultado da divisão: \n" + valor, "Total", 1);
                    l.adicionaNoFim(valor);
                    break;

                case 4:
                    if (l.getCabeca() == null) {
                        JOptionPane.showMessageDialog(null, "Não há histórico ainda!", "AVISO", 2);
                    } else {
                        do {
                            opcaoHistorico = JOptionPane.showOptionDialog(null, valor, "Histórico", 0,
                                    1, null, historico, null);

                            switch (opcaoHistorico) {

                                case 0:
                                    valor = l.moveAtras();
                                    break;
                                case 1:
                                    valor = l.moveFrente();
                                    break;
                            }
                        } while (opcaoHistorico != 2);
                    }
                    break;

                case 5:

                    do {
                        opcaoConversao = JOptionPane.showOptionDialog(null, "Qual conversão ou operação quer realizar?",
                                "Calculadora", 0, 3, null, conversao, null);

                        switch (opcaoConversao) {

                            case 0:
                                convertendo = JOptionPane.showInputDialog(null, "Insira o decimal que deseja converter", "Decimal para binário", 3);

                                if (convertendo == null) {
                                    break;
                                } else if (convertendo.matches("\\d+")) {
                                    numero = Long.parseLong(convertendo);
                                    JOptionPane.showMessageDialog(null,
                                            calculadora.decBit(numero));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Valor inválido!", "AVISO", 2);
                                }

                                break;

                            case 1:
                                convertendo = JOptionPane.showInputDialog(null, "Insira o binário que deseja converter", "Binário para decimal", 3);

                                if (convertendo == null) {
                                    break;
                                } else if (convertendo.matches("\\d+")) {
                                    numero = Long.parseLong(convertendo);
                                    JOptionPane.showMessageDialog(null,
                                            calculadora.bitDec(numero));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Valor inválido!", "AVISO", 2);
                                }

                                break;

                            case 2:
                                valor = calculadora.raizQuadrada();
                                valor = Math.round(valor * 100);
                                valor = valor / 100;
                                JOptionPane.showMessageDialog(null, "A raíz quadrada será de " + valor, "Total", 1);
                                l.adicionaNoFim(valor);
                                break;

                            case 3:
                                valor = calculadora.potenciacao();
                                JOptionPane.showMessageDialog(null, "O resultado da potência será de " + valor, "Total", 1);
                                l.adicionaNoFim(valor);
                                break;

                            case 4:
                                opcaoEscolha = JOptionPane.showOptionDialog(null, "Deseja realmente apagar o histórico?",
                                        "Apagar Histórico", 0, 2, null, escolha, null);

                                if (opcaoEscolha == 0) {
                                    l.apagaHistorico();
                                    JOptionPane.showMessageDialog(null, "Histórico apagado.", "Sucesso!", 1);
                                }

                                break;
                        }

                    } while (opcaoConversao != 5);

            }

        } while (opcao != 6);

    }

}
