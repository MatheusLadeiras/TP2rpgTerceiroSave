import java.util.*;
public final class Entrada extends Obstaculos  { //é a classe combate sem overrite enquanto estou trabalhando nela

    Scanner scanner = new Scanner(System.in);

    public Entrada(boolean completo, Luca luca, Pr0t0 robo) {
        super(completo, luca, robo);
    }
    public void introdução() {
        System.out.println("Você acaba de acordar dentro da carruagem que te levou a convenção, olhando em volta percebe seu robô desativado na sua frente e as ferramentas no banco ao seu lado, ative-o antes de sair!\n\n");
        do {
            System.out.println("Ações:"); //Quando for completo só falar que já foi feito
            System.out.println("1) Pegar as ferramentas do seu lado");//Adicionar o id de ferramentas ao inventário, se já tiver dizer que já foi feito
            System.out.println("2) Ativar Pr0t0");//Procurar por id, se tiver, acaba a etapa, se não, manda pegar ferramentas
            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                action = 0;
            }
            switch (action) {
                case 1:
                    if (luca.getInventario().contains(1)) {
                        System.out.println("Você já pegou esse item");
                    } else {
                        luca.adicionarItem(1);
                        System.out.println("Você tem suas ferramentas de volta! Tome mais cuidado com elas.");
                    }
                    break;
                case 2:
                    if (luca.getInventario().contains(1)) {
                        System.out.println("Você habilmente dá corda em um ponto e move uma manivela em outro, Pr0t0 está ativo, hora de sair!");
                        completo = true;
                    } else {
                        System.out.println("Você precisa das suas ferramentas para fazer isso.");
                    }
                    break;
                default:
                    System.out.printf("Entrada inválida\n");
                    break;
            }
        } while (/*getCompleto() == true*/completo == false);
        System.out.println("Esse método de exploração é o básico do jogo.");
        System.out.println("No inicio de cada desafio será comunicado seu próximo passo, complete a tarefa para automaticamente seguir adiante!");
        System.out.println("Aperte qualquer tecla para começar a primeira fase!");
        scanner.nextLine();
        scanner.nextLine();
    }

    @Override
    public void desafio() {
        ArrayList tracker = new ArrayList();
        completo = false;
        System.out.println("O dia está lindo hoje na Convenção Real de Beridgate, a maioria das pessoas transita pela área aberta enquanto alguns poucos sortudos se dirigem para o portão para o palco principal, você contudo não tem convite para passar pela porta da frente, deverá então achar outro jeito de chegar ao seu destino. \n\n");
        do {
            //System.out.println("Pr0t0: " + robo.getEngrenagens() + "/300     Luca: " + luca.getEngrenagens());
            System.out.println("Ações:"); //Quando for completo só falar que já foi feito
            System.out.println("1) Se aproximar do portão para invadir"); //Se conseguir ganhar a batalha no primeiro turno com uma rolagem critica do Pr0t0 dá pra entrar antes que o portão feche
            System.out.println("2) Se aproximar do portão sem o Pr0t0 para investigar"); //Ver como exatamente farei sobre o combate, algo como dano toda rodada até resolver o problema?
            System.out.println("3) Um homem parece estar com problemas com sua carruagem, você pode se aproximar se quiser."); //Escolha de gastar peças para ajuda-lo, ganhará a manivela
            System.out.println("4) Na fila pra entrada tem uma antigo amigo de seu pai, ele parece ter um convite, você poderia pedir pelo seu convite!");
            System.out.println("5) Talvez procurar uma outra entrada seja uma boa ideia, você pode procurar em volta da arena e ver se tem alguma sorte."); //Essa é a parte da entrada lateral
            System.out.println("6) Parece que tem uma comoção mais a frente, você poderia dar uma olhada.");
            System.out.println("7) Parece que tem uma pilha de maquinário quebrado mais afastado do evento, tem um homem lá perto vigiando, por que não falar com ele?");
            //Ele está cuidando pra que seja jogado fora depois, e diz que se conseguir reaproveitar algo, pode pegar as partes que funcionam
            //Só fazer o testo e aumentar o saldo
            System.out.println("8) Você vê que algumas carroças estão seguindo mais adiante, talvez tenha uma entrada por garagem?");
            //Ao perguntar te falam que não tem mais entrada desse tipo para o público, só a entrada de serviço na lateral do evento mas essa está danificada.

            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                action = 0;
            }
            switch (action) {
                case 1:
                    if (!tracker.contains(1)) {
                        combate(8, -50, -100, -120, 0, 1);
                    } else {
                        System.out.println("O portão continua fechado e a fila parou de andar, você causou uma baita comoção, mas não exatamente a do tipo que você veio para causar, o jeito é achar outra entrada já que o portão não é mais viável");
                    }
                    break;
                case 2:
                    if (tracker.contains(2)) {
                        System.out.println("Você decide voltar para olhar o portão mais uma vez.");
                    }
                    System.out.println("Você passa paralelo a enorme fila enquanto se dirige até o massiço portão, na frente da fila guardas recebem os convites e revistam cada convidado, já no parapeito, um homem está ao lado do que sem dúvida são os controles da entrada, se fosse fazer um ataque frontal, seria necessário derrotar os guardas em um instante e entrar antes que o portão fosse fechado, mesmo assim, uma vez lá dentro parece que seria fácil desaparecer antes da chegada de reforços. ");
                    if (!tracker.contains(2)) {
                        System.out.println("Com essa aproximação mais calma você consegue perceber logo ao lado uma caixa de fúsiveis, de forma rápida você pega a bateria, essa peça rara pode ser muito útil no futuro!");
                        luca.adicionarItem(3);//id 3 é bobina, quando usar no poder procurar id 3 e retirar a primeira instância.
                    }
                    break;
                case 3:
                    if (!tracker.contains(3)) {
                        System.out.println("Na sua frente o homem se debruça sobre sua carruagem mecânica. ");
                        System.out.println("- Meu deus, essa maldita caranga não funciona de jeito nenhum, chegarei atrasado dessa forma. ");
                        System.out.println("Você é capaz de perceber o erro de longe, seria fácil consertar mas você teria de usar algumas de suas peças. Coloque 'S' para ajudar, qualquer outra tecla para seguir em frente. ");
                        String input = scanner.nextLine();
                        input = scanner.nextLine();
                        if (input.equals("S")) {
                            if(luca.getEngrenagens() >= 50) {
                                interageComPersonagem(luca, -50);
                                System.out.println("O homem te agradece de forma animada e lhe pergunta se tem algo que poderia fazer pra te agradecer, depois de uma breve conversa, ele lhe entrega uma peça sobreecelente que tentou usar para os reparos, essa alavanca especial é uma peça extremamente rara e pode vir a ser útil.");
                                luca.adicionarItem(2);
                            }
                        } else {
                            System.out.println("Você deixa o homem para seus problemas, parece que ele está chamando um gincho, mais sorte na próxima...");
                        }
                    } else {
                        System.out.println("O homem e seu carro não se encontram mais.");
                    }
                    break;
                case 4:
                    if (!tracker.contains(4)) {
                        System.out.println("Você deixa Pr0t0 longe do portão e se aproxima parae falar com ele sobre o seu objetivo e que você tem que ter esse convite.");
                        System.out.println("Ele ri pensando que é uma brincadeira e lhe passa algumas engrenagens sobrecelentes que tem.");
                        System.out.println("-Vá garoto, pode brincar com essas aqui, elas podem ser uteis para essa sua tal invenção.");
                        interageComPersonagem(luca, 100);
                        System.out.println("Estranhamente, isso foi útil mesmo sem o convite.");
                    } else {
                        System.out.println("Quando você volta parece que ele já entrou no evento.");
                    }
                    break;
                case 5:
                        System.out.println("Você procura por um tempo e acha uma porta lateral, ela é macissa mas não tanto quanto a porta da frente, ninguém parece estar protegendo-a também.");
                        System.out.println("Logo ao lado você percebe um painel de controle, está emperrado! Por isso que essa entrada está largada, não dá pra entrar por ela.");
                        System.out.println("Normalmente você poderia consertar, mas além das engrenagens precisaria de algo para aplicar força no ponto certo, Pr0t0 não tem essa precisão, se tivesse uma chave especial ou uma manivela mecânica, seria capaz de abrir o local. ");
                        System.out.println("Em compensação, Pr0t0 tem força de sobra, usando o Overclock você tem quase certeza que ele poderia abrir a porta, contudo não apenas o dano seria enorme, como também tinha a chance de atrair alguém logo em seguida.");
                        System.out.println("Digite 1 para tentar consertar, 2 para tentar arrancar o portão e qualquer outra tecla para voltar.");
                        int q = scanner.nextInt();
                        switch (q) {
                            case 1:
                                if (luca.getInventario().contains(2) && luca.engrenagens >= 100) {
                                    interageComPersonagem(luca, -100);
                                    System.out.println("O portão range e levanta muito devagar, contudo ele abre até o fim, com nenhum guarda a vista, você avança desimpedido para a parte interna da convenção, agora é só achar o palco!");
                                    this.completo = true;
                                } else {
                                    System.out.println("Você não tem as peças necessárias, talvez seja bom procurar pelo evento!");
                                }
                                break;
                            case 2:
                                interageComPersonagem(robo, -180);
                                System.out.println("A porta é jogada para o lado mas Pr0t0 se mantém com sérios danos, antes de poder pensar em seu próximo passo, diversos soldados aparecem para ver o motivo da confusão.");
                                combate(8, -50, -100, -120, 0, 3);
                                break;
                            default:
                                System.out.println("Quem sabe você tem mais sorte aqui outra hora?");
                                break;
                        }
                    break;
                case 6: //tem que implementar ainda
                    if (!tracker.contains(6)) {
                        System.out.println("Se aproximando da comoção, você vê um homem esbravejando sobre sua invenção, sobre como ela revolucionaria a construção civil e o carregamento de carga e que ele deveria também ser adimitido no evento.");
                        System.out.println("Era evidente que falava de uma mistura de um exoesqueleto de engrenagens com um braço direito gigante feito de ferro com canos exalando vapor, algumas pessoas pareciam impressionadas, Luca porém dá uma pequena risadinha pensando que ele era só bravata de estar a frente do evento e tudo que podia fazer era reclamar.");
                        System.out.println("O inventor contudo, se sente revoltado em ver tal atitude da criança, os detalhes do ocorrido nos próximos momentos são meios confusos, mas entre xingamentos e ridicularizações, uma roda se forma em volta do inventor e Pr0t0 onde este desafia a 'Lataria' para provar que sua invenção era sem dúvida a mais robusta...");
                        combate(6, -40, -80, -160, 0, 2);
                    } else {
                        System.out.println("A multidão já se dispersou e o inventor não está mais ali.");
                    }
                    break;
                case 7:
                    if (!tracker.contains(7)) {
                        System.out.println("Ao se aproximar e perguntar sobre a pilha o homem responde que será jogando fora e está apenas aguardando a coleta que está atrasada. Vendo o interesse do garoto, diz que esse pode pegar o que quiser, se ele puder reutilizar, será melhor que simplismente jogar fora.");
                        interageComPersonagem(luca, 200);
                    } else {
                        System.out.println("O homem acena pra você ao te ver mais uma vez. Você olha novamente a pilha mas não tem outras peças que possam ser aproveitadas.");
                    }
                    break;
                case 8:
                    System.out.println("Você pergunta para as pessoas em volta e elas dizem não saber de nenhuma garagem, a maioria parece estar com problemas com engarrafamento pelo evento, alguns contudo dizem que havia uma entrada secundária de carga onde alguns carros entravam, mas parece que ela emperrou alguns dias antes.");
                    break;
                default:
                    System.out.printf("Entrada inválida\n");
                    break;
            }
            if (!tracker.contains(action)) {tracker.add(action); }
        } while (completo == false);
    }

    @Override
    public void combate(int vida, int danoLeve, int danoNormal, int danoCritico, int turno, int id) {
        //Tentei colocar ", Pr0t0 robo, Luca luca" mas só torna this.robo is null pra "robo" is null
        boolean armadilha = false;
        if(id == 1) {System.out.println("Vocês avançam para tentar alcançar o portão em uma unica investida, é tudo ou nada!");} else if (id == 2) {
            System.out.println("O inventor aponta o estranho exobraço mecanizado na direção de Pr0t0, mostre pra ele quem tem a invenção mais incrível!");
        }
        do {
            if(id == 1 || id == 3) {System.out.println("Os soldados se posicionam em volta de Pr0t0 prontos para o combate!");} else {
                System.out.println("O inventor se mantém a sua frente combativo.");
            }
            System.out.println("Pr0t0: " + robo.getEngrenagens() + "/300     Luca: " + luca.getEngrenagens());
            luca.agir(); //Se o id do inimigo for maior que 4 a granada de bobina funciona nele, simplifica bastante assim.
            int dano = robo.agir();
            if (luca.traquinagem == 2) {
                vida = 0;
            }
            vida = vida - dano;
            if(vida > 0) {
                System.out.println("Os inimigos agem!");
                int n = rand.nextInt(10);
                if (luca.getTraquinagem() == 1) {
                    System.out.println("Entre pedradas e gritaria de Luca, os inimigos tem mais dificuldade em atacar Pr0t0.");
                    n = n - 1;
                }
                if (armadilha == true) {
                    System.out.println("A armadilha reduz o dano dos ataques vindouros");
                    robo.setProteção(1);
                }
                switch (n) {
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        System.out.println("Um ataque é acertado em Pr0t0.");
                        interageComPersonagem(robo, danoNormal);
                        break;
                    case 9:
                    case 10:
                        System.out.println("Um ataque se finca nas engrenagens de Pr0t0!");
                        interageComPersonagem(robo, danoCritico);
                        break;
                    default:
                        System.out.println("Os ataques apenas raspam em Pr0t0 causando algum dano, mas nada tão considerável");
                        interageComPersonagem(robo, danoLeve);
                        break;
                }
            }
            if (luca.getTraquinagem() == 3) {
                int engrenagens = robo.getEngrenagens() + 100;
                robo.setEngrenagens(engrenagens);
                System.out.println("Luca terminou os reparos.");
                //A nova vida aparece no inicio do turno
            }
            if (luca.getTraquinagem() == 4) {
                System.out.println("Luca joga a armadilha, os inimigos se vêem com o ataque debilitado.");
                armadilha = true;
            }
            if (luca.getTraquinagem() == 5) {
                System.out.println("Luca Joga a granada de bobina...");
                if (id > 3) {
                    System.out.println("...fritando os circuitos do alvo.");
                    vida = vida - 15;
                } else {
                    System.out.println("...Sem efeito algum.");
                }
            }
            turno++;
        } while (vida > 0);
        if (id == 2) {
            System.out.println("Você passa pelos guardas e adentra o complexo antes que alguém possa lhe parar, agora é só achar o Palco Principal.");
            this.completo = true;
        } else if(!(luca.getTraquinagem() == 2)) {
            if (id == 1) { //Fazer uma excessão pra caso fuga tenha sido bem sucedida, um if pegando esse if else
                if (turno < 2) {
                    System.out.println("Agindo rapidamente Pr0t0 atropela os guardas e você segue atrás com o portão fechando momentos depois, antes que os outros soldados apareçam para reforçar, vocês já sumiram por dentre as caixas de maquinário por uma saída lateral.");
                    this.completo = true;
                } else {
                    System.out.println("O fim do combate ocorre mas o portão já se encontra fechado a sua frente, ele é grande demais para ser destruido, você precisa encontrar outro caminho");
                }
            } else {
                System.out.println("O inventor jaz inconciente a sua frente, olhando em volta você vê que ele tinha diversas peças não utilizadas, seria cruel desmontar a sua invenção para conseguir mais engrenagens, contudo o que ele não tinha usado pode muito bem ser aproveitado por você, afinal, ele não está em condições de aproveitar as peças agora...");
                interageComPersonagem(luca, 200);
            }
        } //Não precisa de mensagem pra falar que fugiram pois a própria fuga já fala disso!
    }
}
