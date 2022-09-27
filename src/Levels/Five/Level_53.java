


// Source File Name:   Level_53.java

package Levels.Five;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_53 extends BasicLevel
{

    public Level_53()
    {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "river[A]";
        BackGroundImage = "";
        Time = "300";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        BackGroundImage = "Clouds";
        attribute = "Ground";
        LevelLength = 5500;
        Bombs = true;
        BombsTurnOff = 128;
        AddCoin(27, 4, 1, 30);
        AddCoin(33, 11);
        AddCoin(37, 3, 1, 39);
        AddCoin(50, 6, 1, 52);
        AddCoin(60, 4, 1, 64);
        AddCoin(85, 5, 1, 87);
        AddCoin(93, 4, 1, 95);
        AddCoin(97, 4, 1, 99);
        AddCoin(113, 12, 1, 116);
        AddCoin(120, 5, 1, 122);
        AddCastle(1, 8, "small");
        Add("stone", 0, 13, 16, 2);
        Add("tree", 18, 12, 3, 3);
        Add("tree", 26, 5, 5, 4);
        Add("tree", 24, 9, 8, 6);
        Add("tree", 32, 12, 3, 3);
        Add("tree", 35, 8, 5, 7);
        Add("tree", 40, 4, 7, 11);
        Add("tree", 50, 13, 4, 2);
        Add("tree", 60, 5, 4, 8);
        Add("tree", 59, 13, 5, 2);
        Add("tree", 65, 13, 5, 2);
        Add("tree", 70, 9, 3, 6);
        Add("tree", 76, 6, 6, 9);
        Add("tree", 98, 11, 4, 4);
        Add("tree", 104, 7, 8, 8);
        Add("tree", 113, 13, 3, 2);
        Add("tree", 116, 9, 4, 6);
        Add("tree", 122, 9, 4, 6);
        AddStone(129, 13, 2, 300);
        Add("chocolate", 138, 9, 6, 4);
        Add("chocolate", 140, 7, 4, 3);
        Add("chocolate", 142, 5, 2, 2);
        Add("chocolate", 152, 12, 1, 1);
        AddCastle(155, 2, "big");
        AddCheckPoints(160, 12, 54, new Point(6, 7));
        AddEnemyTurtlePatrol(26, 3, 4);
        AddFlyingTurtlePatrol(74, 2, 4);
        AddEnemyTurtlePatrol(104, 6, 7);
        AddFlyingTurtlePatrol(114, 2, 4);
        AddEnemyTurtlePatrol(129, 12, 8);
        AddLift_UpDown(55, 10, 4);
        AddLift_LeftRight(84, 8, 4);
        AddLift_LeftRightInvert(92, 9, 4);
        AddLift_LeftRight(129, 6, 4);
        AddEnemyMushroom(42, 3);
        AddEnemyMushroom(46, 3);
        AddQuestionMarkWithMushroom(59, 9);
        AddEnemyMushroom(81, 5);
        AddCheckPointsFlag(152, 3);
    }
}
