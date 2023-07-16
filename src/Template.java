import java.util.*;

public abstract class Template implements Personagem {
    protected String nome;
    protected String idade;
    protected int engrenagens;
    //private ArrayList inventario; //Devido ao modelo diferente de jogo que a professora aprovou, só um dos personagens tem inventario

    public Template(String nome, String idade, int engrenagens) {
        setNome(nome);
        setIdade(idade);
        setEngrenagens(engrenagens);
    }

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    @Override
    public abstract void contarHistória();

    @Override
    public abstract boolean poderEspecial(int saldo);

//Quando termina-las tem que colocar na interface de personagem também
    public abstract int agir();

    public void instruçõesCombate() {
        System.out.println("\nEssa é uma explicação base acessível a qualquer momento, os detalhes do combate conduto, você deverá aprender jogando.");
        System.out.println("No combate você deve derrotar o inimigo tentando minimizar danos recebidos ou simplismente escapar.");
        System.out.println("Pr0t0 pode atacar, defender ou usar Overdrive, a ultima ação irá danifica-lo gravemente, mas tem efeitos devastadores!");
        System.out.println("Luca pode tentar escapar do combate mas não há garantias de funcionamento, ele pode tentar atrapalhar os inimigos tornando seus ataques mais ineficazes, ou...");
        System.out.println("Ele pode usar suas técnicas de relojoeiro, essas ações ocorrem apenas no final do turno e custam 100 engrenagens e talvez outros itens limitados, mesmo assim, elas são extremamente poderosas:");
        System.out.println("Reparos de emergencia curam Pr0t0 em um terço de sua vida e gastando o mesmo em engrenagens, tirando esses momentos Luca só pode cura-lo quando conseguir tempo entre obstáculos, contudos esses reparos não gastam engrenagens!");
        System.out.println("Armadilha de contenção lhe permite impedir que os inimigos causem muito dano a Pr0t0, contudo só no próximo turno que esse efeito vai ocorrer, se tiver um aviso de um ataque diferente vindo, pode ser uma boa pedida. OBS: Não acumula com defesa!");
        System.out.println("A granada de bobina custa um fusível além de engrenagens, elas são inuteis contra seres humanos mas danificam de forma pesada robôs inimigos na hora!");
        System.out.println("Boa sorte!\n");
    }

    //public abstract void adicionarItem(int id); //Adicionar item é na verdade apenas pro Luca

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public int getEngrenagens() {
        return engrenagens;
    }

    public void setEngrenagens(int engrenagens) {
        this.engrenagens = engrenagens;
    }

    /*public ArrayList getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList inventario) {
        this.inventario = inventario;
    }*/
}
