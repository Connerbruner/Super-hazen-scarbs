


// Source File Name:   Level_51.java

package Levels.Five;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_51 extends BasicLevel
{

    public Level_51()
    {
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
        AddStone(0, 13, 2, 49);
        AddStone(51, 13, 2, 92);
        AddStone(96, 13, 2, 114);
        AddStone(116, 13, 2, 152);
        AddStone(155, 13, 2, 230);
        AddPump(44, 10, 3);
        AddPump(51, 10, 3);
        AddPump(156, 7, 2);
        AddPump(163, 11, 2);
        AddTurtle(15, 11);
        AddTurtle(38, 11);
        AddTurtle(126, 11);
        AddTurtle(144, 11);
        AddTurtle(145, 11);
        AddEnemyMushroom(18, 12);
        AddEnemyMushroom(19, 12);
        AddEnemyMushroom(20, 12);
        AddEnemyMushroom(29, 12);
        AddEnemyMushroom(30, 12);
        AddEnemyMushroom(31, 12);
        AddEnemyMushroom(63, 12);
        AddEnemyMushroom(64, 12);
        AddEnemyMushroom(65, 12);
        AddEnemyMushroom(72, 12);
        AddEnemyMushroom(73, 12);
        AddEnemyMushroom(74, 12);
        AddEnemyMushroom(102, 12);
        AddEnemyMushroom(103, 12);
        AddEnemyMushroom(104, 12);
        AddEnemyMushroom(119, 12);
        AddEnemyMushroom(120, 12);
        AddEnemyMushroom(121, 12);
        AddEnemyMushroom(133, 12);
        AddFlyingTurtle(57, 9);
        AddFlyingTurtle(83, 9);
        AddFlyingTurtle(175, 9);
        AddFlyingTurtle(180, 9);
        AddChocolate(89, 9, 4, 90);
        AddChocolate(90, 9, 1, 94);
        AddChocolate(116, 10, 3, 117);
        AddChocolate(147, 9, 4, 148);
        AddChocolate(156, 9, 1, 158);
        for(int i = 0; i < 5; i++)
            AddChocolate(182 + i, 12 - i, 1, 187);

        AddChocolate(189, 5, 6, 191);
        AddChocolate(199, 12);
        AddBrick(90, 5);
        AddBrickWithStar(91, 5);
        AddBrick(92, 5);
        AddInvisibleBrckWith1Up(148, 9);
        AddBrick(149, 9);
        AddBrick(150, 9);
        AddRocketLauncher(111, 11, 2);
        AddRocketLauncher(159, 11, 2);
        AddRocketLauncher(170, 11, 2);
        AddCheckPointsFlag(199, 3);
        AddCastle(203, 8, "small");
        AddCheckPoints(206, 12, 52, new Point(2, 3));
        AddCheckPoints_InsidePumpvertically(156, 6, 103, new Point(2, 3));
    }
}
