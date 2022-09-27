


// Source File Name:   UnderGroundEnd.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class UnderGroundEnd extends BasicLevel
{

    public UnderGroundEnd()
    {
        BackGroundColor = "Blue";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        BackGroundImage = "Mountain";
        attribute = "Ground";
        LevelLength = 1500;
        AddStone(0, 13, 2, 50);
        AddPump(3, 11, 2);
        for(int i = 0; i < 8; i++)
            AddChocolate(5 + i, 12 - i, 1, 14);

        AddChocolate(22, 12);
        AddCastle(26, 8, "small");
        AddCheckPoints(29, 12, 13, new Point(3, 11));
    }
}
