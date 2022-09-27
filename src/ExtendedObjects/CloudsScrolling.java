


// Source File Name:   CloudsScrolling.java

package ExtendedObjects;

import SandBox.Mario;
import com.golden.gamedev.object.*;
import java.awt.image.BufferedImage;

public class CloudsScrolling extends Sprite
{

    public CloudsScrolling(BufferedImage image, int x, int y, Mario g)
    {
        game = g;
        setImage(image);
        setLocation(x, y);
        OriginalX = x;
    }

    
    public void update(long elapsedTime)
    {
        double divided = game.playfield.getBackground().getX() / 1.3D;
        setX(divided + (double)OriginalX);
        super.update(elapsedTime);
    }

    Mario game;
    int OriginalX;
}
