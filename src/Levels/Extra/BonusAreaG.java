


// Source File Name:   BonusAreaG.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class BonusAreaG extends BasicLevel
{

    public BonusAreaG()
    {
        BackGroundColor = "BarkBlue";
        BackGroundMiddleImage1 = "";
        BackGroundMiddleImage2 = "AnimatedSea";
        BackGroundImage = "";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Sea";
        LevelLength = 2200;
        AddHoriImage(62, 7);
        AddStone(0, 13, 2, 22);
        AddStone(26, 10, 5, 28);
        AddStone(32, 10, 5, 34);
        AddStone(34, 13, 2, 38);
        AddStone(40, 13, 2, 42);
        AddStone(44, 13, 2, 70);
        AddStone(59, 12, 1, 70);
        AddStone(60, 11, 1, 70);
        AddStone(61, 9, 2, 70);
        AddStone(63, 6, 3, 70);
        AddStone(61, 2, 4, 70);
        AddStone(11, 6, 1, 16);
        AddStone(26, 2, 3, 28);
        AddStone(32, 2, 2, 34);
        AddStone(38, 4, 1, 44);
        AddStone(50, 9, 1, 54);
        AddStone(54, 6, 1, 58);
        AddBrick(15, 4, 2, 16);
        AddBrick(12, 10, 3, 13);
        AddBrick(20, 9, 4, 21);
        AddBrick(38, 5, 4, 39);
        AddBrick(43, 5, 4, 44);
        AddBrick(46, 11, 2, 47);
        AddCoin(22, 7, 1, 32);
        AddCoin(40, 12, 1, 42);
        AddCoin(50, 8, 1, 54);
        AddCoin(54, 5, 1, 58);
        AddOctoPussy(14, 7);
        AddOctoPussy(29, 8);
        AddOctoPussy(40, 6);
        AddFishGrey(34, 5);
        AddFishGrey(43, 7);
        AddFishGrey(48, 4);
        AddFishRed(55, 11);
        AddFishRed(60, 2);
        AddLiftDown(22, 4, 4);
        AddLiftDown(28, 6, 4);
    }
}
