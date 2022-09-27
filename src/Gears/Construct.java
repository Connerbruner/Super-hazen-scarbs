


// Source File Name:   Construct.java

package Gears;

import java.io.Serializable;

public class Construct
    implements Serializable
{

    public Construct()
    {
        Frame = 0;
    }

    public int getFrame()
    {
        return Frame;
    }

    public void setFrame(int Frame)
    {
        this.Frame = Frame;
    }

    public String getExtraInfo()
    {
        return ExtraInfo;
    }

    public String getItem_Type()
    {
        return Item_Type;
    }

    public void setItem_Type(String Item_Type)
    {
        this.Item_Type = Item_Type;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getLength_X()
    {
        return Length_X;
    }

    public void setLength_X(int Length_X)
    {
        this.Length_X = Length_X;
    }

    public int getLength_Y()
    {
        return Length_Y;
    }

    public void setLength_Y(int Length_Y)
    {
        this.Length_Y = Length_Y;
    }

    public void setPatrolLength(int Length)
    {
        PetrolLength = Length;
    }

    public int getBridgeLength()
    {
        return BridgeLength;
    }

    public void setBridgeLength(int BridgeLength)
    {
        this.BridgeLength = BridgeLength;
    }

    public String Item_Type;
    public int x;
    public int y;
    public int Length_X;
    public int Length_Y;
    public int PetrolLength;
    public String ExtraInfo;
    public int BridgeLength;
    public int Frame;
}
