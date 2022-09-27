


// Source File Name:   Level_41.java

package Levels.Four;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_41 extends BasicLevel
{

    public Level_41()
    {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "mountain &trees";
        BackGroundImage = "grass[A]";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 8000;
        AddSonOfABuitch(33, 3);
        AddCastle(1, 2, "big");
        AddStone(0, 13, 2, 32);
        AddPump(21, 10, 3);
        AddQuestionMark(25, 5);
        AddQuestionMarkWithMushroom(25, 9);
        AddStone(34, 13, 2, 78);
        AddCoin(41, 9);
        AddCoin(42, 8, 1, 44);
        AddCoin(44, 9);
        AddQuestionMark(64, 5);
        AddQuestionMark(66, 5);
        AddQuestionMark(64, 9);
        AddQuestionMark(66, 9);
        AddStone(82, 13, 2, 149);
        AddQuestionMark(90, 9, 1, 94);
        AddInvisibleBrckWith1Up(92, 5);
        AddChocolate(103, 10, 3, 104);
        AddCoin(105, 6, 1, 109);
        AddPump(116, 9, 4);
        AddPump(132, 9, 4);
        AddCoin(119, 6, 1, 123);
        AddCoin(135, 6, 1, 139);
        AddQuestionMark(148, 5, 1, 152);
        AddQuestionMark(146, 9, 1, 148);
        AddQuestionMarkWithMushroom(148, 9);
        AddBrick(149, 9, 1, 151);
        AddQuestionMark(151, 9, 1, 154);
        AddPump(163, 11, 2);
        AddStone(151, 13, 2, 174);
        AddStone(177, 13, 2, 180);
        AddStone(182, 13, 2, 190);
        AddChocolate(189, 10, 3, 190);
        AddStone(192, 13, 2, 280);
        for(int i = 0; i < 8; i++)
            AddChocolate(208 + i, 12 - i, 1, 217);

        AddBank(220, 9);
        AddCheckPointsFlag(225, 3);
        AddChocolate(225, 12);
        AddCastle(229, 8, "small");
        AddCheckPoints(232, 12, 42, new Point(2, 3));
        AddCheckPoints_InsidePumpvertically(132, 9, 101, new Point(2, 3));
    }
}
