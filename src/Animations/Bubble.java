


// Source File Name:   Bubble.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;

public class Bubble extends AdvanceSprite
{

    public Bubble(int x, int y, Mario M)
    {
        game = M;
        setLocation(x, y);
        setImages(game.bsLoader.getStoredImages("Bubble"));
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        int anim[] = {
            0, 1, 2, 3, 2, 1, 0
        };
        setAnimationFrame(anim);
    }

    
    public void update(long l)
    {
        moveY(-2D);
        if(getY() < 64D)
            setActive(false);
        super.update(l);
    }

    Mario game;
}
