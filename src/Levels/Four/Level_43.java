


// Source File Name:   Level_43.java

package Levels.Four;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_43 extends BasicLevel
{

    public Level_43()
    {
        BackGroundColor = "BlueFant";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "RedTrees";
        BackGroundImage = "null";
        Time = "300";
        type = "OrangeAndMushroom";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 5500;
        AddStone(0, 13, 2, 15);
        AddCastle(1, 8, "small");
        AddTree(16, 13, 20, 21);
        AddTree(19, 5, 20, 24);
        AddTree(23, 9, 20, 30);
        AddTree(32, 4, 20, 35);
        AddTree(39, 5, 20, 44);
        AddTree(36, 12, 20, 43);
        AddTree(44, 9, 20, 47);
        AddTree(51, 8, 20, 54);
        AddTree(67, 7, 20, 70);
        AddTree(65, 13, 20, 70);
        AddTree(70, 3, 20, 73);
        AddTree(72, 9, 20, 75);
        AddTree(74, 5, 20, 79);
        AddTree(84, 9, 20, 87);
        AddTree(99, 11, 20, 102);
        AddTree(105, 10, 20, 108);
        AddTree(113, 9, 20, 118);
        AddTree(117, 6, 20, 120);
        AddTree(121, 13, 20, 128);
        AddTree(130, 10, 20, 135);
        AddCoin(20, 4, 1, 23);
        AddCoin(24, 8, 1, 29);
        AddEnemyTurtlePatrol(23, 8, 6);
        AddEnemyTurtlePatrol(23, 8, 6);
        AddEnemyTurtlePatrol(36, 11, 6);
        AddFlyingTurtlePatrol(36, 1, 4);
        AddQuestionMarkWithMushroom(43, 2);
        AddCoin(48, 7);
        AddBalenceLift(48, 5, 7);
        AddCoin(57, 3);
        AddLift_UpDown(58, 8);
        AddLift_UpDown(62, 6);
        AddCoin(67, 6, 1, 70);
        AddCoin(70, 2, 1, 73);
        AddCoin(73, 8);
        AddEnemyTurtlePatrol(74, 4, 5);
        AddBalenceLift(80, 5, 9);
        AddCoin(96, 7);
        AddBalenceLift(91, 5, 6);
        AddBalenceLift(102, 5, 7);
        AddCoin(113, 8, 1, 118);
        AddLift_UpDown(136, 7);
        AddStone(141, 13, 2, 180);
        AddChocolate(147, 12);
        AddCheckPointsFlag(147, 3);
        AddCastle(150, 2, "big");
        AddCheckPoints(155, 12, 44, new Point(5, 7));
    }
}
