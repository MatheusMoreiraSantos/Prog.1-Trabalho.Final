public class Carta {
    private int numero;

    public Carta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return String.valueOf(numero);
    }

    public int calcularPontuacao() {
        return 0;
    }
}