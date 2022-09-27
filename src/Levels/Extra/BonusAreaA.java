


// Source File Name:   BonusAreaA.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class BonusAreaA extends BasicLevel
{

    public BonusAreaA()
    {
        BackGroundColor = "";
        BackGroundMiddleImage1 = "";
        BackGroundMiddleImage2 = "cave-img";
        BackGroundImage = "";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "UnderGround";
        LevelLength = 640;
        AddBrick(0, 2, 12, 1);
        AddBrick(4, 2, 1, 15);
        AddBrick(4, 10, 3, 15);
        AddCoin(5, 5, 1, 14);
        AddCoin(4, 7, 1, 15);
        AddCoin(4, 9, 1, 15);
        AddStone(0, 13, 2, 20);
        AddPumpImage(19, 2, 9);
        AddHoriImage(17, 11);
    }
}
