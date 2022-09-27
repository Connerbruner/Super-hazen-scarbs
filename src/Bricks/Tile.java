


// Source File Name:   Tile.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;

// Referenced classes of package Bricks:
//            BasicBrick

public class Tile extends Sprite
    implements BasicBrick
{

    public Tile(int x, int y, int Frame, Mario M)
    {
        game = M;
        setLocation(x, y);
        setImage(game.bsLoader.getStoredImages("Tile")[Frame]);
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

    Mario game;
}
