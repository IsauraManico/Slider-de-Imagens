
package Animacoes;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author isaura
 */
public class Animacao extends JComponent
{
    
    private Image[] frames;
    private int frameDuracao;
    private int currentFrame;
    private boolean running;
    
    
    public Animacao(Image[] frames, long duration)
    {
        this.frames = frames;
        setDuration(duration);
    }
    
     public void setDuration(long duration)
     {
        frameDuracao = (int) (duration / frames.length);
    }
      public boolean isRunning() {
        return running;
    }
      
      
       public void start() {
        if (!running) {
            running = true;
            new Thread(() -> animate(), "Animator").start();
        }
    }

    public void stop() {
        running = false;
    }

    private void animate() 
    {
        try {
            while (isRunning()) {
                repaint();
                Thread.sleep(frameDuracao);
                nextFrame();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void nextFrame() {
        currentFrame = (currentFrame + frames.length + 1) % frames.length;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(frames[currentFrame], 0, 0, getWidth(), getHeight(), this);
    }

    
    
}
