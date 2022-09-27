


// Source File Name:   Flower.java

package Objects;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class Flower extends AnimatedSprite
    implements BasicEnemy
{

    public Flower(int x, int y, BufferedImage storedImages[], Mario M)
    {
        setLocation(x, y);
        setImages(storedImages);
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(100));
        game = M;
        setID(4);
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
}
