import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    public static final int NUMERO_DE_COLUNAS = 0;
    private List<List<Carta>> linhas;

    public Tabuleiro() {
        this.linhas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            linhas.add(new ArrayList<>());
        }
    }

    public void posicionarCarta(Carta carta, int coluna) {
        List<Carta> linha = linhas.get(coluna);
        if (linha.isEmpty() || carta.getNumero() > linha.get(linha.size() - 1).getNumero()) {
            linha.add(carta);
        } else {
            int index = encontrarIndexInsercao(linha, carta);
            linha.add(index, carta);
        }
    }

    public int encontrarMelhorColuna(Carta carta) {
        int melhorColuna = 0;
        int menorDiferenca = Integer.MAX_VALUE;

        for (int coluna = 0; coluna < 5; coluna++) {
            List<Carta> linha = linhas.get(coluna);

            if (linha.isEmpty()) {
                return coluna;
            }

            int ultimaCarta = linha.get(linha.size() - 1).getNumero();
            int diferenca = Math.abs(ultimaCarta - carta.getNumero());

            if (diferenca < menorDiferenca) {
                menorDiferenca = diferenca;
                melhorColuna = coluna;
            }
        }

        return melhorColuna;
    }

    public void imprimirTabuleiro() {
        for (List<Carta> linha : linhas) {
            for (Carta carta : linha) {
                System.out.print(carta.getNumero() + " ");
            }
            System.out.println();
        }
    }

    public List<Carta> coletarCartas(Jogador jogador) {
        List<Carta> cartasColetadas = new ArrayList<>();
        for (List<Carta> linha : linhas) {
            cartasColetadas.addAll(linha);
        }
        linhas.clear();
        jogador.adicionarCartasColetadas(cartasColetadas);
        return cartasColetadas;
    }

    private int encontrarIndexInsercao(List<Carta> linha, Carta carta) {
        for (int i = 0; i < linha.size(); i++) {
            if (carta.getNumero() < linha.get(i).getNumero()) {
                return i;
            }
        }
        return 0;
    }

    public List<Carta> removerCartasDaColuna(int i) {
        return null;
    }

    public List<Carta> getCartasNaColuna(int i) {
        return null;
    }
}
