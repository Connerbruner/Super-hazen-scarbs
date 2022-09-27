


// Source File Name:   QuestCompleteText.java

package Animations;

import com.golden.gamedev.object.Sprite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class QuestCompleteText extends Sprite
{

    public QuestCompleteText(BufferedImage storedImage, double x, double y)
    {
        delay = 600;
        setImage(storedImage);
        setLocation(x, y);
    }

    
    public void update(long elapsedTime)
    {
        if(delay > 0)
            delay--;
        if(delay < 2 && getScreenX() < 48D)
            moveX(2D);
        super.update(elapsedTime);
    }

    
    public void render(Graphics2D g)
    {
        if(delay < 2)
            super.render(g);
    }

    int delay;
}
