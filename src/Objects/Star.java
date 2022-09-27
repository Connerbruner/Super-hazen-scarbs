


// Source File Name:   Star.java

package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class Star extends AnimatedSprite
    implements BasicEnemy
{

    public Star(int x, int y, BufferedImage storedImage[], Mario g)
    {
        super(storedImage, x, y);
        PositiveX = true;
        Gravity = -5D;
        game = g;
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(100));
        setID(20);
        PositiveX = false;
        XSpeed = 2D;
    }

    
    public void update(long l)
    {
        if(Gravity < 5D)
            Gravity = Gravity + 0.5D;
        moveY(Gravity);
        if(PositiveX)
            moveX(-2D);
        else
            moveX(2D);
        if(getY() > 700D)
            setActive(false);
        super.update(l);
    }

    
    public void bounce()
    {
        Gravity = -9D;
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
        game.player.STAR();
        super.setActive(false);
    }

    
    public void KilledByFireBall()
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
        game.player.STAR();
        super.setActive(false);
    }

    
    public void CollidedWithMarioTORight()
    {
        game.player.STAR();
        super.setActive(false);
    }

    
    public void EnemyJumperOnMario()
    {
        game.player.STAR();
        super.setActive(false);
    }

    
    public int Life()
    {
        return 0;
    }

    
    public void setYloc(double d)
    {
        bounce();
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
    public double Gravity;
    private double XSpeed;
}
