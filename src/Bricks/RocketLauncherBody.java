


// Source File Name:   RocketLauncherBody.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class RocketLauncherBody extends Sprite
    implements BasicBrick
{

    public RocketLauncherBody(BufferedImage bufferedImage, int x, int y, Mario M)
    {
        super(bufferedImage, x, y);
        game = M;
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
