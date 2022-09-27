


// Source File Name:   BonusAreaD.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class BonusAreaD extends BasicLevel
{

    public BonusAreaD()
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
        AddBrick(3, 2, 1, 19);
        AddBrick(3, 9, 1, 15);
        AddBrick(3, 10, 2, 4);
        AddBrick(14, 10, 2, 15);
        AddCoin(3, 8, 1, 15);
        AddCoin(3, 12, 1, 15);
        AddBrickWithMushroom(17, 9);
        AddStone(0, 13, 2, 20);
        AddPumpImage(19, 2, 9);
        AddHoriImage(17, 11);
    }
}
