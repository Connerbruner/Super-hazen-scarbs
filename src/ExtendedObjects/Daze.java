


// Source File Name:   Daze.java

package ExtendedObjects;

import Objects.Boss;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;

public class Daze extends AnimatedSprite
{

    public Daze(Mario game, Boss boss)
    {
        this.game = game;
        this.boss = boss;
        setImages(game.bsLoader.getStoredImages("Daze"));
        setLocation(boss.getX(), boss.getY());
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(150));
    }

    
    public void update(long elapsedTime)
    {
        if(boss.isActive())
        {
            setLocation(boss.getX() - 16D, boss.getY() - 32D);
            super.update(elapsedTime);
        } else
        {
            setActive(false);
        }
        if(getFrame() == getFinishAnimationFrame())
            setActive(false);
    }

    Boss boss;
    Mario game;
}
