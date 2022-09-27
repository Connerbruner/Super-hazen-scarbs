


// Source File Name:   Kiss.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;

class Kiss extends AdvanceSprite
{

    public Kiss(int x, int y, Mario M)
    {
        animations = 1;
        setLocation(x, y);
        setImages(M.bsLoader.getStoredImages("Kiss"));
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(anim);
    }

    
    public void update(long l)
    {
        if(getFrame() == anim.length - 8)
            setAnimationFrame(anim.length - 8, anim.length - 1);
        super.update(l);
    }

    Mario game;
    int animations;
    int anim[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 7, 7, 
        7, 8, 8, 8, 9, 9, 10, 10, 11, 12, 
        13, 14, 15, 16, 17, 18, 19, 20
    };
}
