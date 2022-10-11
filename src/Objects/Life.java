


// Source File Name:   Life.java

package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class Life extends AnimatedSprite
    implements BasicEnemy
{

    public Life(int x, int y, BufferedImage storedImage[], Mario g)
    {
        super(storedImage, x, y);
        PositiveX = true;
        Gravity = 6;
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(300));
        setID(12);
        PositiveX = false;
    }

    
    public void update(long l)
    {
        moveY(Gravity);
        if(PositiveX)
            moveX(-2D);
        else
            moveX(2D);
        super.update(l);
    }

    
    public void CollidedWithBrick_GoToLeft()
    {
        PositiveX = true;
    }

    
    public void CollidedWithBrick_GoToRight()
    {
        PositiveX = false;
    }

    public int getType()
    {
        return getID();
    }

    
    public void MarioJumpedOnEnemy()
    {
        setActive(false);
    }

    
    public void KilledByFireBall()
    {
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d)
    {
        setY(d);
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
        setActive(false);
    }

    
    public void CollidedWithMarioTORight()
    {
        setActive(false);
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

    boolean PositiveX;
    Mario game;
    public int Gravity;
}
