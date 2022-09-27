


// Source File Name:   MountainsScrolling.java

package ExtendedObjects;

import SandBox.Mario;
import com.golden.gamedev.object.*;
import java.awt.image.BufferedImage;

public class MountainsScrolling extends Sprite
{

    public MountainsScrolling(BufferedImage image, int x, int y, Mario g)
    {
        game = g;
        setImage(image);
        setLocation(x, y);
        OriginalX = x;
    }

    
    public void update(long elapsedTime)
    {
        double divided = game.playfield.getBackground().getX() / 2.1000000000000001D;
        setX(divided + (double)OriginalX);
        super.update(elapsedTime);
    }

    Mario game;
    int OriginalX;
}
