


// Source File Name:   LiftUP.java

package Lifts;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;

// Referenced classes of package Lifts:
//            BasicLift

public class LiftUP extends Sprite
    implements BasicLift
{

    public LiftUP(int x, int y, Mario g)
    {
        MarioOnLift = false;
        game = g;
        setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6));
        setLocation(x, y);
    }

    public LiftUP(int x, int y, Mario g, int Points)
    {
        MarioOnLift = false;
        game = g;
        setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), Points));
        setLocation(x + 24, y);
    }

    
    public void update(long elapsedTime)
    {
        if(getY() < -100D)
            setY(580D);
        moveY(-2D);
        if(MarioOnLift)
        {
            game.player.moveY(-2D);
            MarioOnLift = false;
        }
        super.update(elapsedTime);
    }

    
    public boolean OnLift()
    {
        return MarioOnLift;
    }

    
    public void MarioIsOnLift()
    {
        MarioOnLift = true;
    }

    boolean MarioOnLift;
    Mario game;
}
