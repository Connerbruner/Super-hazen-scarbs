


// Source File Name:   chocolate.java

package Bricks;

import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class chocolate extends Sprite
    implements BasicBrick
{

    public chocolate(int x, int y, BufferedImage storedImage)
    {
        setLocation(x, y);
        setImage(storedImage);
        setID(2);
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
