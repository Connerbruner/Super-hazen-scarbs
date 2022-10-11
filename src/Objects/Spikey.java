


// Source File Name:   Spikey.java

package Objects;

import Animations.*;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class Spikey extends AnimatedSprite
    implements BasicEnemy
{

    public Spikey(int x, int y, BufferedImage Enemy_Image[], Mario g)
    {
        PositiveX = true;
        Gravity = 8;
        setLocation(x, y);
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(160));
        setAnimate(true);
        setLoopAnim(true);
        game = g;
        setID(117);
        if(MariotoRight())
        {
            PositiveX = false;
            setAnimationFrame(2, 3);
        } else
        {
            PositiveX = true;
            setAnimationFrame(0, 1);
        }
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

    
    public void MarioJumpedOnEnemy()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            KilledByFireBall();
        } else
        {
            game.player.Decerease();
        }
    }

    
    public void KilledByFireBall()
    {
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
        setActive(false);
    }

    
    public void bounce()
    {
        Gravity = 6;
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
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void OtherEnemyTouchedFromRight()
    {
        PositiveX = true;
        setAnimationFrame(0, 1);
    }

    
    public void OtherEnemyTouchedFromLeft()
    {
        PositiveX = false;
        setAnimationFrame(2, 3);
    }

    
    public void CollidedWithMarioFromTOLeft()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
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
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            setActive(false);
        } else
        {
            game.player.Decerease();
        }
    }

    
    public void EnemyJumperOnMario()
    {
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            KilledByFireBall();
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
        if(PositiveX)
        {
            PositiveX = false;
            setAnimationFrame(2, 3);
        } else
        {
            PositiveX = true;
            setAnimationFrame(0, 1);
        }
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
