


// Source File Name:   Iron.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class Iron extends Sprite
    implements BasicBrick
{

    Iron(int x, int y, BufferedImage storedImage[], Mario g)
    {
        Gravity = -5;
        Jump = true;
        setLocation(x, y);
        game = g;
        if("Sea".equals(game.GetAttribute()))
            setImage(storedImage[0]);
        else
        if("Ground".equals(game.GetAttribute()))
            setImage(storedImage[1]);
        else
        if("UnderGround".equals(game.GetAttribute()))
            setImage(storedImage[2]);
        else
        if("Castle".equals(game.GetAttribute()))
            setImage(storedImage[3]);
        setID(2);
    }

    public Iron(int x, int y, BufferedImage storedImage[], String color, Mario g)
    {
        Gravity = -5;
        Jump = true;
        setLocation(x, y);
        game = g;
        if("UnderGround".equals(game.GetAttribute()) || "Castle".equals(game.GetAttribute()))
            setImage(storedImage[0]);
        else
            setImage(storedImage[1]);
        setID(2);
    }

    public Iron(int x, int y, BufferedImage storedImage[], String color, String bounce, Mario g)
    {
        Gravity = -5;
        Jump = true;
        setLocation(x, y);
        game = g;
        if("UnderGround".equals(game.GetAttribute()) || "Castle".equals(game.GetAttribute()))
            setImage(storedImage[0]);
        else
            setImage(storedImage[1]);
        setID(2);
        if("noBounce".equals(bounce))
        {
            Jump = false;
            Gravity = 5;
        }
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
        return Jump;
    }

    int Gravity;
    boolean Jump;
    Mario game;
}
