// Source File Name:   Level_62.java
package Levels.Six;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_62 extends BasicLevel {

    public Level_62() {
        BackGroundColor = "black";
        BackGroundMiddleImage1 = "stars[A]";
        BackGroundMiddleImage2 = "purplestones";
        BackGroundImage = "grass[A]";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 7700;
        AddStone(0, 13, 2, 123);
        AddStone(129, 13, 2, 141);
        AddStone(142, 13, 2, 143);
        AddStone(144, 13, 2, 152);
        AddStone(153, 13, 2, 270);
        AddCastle(1, 8, "small");
        AddBrick(10, 9, 1, 13);
        AddPump(19, 9, 4);
        AddBrick(23, 5);
        AddBank(24, 5);
        AddBrick(25, 5);
        AddInvisibleBrckWithCoin(24, 9);
        AddTurtle(24, 11);
        AddPump(28, 9, 4);
        AddPump(32, 6, 2);
        AddChocolate(32, 8, 1, 34);
        AddPump(35, 11, 2);
        AddPump(37, 11, 2);
        AddPump(46, 9, 4);
        AddBrick(51, 9);
        AddBrickWithMushroom(52, 9);
        AddPump(56, 8, 5);
        AddPump(62, 7, 2);
        AddChocolate(62, 9, 1, 64);
        AddPump(67, 11, 2);
        AddPump(74, 11, 2);
        AddBrick(67, 5, 1, 72);
        AddBrick(77, 5, 1, 80);
        AddPump(80, 10, 3);
        AddInvisibleBrckWithCoin(82, 9);
        AddPump(84, 11, 2);
        AddPump(87, 7, 6);
        AddPump(94, 10, 3);
        AddPump(102, 9, 4);
        AddPump(105, 11, 2);
        AddPump(111, 6, 3);
        AddChocolate(111, 9, 1, 113);
        AddPump(115, 11, 2);
        AddBrick(110, 9);
        AddBrick(113, 9);
        AddBrick(115, 5);
        AddHelmet(115, 8);
        AddBrick(119, 5, 1, 128);
        AddPump(131, 11, 2);
        AddPump(135, 11, 2);
        AddBrick(138, 8, 1, 140);
        AddBrick(145, 5, 1, 147);
        AddBrick(144, 9, 1, 147);
        AddBrickWithStar(140, 5);
        AddBrick(141, 5);
        AddChocolate(149, 12, 1, 152);
        AddChocolate(150, 11, 1, 152);
        AddChocolate(151, 10);
        AddPump(153, 10, 3);
        AddChocolate(156, 9, 4, 157);
        AddChocolate(157, 11, 2, 158);
        AddBrick(160, 5, 1, 163);
        AddBrick(160, 9, 1, 163);
        AddPump(167, 6, 3);
        AddChocolate(167, 9, 1, 169);
        AddPump(174, 9, 4);
        AddPump(179, 11, 2);
        AddPump(181, 10, 3);
        AddPump(183, 9, 4);
        AddPump(189, 10, 3);
        AddPump(201, 9, 4);
        AddChocolate(199, 12);
        AddChocolate(200, 11, 2, 201);
        for (int i = 0; i < 4; i++) {
            AddChocolate(203 + i, 8 - i, 5 + i, 208);
        }

        AddCheckPointsFlag(216, 3);
        AddChocolate(216, 12);
        AddCastle(220, 8, "small");
        AddCheckPoints(223, 12, 63, new Point(2, 3));
        AddHelmet(51, 12);
        AddHelmet(91, 12);
        AddHelmet(158, 12);
        AddEnemyMushroom(166, 12);
        AddFlyingTurtle(205, 2);
        AddCheckPoints_InsidePumpvertically(19, 9, 105, new Point(2, 3));
        AddCheckPoints_InsidePumpvertically(56, 8, 106, new Point(2, 3));
        AddCheckPoints_InsidePumpvertically(153, 10, 107, new Point(2, 3));

        this.AddClowdGoUP_CheckPoints(81, 3, 96, new Point(5, 5));
        AddQuestionMark(81, 5);

    }
}
