import java.util.*;
// O jogo tem uma fala inspirada em jogos para crianças, em alguns lugares fica mais que em outros, só achei que seria engraçado assim
// O jogo não está muito bem balanceado e tem como dar softlock com uma facilidade mediana, seria fácil mudar isso mas
// eu ri muito com meu irmãzinho jogando e ficando irritado então agora é feature
public class Main {
    public static void main(String[] args) {
        System.out.println("Começando o jogo!");

        ArrayList inventario = new ArrayList();
        /*inventario.add(3);
        inventario.add(3);*/
        Luca luca = new Luca("Luca", "15 anos", 300, inventario, 0);
        Pr0t0 robo = new Pr0t0("Pr0t0", "36 horas", 300, 0);

        luca.contarHistória();
        robo.contarHistória();

        boolean completo = false;
        Entrada entrada = new Entrada(completo, luca, robo);
        //entrada.combate(30, -100, -100, -100,0, 5);
        entrada.introdução();
        System.out.println("Fim da introdução");
        entrada.desafio();
    }
}