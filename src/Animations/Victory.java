


// Source File Name:   Victory.java

package Animations;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;

public class Victory extends AdvanceSprite
{

    public Victory(Mario M, int x, int y)
    {
        game = M;
        if(game.player.getID() != 1)
            if(game.player.getID() == 2)
            {
                for(int i = 0; i < anim.length; i++)
                    anim[i] = anim[i] + 11;

            } else
            if(game.player.getID() == 3)
            {
                for(int i = 0; i < anim.length; i++)
                    anim[i] = anim[i] + 22;

            }
        setAnimationFrame(anim);
        setLocation(x - 32, y - 32);
        setImages(M.bsLoader.getStoredImages("Victory"));
        setAnimationTimer(new Timer(120));
        setAnimate(true);
    }

    
    public void update(long elapsedTime)
    {
        if(getFrame() == getFinishAnimationFrame())
            setActive(false);
        super.update(elapsedTime);
    }

    Mario game;
    int anim[] = {
        0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 
        4, 5, 6, 7, 8, 9, 10
    };
}
