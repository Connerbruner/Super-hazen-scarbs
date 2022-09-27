// Source File Name:   Level_52.java
package Levels.Five;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_52 extends BasicLevel {

    public Level_52() {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "lolypopWhite";
        BackGroundImage = "fencewhite";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 7000;
        AddCastle(1, 8, "small");
        AddStone(0, 13, 2, 26);
        AddStone(29, 13, 2, 66);
        for (int i = 0; i < 3; i++) {
            AddChocolate(12 + i, 12 - i, 1, 16);
        }

        AddChocolate(16, 9, 1, 19);
        AddRocketLauncher(17, 7, 2);
        AddTurtle(20, 11);
        AddBouncer(25, 11);
        AddCoin(21, 4, 1, 24);
        AddCoin(29, 8, 1, 32);
        AddBrick(29, 5, 1, 34);
        AddBrickWithMushroom(34, 5);
        AddBrick(29, 9, 1, 35);
        AddFlyingTurtle(38, 9);
        AddMonkey(45, 9);
        for (int i = 0; i < 3; i++) {
            AddChocolate(44 + i, 12 - i, 1, 49);
        }

        AddChocolate(49, 11, 2, 50);
        AddPump(55, 10, 3);
        for (int i = 0; i < 4; i++) {
            AddChocolate(62 + i, 12 - i, 1, 66);
        }

        AddChocolate(68, 8, 5, 71);
        AddChocolate(69, 7, 1, 71);
        AddEnemyMushroom(59, 12);
        AddEnemyMushroom(60, 12);
        AddQuestionMark(78, 9, 1, 83);
        AddInvisibleBrckWithCoin(84, 9);
        AddMonkey(82, 10);
        AddBrick(86, 5, 1, 88);
        AddBrick(89, 8, 1, 92);
        AddStone(68, 13, 2, 92);
        AddCoin(86, 4, 1, 88);
        AddCoin(89, 12, 1, 91);
        AddStone(96, 13, 2, 127);
        AddFlyingTurtle(105, 9);
        AddRocketLauncher(107, 11, 2);
        AddPump(115, 11, 2);
        AddBrick(118, 5, 1, 125);
        AddBrickWithStar(125, 5);
        AddBrick(118, 9, 1, 126);
        AddStone(129, 13, 2, 144);
        AddChocolate(129, 10, 3, 130);
        AddMonkey(120, 2);
        AddMonkey(123, 7);
        AddHelmet(134, 12);
        AddHelmet(135, 12);
        AddHelmet(136, 12);
        AddBank(141, 11);
        AddBrickWithMushroom(142, 11);
        AddBrick(147, 9, 1, 150);
        AddBrick(153, 5, 1, 158);
        AddEnemyTurtlePatrol(153, 4, 4);
        AddStone(151, 13, 2, 170);
        AddEnemyMushroom(154, 12);
        AddEnemyMushroom(155, 12);
        AddFlyingTurtle(164, 9);
        AddFlyingTurtle(165, 9);
        AddBrickWithMushroom(168, 9);
        AddStone(173, 13, 2, 175);
        AddPump(173, 11, 2);
        AddBrick(172, 5, 1, 176);
        AddCoin(172, 4, 1, 174);
        AddStone(177, 13, 2, 185);
        AddChocolate(183, 12, 1, 185);
        AddChocolate(184, 11);
        AddStone(186, 13, 2, 188);
        AddChocolate(186, 9, 4, 188);
        AddChocolate(187, 8);
        AddStone(189, 13, 2, 250);
        AddChocolate(189, 6, 7, 192);
        AddChocolate(190, 5, 1, 192);
        AddChocolate(200, 12);
        AddCheckPointsFlag(200, 3);
        AddCastle(204, 8, "small");
        AddCheckPoints(207, 12, 53, new Point(2, 3));
        AddCheckPoints_InsidePumpvertically(55, 10, 104, new Point(2, 3));

        this.AddClowdGoUP_CheckPoints(85, 3, 95, new Point(5, 5));
        AddQuestionMark(85, 5);

    }
}
