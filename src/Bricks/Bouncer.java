


// Source File Name:   Bouncer.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class Bouncer extends Sprite
    implements BasicBrick
{

    public Bouncer(int x, int y, BufferedImage b, Mario g)
    {
        setLocation(x, y);
        setImage(b);
        setID(13);
        game = g;
    }

    
    public void RemoveIt()
    {
        setActive(false);
    }

    
    public void HitFromDown()
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
