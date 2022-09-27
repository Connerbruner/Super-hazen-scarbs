


// Source File Name:   SimpleAnimatedSprite.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class SimpleAnimatedSprite extends AnimatedSprite
{

    public SimpleAnimatedSprite(BufferedImage storedImages[], int x, int y)
    {
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(140));
        setAnimate(true);
        setLoopAnim(true);
    }

    Mario game;
}
