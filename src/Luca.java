import java.util.*;

public final class Luca extends Template{
    protected ArrayList inventario;
    protected int traquinagem;
    public Luca(String nome, String idade, int caracteristica, ArrayList inventario, int traquinagem) {
        super(nome, idade, caracteristica);
        setInventario(inventario);
        setTraquinagem(traquinagem);
    }

    @Override
    public void contarHistória() {
        System.out.println("Você é Luca, o último filho de uma linhagem de relojoeiros, sua família já foi reconhecida abertamente como grandes inventores, contudo recentemente, seu prestigio tem sido esquecido com a ascensão dos inventores steampunk que usam fumaça para aprimorar suas maquinas, Luca agora quer provar que, contanto que tenha imaginação, ele também pode fazer coisas incríveis.\n");
    }

    @Override
    public boolean poderEspecial(int saldo) {//O poder simplismente muda a reserva de engrenagens quando utilizado e impede que seja gasto mais do que se tem as ações ocorrem de forma individua
        int engrenagens = getEngrenagens();
        engrenagens = engrenagens + saldo;//A classe serve para aumentar as peças ao colocar um valor positivo e reduzir colocalndo negativo msm que não precise do boolean pro poder
        if(engrenagens > 0) {
            setEngrenagens(engrenagens);
            return true;
        }
        System.out.println("Você infelizmente não tem as peças necessárias.");
        return false;
    }

    @Override
    public int agir() {
        setTraquinagem(0);
        boolean tutorial = false;
        boolean success = false;
                System.out.println("Ação de Luca:");
                System.out.println("1) Atrapalhar");
                System.out.println("2) Fugir");
                System.out.println("3) Criar invenção");
                System.out.println("4) Regras de combate");
        do {
            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                action = 0;
            }
            tutorial = false;
            switch (action) {
                case 1:
                    setTraquinagem(1);
                    break;
                case 2:
                    System.out.println("Lucas tenta achar uma forma de fugir.");
                    int n = rand.nextInt(4);
                    switch (n) {
                        case 1:
                        case 2:
                        case 3:
                            System.out.println("Você tem uma ideia mas logo o posicionamento dos inimigos e suas ações atrapalham a execução de seu plano");
                            break;
                        case 4:
                            System.out.println("De forma rápida vocês desaparecem de seus perseguidores, essa foi por pouco!");
                            setTraquinagem(2);
                            break;
                    }
                    break;
                case 3:
                    if(poderEspecial(-100) == true) {
                        System.out.println("Diga o que você quer fazer:");
                        System.out.println("1) Reparos de emergencia");
                        System.out.println("2) Armadilha de contenção");
                        System.out.println("3) Granada de bobina");
                        try {
                            action = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            action = 0;
                        }
                        switch (action) {//o metodo já avisa se não tiver peças o bastante
                            case 1:
                                setTraquinagem(3); System.out.println("Luca começa a trabalhar");
                                break;
                            case 2:
                                setTraquinagem(4); System.out.println("Luca começa a trabalhar");
                                break;
                            case 3:
                                if(inventario.contains(3) == true) {setTraquinagem(5); System.out.println("Luca começa a trabalhar"); inventario.remove(Integer.valueOf(3));} else {
                                    tutorial = true;
                                    System.out.println("Você não tem a bobina necessária para fazer essa invenção");
                                    int compensação = engrenagens + 100;
                                    setEngrenagens(compensação);
                                }
                                break;
                            default:
                                System.out.printf("Entrada inválida\n");
                                tutorial = true;
                                break;
                        }
                    } else {
                        //System.out.printf("Você não tem engrenagens para nenhuma das invenções \n");
                        tutorial = true;
                    }
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
        return 0;
    }

    public void adicionarItem(int id) {
        inventario.add(id);
    }

    public ArrayList getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList inventario) {
        this.inventario = inventario;
    }

    public int getTraquinagem() {
        return traquinagem;
    }

    public void setTraquinagem(int traquinagem) {
        this.traquinagem = traquinagem;
    }
}
