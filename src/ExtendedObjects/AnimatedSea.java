


// Source File Name:   AnimatedSea.java

package ExtendedObjects;

import SandBox.Mario;
import com.golden.gamedev.object.*;
import java.awt.image.BufferedImage;

public class AnimatedSea extends Sprite
{

    public AnimatedSea(BufferedImage image, int x, int y, Mario g, int start)
    {
        movement = 0;
        positve = true;
        game = g;
        setImage(image);
        setLocation(x, y);
        OriginalX = x;
        movement = start;
    }

    
    public void update(long elapsedTime)
    {
        if(movement < -30)
            positve = true;
        if(movement > 30)
            positve = false;
        if(positve)
            movement = movement + 1;
        else
            movement = movement - 1;
        double divided = game.playfield.getBackground().getX() / 2.1000000000000001D;
        setX(divided + (double)OriginalX + (double)(movement / 3));
        super.update(elapsedTime);
    }

    Mario game;
    int OriginalX;
    int movement;
    boolean positve;
}
