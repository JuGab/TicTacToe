/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;


import java.util.Random;
import static tictactoe.MainScreen.Tbtn9;
import static tictactoe.MainScreen.lbRound;

/**
 *
 * @author JGLop
 */
public class Jogo implements AcoesJogo{
    
    protected Player player1;
    protected Player player2;
    protected char esp[][] = {
                        {'0', '0', '0'},
                        {'0', '0', '0'},
                        {'0', '0', '0'}
                    };
    protected Jogador ganhador;
    protected boolean jogando;
    protected Jogador round;
    

   
    
    

    public Jogo() {
       
       
    }
    
    public int getEsp(int x, int y) {
        
        int resp = this.esp[x][y];
        
        return resp;
    }
    
    public void setEsp(int x, int y, char m){
        
        
        this.esp[x][y] = m;
    
    }

    @Override
    public void iniciar(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.player1.nome = "player1";
        this.player2.nome = "player2";

        MainScreen.btnRerun.setVisible(false);
        MainScreen.btnRerun.setEnabled(false);
        MainScreen.lbWin.setText("Winner: ");
        /*esp[0][0] = '0';
        esp[0][1] = '0';
        esp[0][2] = '0';
        esp[1][0] = '0';
        esp[1][1] = '0';
        esp[1][2] = '0';
        esp[2][0] = '0';
        esp[2][1] = '0';
        esp[2][2] = '0';*/
        
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                esp[i][j] = '0';
            }
        }
        
        this.atualizar();
        this.sortear();
        MainScreen.lbRound.setText("Round: " + this.round.nome);
        
        
        for(int i = 0; i <= 8; i++){
           MainScreen.buttons[i].setText(Character.toString(' '));
            MainScreen.buttons[i].setEnabled(true);
          
        }

        
    }

    @Override
    public void finalizar() {
        MainScreen.lbWin.setText("Winner: " + this.ganhador.nome);
         for(int i = 0; i <= 8; i++){
            MainScreen.buttons[i].setEnabled(false);
        }
        MainScreen.btnRerun.setVisible(true);
        MainScreen.btnRerun.setEnabled(true);
    }

    @Override
    public void atualizar() {
        
        System.out.printf("""
                          
                           %c  %c  %c
                           %c  %c  %c
                           %c  %c  %c
                        
                          
                           """,  this.esp[0][0],this.esp[0][1],this.esp[0][2],this.esp[1][0],
                           this.esp[1][1],this.esp[1][2],this.esp[2][0],this.esp[2][1],this.esp[2][2]);
    }

    @Override
    public void sortear() {
        
        Random rand = new Random();
        
        /*
            ordem
        */
        
        
        
        /*
         simbolo
        */
        
        this.player1.simb = rand.nextBoolean() ? 'x' : 'y';
        if(this.player1.simb == 'x'){
            this.player2.simb = 'y';
            
        }
        else{
            this.player2.simb = 'x';
        }
  
        int n = rand.nextInt(2);
  
        if(n == 1){
            this.player2.setSeu_turno(false);
            this.player1.setSeu_turno(true);
            System.out.println("Turno do Player 1");
            
            this.round = this.player1;
            
        
        }
        else if(n == 0){
            this.player1.setSeu_turno(false);
            this.player2.setSeu_turno(true);
            System.out.println("Turno do Player 2");
            this.round = this.player2;
        }
            
    }

    @Override
    public void fim_turno() {
        this.player1.setSeu_turno(!(this.player1.isSeu_turno()));
        this.player2.setSeu_turno(!(this.player2.isSeu_turno()));
        this.round = (this.player1.seu_turno == true)? this.player1 : this.player2;
        System.out.println("Turno mudou");
    }

    @Override
    public void verificar_acoes() {
        
                for(int i = 0; i <= 2; i++){
                    
                    if(this.esp[0][i] == this.esp[1][i] && this.esp[1][i] == this.esp[2][i] && this.esp[0][i] != '0'){
                        System.out.println(this.verificar_ganhador(0, 0) + " ganhou na vertical");
                        this.finalizar();
                        
                        break;
                    }
                    else if(this.esp[i][0] == this.esp[i][1] && this.esp[i][1] == this.esp[i][2]  && this.esp[i][0] != '0'){
                        System.out.println(this.verificar_ganhador(0, 0) + " ganhou na horizontal");
                        this.verificar_ganhador(0, 1);
                        this.finalizar();
                        break;
                    }
                    else if(this.esp[0][0] == this.esp[1][1] && this.esp[1][1] == this.esp[2][2]  && this.esp[0][0] != '0'){
                        System.out.println(this.verificar_ganhador(0, 0) + " ganhou na diagonal da esquerda para direita");
                        this.verificar_ganhador(1, 1);
                        this.finalizar();
                        break;
                    }
                    else if(this.esp[0][2] == this.esp[1][1] && this.esp[1][1] == this.esp[2][0]  && this.esp[2][0] != '0'){
                        System.out.println(this.verificar_ganhador(0, 0) + " ganhou na diagonal da direita para esquerda");
                        this.verificar_ganhador(0, 2);
                        this.finalizar();
                        break;
                    }
                    else{
                        this.fim_turno();
                    }
                    
                }
                         
    }

    @Override
    public String verificar_ganhador(int n1, int n2) {
        
        if(this.player1.simb == this.esp[n1][n2]){
            this.ganhador = this.player1;
        }
        else{
            this.ganhador = this.player2;
        }
        return this.ganhador.nome;
        
        

    }

    
}
