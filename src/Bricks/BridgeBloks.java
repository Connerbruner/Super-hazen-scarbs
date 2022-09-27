


// Source File Name:   BridgeBloks.java

package Bricks;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            TemporaryAndInvisibleBrick, BasicBrick

public class BridgeBloks extends Sprite
    implements BasicBrick
{

    public BridgeBloks(int x, int y, BufferedImage b, Mario g)
    {
        Gravity = 4;
        Jump = false;
        setLocation(x, y);
        setImage(b);
        setID(18);
        game = g;
    }

    
    public void update(long l)
    {
        if(Gravity >= 4)
        {
            Jump = false;
        } else
        {
            Gravity = Gravity + 1;
            moveY(Gravity);
        }
    }

    
    public void HitFromDown()
    {
        if(game.player.getID() == 2 || game.player.getID() == 3)
        {
            game.addSomeBrickFragmends(getX(), getY());
            game.BrickGroup.add(new TemporaryAndInvisibleBrick((int)getX(), (int)getY(), ImageUtil.createImage(32, 32, 3), game));
            RemoveIt();
        }
        Gravity = -5;
        Jump = true;
    }

    
    public void RemoveIt()
    {
        setActive(false);
    }

    
    public String getInsideItem()
    {
        return "empty";
    }

    public void Bounce()
    {
        Gravity = -5;
        Jump = true;
    }

    
    public boolean isJump()
    {
        return Jump;
    }

    int Gravity;
    boolean Jump;
    Mario game;
}
