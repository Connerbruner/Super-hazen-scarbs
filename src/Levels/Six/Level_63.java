


// Source File Name:   Level_63.java

package Levels.Six;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_63 extends BasicLevel
{

    public Level_63()
    {
        BackGroundColor = "black";
        BackGroundMiddleImage1 = "stars[A]";
        BackGroundMiddleImage2 = "";
        BackGroundImage = "";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 7700;
        Bombs = true;
        BombsTurnOff = 156;
        AddCastle(1, 8, "small");
        AddStone(0, 13, 2, 16);
        AddTree(18, 13, 10, 21);
        AddTree(21, 9, 10, 24);
        AddTree(24, 13, 10, 27);
        AddTree(31, 9, 10, 35);
        AddLift_UpDown(28, 8, 4);
        AddCoin(28, 2, 1, 30);
        AddBouncer(38, 11);
        AddTree(37, 13, 10, 40);
        AddTree(43, 13, 10, 46);
        AddTree(49, 11, 10, 53);
        AddTree(65, 9, 10, 70);
        AddLift_LeftRight(40, 5, 4);
        AddLift_LeftRight(46, 7, 4);
        AddLift_LeftRight(52, 6, 4);
        AddLift_UpDown(60, 7, 4);
        AddQuestionMarkWithMushroom(55, 3);
        AddTree(65, 9, 10, 70);
        AddBalenceLift(70, 5, 4);
        AddBalenceLift(78, 5, 3);
        AddCoin(85, 2, 1, 88);
        AddTree(85, 3, 10, 88);
        AddTree(85, 10, 10, 90);
        AddTree(90, 8, 10, 93);
        AddTree(93, 13, 10, 96);
        AddTree(97, 13, 10, 101);
        AddTree(103, 13, 10, 106);
        AddCoin(100, 8, 1, 104);
        AddTree(107, 9, 10, 112);
        AddTree(113, 13, 10, 118);
        AddBouncer(116, 11);
        AddLift_LeftRight(120, 5);
        AddBalenceLift(126, 6, 4);
        AddCoin(128, 5, 1, 130);
        AddTree(132, 5, 10, 135);
        AddTree(132, 13, 10, 136);
        AddTree(135, 9, 10, 139);
        AddLiftFall(141, 7);
        AddLiftFall(145, 6);
        AddLiftFall(149, 8);
        AddLiftFall(153, 7);
        AddCoin(145, 7, 1, 147);
        AddCoin(154, 3, 1, 156);
        AddTree(156, 5, 15, 159);
        AddStone(160, 13, 2, 200);
        AddCheckPointsFlag(167, 3);
        AddChocolate(167, 12);
        AddCastle(170, 2, "big");
        AddCheckPoints(175, 12, 64, new Point(5, 6));
    }
}
