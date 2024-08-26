/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tictactoe;

/**
 *
 * @author JGLop
 */
public abstract interface AcoesJogo {
    
    public abstract void iniciar(Player p1, Player p2);
    public abstract void finalizar();
    public abstract void verificar_acoes();
    public abstract String verificar_ganhador(int n1, int n2);
    public abstract void atualizar();
    public abstract void sortear();
    public abstract void fim_turno();
    
    
}
