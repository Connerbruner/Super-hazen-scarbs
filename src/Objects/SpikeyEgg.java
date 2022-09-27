


// Source File Name:   SpikeyEgg.java

package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            Spikey, BasicEnemy, Player

public class SpikeyEgg extends AnimatedSprite
    implements BasicEnemy
{

    public SpikeyEgg(int x, int y, BufferedImage Enemy_Image[], Mario g, boolean direction)
    {
        Gravity = -12;
        PositiveX = true;
        setLocation(x, y);
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(160));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 1);
        PositiveX = direction;
        game = g;
        setID(118);
    }

    
    public void update(long l)
    {
        if(Gravity < 8)
            Gravity++;
        moveY(Gravity);
        super.update(l);
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
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImages("Spikey")[0], MariotoRight()));
        setActive(false);
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d)
    {
        game.EnemyGroup.add(new Spikey((int)getX(), (int)getY(), game.bsLoader.getStoredImages("Spikey"), game));
        setActive(false);
        setY(d);
    }

    
    public void CollidedWithShell()
    {
    }

    
    public int getType()
    {
        return getID();
    }

    
    public void CollidedWithMovingShell()
    {
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void CollidedWithBrick_GoToLeft()
    {
    }

    
    public void CollidedWithBrick_GoToRight()
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
        if(game.player.HasStar())
        {
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
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
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
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
    public int Gravity;
    boolean PositiveX;
}
