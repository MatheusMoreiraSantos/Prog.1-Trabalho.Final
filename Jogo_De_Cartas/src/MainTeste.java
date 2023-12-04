import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTeste {
   /* private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Informe o número de jogadores (entre 3 e 6): ");
        int numJogadores = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente

        List<Jogador> jogadores = criarJogadores(numJogadores);
        distribuirCartas(jogadores);

        System.out.println("\nInformações dos Jogadores:");
        imprimirJogadores(jogadores);
    }

    private static List<Jogador> criarJogadores(int numJogadores) {
        List<Jogador> jogadores = new ArrayList<>();

        for (int i = 1; i <= numJogadores; i++) {
            System.out.print("Informe o nome do Jogador " + i + ": ");
            String nome = scanner.nextLine();
            List<Carta> maoVazia = new ArrayList<>();
            Jogador jogador = new Jogador(nome, maoVazia);
            jogadores.add(jogador);
        }

        return jogadores;
    }

    private static void distribuirCartas(List<Jogador> jogadores) {
        Baralho baralho = new Baralho();

        for (Jogador jogador : jogadores) {
            List<Carta> mao = baralho.distribuirCartas(12);
            jogador.getMao().addAll(mao);
        }
    }

    private static void imprimirJogadores(List<Jogador> jogadores) {
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    } */

/* public static void main(String[] args) {
        // Criar um tabuleiro
        Tabuleiro tabuleiro = new Tabuleiro();

        // Criar algumas cartas para teste
        Carta carta1 = new Carta(5);
        Carta carta2 = new Carta(12);
        Carta carta3 = new Carta(8);

        // Posicionar as cartas no tabuleiro
        tabuleiro.posicionarCarta(carta1);
        tabuleiro.posicionarCarta(carta2);
        tabuleiro.posicionarCarta(carta3);

        // Imprimir o estado atual do tabuleiro
        System.out.println("Estado Atual do Tabuleiro:");
        tabuleiro.imprimirTabuleiro();

        // Simular coleta de cartas na linha 2 (índice 1)
        tabuleiro.coletarCartas(1);

        // Imprimir o estado do tabuleiro após a coleta
        System.out.println("\nTabuleiro após Coleta:");
        tabuleiro.imprimirTabuleiro();
    } */




    
}
