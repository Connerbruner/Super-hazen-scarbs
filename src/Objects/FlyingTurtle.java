


// Source File Name:   FlyingTurtle.java

package Objects;

import Animations.*;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            EnemyTurtle, BasicEnemy, Player

public class FlyingTurtle extends AnimatedSprite
    implements BasicEnemy
{

    public FlyingTurtle(BufferedImage bufferedImage[], int x, int y, Mario g)
    {
        super(bufferedImage, x, y);
        PositiveX = true;
        Gravity = -6;
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 1);
        setID(101);
        game = g;
    }

    
    public void update(long l)
    {
        if(Gravity < 8)
            Gravity = Gravity + 1;
        super.update(l);
        moveY(Gravity);
        if(PositiveX)
            moveX(-2D);
        else
            moveX(2D);
        super.update(l);
    }

    
    public void bounce()
    {
        Gravity = -16;
    }

    
    public void MarioJumpedOnEnemy()
    {
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));        game.player.Jump(-8);
        game.EnemyGroup.add(new EnemyTurtle((int)getX(), (int)getY(), game, true));
        if(game.player.HasStar())
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void CollidedWithMovingShell()
    {
        BufferedImage HorizontalFilpShell = game.bsLoader.getStoredImage("TurtelShell");
        HorizontalFilpShell = ImageUtil.flipHorizontal(HorizontalFilpShell);
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), HorizontalFilpShell, MariotoRight()));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void CollidedWithBrick_GoToLeft()
    {
        PositiveX = true;
        setAnimationFrame(0, 1);
    }

    
    public void CollidedWithBrick_GoToRight()
    {
        PositiveX = false;
        setAnimationFrame(2, 3);
    }

    
    public int getType()
    {
        return getID();
    }

    
    public void KilledByFireBall()
    {
        BufferedImage HorizontalFilpShell = game.bsLoader.getStoredImage("TurtelShell");
        HorizontalFilpShell = ImageUtil.flipHorizontal(HorizontalFilpShell);
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), HorizontalFilpShell, MariotoRight()));
        setActive(false);
    }

    
    public void setYloc(double d)
    {
        setY(d);
        bounce();
    }

    
    public void CollidedWithShell()
    {
    }

    
    public void OtherEnemyTouchedFromRight()
    {
        PositiveX = false;
        setAnimationFrame(2, 3);
    }

    
    public void OtherEnemyTouchedFromLeft()
    {
        PositiveX = true;
        setAnimationFrame(0, 1);
    }

    
    public void CollidedWithMarioFromTOLeft()
    {
        if(game.player.HasStar())
        {
            CollidedWithMovingShell();
            setActive(false);
        } else
        {
            game.player.Decerease();
        }
    }

    
    public void CollidedWithMarioTORight()
    {
        if(game.player.HasStar())
        {
            CollidedWithMovingShell();
            setActive(false);
        } else
        {
            game.player.Decerease();
        }
    }

    public void Kill()
    {
    }

    
    public void EnemyJumperOnMario()
    {
        if(game.player.HasStar())
        {
            CollidedWithMovingShell();
            setActive(false);
        } else
        {
            game.player.Decerease();
        }
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
