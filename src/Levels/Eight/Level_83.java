


// Source File Name:   Level_83.java

package Levels.Eight;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_83 extends BasicLevel
{

    public Level_83()
    {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "Wall";
        BackGroundImage = "fencegreen";
        Time = "400";
        type = "Guns";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 7450;
        AddCastle(1, 8, "small");
        AddStone(0, 13, 2, 69);
        AddWall(24, 7, 6, 32);
        AddRocketLauncher(18, 11, 2);
        AddFlyingTurtle(28, 11);
        AddRocketLauncher(34, 10, 3);
        AddWall(37, 7, 6, 51);
        AddPump(53, 9, 4);
        AddBrick(60, 5, 1, 66);
        AddBrickWithMushroom(66, 5);
        AddBrick(67, 5);
        AddBrick(60, 9, 1, 68);
        AddChocolate(71, 9);
        AddChocolate(71, 10, 3, 73);
        AddChocolate(73, 11, 2, 74);
        AddChocolate(74, 12);
        AddStone(71, 13, 2, 75);
        AddStone(77, 13, 2, 124);
        AddStone(126, 13, 2, 128);
        AddStone(130, 13, 2, 197);
        AddStone(208, 13, 2, 250);
        AddWall(79, 7, 6, 85);
        AddMonkey(64, 7);
        AddMonkey(65, 11);
        AddWall(88, 7, 6, 94);
        AddWall(97, 7, 6, 107);
        AddRocketLauncher(86, 11, 2);
        AddFlyingTurtle(91, 10);
        AddChocolate(95, 10, 3, 96);
        AddChocolate(109, 9, 4, 111);
        AddBrick(115, 5);
        AddBrickWithMushroom(116, 5);
        AddBrick(117, 5, 1, 123);
        AddBrick(115, 9, 1, 123);
        AddMonkey(120, 7);
        AddMonkey(118, 11);
        AddPump(126, 9, 4);
        AddWall(132, 7, 6, 166);
        AddWall(172, 7, 6, 192);
        AddTurtle(136, 11);
        AddMonkey(145, 11);
        AddMonkey(160, 10);
        AddPump(168, 10, 3);
        AddMonkey(177, 11);
        AddMonkey(185, 11);
        AddBank(190, 9);
        AddChocolate(195, 11, 2, 196);
        AddChocolate(198, 11);
        AddChocolate(200, 9);
        AddChocolate(202, 7);
        AddChocolate(204, 5, 1, 206);
        AddChocolate(214, 12);
        AddCheckPointsFlag(214, 3);
        AddCastle(220, 2, "big");
        AddCheckPoints(225, 12, 841, new Point(2, 5));
    }
}
