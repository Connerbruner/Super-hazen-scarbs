


// Source File Name:   Level_81.java

package Levels.Eight;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_81 extends BasicLevel
{

    public Level_81()
    {
        BackGroundColor = "Blue";
        BackGroundMiddleImage1 = "sky";
        BackGroundMiddleImage2 = "mountain";
        BackGroundImage = "fencegreen";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        attribute = "Ground";
        LevelLength = 12700;
        AddStone(0, 13, 2, 46);
        AddStone(47, 13, 2, 48);
        AddStone(49, 13, 2, 51);
        AddStone(52, 13, 2, 54);
        AddStone(55, 13, 2, 57);
        AddStone(58, 13, 2, 169);
        AddStone(170, 13, 2, 171);
        AddStone(172, 13, 2, 174);
        AddStone(175, 13, 2, 176);
        AddStone(177, 13, 2, 179);
        AddStone(180, 13, 2, 197);
        AddStone(198, 13, 2, 199);
        AddStone(200, 13, 2, 201);
        AddStone(202, 13, 2, 220);
        AddStone(227, 13, 2, 237);
        AddStone(238, 13, 2, 240);
        AddStone(242, 13, 2, 244);
        AddStone(246, 13, 2, 290);
        AddStone(293, 13, 2, 295);
        AddStone(298, 13, 2, 314);
        AddStone(319, 13, 2, 320);
        AddStone(324, 13, 2, 359);
        AddStone(360, 13, 2, 361);
        AddStone(362, 13, 2, 363);
        AddStone(364, 13, 2, 365);
        AddStone(366, 13, 2, 400);
        AddCastle(1, 2, "big");
        AddHelmet(13, 12);
        AddHelmet(80, 12);
        AddHelmet(251, 12);
        AddHelmet(281, 12);
        AddEnemyMushroom(21, 12);
        AddEnemyMushroom(22, 12);
        AddEnemyMushroom(23, 12);
        AddEnemyMushroom(31, 12);
        AddEnemyMushroom(72, 12);
        AddEnemyMushroom(73, 12);
        AddEnemyMushroom(74, 12);
        AddEnemyMushroom(107, 12);
        AddEnemyMushroom(108, 12);
        AddEnemyMushroom(108, 12);
        AddEnemyMushroom(147, 12);
        AddEnemyMushroom(148, 12);
        AddEnemyMushroom(149, 12);
        AddEnemyMushroom(232, 12);
        AddEnemyMushroom(233, 12);
        AddEnemyMushroom(234, 12);
        AddEnemyMushroom(256, 12);
        AddEnemyMushroom(257, 12);
        AddEnemyMushroom(258, 12);
        AddEnemyMushroom(261, 12);
        AddEnemyMushroom(271, 12);
        AddPump(246, 8, 5);
        AddPump(35, 9, 4);
        AddPump(76, 9, 4);
        AddPump(94, 9, 4);
        AddPump(104, 9, 4);
        AddPump(242, 9, 4);
        AddPump(82, 10, 3);
        AddPump(140, 10, 3);
        AddPump(238, 10, 3);
        AddPump(344, 10, 3);
        AddPump(115, 11, 2);
        AddPump(355, 11, 2);
        AddTurtle(41, 11);
        AddTurtle(43, 11);
        AddTurtle(65, 11);
        AddTurtle(123, 11);
        AddTurtle(128, 11);
        AddTurtle(129, 11);
        AddTurtle(130, 11);
        AddTurtle(205, 11);
        AddTurtle(207, 11);
        AddTurtle(304, 11);
        AddTurtle(331, 11);
        AddTurtle(338, 11);
        AddTurtle(339, 11);
        AddTurtle(340, 11);
        AddInvisibleBrckWith1Up(80, 8);
        AddCoin(64, 8);
        AddCoin(89, 8);
        AddCoin(98, 8);
        AddCoin(283, 8);
        AddCoin(284, 8);
        AddCoin(291, 8);
        AddCoin(296, 8);
        AddCoin(316, 8);
        AddCoin(317, 8);
        AddCoin(321, 8);
        AddCoin(322, 8);
        AddCoin(109, 4);
        AddCoin(110, 4);
        AddCoin(223, 8, 1, 225);
        AddChocolate(153, 9, 4, 154);
        AddChocolate(163, 9, 4, 164);
        AddChocolate(210, 11, 2, 211);
        AddChocolate(303, 11, 2, 304);
        AddChocolate(307, 11, 2, 308);
        AddChocolate(360, 11, 2, 361);
        AddChocolate(362, 9, 4, 363);
        AddChocolate(364, 7, 6, 365);
        AddChocolate(366, 5, 8, 368);
        AddInvisibleBrckWithCoin(158, 9);
        AddBrick(154, 5, 1, 158);
        AddBank(158, 5);
        AddBrick(159, 5, 1, 162);
        AddFlyingTurtle(158, 11);
        AddFlyingTurtle(171, 11);
        AddFlyingTurtle(176, 11);
        AddBrick(184, 8, 1, 186);
        AddBrickWithStar(186, 8);
        AddBrick(187, 8, 1, 191);
        for(int i = 0; i < 6; i++)
            AddChocolate(275 + i, 12 - i, 1, 281);

        AddCheckPointsFlag(376, 3);
        AddChocolate(376, 12);
        AddCastle(380, 8, "small");
        AddCheckPoints(383, 12, 82, new Point(2, 3));
        AddCheckPoints_InsidePumpvertically(104, 9, 109, new Point(2, 3));
    }
}
