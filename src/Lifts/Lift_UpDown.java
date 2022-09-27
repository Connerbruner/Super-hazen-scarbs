


// Source File Name:   Lift_UpDown.java

package Lifts;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;

// Referenced classes of package Lifts:
//            BasicLift

public class Lift_UpDown extends Sprite
    implements BasicLift
{

    public Lift_UpDown(int x, int y, Mario g)
    {
        MarioOnLift = false;
        DistanceFromCenter = 160D;
        game = g;
        setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6));
        setLocation(x, y);
        CenterY = y;
    }

    public Lift_UpDown(int x, int y, Mario g, int Points)
    {
        MarioOnLift = false;
        DistanceFromCenter = 160D;
        game = g;
        setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), Points));
        setLocation(x, y);
        CenterY = y;
    }

    
    public void update(long elapsedTime)
    {
        int zx = (int)(Math.cos(game.Distance) * DistanceFromCenter);
        setY((double)zx + CenterY);
        if(MarioOnLift)
        {
            game.player.moveY(4D);
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
    private double CenterY;
}
