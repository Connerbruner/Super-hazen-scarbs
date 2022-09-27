


// Source File Name:   BigToSmallMarioAnim.java

package Animations;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BigToSmallMarioAnim extends AdvanceSprite
{

    public BigToSmallMarioAnim(double x, double y, BufferedImage storedImages[], Mario g, boolean RightActivated)
    {
        Right = true;
        Blink = false;
        Right = RightActivated;
        if(Right)
        {
            setImages(storedImages);
        } else
        {
            BufferedImage Allimages[] = storedImages;
            for(int i = 0; i < Allimages.length; i++)
                Allimages[i] = ImageUtil.flipHorizontal(Allimages[i]);

            setImages(Allimages);
        }
        int anim[] = {
            0, 1, 0, 1, 0, 1, 2, 3, 2, 3, 
            2, 3, 2, 3, 3, 3, 3, 4, 4, 4
        };
        setAnimationFrame(anim);
        setLocation(x, y);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        game = g;
    }

    
    public void update(long l)
    {
        if(getFrame() == getFinishAnimationFrame())
        {
            game.PlayEnemys();
            game.getPlayer().setImages(game.bsLoader.getStoredImages("player"));
            setActive(false);
        }
        super.update(l);
        if(Blink)
            Blink = false;
        else
            Blink = true;
    }

    
    public void render(Graphics2D g)
    {
        if(Blink)
            super.render(g);
    }

    Mario game;
    boolean Right;
    boolean Blink;
}
