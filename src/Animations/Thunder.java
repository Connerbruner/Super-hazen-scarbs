


// Source File Name:   Thunder.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.object.*;
import com.golden.gamedev.util.Utility;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Thunder extends AnimatedSprite
{

    public Thunder(int x, int y, BufferedImage storedImages[], Mario M)
    {
        delay = 0;
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        game = M;
        OriginalX = x;
    }

    
    public void update(long elapsedTime)
    {
        delay--;
        if(delay < 0)
        {
            delay = Utility.getRandom(1, 5) * 25;
            setAnimate(true);
        }
        setX(game.playfield.getBackground().getX());
        super.update(elapsedTime);
    }

    
    public void render(Graphics2D g)
    {
        g.drawImage(getImage(), 0, 0, 640, 480, null);
        super.render(g);
    }

    Mario game;
    int OriginalX;
    int delay;
}
