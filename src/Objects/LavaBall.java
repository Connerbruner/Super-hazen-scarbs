


// Source File Name:   LavaBall.java

package Objects;

import Animations.LavaSpots;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.util.Utility;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class LavaBall extends AnimatedSprite
    implements BasicEnemy
{

    public LavaBall(double x, double y, Mario g)
    {
        super(x, 448D);
        gravity = -10D;
        showRippleAt = 416;
        delay = 10;
        game = g;
        setImages(game.bsLoader.getStoredImages("LavaBall"));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(150));
    }

    
    public void update(long elapsedTime)
    {
        if(getY() > 500D)
            Jump();
        else
            moveY(gravity);
        if(gravity > 0.0D)
            setAnimationFrame(3, 5);
        else
            setAnimationFrame(0, 2);
        if(gravity < 0.0D && getY() < 320D && delay < 0)
            ThrowLavaSpots();
        if(gravity < 10D)
            gravity = gravity + 0.40000000000000002D;
        if(delay > -10)
            delay--;
        super.update(elapsedTime);
    }

    private void ThrowLavaSpots()
    {
        delay = Utility.getRandom(1, 2) * 5;
        game.AnimationGroup.add(new LavaSpots(getX() + (double)(Utility.getRandom(0, 1) * 20), getY() + 48D, game.bsLoader.getStoredImages("LavaSpots")));
    }

    private void Jump()
    {
        timer--;
        if(timer < 0)
        {
            timer = Utility.getRandom(2, 7) * 20;
            setY(500D);
            gravity = Utility.getRandom(-17, -14);
        }
    }

    
    public void CollidedWithBrick_GoToLeft()
    {
    }

    
    public void CollidedWithBrick_GoToRight()
    {
    }

    
    public int getType()
    {
        return getID();
    }

    
    public void MarioJumpedOnEnemy()
    {
    }

    
    public void KilledByFireBall()
    {
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d1)
    {
    }

    
    public void CollidedWithShell()
    {
    }

    
    public void CollidedWithMovingShell()
    {
    }

    
    public void OtherEnemyTouchedFromRight()
    {
    }

    
    public void OtherEnemyTouchedFromLeft()
    {
    }

    
    public void CollidedWithMarioFromTOLeft()
    {
    }

    
    public void CollidedWithMarioTORight()
    {
    }

    
    public void EnemyJumperOnMario()
    {
    }

    
    public int Life()
    {
        return 0;
    }

    
    public void CollidedWithJumping_Brick()
    {
    }

    
    public boolean MariotoRight()
    {
        boolean positive;
        if(game.player.getX() < getX())
            positive = false;
        else
            positive = true;
        return positive;
    }

    Mario game;
    double gravity;
    private int timer;
    int showRippleAt;
    int delay;
}
