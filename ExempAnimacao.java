
package Animacoes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author isaura
 */
public class ExempAnimacao extends JFrame
{
    
    
    
  
    private Image[] loadImagens() {
        Image[] frames = new Image[3];
        String url = "img/";
            for (int i = 0; i < frames.length; i++) {
                String fileName = url+"a" + (i + 1) + ".jpg";
                
                Image file = new ImageIcon(getClass().getResource(fileName)).getImage();
                frames[i] = file;
            }
       
      
        return frames;
    }
    
     public ExempAnimacao() {
          this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
       this.setResizable(false);
        setMinimumSize(new Dimension(600, 600));

        // nesse exemplo, todas as animações vão ter imagens distintas, substitua as minhas imagens pelas tuas!!
        Image[] frames = loadImagens();

        Animacao animation1 = new Animacao(frames, 500); // animação de 0.5 segundos
        Animacao animation2 = new Animacao(frames, 1000); // animação de 1 segundo
        //Animation animation3 = new Animation(frames, 1500); // animação de 1.5 segundos
        //Animation animation4 = new Animation(frames, 3000); // animação de 3 segundos

        JButton button1 = new JButton("Animação 1");
        button1.addActionListener(event -> clicouNoBotao(animation1));

        JButton button2 = new JButton("Animação 2");
        button2.addActionListener(event -> clicouNoBotao(animation2));

        

        JPanel animationPanel = new JPanel(new GridLayout(2, 2));
        animationPanel.setBackground(Color.red);
        animationPanel.add(animation1);
        animationPanel.add(animation2);
        

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
      
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(buttonPanel, BorderLayout.NORTH);
        container.add(animationPanel, BorderLayout.CENTER);
    }

    private void clicouNoBotao(Animacao animation) 
    {
        if (animation.isRunning()) 
        {
            animation.stop();
        } else {
            animation.start();
        }
    }

    
    public static void main(String[] args) 
    {
        new ExempAnimacao().setVisible(true);
    }
}
