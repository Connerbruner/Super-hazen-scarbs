


// Source File Name:   BonusAreaB.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class BonusAreaB extends BasicLevel
{

    public BonusAreaB()
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
        AddBrick(3, 2, 4, 19);
        AddBrick(17, 6, 5, 19);
        AddBrick(3, 9, 1, 16);
        AddBank(16, 9);
        AddCoin(4, 8, 1, 16);
        AddCoin(3, 12, 1, 16);
        AddStone(0, 13, 2, 20);
        AddPumpImage(19, 2, 9);
        AddHoriImage(17, 11);
    }
}
