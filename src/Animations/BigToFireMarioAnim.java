


// Source File Name:   BigToFireMarioAnim.java

package Animations;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BigToFireMarioAnim extends Sprite
{

    public BigToFireMarioAnim(double x, double y, Mario g)
    {
        Right = true;
        delay = 60;
        Fps = 2;
        BigBlackMario = new BufferedImage[4];
        FirePlayer = new BufferedImage[4];
        BigGreenMario = new BufferedImage[4];
        BigRedMario = new BufferedImage[4];
        currentFrame = 1;
        setLocation(x, y);
        game = g;
        BigBlackMario = game.bsLoader.getStoredImages("BigBlackMario");
        FirePlayer = game.bsLoader.getStoredImages("FirePlayer");
        BigGreenMario = game.bsLoader.getStoredImages("BigGreenMario");
        BigRedMario = game.bsLoader.getStoredImages("BigRedMario");
        MariosCurrentFrame = game.player.getFrame();
    }

    
    public void update(long l)
    {
        Fps--;
        if(Fps < 0)
        {
            nextFrame();
            Fps = 2;
        }
        delay--;
        if(delay < 0)
        {
            game.PlayEnemys();
            game.getPlayer().setImages(game.bsLoader.getStoredImages("FirePlayer"));
            setActive(false);
        }
        super.update(l);
    }

    
    public void render(Graphics2D g)
    {
        if(currentFrame == 1)
            setImage(BigBlackMario[MariosCurrentFrame]);
        else
        if(currentFrame == 2)
            setImage(FirePlayer[MariosCurrentFrame]);
        else
        if(currentFrame == 3)
            setImage(BigGreenMario[MariosCurrentFrame]);
        else
        if(currentFrame == 4)
            setImage(BigRedMario[MariosCurrentFrame]);
        super.render(g);
    }

    private void nextFrame()
    {
        if(currentFrame == 1)
            currentFrame = 2;
        else
        if(currentFrame == 2)
            currentFrame = 3;
        else
        if(currentFrame == 3)
            currentFrame = 4;
        else
        if(currentFrame == 4)
            currentFrame = 1;
    }

    Mario game;
    boolean Right;
    int delay;
    int Fps;
    BufferedImage BigBlackMario[];
    BufferedImage FirePlayer[];
    BufferedImage BigGreenMario[];
    BufferedImage BigRedMario[];
    private int currentFrame;
    int MariosCurrentFrame;
}
