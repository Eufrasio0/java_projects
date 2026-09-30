package Aula;
import javax.swing.*;
import java.awt.*;

public class Aula1 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cont = 1;
        while(cont <= 40) {
            g.drawLine(10, 10, 700, cont * 20);
            
            cont++;
       }
       g.drawString("porra", 10, 300);
    }

    public static void main(String[] args) {

        JFrame janela = new JFrame();

        Aula1 painel = new Aula1();

        janela.add(painel);

        janela.setSize(500, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
    



