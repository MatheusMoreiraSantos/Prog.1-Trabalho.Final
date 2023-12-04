import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<>();
        for (int i = 1; i <= 109; i++) {
            cartas.add(new Carta(i));
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public List<Carta> distribuirCartas(int quantidade) {
        List<Carta> cartasDistribuidas = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            cartasDistribuidas.add(cartas.remove(0));
        }
        return cartasDistribuidas;
    }
   }
