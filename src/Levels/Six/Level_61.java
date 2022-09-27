


// Source File Name:   Level_61.java

package Levels.Six;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_61 extends BasicLevel
{

    public Level_61()
    {
        BackGroundColor = "black";
        BackGroundMiddleImage1 = "stars[A]";
        BackGroundMiddleImage2 = "purplestones";
        BackGroundImage = "grass[A]";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 6700;
        AddCastle(1, 2, "big");
        AddQuestionMark(16, 9, 1, 18);
        AddStone(0, 13, 2, 20);
        AddSonOfABuitch(32, 2);
        AddChocolate(26, 12, 1, 32);
        AddChocolate(29, 11, 1, 34);
        AddChocolate(31, 10, 1, 36);
        AddChocolate(35, 9, 1, 38);
        AddBrickWithMushroom(36, 5);
        AddBrick(37, 5);
        AddStone(23, 13, 2, 31);
        AddStone(37, 13, 2, 39);
        AddBrick(41, 9, 1, 43);
        AddBank(43, 9);
        AddStone(41, 13, 2, 57);
        AddCoin(62, 9, 1, 65);
        for(int i = 0; i < 4; i++)
            AddChocolate(69 + i, 12 - i, 1, 74);

        AddStone(59, 13, 2, 74);
        AddCoin(76, 7, 1, 78);
        AddStone(77, 13, 2, 92);
        AddChocolate(84, 11, 1, 86);
        AddChocolate(85, 10);
        AddChocolate(87, 8, 5, 90);
        AddChocolate(88, 7, 1, 90);
        AddChocolate(89, 6);
        AddBrick(90, 6, 1, 93);
        AddInvisibleBrckWith1Up(90, 8);
        AddBrick(92, 10, 1, 95);
        AddStone(96, 13, 2, 127);
        AddPump(102, 10, 3);
        AddCoin(105, 8, 1, 108);
        AddInvisibleBrckWithCoin(113, 5);
        AddInvisibleBrckWithCoin(113, 9);
        for(int i = 0; i < 5; i++)
            AddChocolate(122 + i, 12 - i, 1, 127);

        AddBrick(127, 8, 1, 129);
        AddBrickWithMushroom(130, 8);
        AddQuestionMark(131, 8);
        AddBrick(130, 12, 1, 135);
        AddStone(134, 13, 2, 136);
        AddStone(137, 13, 2, 149);
        for(int i = 0; i < 6; i++)
            AddChocolate(143 + i, 12 - i, 1, 149);

        AddBrick(149, 7, 1, 151);
        AddBrick(151, 9);
        AddBank(152, 9);
        AddBrick(152, 11, 1, 155);
        AddStone(155, 13, 2, 164);
        AddStone(167, 13, 2, 174);
        for(int i = 0; i < 5; i++)
            AddChocolate(169 + i, 12 - i, 1, 174);

        AddStone(176, 13, 2, 220);
        AddChocolate(176, 5, 8, 178);
        AddCheckPointsFlag(186, 3);
        AddChocolate(186, 12);
        AddCastle(192, 8, "small");
        AddCheckPoints(195, 12, 62, new Point(2, 3));
    }
}
