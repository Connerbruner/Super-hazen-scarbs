


// Source File Name:   Stone.java

package Bricks;

import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class Stone extends Sprite
    implements BasicBrick
{

    public Stone(int x, int y, BufferedImage Stone_Image)
    {
        setLocation(x, y);
        setImage(Stone_Image);
        setID(4);
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
}
