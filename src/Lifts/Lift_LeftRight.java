


// Source File Name:   Lift_LeftRight.java

package Lifts;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;

// Referenced classes of package Lifts:
//            BasicLift

public class Lift_LeftRight extends Sprite
    implements BasicLift
{

    public Lift_LeftRight(int x, int y, Mario g)
    {
        MarioOnLift = false;
        DistanceFromCenter = 64D;
        game = g;
        setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6));
        setLocation(x, y);
        CenterX = x;
    }

    public Lift_LeftRight(int x, int y, Mario g, int Points)
    {
        MarioOnLift = false;
        DistanceFromCenter = 64D;
        game = g;
        setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), Points));
        setLocation(x, y);
        CenterX = x;
    }

    
    public void update(long elapsedTime)
    {
        x1 = getOldX();
        setX(Math.cos(game.Distance) * DistanceFromCenter + CenterX);
        x1 = getX() - x1;
        if(MarioOnLift)
        {
            game.player.moveX(x1);
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
    private double DistanceFromCenter;
    private double CenterX;
    double x1;
}
