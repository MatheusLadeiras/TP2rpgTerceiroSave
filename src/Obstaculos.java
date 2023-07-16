import java.util.Random;

public abstract class Obstaculos implements Interações {
    public boolean completo;
    protected Luca luca;
    protected Pr0t0 robo;

    Random rand = new Random();

    public Obstaculos (boolean completo, Luca luca, Pr0t0 robo) {
        this.completo = completo;
        setLuca(luca);
        setPr0t0(robo);
        //setCompleto(completo);
    }
    @Override
    public void interageComPersonagem(Template personagem, int saldo) {
        String s = personagem.getNome();
        if (saldo > 0) {
            System.out.println(s+" ganhou "+saldo+" engrenagens.");
        } else {
            int perda = saldo * -1;
            System.out.println(s+" perdeu "+perda+" engrenagens.");
        }
        personagem.poderEspecial(saldo);
    }

    @Override
    public abstract void desafio();
    @Override
    public abstract void combate(int vida, int danoLeve, int danoNormal, int danoCritico, int turno, int id);

    public boolean getCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public Luca getLuca() {
        return luca;
    }

    public void setLuca(Luca luca) {
        this.luca = luca;
    }

    public Pr0t0 getPr0t0() {
        return robo;
    }

    public void setPr0t0(Pr0t0 robo) {
        this.robo = robo;
    }
}
