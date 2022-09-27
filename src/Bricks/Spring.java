


// Source File Name:   Spring.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class Spring extends AdvanceSprite
    implements BasicBrick
{

    public Spring(int x, int y, BufferedImage b[], Mario g)
    {
        setLocation(x, y);
        setImages(b);
        int anim[] = {
            0, 1, 2, 2, 1, 0
        };
        setAnimationFrame(anim);
        setID(14);
        game = g;
    }

    
    public void RemoveIt()
    {
    }

    
    public void HitFromDown()
    {
    }

    
    public String getInsideItem()
    {
        return "empty";
    }

    public void PlayAnimation()
    {
        setAnimate(true);
    }

    
    public boolean isJump()
    {
        return false;
    }

    Mario game;
}
