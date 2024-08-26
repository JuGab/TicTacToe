/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;

/**
 *
 * @author JGLop
 */
public abstract class Jogador {
    
    protected Jogo jogo;
    protected String nome;
    protected int max_pontos;
    protected int pontos_atuais;
    protected int vitorias;
    protected boolean seu_turno;
    protected char simb;

    public Jogador(Jogo jogo) {
        this.jogo = jogo;
        this.seu_turno = false;
    }
    
    public void marcar(int x, int y){
        
        if(this.seu_turno == true){
        
            if(this.jogo.getEsp(x,y) != '0'){
                System.out.println("Erro: espaco ja marcado");

            }
            else{
                this.jogo.setEsp(x, y, simb);
                this.jogo.atualizar();
                this.jogo.verificar_acoes();
            }
        }
    }

    public void setSeu_turno(boolean seu_turno) {
        this.seu_turno = seu_turno;
    }

    public boolean isSeu_turno() {
        return this.seu_turno;
    }
    
    
    
    
    
    
    
}
