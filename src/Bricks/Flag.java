


// Source File Name:   Flag.java

package Bricks;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import java.awt.image.BufferedImage;

public class Flag extends Sprite
{

    public Flag(int i, int i0, BufferedImage storedImage, Mario aThis)
    {
        super(storedImage, i, i0);
        game = aThis;
        setID(-2);
    }

    Mario game;
}
