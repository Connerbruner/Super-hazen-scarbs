


// Source File Name:   BasicBrick.java

package Bricks;


public interface BasicBrick
{

    public abstract void HitFromDown();

    public abstract void RemoveIt();

    public abstract void setActive(boolean flag);

    public abstract int getID();

    public abstract String getInsideItem();

    public abstract boolean isJump();
}
