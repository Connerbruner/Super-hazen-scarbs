


// Source File Name:   BrickWithStar.java

package Bricks;

import Animations.StarAnim;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            Iron, BasicBrick

public class BrickWithStar extends Sprite
    implements BasicBrick
{

    public BrickWithStar(int x, int y, BufferedImage b, Mario g)
    {
        InsideItem = "Star";
        setLocation(x, y);
        setImage(b);
        setID(11113);
        game = g;
    }

    
    public void HitFromDown()
    {
        game.BrickGroup.add(new Iron((int)getX(), (int)getY(), game.bsLoader.getStoredImages("Iron"), game));
        game.VolitileGroup.add(new StarAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("Star")[0], game));
        RemoveIt();
    }

    
    public void RemoveIt()
    {
        setActive(false);
    }

    
    public String getInsideItem()
    {
        return InsideItem;
    }

    
    public boolean isJump()
    {
        return false;
    }

    private String InsideItem;
    Mario game;
}
