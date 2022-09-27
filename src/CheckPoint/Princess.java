


// Source File Name:   Princess.java

package CheckPoint;

import java.awt.Point;

// Referenced classes of package CheckPoint:
//            CheckPoints

public class Princess extends CheckPoints
{

    public Princess(double x, double y, int NextLevel, Point NextLocation)
    {
        super(x, y + 16D, NextLevel, NextLocation);
        this.NextLevel = NextLevel;
        this.NextLocation = NextLocation;
        setID(26);
    }

    
    public int GetNextLevel()
    {
        return NextLevel;
    }

    
    public Point GetNextLocation()
    {
        return NextLocation;
    }
}
