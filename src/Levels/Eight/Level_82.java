


// Source File Name:   Level_82.java

package Levels.Eight;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_82 extends BasicLevel
{

    public Level_82()
    {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "lolypopRed";
        BackGroundImage = "fencegreen";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 7450;
        AddSonOfABuitch(33, 3);
        AddCastle(1, 8, "small");
        AddStone(0, 13, 2, 15);
        AddStone(16, 13, 2, 21);
        AddStone(22, 13, 2, 36);
        AddStone(37, 13, 2, 45);
        AddStone(46, 13, 2, 50);
        AddStone(51, 13, 2, 52);
        AddStone(53, 13, 2, 56);
        AddStone(57, 13, 2, 63);
        AddStone(64, 13, 2, 78);
        AddStone(80, 13, 2, 84);
        AddStone(85, 13, 2, 138);
        AddStone(139, 13, 2, 144);
        AddStone(145, 13, 2, 146);
        AddStone(147, 13, 2, 148);
        AddStone(154, 13, 2, 176);
        AddStone(179, 13, 2, 202);
        AddStone(203, 13, 2, 204);
        AddStone(206, 13, 2, 250);
        AddFlyingTurtle(15, 9);
        AddFlyingTurtle(23, 1);
        AddChocolate(17, 12, 1, 21);
        AddChocolate(18, 11, 1, 21);
        AddChocolate(19, 10, 1, 21);
        AddChocolate(20, 9, 1, 21);
        AddChocolate(22, 7, 6, 26);
        AddChocolate(23, 6, 1, 26);
        AddChocolate(24, 5, 1, 26);
        AddQuestionMark(29, 9, 1, 33);
        AddBouncer(44, 11);
        AddBrick(43, 5);
        AddBrickWith1UP(44, 5);
        AddBrick(45, 5, 1, 76);
        AddFlyingTurtle(54, 9);
        AddFlyingTurtle(64, 9);
        AddFlyingTurtle(67, 9);
        AddFlyingTurtle(90, 10);
        AddFlyingTurtle(95, 10);
        AddHelmet(118, 12);
        AddHelmet(120, 12);
        AddBrick(77, 9, 1, 79);
        AddRocketLauncher(85, 11, 2);
        AddRocketLauncher(93, 10, 2);
        AddRocketLauncher(93, 12, 1);
        AddBank(99, 9);
        AddBrickWithMushroom(100, 9);
        AddRocketLauncher(105, 11, 2);
        AddBrick(110, 9, 1, 112);
        AddRocketLauncher(115, 12, 1);
        AddBrick(118, 9);
        AddChocolate(119, 9);
        AddBrickWithCoin(120, 9);
        AddRocketLauncher(119, 8, 1);
        AddRocketLauncher(125, 10, 3);
        AddPump(131, 11, 2);
        AddFlyingTurtle(137, 10);
        AddPump(142, 11, 2);
        AddPump(156, 9, 4);
        AddPump(163, 11, 2);
        AddFlyingTurtle(167, 9);
        AddFlyingTurtle(169, 10);
        AddFlyingTurtle(172, 8);
        AddRocketLauncher(175, 11, 2);
        AddChocolate(182, 12, 1, 187);
        AddChocolate(183, 11, 1, 187);
        AddChocolate(184, 10, 1, 187);
        AddChocolate(185, 9, 1, 187);
        AddChocolate(186, 8, 1, 187);
        AddEnemyMushroom(182, 10);
        AddEnemyMushroom(185, 8);
        AddHelmet(187, 12);
        AddRocketLauncher(191, 10, 2);
        AddRocketLauncher(191, 12, 1);
        AddChocolate(199, 12, 1, 202);
        AddChocolate(200, 11, 1, 202);
        AddChocolate(201, 10, 1, 202);
        AddFlyingTurtle(202, 5);
        AddChocolate(203, 8, 5, 204);
        AddChocolate(206, 5, 8, 208);
        AddChocolate(216, 12);
        AddCastle(220, 8, "small");
        AddCheckPoints_InsidePumpvertically(156, 9, 110, new Point(2, 3));
        AddCheckPointsFlag(216, 3);
        AddCheckPoints(223, 12, 83, new Point(2, 3));
    }
}
