


// Source File Name:   BonusAreaE.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class BonusAreaE extends BasicLevel
{

    public BonusAreaE()
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
        AddBrick(4, 7, 1, 15);
        AddBrick(14, 3, 4, 15);
        AddBrick(4, 6);
        AddBrick(15, 5, 1, 17);
        AddCoin(5, 5, 2, 14);
        AddBank(18, 7);
        AddStone(0, 13, 2, 20);
        AddPumpImage(19, 2, 9);
        AddHoriImage(17, 11);
    }
}
