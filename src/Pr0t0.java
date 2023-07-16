import java.util.*;
public final class Pr0t0 extends Template {

    protected int proteção;
    public Pr0t0(String nome, String idade, int caracteristica, int proteção) {
        super(nome, idade, caracteristica);
        setProteção(proteção);
    }
    //Perder vai ser um try catch que vai dar um erro se a vida chegar abaixo de 0 parando o código pra dar a mensagem de game over, assim coisas como println de ocorridos no turno ou similares não ocorrem
    //Também colocar no overdrive caso chegue a 0, não só nos combates
    @Override
    public void contarHistória() {
        System.out.println("Pr0t0 é a mais nova invenção de Lucas, um robô feito de madeira e engrenagens energizado pelos precisos movimentos mecânicos de seu interior, montado com o objetivo de provar ao mundo que relojoaria é mais incrível que o steampunk e que o único limite é a criatividade, agora ele só precisa de um lugar para mostrar sua invenção ao mundo... \n");
    }

    @Override
    public boolean poderEspecial(int dano) {
        if (getProteção() == 1) {dano = dano/2; int defesa = dano*-1; System.out.println("Contudo seu estado de defesa reduz o dano para "+ defesa);}
        if (getProteção() == 2) {dano = dano*0; System.out.println("Contudo seu estado de defesa extrema reduz para nada o ataque!");}
        int engrenagens = getEngrenagens();
        engrenagens = engrenagens + dano;
        setEngrenagens(engrenagens);
        return true;
    }

    public int getProteção() {
        return proteção;
    }

    public void setProteção(int proteção) {
        this.proteção = proteção;
    }

    @Override //tem que ter o limite e o game over
    public void setEngrenagens(int engrenagens) {
        if (engrenagens <= 0) {
            System.out.println("Pr0t0 subitamente para no lugar por alguns segundos como se tivesse travado, subitamente o relógio em seu peito começa a se mover rapidamente, um ponteiro indo em cada direção, os braços começam a girar em círculos e ele volta a se mover cambaleando, o tilintar das peças saindo do lugar pode ser ouvido e em momentos ele se desmonta na frente de Luca, incrédulo com o ocorrido. Agora sem seu protetor, os guardas rapidamente pegar o encrenqueiro e o arrastam para fora da convenção, Luca contudo tem sua mente ocupada, isso não aconteceria de novo ano que vem!");
            System.out.println("Game Over!");
            System.exit(0);
        } else if (engrenagens > 300) {
            engrenagens = 300;
        }
        this.engrenagens = engrenagens;
    }

    @Override
    public int agir() {
        boolean overdrive = false;
        boolean tutorial = false;
        int dano = 0;
        do {
            System.out.println("Ação de Pr0t0:");
            System.out.println("1) Protocolo de Ataque");
            System.out.println("2) Protocolo de autopreservação");
            System.out.println("3) Protocolo Experimental Overdrive");
            System.out.println("4) Regras de combate");
            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                action = 0;
            }
            dano = 0;
            tutorial = false;
            overdrive = false;
            setProteção(0);
                switch (action) {
                    case 1:
                        int n = rand.nextInt(10);
                        switch (n) {
                            case 1:
                            case 2:
                            case 3:
                                System.out.println("Pr0t0 ataca o alvo depois de um pequeno intervalo, uma pequena imprecisão nas engrenagens torna a agrassão mais fraca que o esperado.");
                                dano = 3;
                                break;
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                System.out.println("Pr0t0 ataca o alvo subitamente após receber o comando acertando um poderoso ataque.");
                                dano = 5;
                                break;
                            case 9:
                            case 10:
                                System.out.println("Pr0t0 age com uma rapidez inesperada e é capaz de acertar um golpe poderoso no ponto critico da força adversária!");
                                dano = 8;
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Pr0t0 toma uma forma defensiva se preparando para receber os ataques.");
                        setProteção(1);
                        break;
                    case 3:
                        overdrive = true;
                        poderEspecial(-100);
                        break;
                    case 4:
                        tutorial = true;
                        instruçõesCombate();
                        break;
                    default:
                        System.out.printf("Entrada inválida\n");
                        tutorial = true;
                        break;
                }
            } while (tutorial == true);
        if(overdrive == true) {
            System.out.println("Overdrive ativado!");
            System.out.println("1) Protocolo de Ataque"); //Os valores de dano do overdrive
            System.out.println("2) Protocolo de autopreservação"); //Não toma dano, só vale a pena se for um ataque muito forte, talvez não tomar dano próximo turno também
            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                action = 0;
            }
            switch (action) {
                case 1:
                    int n = rand.nextInt(10);
                    switch (n) {
                        case 1:
                        case 2:
                            System.out.println("As engrenagens dão tudo de si para fazer um movimento de extremo poder, o ataque é impreciso mas ainda carrega uma força enorme");
                            dano = 5;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            System.out.println("Pr0t0 desfere um ataque devastador em meio a cacofonia das engrenagens.");
                            dano = 8;
                            break;
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            System.out.println("Luca não é nem capaz de ver o movimento mas o adversário foi acertado em cheio por um ataque que fez a terra tremer!");
                            dano = 10;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Pr0t0 começa a exalar um barulho ensurdecedor enquanto todas as suas engrenagens começam a trabalhar com o unico objetivo de torna-lo impenetrável!.");
                    setProteção(2);
                    break;
                default:
                    System.out.printf("Entrada inválida\n");
                    tutorial = true;
                    break;
            }
        }
        return dano;
    }
}
