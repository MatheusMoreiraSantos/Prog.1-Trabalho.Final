import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    private List<Jogador> jogadores;
    private Baralho baralho;
    private Tabuleiro tabuleiro;
    private Scanner scanner;

    public Jogo() {
        this.jogadores = new ArrayList<>();
        this.baralho = new Baralho();
        this.tabuleiro = new Tabuleiro();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJogo() {
        inicializarJogadores();
        baralho.embaralhar();
        distribuirCartas();

        for (int rodada = 1; rodada <= 12; rodada++) {
            System.out.println("\n=== Rodada " + rodada + " ===");

            for (Jogador jogador : jogadores) {
                realizarJogada(jogador);
            }

            tabuleiro.imprimirTabuleiro();
            imprimirPontuacao();

            coletarCartasDoTabuleiro();
            verificarFimDoJogo();
        }

        finalizarJogo();
    }

    private void inicializarJogadores() {
        System.out.print("Informe o número de jogadores (3 a 6): ");
        int numJogadores = scanner.nextInt();

        if (numJogadores < 3 || numJogadores > 6) {
            System.out.println("Número de jogadores inválido. O jogo requer de 3 a 6 jogadores.");
            System.exit(0);
        }

        scanner.nextLine(); // Consumir a quebra de linha pendente

        for (int i = 1; i <= numJogadores; i++) {
            System.out.print("Informe o nome do Jogador " + i + ": ");
            String nome = scanner.nextLine();
            Jogador jogador = new Jogador(nome, null);
            jogadores.add(jogador);
        }
    }

    private void distribuirCartas() {
        for (Jogador jogador : jogadores) {
            List<Carta> cartas = baralho.distribuirCartas(12);
            jogador.receberCartas(cartas);
        }
    
        for (int i = 0; i < 5; i++) {
            Carta carta = baralho.distribuirCartas(1).get(0);
            tabuleiro.posicionarCarta(carta, i);
        }
    }

    private void realizarJogada(Jogador jogador) {
        System.out.println("\n" + jogador.getNome() + ", é sua vez.");

        // Exibir mão do jogador
        System.out.println("Sua mão: " + jogador.getMao());

        // Solicitar ao jogador que escolha uma carta
        System.out.print("Escolha uma carta para jogar: ");
        int escolha = 0;
        try {
            escolha = Integer.parseInt(scanner.nextLine());

            // Validar a escolha
            if (escolha >= 1 && escolha <= jogador.getMao().size()) {
                Carta cartaEscolhida = jogador.getMao().remove(escolha - 1);
                tabuleiro.posicionarCarta(cartaEscolhida, escolha);
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
                realizarJogada(jogador); // Chamada recursiva para nova tentativa
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Tente novamente.");
            realizarJogada(jogador); // Chamada recursiva para nova tentativa
        }
    }

    private void coletarCartasDoTabuleiro() {
        for (int i = 0; i < Tabuleiro.NUMERO_DE_COLUNAS; i++) {
            List<Carta> cartasNaColuna = tabuleiro.removerCartasDaColuna(i);

            // Adicionar lógica para contabilizar pontos das cartas coletadas pelos jogadores
            for (Jogador jogador : jogadores) {
                jogador.adicionarCartasColetadas(cartasNaColuna);
            }
        }
    }

    private void verificarFimDoJogo() {
        int pontuacaoMaximaPossivel = calcularPontuacaoMaxima();
        Jogador vencedor = null;

        for (Jogador jogador : jogadores) {
            if (jogador.getPontos() == 0) {
                vencedor = jogador;
                break;
            }
        }

        if (vencedor != null) {
            System.out.println("\n=== Fim do Jogo ===");
            System.out.println("O vencedor é: " + vencedor.getNome());
        } else {
            System.out.println("\n=== Fim do Jogo ===");
            System.out.println("O jogo terminou, mas não há vencedor.");
        }
    }

    private int calcularPontuacaoMaxima() {
        int pontuacaoMaxima = 0;

        // Adicionar lógica para calcular a pontuação máxima possível
        // (de acordo com as regras específicas do jogo)
        // Isso pode envolver a análise das cartas restantes no baralho e no tabuleiro.

        // Pontuação máxima possível nas cartas do baralho
        for (int i = 1; i <= 109; i++) {
            Carta carta = new Carta(i);
            pontuacaoMaxima += carta.calcularPontuacao();
        }

        // Pontuação máxima possível nas cartas do tabuleiro
        for (int i = 0; i < Tabuleiro.NUMERO_DE_COLUNAS; i++) {
            List<Carta> cartasNaColuna = tabuleiro.getCartasNaColuna(i);
            for (Carta carta : cartasNaColuna) {
                pontuacaoMaxima += carta.calcularPontuacao();
            }
        }

        return pontuacaoMaxima;
    }

    private void imprimirPontuacao() {
        System.out.println("\n=== Pontuação ===");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ": " + jogador.getPontos());
        }
    }

    private void finalizarJogo() {
        // Adicionar lógica de contagem final de pontos e anunciar vencedor
        System.out.println("\n=== Fim do Jogo ===");
        System.out.println("Pontuação Final:");
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ": " + jogador.getPontos());
        }

        int pontuacaoMaximaPossivel = calcularPontuacaoMaxima();
        System.out.println("Pontuação Máxima Possível: " + pontuacaoMaximaPossivel);

        Jogador vencedor = determinarVencedor();
        if (vencedor != null) {
            System.out.println("O vencedor é: " + vencedor.getNome());
        } else {
            System.out.println("O jogo terminou, mas não há vencedor.");
        }
    }

    private Jogador determinarVencedor() {
        Jogador vencedor = jogadores.get(0);
        for (Jogador jogador : jogadores) {
            if (jogador.getPontos() < vencedor.getPontos()) {
                vencedor = jogador;
            }
        }

        return vencedor;
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciarJogo();
    }
}
