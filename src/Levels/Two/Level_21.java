// Source File Name:   Level_21.java
package Levels.Two;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_21 extends BasicLevel {

    public Level_21() {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "lolypopGreen";
        BackGroundImage = "fencegreen";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 7000;
        AddCastle(1, 2, "big");
        Add("stone", 0, 13, 92, 2);
        Add("stone", 96, 13, 10, 2);
        Add("stone", 109, 13, 30, 2);
        Add("stone", 142, 13, 10, 2);
        Add("stone", 154, 13, 100, 2);
        Add("Brick", 15, 9, 1, 1);
        Add("QuestionMarkWithMushroom", 16, 9, 1, 1);
        Add("Brick", 17, 9, 1, 1);
        Add("chocolate", 20, 12, 5, 1);
        Add("chocolate", 21, 11, 4, 1);
        Add("chocolate", 22, 10, 3, 1);
        Add("chocolate", 23, 9, 2, 1);
        Add("chocolate", 24, 8, 1, 1);
        Add("Brick", 29, 5, 3, 1);
        Add("chocolate", 34, 9, 1, 4);
        Add("chocolate", 35, 11, 1, 2);
        Add("pump", 46, 9, 1, 4);
        Add("QuestionMark", 53, 5, 5, 1);
        Add("QuestionMark", 54, 9, 4, 1);
        Add("Brick", 68, 9, 1, 1);
        AddBrickWithStar(69, 5);
        Add("Brick", 70, 5, 3, 1);
        Add("pump", 74, 9, 1, 4);
        Add("QuestionMark", 79, 9, 4, 1);
        Add("QuestionMark", 85, 9, 3, 1);
        Add("Brick", 81, 5, 2, 1);
        Add("Brick", 84, 5, 2, 1);
        Add("Brick", 92, 5, 4, 1);
        Add("pump", 103, 9, 1, 4);
        Add("pump", 115, 11, 1, 2);
        Add("pump", 122, 9, 1, 4);
        Add("pump", 126, 10, 1, 3);
        Add("pump", 130, 8, 1, 5);
        Add("Brick", 126, 5, 3, 1);
        Add("chocolate", 154, 10, 1, 3);
        Add("Bank", 161, 9, 1, 1);
        Add("Brick", 164, 5, 4, 1);
        Add("QuestionMark", 170, 9, 1, 1);
        Add("pump", 176, 10, 1, 3);
        Add("Brick", 185, 9, 2, 1);
        Add("CoinInside", 186, 5, 1, 1);
        Add("chocolate", 190, 3, 2, 10);
        Add("chocolate", 200, 12, 1, 1);
        AddEnemyMushroom(24, 7);
        AddBrickWith1UP(28, 5);
        AddInvisibleBrckWithCoin(28, 9);
        AddTurtle(28, 11);
        AddTurtle(30, 11);
        AddEnemyMushroom(38, 12);
        AddEnemyMushroom(39, 12);
        AddEnemyMushroom(59, 12);
        AddEnemyMushroom(60, 12);
        AddTurtle(64, 11);
        AddEnemyMushroom(66, 12);
        AddEnemyMushroom(67, 12);
        AddEnemyMushroom(68, 12);
        AddTurtle(53, 7);
        AddQuestionMarkWithMushroom(53, 9);
        AddEnemyMushroom(83, 12);
        AddEnemyMushroom(84, 12);
        AddEnemyMushroom(85, 12);
        AddEnemyMushroom(99, 12);
        AddEnemyMushroom(113, 12);
        AddEnemyMushroom(119, 12);
        AddFlyingTurtle(149, 10);
        AddEnemyMushroom(159, 12);
        AddEnemyMushroom(160, 12);
        AddFlyingTurtle(165, 9);
        AddFlyingTurtle(169, 9);
        AddBrickWithMushroom(172, 5);
        AddTurtle(178, 11);
        AddInvisibleBrckWithCoin(186, 5);
        AddBouncer(188, 11);
        AddCheckPointsFlag(200, 3);
        AddCastle(204, 8, "small");
        AddCheckPoints(207, 12, 22, new Point(3, 2));
        AddCheckPoints_InsidePumpvertically(103, 9, 99, new Point(2, 3));

        this.AddClowdGoUP_CheckPoints(83, 3, 92, new Point(5, 5));
        Add("QuestionMark", 83, 5, 1, 1);

    }
}
