


// Source File Name:   Level_73.java

package Levels.Seven;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_73 extends BasicLevel
{

    public Level_73()
    {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "Pillars";
        BackGroundImage = "";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 8000;
        FlyingFishes = true;
        FlyingFishesLength = 6400;
        AddCastle(1, 8, "small");
        AddStone(0, 13, 2, 7);
        AddStone(207, 13, 2, 250);
        AddTree(8, 13, 2, 16);
        AddTree(112, 13, 2, 120);
        AddTree(192, 13, 2, 205);
        AddChocolate(10, 12, 1, 15);
        AddChocolate(11, 11, 1, 15);
        AddChocolate(12, 10, 1, 15);
        AddChocolate(31, 10, 5, 32);
        AddChocolate(47, 10, 5, 48);
        AddChocolate(63, 10, 5, 64);
        AddChocolate(68, 10, 5, 69);
        AddChocolate(79, 10, 5, 80);
        AddChocolate(84, 10, 5, 85);
        AddChocolate(95, 10, 5, 96);
        AddChocolate(99, 9, 6, 100);
        AddChocolate(105, 9, 6, 106);
        AddChocolate(127, 10, 5, 128);
        AddChocolate(143, 10, 5, 144);
        AddChocolate(146, 12, 3, 147);
        AddChocolate(155, 12, 3, 156);
        AddChocolate(159, 10, 5, 160);
        AddChocolate(168, 10, 5, 169);
        AddChocolate(183, 10, 5, 184);
        AddChocolate(193, 10, 3, 195);
        AddChocolate(195, 11, 2, 196);
        AddChocolate(196, 12);
        AddChocolate(208, 12, 1, 217);
        AddChocolate(209, 11, 1, 217);
        AddChocolate(210, 10, 1, 217);
        AddChocolate(211, 9, 1, 217);
        AddChocolate(212, 8, 1, 217);
        AddChocolate(213, 7, 1, 217);
        AddChocolate(214, 6, 1, 217);
        AddChocolate(215, 5, 1, 217);
        AddChocolate(225, 12);
        AddCheckPointsFlag(225, 3);
        AddCastle(228, 2, "big");
        AddCheckPoints(233, 12, 74, new Point(6, 6));
        AddWoodenBridge(15, 10, 31);
        AddWoodenBridge(32, 10, 47);
        AddWoodenBridge(48, 10, 63);
        AddWoodenBridge(69, 10, 79);
        AddWoodenBridge(85, 10, 95);
        AddWoodenBridge(100, 9, 105);
        AddWoodenBridge(122, 10, 125);
        AddWoodenBridge(128, 10, 143);
        AddWoodenBridge(147, 12, 155);
        AddWoodenBridge(160, 10, 168);
        AddWoodenBridge(171, 10, 173);
        AddWoodenBridge(175, 10, 177);
        AddWoodenBridge(179, 10, 181);
        AddWoodenBridge(184, 10, 193);
        AddTurtle(47, 9);
        AddFlyingTurtle(60, 8);
        AddFlyingTurtle(143, 6);
        AddFlyingTurtle(155, 8);
        AddEnemyTurtlePatrol(68, 9, 11);
        AddEnemyTurtlePatrol(84, 9, 11);
        AddEnemyTurtlePatrol(112, 13, 7);
    }
}
