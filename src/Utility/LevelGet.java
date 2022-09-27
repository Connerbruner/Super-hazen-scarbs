


// Source File Name:   LevelGet.java

package Utility;

import Levels.One.Level_11;

public class LevelGet
{

    public LevelGet()
    {
        lvl = new Level_11();
    }

    public static void main(String args[])
    {
        LevelGet L = new LevelGet();
        L.Begin();
    }

    private void Begin()
    {
        for(int i = 0; i < lvl.Get_Items_Amount(); i++)
        {
            Gears.Construct temp = lvl.get_Item_Number(i);
        }

    }

    Level_11 lvl;
}
