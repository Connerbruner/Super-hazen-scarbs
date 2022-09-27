


// Source File Name:   Level_Start.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_Start extends BasicLevel
{

    public Level_Start()
    {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "mountain";
        BackGroundImage = "grass[A]";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 640;
        AddStone(0, 13, 2, 30);
    }
}
