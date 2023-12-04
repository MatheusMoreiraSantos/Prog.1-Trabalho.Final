import java.util.List;
import java.util.Scanner;

public class Jogador {
    private String nome;
    private List<Carta> mao;
    private int pontos;

    public Jogador(String nome, List<Carta> mao) {
        this.nome = nome;
        this.mao = mao;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    public void selecionarCarta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(nome + ", escolha uma carta da sua mão:");
        for (int i = 0; i < mao.size(); i++) {
            System.out.println((i + 1) + ". " + mao.get(i));
        }

        int escolha;
        do {
            System.out.print("Digite o número da carta escolhida: ");
            escolha = scanner.nextInt();
        } while (escolha < 1 || escolha > mao.size());

        Carta cartaEscolhida = mao.remove(escolha - 1);
        System.out.println(nome + " escolheu a carta " + cartaEscolhida);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", mao=" + mao +
                ", pontos=" + pontos +
                '}';
    }

    public void adicionarCartasColetadas(List<Carta> cartasColetadas) {
    }

    public String getCartasColetadas() {
        return null;
    }

    public void receberCartas(List<Carta> cartas) {
    }
}
