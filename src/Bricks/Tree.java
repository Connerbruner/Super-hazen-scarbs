


// Source File Name:   Tree.java

package Bricks;

import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class Tree extends Sprite
    implements BasicBrick
{

    public Tree(int x, int y, BufferedImage Stone_Image)
    {
        setLocation(x, y);
        setImage(Stone_Image);
        setID(22);
    }

    public Tree(BufferedImage bufferedImage, int x, int y)
    {
        this(x, y, bufferedImage);
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
