// Source File Name:   AnimatedGrass.java
package ExtendedObjects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class AnimatedGrass extends AnimatedSprite {

    public AnimatedGrass(BufferedImage storedImages[], int x, int y) {
        Gravity = -15;
        setLocation(x + 16, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(200));
        setAnimate(true);
        setLoopAnim(true);
    }

    int Gravity;
    Mario game;
}
