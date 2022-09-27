


// Source File Name:   SmallToBigMarioAnim.java

package Animations;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

public class SmallToBigMarioAnim extends AdvanceSprite
{

    public SmallToBigMarioAnim(double x, double y, BufferedImage storedImages[], Mario g, boolean right)
    {
        Right = true;
        Right = right;
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
            0, 1, 0, 1, 0, 1, 0, 1, 2, 1, 
            0, 1, 2, 0, 2
        };
        setAnimationFrame(anim);
        setLocation(x, y);
        setAnimationTimer(new Timer(150));
        setAnimate(true);
        setLoopAnim(true);
        game = g;
    }

    
    public void update(long l)
    {
        if(getFrame() == getFinishAnimationFrame())
        {
            game.PlayEnemys();
            game.getPlayer().setImages(game.bsLoader.getStoredImages("BigPlayer"));
            setActive(false);
        }
        super.update(l);
    }

    Mario game;
    boolean Right;
}
