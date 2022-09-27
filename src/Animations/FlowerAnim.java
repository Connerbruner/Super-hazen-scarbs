


// Source File Name:   FlowerAnim.java

package Animations;

import Objects.Flower;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class FlowerAnim extends AnimatedSprite
{

    public FlowerAnim(int x, int y, BufferedImage storedImages[], Mario M)
    {
        GiveSomeTimeToRender = 16;
        start = false;
        setLocation(x, y);
        setImages(storedImages);
        reachPosY = y - 32;
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(100));
        game = M;
        game.playSound("music/smb_powerup_appears.mp3");
    }

    
    public void update(long l)
    {
        if(GiveSomeTimeToRender > 0)
            GiveSomeTimeToRender--;
        else
            start = true;
        if(start)
            if(getY() >= (double)reachPosY)
            {
                moveY(-1D);
            } else
            {
                game.EnemyGroup.add(new Flower((int)getX(), reachPosY, game.bsLoader.getStoredImages("Flower"), game));
                setActive(false);
            }
        super.update(l);
    }

    
    public void render(Graphics2D g)
    {
        if(start)
            super.render(g);
    }

    int reachPosY;
    Mario game;
    int GiveSomeTimeToRender;
    boolean start;
}
