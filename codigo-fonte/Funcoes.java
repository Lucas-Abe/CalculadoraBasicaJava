package ed_aps;

import javax.swing.JOptionPane;

/**
 * Classe para as operações matemáticas e a conversão de decimal para binário e
 * vice-versa.
 */
public class Funcoes {

    private FuncaoP p = new FuncaoP();
    private long numero;
    private long temp = 0;
    private long resto;
    private String total = "";
    double n1;
    double n2;

    /**
     * Método onde um valor decimal é convertido em um valor binário.
     *
     * @param valor valor decimal
     * @return uma string com o valor binário.
     */
    public String decBit(long valor) {
        this.numero = valor;
        temp = this.numero;
        total = "";

        while (numero != 0 && numero != 1) {
            resto = numero % 2;
            numero = numero / 2;
            p.empilha(resto);
        }
        resto = numero % 2;
        p.empilha(resto);

        try {
            while (temp != 1 && temp != 0) {
                total = total + p.desempilha();
                temp = temp / 2;
            }
            total = total + p.desempilha();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return total;
    }

    /**
     * Método onde um valor binário é convertido em um valor decimal.
     *
     * @param valor valor binário
     * @return uma string com o valor em decimal.
     */
    public String bitDec(long valor) {
        this.numero = valor;
        temp = this.numero;
        total = "";

        total = Long.toString(numero);

        for (int i = 0; i < total.length(); i++) {

            char check = total.charAt(i);

            if (check != '0' && check != '1') {
                return "O valor colocado não é um número binário.";
            }
        }

        temp = Long.parseLong(total, 2);
        total = Long.toString(temp);

        return total;
    }

    /**
     * Método onde são somados dois números.
     *
     * @return a soma do primeiro com o segundo número.
     */
    public double soma() {

        String i = JOptionPane.showInputDialog(null, "Digite o primeiro número", "Primeiro número", 1);
        String j = JOptionPane.showInputDialog(null, "Digite o segundo número", "Segundo número", 1);
        n1 = 0;
        n2 = 0;

        if (i == null) {
            i = "0";
        }

        if (j == null) {
            j = "0";
        }

        try {
            n1 = Double.parseDouble(i);
            n2 = Double.parseDouble(j);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algum valor inserido é inválido, resultado será 0.", "AVISO", 2);
            n1 = 0;
            n2 = 0;
        }

        return n1 + n2;
    }

    /**
     * Método onde o primeiro número é subtraído pelo segundo.
     *
     * @return a subtração do primeiro com o segundo número.
     */
    public double subtracao() {

        String i = JOptionPane.showInputDialog(null, "Digite o primeiro número", "Primeiro número", 1);
        String j = JOptionPane.showInputDialog(null, "Digite o segundo número", "Segundo número", 1);
        n1 = 0;
        n2 = 0;

        if (i == null) {
            i = "0";
        }

        if (j == null) {
            j = "0";
        }

        try {
            n1 = Double.parseDouble(i);
            n2 = Double.parseDouble(j);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algum valor inserido é inválido, resultado será 0.", "AVISO", 2);
            n1 = 0;
            n2 = 0;
        }
        return n1 - n2;
    }

    /**
     * Método onde o rimeiro número é multiplicado pelo segundo.
     *
     * @return a multiplicação entre o primeiro e o segundo número.
     */
    public double multiplicacao() {

        String i = JOptionPane.showInputDialog(null, "Digite o primeiro número", "Primeiro número", 1);
        String j = JOptionPane.showInputDialog(null, "Digite o segundo número", "Segundo número", 1);
        n1 = 0;
        n2 = 0;

        if (i == null) {
            i = "0";
        }

        if (j == null) {
            j = "0";
        }

        try {
            n1 = Double.parseDouble(i);
            n2 = Double.parseDouble(j);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algum valor inserido é inválido, resultado será 0.", "AVISO", 2);
            n1 = 0;
            n2 = 0;
        }

        return n1 * n2;
    }

    /**
     * Método onde o primeiro número é dividido pelo segundo.
     *
     * @return a divisão entre o primeiro número pelo segundo.
     */
    public double divisao() {

        String i = JOptionPane.showInputDialog(null, "Digite o primeiro número", "Primeiro número", 1);
        String j = JOptionPane.showInputDialog(null, "Digite o segundo número", "Segundo número", 1);
        n1 = 0;
        n2 = 0;

        if (i == null) {
            i = "0";
        }

        if (j == null) {
            j = "0";
        }

        try {
            n1 = Double.parseDouble(i);
            n2 = Double.parseDouble(j);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algum valor inserido é inválido, resultado será 0.", "AVISO", 2);
            n1 = 0;
            n2 = 0;
        }

        if (n2 == 0) {
            JOptionPane.showMessageDialog(null, "Não é possível fazer essa divisão, resultado será 0.", "AVISO", 2);
            return 0;
        }

        return n1 / n2;
    }

    /**
     * Método onde é calculado a raíz quadrada de um número.
     *
     * @return a raíz quadrada de um número.
     */
    public double raizQuadrada() {
        String numero = JOptionPane.showInputDialog(null, "Insira o número que quer ver a raíz quadrada", "Raíz quadrada", 1);
        n1 = 0;

        try {
            n1 = Double.parseDouble(numero);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Você não colocou um número. O resultado será 0.", "AVISO", 2);
            n1 = 0;
        }

        if (n1 < 0) {
            JOptionPane.showMessageDialog(null, "Não existe raíz quadrada de números negativos. O resultado será 0.", "AVISO", 2);
            return 0;
        }

        n1 = Math.sqrt(n1);

        return n1;
    }

    /**
     * Método onde o primeiro número é elevado a potência do segundo.
     *
     * @return o primeiro número elevado pelo segundo.
     */
    public double potenciacao() {
        String num = JOptionPane.showInputDialog(null, "Insira a base", "Potenciação", 1);
        String potencia = JOptionPane.showInputDialog(null, "Insira o expoente", "Potenciação", 1);
        double numeroP;
        double potenciaP;

        try {
            numeroP = Double.parseDouble(num);
            potenciaP = Double.parseDouble(potencia);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Você não colocou um número. O resultado será 0.", "AVISO", 2);
            numeroP = 0;
            potenciaP = 1;
        }

        numeroP = Math.pow(numeroP, potenciaP);

        return numeroP;
    }

}
