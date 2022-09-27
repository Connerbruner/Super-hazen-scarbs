


// Source File Name:   WoodenBridge.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;

// Referenced classes of package Bricks:
//            BasicBrick

public class WoodenBridge extends Sprite
    implements BasicBrick
{

    public WoodenBridge(int x, int y, Mario g)
    {
        setLocation(x, y);
        game = g;
        setImage(game.bsLoader.getStoredImage("WoodenBridge"));
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

    Mario game;
}
