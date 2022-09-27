


// Source File Name:   SpriteGroup.java

package com.golden.gamedev.object;

import com.golden.gamedev.util.Utility;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Comparator;

// Referenced classes of package com.golden.gamedev.object:
//            Timer, Sprite, Background

public class SpriteGroup
{

    private int expandFactor;
    private Timer scanFrequence;
    private String name;
    private boolean active;
    private Background background;
    private Comparator comparator;
    private Sprite sprites[];
    private int size;

    public SpriteGroup(String name)
    {
        expandFactor = 20;
        scanFrequence = new Timer(15000);
        active = true;
        this.name = name;
        background = Background.getDefaultBackground();
        sprites = new Sprite[expandFactor];
    }

    public void add(Sprite member)
    {
        sprites[size] = member;
        member.setBackground(background);
        if(++size >= sprites.length)
            sprites = (Sprite[])(Sprite[])Utility.expand(sprites, expandFactor);
    }

    public void add(int index, Sprite member)
    {
        if(index > size)
            index = size;
        if(index == size)
        {
            add(member);
        } else
        {
            System.arraycopy(sprites, index, sprites, index + 1, size - index);
            sprites[index] = member;
            member.setBackground(background);
            if(++size >= sprites.length)
                sprites = (Sprite[])(Sprite[])Utility.expand(sprites, expandFactor);
        }
    }

    public Sprite remove(int index)
    {
        Sprite removedSprite = sprites[index];
        int numMoved = size - index - 1;
        if(numMoved > 0)
            System.arraycopy(sprites, index + 1, sprites, index, numMoved);
        sprites[--size] = null;
        return removedSprite;
    }

    public boolean remove(Sprite s)
    {
        for(int i = 0; i < size; i++)
            if(sprites[i] == s)
            {
                remove(i);
                return true;
            }

        return false;
    }

    public void clear()
    {
        size = 0;
    }

    public void reset()
    {
        sprites = null;
        sprites = new Sprite[expandFactor];
        size = 0;
    }

    public void update(long elapsedTime)
    {
        for(int i = 0; i < size; i++)
        {
            if(!sprites[i].isActive())
                continue;
            if(sprites[i].getScreenX() > -500D && sprites[i].getScreenX() < 800D)
                sprites[i].update(elapsedTime);
            else
            if("BackGroundSpriteGroup".equals(getName()))
                sprites[i].update(elapsedTime);
            if(sprites[i].getY() < -1000D || sprites[i].getY() > 1500D)
                sprites[i].setActive(false);
        }

        if(scanFrequence.action(elapsedTime))
            removeInactiveSprites();
    }

    public void removeInactiveSprites()
    {
        removeSprites(false);
    }

    public void removeImmutableSprites()
    {
        removeSprites(true);
    }

    private void removeSprites(boolean removeImmutable)
    {
        int i = 0;
        int removed = 0;
        for(; i < size; i++)
        {
            if(!removeImmutable)
                for(; i + removed < size && !sprites[i + removed].isActive() && !sprites[i + removed].isImmutable(); removed++);
            else
                for(; i + removed < size && !sprites[i + removed].isActive(); removed++);
            if(removed > 0)
            {
                removeRange(i, i + removed);
                removed = 0;
            }
        }

        if(sprites.length > size + expandFactor * 2)
        {
            Sprite dest[] = new Sprite[size + expandFactor];
            System.arraycopy(sprites, 0, dest, 0, size);
            sprites = dest;
        }
    }

    private void removeRange(int fromIndex, int toIndex)
    {
        int numMoved = size - toIndex;
        System.arraycopy(sprites, toIndex, sprites, fromIndex, numMoved);
        for(int newSize = size - (toIndex - fromIndex); size != newSize;)
            sprites[--size] = null;

    }

    public void render(Graphics2D g)
    {
        if(comparator != null)
            sort(comparator);
        for(int i = 0; i < size; i++)
            if(sprites[i].isActive())
                sprites[i].render(g);

    }

    public void sort(Comparator c)
    {
        Arrays.sort(sprites, 0, size, c);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Background getBackground()
    {
        return background;
    }

    public void setBackground(Background backgr)
    {
        background = backgr;
        if(background == null)
            background = Background.getDefaultBackground();
        for(int i = 0; i < size; i++)
            sprites[i].setBackground(background);

    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean b)
    {
        active = b;
    }

    public Comparator getComparator()
    {
        return comparator;
    }

    public void setComparator(Comparator c)
    {
        comparator = c;
    }

    public Sprite getActiveSprite()
    {
        for(int i = 0; i < size; i++)
            if(sprites[i].isActive())
                return sprites[i];

        return null;
    }

    public Sprite getInactiveSprite()
    {
        for(int i = 0; i < size; i++)
            if(!sprites[i].isActive())
            {
                sprites[i].setActive(true);
                return sprites[i];
            }

        return null;
    }

    public Sprite[] getSprites()
    {
        return sprites;
    }

    public int getSize()
    {
        return size;
    }

    public int getExpandFactor()
    {
        return expandFactor;
    }

    public void setExpandFactor(int factor)
    {
        expandFactor = factor;
    }

    public Timer getScanFrequence()
    {
        return scanFrequence;
    }

    
    public String toString()
    {
        return super.toString() + " " + "[name=" + name + ", active=" + getSize() + ", total=" + sprites.length + ", member=" + getActiveSprite() + ", background=" + background + "]";
    }
}
