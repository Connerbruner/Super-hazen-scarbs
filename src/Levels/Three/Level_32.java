


// Source File Name:   Level_32.java

package Levels.Three;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_32 extends BasicLevel
{

    public Level_32()
    {
        BackGroundColor = "black";
        BackGroundMiddleImage1 = "stars[A]";
        BackGroundMiddleImage2 = "purplestones";
        BackGroundImage = "fencewhite";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        BackGroundImage = "Fence";
        attribute = "Ground";
        LevelLength = 7500;
        AddStone(0, 13, 2, 80);
        AddStone(82, 13, 2, 123);
        AddStone(125, 13, 2, 128);
        AddStone(130, 13, 2, 250);
        AddCastle(1, 8, "small");
        AddTurtle(15, 12);
        AddEnemyMushroom(23, 12);
        AddEnemyMushroom(24, 12);
        AddEnemyMushroom(25, 12);
        AddTurtle(32, 11);
        AddTurtle(34, 11);
        AddTurtle(42, 11);
        AddTurtle(44, 11);
        AddChocolate(49, 12);
        AddCoin(65, 9, 1, 68);
        AddChocolate(60, 10, 3, 61);
        AddQuestionMarkWithMushroom(60, 6);
        AddTurtle(65, 11);
        AddEnemyMushroom(68, 12);
        AddEnemyMushroom(69, 12);
        AddEnemyMushroom(70, 12);
        AddChocolate(75, 11, 2, 76);
        AddTurtle(77, 11);
        AddChocolate(79, 11, 2, 80);
        AddBank(77, 9);
        AddBrickWithStar(77, 5);
        AddFlyingTurtle(92, 9);
        AddTurtle(109, 2);
        AddEnemyMushroom(117, 12);
        AddEnemyMushroom(118, 12);
        AddEnemyMushroom(119, 12);
        AddChocolate(126, 11, 2, 127);
        AddBrick(126, 6);
        AddTurtle(132, 12);
        AddTurtle(139, 12);
        AddTurtle(140, 12);
        AddTurtle(141, 12);
        AddTurtle(150, 12);
        AddTurtle(160, 12);
        AddTurtle(161, 12);
        AddTurtle(162, 12);
        AddCoin(168, 6, 1, 172);
        AddEnemyMushroom(177, 12);
        AddEnemyMushroom(178, 12);
        AddEnemyMushroom(179, 12);
        AddEnemyMushroom(186, 12);
        AddEnemyMushroom(187, 12);
        AddChocolate(192, 12, 1, 201);
        AddChocolate(193, 11, 1, 201);
        AddChocolate(194, 10, 1, 201);
        AddChocolate(195, 9, 1, 201);
        AddChocolate(196, 8, 1, 201);
        AddChocolate(197, 7, 1, 201);
        AddChocolate(198, 6, 1, 201);
        AddChocolate(199, 5, 1, 201);
        AddChocolate(209, 12);
        AddCheckPointsFlag(209, 3);
        AddCastle(213, 8, "small");
        AddCheckPoints(216, 12, 33, new Point(3, 10));
        AddPump(169, 10, 3);
    }
}
