


// Source File Name:   MarioSlidingDown.java

package Animations;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;

public class MarioSlidingDown extends AnimatedSprite
{

    public MarioSlidingDown(double x, double y, Mario g)
    {
        delay = 100;
        IsDown = false;
        DelayDone = false;
        game = g;
        setImages(game.player.getImages());
        setLocation(x, y);
        setAnimationTimer(new Timer(200));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(12, 13);
    }

    
    public void update(long l)
    {
        if(delay > 0)
            delay--;
        else
            DelayDone = true;
        if(!IsDown)
            moveY(3D);
        if(getY() > (double)(384 - getHeight()))
        {
            setY(384 - getHeight());
            IsDown = true;
            setAnimate(false);
        }
        if(DelayDone & IsDown)
        {
            game.player.setLocation(getX() - 12D, getY());
            game.player.NoControlling();
            game.player.MoveForward();
            game.PlayEnemys();
            setActive(false);
        }
        super.update(l);
    }

    int delay;
    Mario game;
    private boolean IsDown;
    private boolean DelayDone;
}
