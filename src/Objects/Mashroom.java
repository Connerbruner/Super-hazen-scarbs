


// Source File Name:   Mashroom.java

package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class Mashroom extends AnimatedSprite
    implements BasicEnemy
{

    public Mashroom(int x, int y, BufferedImage storedImage[], Mario g)
    {
        super(storedImage, x, y);
        PositiveX = true;
        Gravity = 6;
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(300));
        setID(3);
        PositiveX = false;
    }

    
    public void update(long l)
    {
        if(Gravity < 8)
            Gravity = Gravity + 1;
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
        game.player.Grow();
        setActive(false);
    }

    
    public void KilledByFireBall()
    {
    }

    
    public void bounce()
    {
        Gravity = -9;
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
        game.player.Grow();
        setActive(false);
    }

    
    public void CollidedWithMarioTORight()
    {
        game.player.Grow();
        setActive(false);
    }

    
    public void EnemyJumperOnMario()
    {
        game.player.Grow();
        setActive(false);
    }

    
    public int Life()
    {
        return 0;
    }

    
    public void CollidedWithJumping_Brick()
    {
        if(PositiveX)
            PositiveX = false;
        else
            PositiveX = true;
        bounce();
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
