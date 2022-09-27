


// Source File Name:   Level_33.java

package Levels.Three;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_33 extends BasicLevel
{

    public Level_33()
    {
        BackGroundColor = "black";
        BackGroundMiddleImage1 = "stars[A]";
        BackGroundMiddleImage2 = "purplestones";
        BackGroundImage = "fencewhite";
        Time = "300";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        BackGroundImage = "Clouds";
        attribute = "Ground";
        LevelLength = 5500;
        AddStone(0, 13, 2, 16);
        AddTree(18, 10, 5, 23);
        AddTree(22, 7, 8, 28);
        AddTree(30, 13, 2, 33);
        AddTree(36, 12, 3, 43);
        AddEnemyMushroom(25, 6);
        AddCoin(31, 12);
        AddCoin(32, 12);
        AddCoin(37, 6);
        AddCoin(42, 6, 1, 45);
        AddTree(43, 9, 15, 47);
        AddTree(46, 11, 4, 56);
        AddTree(47, 7, 4, 53);
        AddTree(55, 3, 15, 59);
        AddCoin(56, 2, 1, 58);
        AddQuestionMarkWithMushroom(49, 3);
        AddEnemyTurtlePatrol(47, 6, 5);
        AddEnemyTurtlePatrol(46, 10, 9);
        AddTree(65, 7, 6, 68);
        AddTree(69, 7, 6, 72);
        AddTree(73, 7, 6, 76);
        AddTree(77, 4, 9, 80);
        AddTree(65, 13, 2, 81);
        AddCoin(66, 6);
        AddCoin(70, 6);
        AddCoin(74, 6);
        AddCoin(78, 3);
        AddCoin(81, 5);
        AddCoin(88, 5);
        AddCoin(90, 5);
        AddEnemyTurtlePatrol(65, 11, 15);
        AddTree(84, 11, 4, 88);
        AddTree(97, 9, 6, 100);
        AddTree(104, 5, 15, 108);
        AddTree(108, 7, 15, 111);
        AddTree(107, 11, 15, 111);
        AddTree(116, 12, 10, 119);
        AddTree(119, 10, 10, 131);
        AddFlyingTurtlePatrol(114, 2, 4);
        AddEnemyTurtlePatrol(119, 9, 11);
        AddEnemyTurtlePatrol(119, 9, 11);
        AddCoin(105, 4, 1, 107);
        AddCoin(109, 6);
        AddCoin(108, 10);
        AddChocolate(151, 12);
        AddCheckPointsFlag(151, 3);
        AddCastle(154, 2, "big");
        AddStone(144, 13, 2, 170);
        AddCastle(1, 8, "small");
        AddCheckPoints(159, 12, 34, new Point(2, 5));
        AddBalenceLift(81, 6, 7);
        AddLift_LeftRight(29, 4, 5);
        AddLift_LeftRight(32, 8, 6);
        AddLiftFall(60, 6);
        AddLift_LeftRight(92, 9, 6);
        AddLift_LeftRight(96, 5, 6);
        AddLift_LeftRight(101, 11, 6);
        AddLift_LeftRight(129, 6, 6);
        AddBalenceLift(136, 5, 4);
    }
}
