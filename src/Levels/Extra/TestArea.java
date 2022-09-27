


// Source File Name:   TestArea.java

package Levels.Extra;

import Levels.BasicLevel;
import java.awt.Point;

public class TestArea extends BasicLevel
{

    public TestArea()
    {
        BackGroundColor = "Blue";
        Time = "400";
        type = "GreenAndTrees";
        pos = new Point(10, 12);
        BackGroundImage = "Fence2";
        attribute = "Ground";
        AddStone(0, 13, 2, 7);
        AddStone(9, 13, 2, 11);
    }
}
