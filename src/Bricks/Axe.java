


// Source File Name:   Axe.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class Axe extends AdvanceSprite
    implements BasicBrick
{

    public Axe(int x, int y, BufferedImage storedImage[], Mario g)
    {
        setLocation(x, y);
        setImages(storedImage);
        setAnimate(true);
        setLoopAnim(true);
        int a[] = {
            0, 1, 2, 3, 2, 1
        };
        setAnimationFrame(a);
        setAnimationTimer(new Timer(200));
        setID(15);
        game = g;
    }

    
    public void HitFromDown()
    {
    }

    
    public void RemoveIt()
    {
    }

    
    public String getInsideItem()
    {
        return "empty";
    }

    
    public boolean isJump()
    {
        return false;
    }

    Mario game;
}
