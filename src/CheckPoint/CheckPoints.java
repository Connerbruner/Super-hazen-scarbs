


// Source File Name:   CheckPoints.java

package CheckPoint;

import com.golden.gamedev.object.Sprite;
import java.awt.Point;

// Referenced classes of package CheckPoint:
//            BasicCheckPoints

public class CheckPoints extends Sprite
    implements BasicCheckPoints
{

    public CheckPoints(double x, double y, int NextLevel, Point NextLocation)
    {
        super(x, y);
        this.NextLevel = NextLevel;
        this.NextLocation = NextLocation;
        setID(23);
    }

    
    public void update(long elapsedTime)
    {
        super.update(elapsedTime);
    }

    
    public int GetNextLevel()
    {
        return NextLevel;
    }

    
    public Point GetNextLocation()
    {
        return NextLocation;
    }

    public int NextLevel;
    public Point NextLocation;
}
