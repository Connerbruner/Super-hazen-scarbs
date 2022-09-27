


// Source File Name:   Level_71.java

package Levels.Seven;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_71 extends BasicLevel
{

    public Level_71()
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
        AddCastle(1, 2, "big");
        AddStone(0, 13, 2, 73);
        AddRocketLauncher(19, 11, 2);
        AddRocketLauncher(28, 10, 2);
        AddRocketLauncher(28, 12, 1);
        AddBrickWithMushroom(27, 5);
        AddBrick(28, 5, 1, 30);
        AddFlyingTurtle(24, 9);
        AddFlyingTurtle(38, 9);
        AddFlyingTurtle(52, 9);
        AddRocketLauncher(36, 11, 2);
        AddRocketLauncher(46, 10, 3);
        AddRocketLauncher(56, 10, 2);
        AddRocketLauncher(56, 12, 1);
        AddRocketLauncher(68, 11, 2);
        AddRocketLauncher(64, 7, 2);
        AddQuestionMark(39, 9, 1, 43);
        AddBrick(62, 9, 1, 64);
        AddChocolate(64, 9);
        AddBank(65, 9);
        AddBrick(66, 9);
        AddStone(75, 13, 2, 152);
        AddPump(76, 10, 3);
        AddBrick(82, 9, 1, 89);
        AddBrick(82, 5, 1, 89);
        AddMonkey(86, 2);
        AddMonkey(84, 7);
        AddPump(93, 10, 3);
        AddInvisibleBrckWith1Up(93, 5);
        AddRocketLauncher(104, 11, 2);
        AddPump(109, 10, 3);
        AddTurtle(111, 12);
        AddPump(115, 11, 2);
        AddRocketLauncher(122, 11, 2);
        AddPump(128, 11, 2);
        AddBrick(134, 5, 1, 139);
        AddBrick(134, 9, 1, 139);
        AddMonkey(135, 6);
        AddMonkey(137, 10);
        AddChocolate(141, 10, 3, 142);
        AddRocketLauncher(146, 10, 2);
        AddRocketLauncher(146, 12, 1);
        AddBrick(149, 8, 1, 151);
        AddBrick(153, 6, 1, 155);
        AddBrickWithMushroom(151, 2);
        AddStone(153, 13, 2, 200);
        for(int i = 0; i < 6; i++)
            AddChocolate(153 + i, 12 - i, 1, 159);

        for(int i = 0; i < 8; i++)
            AddChocolate(162 + i, 12 - i, 1, 171);

        AddHelmet(170, 4);
        AddChocolate(179, 12);
        AddCheckPointsFlag(179, 3);
        AddCastle(183, 8, "small");
        AddCheckPoints(186, 12, 72, new Point(2, 3));
        AddCheckPoints_InsidePumpvertically(93, 10, 108, new Point(2, 3));
    }
}
