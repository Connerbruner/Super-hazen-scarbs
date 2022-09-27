


// Source File Name:   LifeAnim.java

package Animations;

import Objects.Life;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class LifeAnim extends Sprite
{

    public LifeAnim(int x, int y, BufferedImage storedImages, Mario M)
    {
        GiveSomeTimeToRender = 16;
        start = false;
        setLocation(x, y);
        setImage(storedImages);
        reachPosY = y - 32;
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
                game.EnemyGroup.add(new Life((int)getX(), reachPosY, game.bsLoader.getStoredImages("1UP"), game));
                setActive(false);
            }
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
