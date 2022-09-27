


// Source File Name:   BonusAreaC.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class BonusAreaC extends BasicLevel
{

    public BonusAreaC()
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
        AddBrick(5, 5, 2, 7);
        AddBrick(5, 7, 2, 6);
        AddBrick(13, 5, 2, 15);
        AddBrick(14, 7, 2, 15);
        AddBrick(6, 9);
        AddBrick(13, 9);
        AddBrick(7, 8);
        AddBrick(12, 8);
        AddBrick(8, 7);
        AddBrick(11, 7);
        AddBrick(9, 5, 2, 11);
        AddBrickWithMushroom(7, 5);
        AddBrick(12, 5);
        AddCoin(9, 3, 1, 11);
        AddCoin(8, 4, 1, 12);
        AddCoin(6, 8);
        AddCoin(13, 8);
        AddCoin(7, 7);
        AddCoin(12, 7);
        AddCoin(8, 6);
        AddCoin(11, 6);
        AddStone(0, 13, 2, 20);
        AddPumpImage(19, 2, 9);
        AddHoriImage(17, 11);
    }
}
