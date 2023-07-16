public interface Interações {
    void interageComPersonagem(Template personagem, int saldo);
    void desafio();//Vai ser a base com todos os switchs e chamando os outros eventos que forem ocorrendo
    //void observar();//Repete pro jogador um panorama geral da área
    //Não vale a pena, é muita coisa atualizar isso pra cada vez que há mudança no cenário e não é tão necessário.

    void combate(int vida, int danoLeve, int danoNormal, int danoCritico, int turno, int id);

}
