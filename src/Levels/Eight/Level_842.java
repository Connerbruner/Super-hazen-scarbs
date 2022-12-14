


// Source File Name:   Level_842.java

package Levels.Eight;

import Levels.BasicLevel;
import java.awt.Point;

public class Level_842 extends BasicLevel
{

    public Level_842()
    {
        BackGroundColor = "";
        BackGroundMiddleImage1 = "Thunder";
        BackGroundMiddleImage2 = "castle-img2";
        BackGroundImage = "";
        Time = "300";
        type = "";
        pos = new Point(10, 12);
        attribute = "Castle";
        LevelLength = 3700;
        AddHelmet(37, 12);
        AddHelmet(38, 12);
        AddFlyingTurtle(51, 9);
        AddFlyingTurtle(70, 10);
        AddFlyingTurtle(75, 9);
        AddPump(28, 11, 4);
        AddPump(35, 10, 15);
        AddPump(45, 11, 15);
        AddCheckPoints_InsidePumpvertically(45, 11, 841, new Point(19, 9));
        AddPump(55, 10, 15);
        AddPump(65, 6, 3);
        AddCheckPoints_InsidePumpvertically(65, 6, 843, new Point(22, 9));
        AddLava(57, 60);
        AddInvisibleBrckWithCoin(63, 9);
        AddTeleport(79, 3, 10, 3);
        AddTeleport(79, 6, 10, 6);
        AddTeleport(79, 9, 10, 9);
        AddTile(0, 13, 1);
        AddTile(1, 13, 1);
        AddTile(2, 13, 1);
        AddTile(3, 13, 1);
        AddTile(4, 13, 1);
        AddTile(5, 13, 1);
        AddTile(6, 13, 1);
        AddTile(7, 13, 1);
        AddTile(8, 13, 1);
        AddTile(9, 13, 1);
        AddTile(10, 13, 1);
        AddTile(11, 13, 1);
        AddTile(12, 13, 1);
        AddTile(13, 13, 1);
        AddTile(14, 13, 1);
        AddTile(15, 13, 1);
        AddTile(16, 13, 1);
        AddTile(17, 13, 1);
        AddTile(18, 13, 1);
        AddTile(19, 13, 1);
        AddTile(20, 13, 1);
        AddTile(21, 13, 1);
        AddTile(22, 13, 1);
        AddTile(23, 13, 1);
        AddTile(24, 13, 1);
        AddTile(25, 13, 1);
        AddTile(26, 13, 1);
        AddTile(31, 13, 1);
        AddTile(32, 13, 1);
        AddTile(33, 13, 1);
        AddTile(38, 13, 1);
        AddTile(39, 13, 1);
        AddTile(40, 13, 1);
        AddTile(41, 13, 1);
        AddTile(42, 13, 1);
        AddTile(43, 13, 1);
        AddTile(48, 13, 1);
        AddTile(49, 13, 1);
        AddTile(50, 13, 1);
        AddTile(51, 13, 1);
        AddTile(52, 13, 1);
        AddTile(53, 13, 1);
        AddTile(61, 13, 1);
        AddTile(62, 13, 1);
        AddTile(63, 13, 1);
        AddTile(64, 13, 1);
        AddTile(65, 13, 1);
        AddTile(66, 13, 1);
        AddTile(67, 13, 1);
        AddTile(68, 13, 1);
        AddTile(69, 13, 1);
        AddTile(70, 13, 1);
        AddTile(71, 13, 1);
        AddTile(72, 13, 1);
        AddTile(73, 13, 1);
        AddTile(74, 13, 1);
        AddTile(75, 13, 1);
        AddTile(76, 13, 1);
        AddTile(77, 13, 1);
        AddTile(78, 13, 1);
        AddTile(79, 13, 1);
        AddTile(80, 13, 1);
        AddTile(81, 13, 1);
        AddTile(82, 13, 1);
        AddTile(83, 13, 1);
        AddTile(84, 13, 1);
        AddTile(85, 13, 1);
        AddTile(86, 13, 1);
        AddTile(87, 13, 1);
        AddTile(88, 13, 1);
        AddTile(89, 13, 1);
        AddTile(90, 13, 1);
        AddTile(91, 13, 1);
        AddTile(92, 13, 1);
        AddTile(93, 13, 1);
        AddTile(94, 13, 1);
        AddTile(95, 13, 1);
        AddTile(96, 13, 1);
        AddTile(97, 13, 1);
        AddTile(98, 13, 1);
        AddTile(99, 13, 1);
        AddTile(100, 13, 1);
        AddTile(101, 13, 1);
        AddTile(102, 13, 1);
        AddTile(103, 13, 1);
        AddTile(104, 13, 1);
        AddTile(105, 13, 1);
        AddTile(106, 13, 1);
        AddTile(106, 14, 5);
        AddTile(105, 14, 5);
        AddTile(104, 14, 5);
        AddTile(103, 14, 5);
        AddTile(102, 14, 5);
        AddTile(101, 14, 5);
        AddTile(100, 14, 5);
        AddTile(99, 14, 5);
        AddTile(98, 14, 5);
        AddTile(97, 14, 5);
        AddTile(96, 14, 5);
        AddTile(95, 14, 5);
        AddTile(94, 14, 5);
        AddTile(93, 14, 5);
        AddTile(92, 14, 5);
        AddTile(91, 14, 5);
        AddTile(90, 14, 5);
        AddTile(89, 14, 5);
        AddTile(88, 14, 5);
        AddTile(87, 14, 5);
        AddTile(86, 14, 5);
        AddTile(85, 14, 5);
        AddTile(84, 14, 5);
        AddTile(83, 14, 5);
        AddTile(82, 14, 5);
        AddTile(81, 14, 5);
        AddTile(80, 14, 5);
        AddTile(79, 14, 5);
        AddTile(78, 14, 5);
        AddTile(77, 14, 5);
        AddTile(76, 14, 5);
        AddTile(75, 14, 5);
        AddTile(74, 14, 5);
        AddTile(73, 14, 5);
        AddTile(72, 14, 5);
        AddTile(71, 14, 5);
        AddTile(70, 14, 5);
        AddTile(69, 14, 5);
        AddTile(68, 14, 5);
        AddTile(67, 14, 5);
        AddTile(66, 14, 5);
        AddTile(65, 14, 5);
        AddTile(64, 14, 5);
        AddTile(63, 14, 5);
        AddTile(61, 14, 5);
        AddTile(62, 14, 5);
        AddTile(53, 14, 5);
        AddTile(52, 14, 5);
        AddTile(51, 14, 5);
        AddTile(50, 14, 5);
        AddTile(49, 14, 5);
        AddTile(48, 14, 5);
        AddTile(43, 14, 5);
        AddTile(42, 14, 5);
        AddTile(41, 14, 5);
        AddTile(40, 14, 5);
        AddTile(38, 14, 5);
        AddTile(39, 14, 5);
        AddTile(33, 14, 5);
        AddTile(32, 14, 5);
        AddTile(31, 14, 5);
        AddTile(26, 14, 5);
        AddTile(25, 14, 5);
        AddTile(24, 14, 5);
        AddTile(23, 14, 5);
        AddTile(22, 14, 5);
        AddTile(21, 14, 5);
        AddTile(20, 14, 5);
        AddTile(19, 14, 5);
        AddTile(18, 14, 5);
        AddTile(17, 14, 5);
        AddTile(16, 14, 5);
        AddTile(15, 14, 5);
        AddTile(14, 14, 5);
        AddTile(13, 14, 5);
        AddTile(12, 14, 5);
        AddTile(11, 14, 5);
        AddTile(10, 14, 5);
        AddTile(9, 14, 5);
        AddTile(8, 14, 5);
        AddTile(7, 14, 5);
        AddTile(6, 14, 5);
        AddTile(5, 14, 5);
        AddTile(4, 14, 5);
        AddTile(3, 14, 5);
        AddTile(2, 14, 5);
        AddTile(0, 14, 5);
        AddTile(1, 14, 5);
        AddTile(27, 13, 2);
        AddTile(34, 13, 2);
        AddTile(27, 14, 6);
        AddTile(34, 14, 6);
        AddTile(44, 14, 6);
        AddTile(30, 13, 0);
        AddTile(37, 13, 0);
        AddTile(30, 14, 4);
        AddTile(37, 14, 4);
        AddTile(44, 13, 2);
        AddTile(54, 13, 2);
        AddTile(47, 13, 0);
        AddTile(47, 14, 4);
        AddTile(54, 14, 6);
        AddTile(60, 13, 0);
        AddTile(60, 14, 4);
        AddTile(65, 9, 11);
        AddTile(66, 9, 11);
        AddTile(1, 2, 10);
        AddTile(0, 2, 9);
        AddTile(3, 2, 10);
        AddTile(2, 2, 9);
        AddTile(5, 2, 10);
        AddTile(4, 2, 9);
        AddTile(7, 2, 10);
        AddTile(6, 2, 9);
        AddTile(9, 2, 10);
        AddTile(8, 2, 9);
        AddTile(11, 2, 10);
        AddTile(10, 2, 9);
        AddTile(13, 2, 10);
        AddTile(12, 2, 9);
        AddTile(15, 2, 10);
        AddTile(14, 2, 9);
        AddTile(17, 2, 10);
        AddTile(16, 2, 9);
        AddTile(19, 2, 10);
        AddTile(18, 2, 9);
        AddTile(21, 2, 10);
        AddTile(20, 2, 9);
        AddTile(23, 2, 10);
        AddTile(22, 2, 9);
        AddTile(25, 2, 10);
        AddTile(24, 2, 9);
        AddTile(27, 2, 10);
        AddTile(26, 2, 9);
        AddTile(29, 2, 10);
        AddTile(28, 2, 9);
        AddTile(31, 2, 10);
        AddTile(30, 2, 9);
        AddTile(33, 2, 10);
        AddTile(32, 2, 9);
        AddTile(35, 2, 10);
        AddTile(34, 2, 9);
        AddTile(37, 2, 10);
        AddTile(36, 2, 9);
        AddTile(39, 2, 10);
        AddTile(38, 2, 9);
        AddTile(41, 2, 10);
        AddTile(40, 2, 9);
        AddTile(43, 2, 10);
        AddTile(42, 2, 9);
        AddTile(45, 2, 10);
        AddTile(44, 2, 9);
        AddTile(47, 2, 10);
        AddTile(46, 2, 9);
        AddTile(49, 2, 10);
        AddTile(48, 2, 9);
        AddTile(51, 2, 10);
        AddTile(50, 2, 9);
        AddTile(53, 2, 10);
        AddTile(52, 2, 9);
        AddTile(55, 2, 10);
        AddTile(54, 2, 9);
        AddTile(57, 2, 10);
        AddTile(56, 2, 9);
        AddTile(59, 2, 10);
        AddTile(58, 2, 9);
        AddTile(61, 2, 10);
        AddTile(60, 2, 9);
        AddTile(63, 2, 10);
        AddTile(62, 2, 9);
        AddTile(65, 2, 10);
        AddTile(64, 2, 9);
        AddTile(67, 2, 10);
        AddTile(66, 2, 9);
        AddTile(69, 2, 10);
        AddTile(68, 2, 9);
        AddTile(71, 2, 10);
        AddTile(70, 2, 9);
        AddTile(73, 2, 10);
        AddTile(72, 2, 9);
        AddTile(75, 2, 10);
        AddTile(74, 2, 9);
        AddTile(77, 2, 10);
        AddTile(76, 2, 9);
        AddTile(79, 2, 10);
        AddTile(78, 2, 9);
        AddTile(81, 2, 10);
        AddTile(80, 2, 9);
        AddTile(83, 2, 10);
        AddTile(82, 2, 9);
        AddTile(85, 2, 10);
        AddTile(84, 2, 9);
        AddTile(87, 2, 10);
        AddTile(86, 2, 9);
        AddTile(89, 2, 10);
        AddTile(88, 2, 9);
        AddTile(91, 2, 10);
        AddTile(90, 2, 9);
        AddTile(93, 2, 10);
        AddTile(92, 2, 9);
        AddTile(95, 2, 10);
        AddTile(94, 2, 9);
        AddTile(97, 2, 10);
        AddTile(96, 2, 9);
        AddTile(99, 2, 10);
        AddTile(98, 2, 9);
        AddTile(101, 2, 10);
        AddTile(100, 2, 9);
        AddTile(103, 2, 10);
        AddTile(102, 2, 9);
        AddTile(105, 2, 10);
        AddTile(104, 2, 9);
        AddTile(107, 2, 10);
        AddTile(106, 2, 9);
    }
}
