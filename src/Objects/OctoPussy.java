


// Source File Name:   OctoPussy.java

package Objects;

import Animations.DirectFalling;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.Point;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class OctoPussy extends AnimatedSprite
    implements BasicEnemy
{

    public OctoPussy(int x, int y, Mario g)
    {
        PositiveX = true;
        Wait = 0;
        game = g;
        setLocation(x, y);
        setImages(game.bsLoader.getStoredImages("OctoPussy"));
        setID(111);
        CheckPoint = new Point((int)getX() - 64, (int)getY());
    }

    
    public void update(long l)
    {
        Wait--;
        if(getY() > 288D)
        {
            Wait = 0;
            if(game.player.getX() < getX())
                CheckPoint.x = (int)getX() - 64;
            else
                CheckPoint.x = (int)getX() + 64;
            CheckPoint.y = (int)getY() - 64;
            DownFrame = 0;
        }
        if((getX() == CheckPoint.getX()) & (getY() == CheckPoint.getY()))
        {
            Wait = 20;
            if(game.player.getX() < getX())
                CheckPoint.x = (int)getX() - 64;
            else
                CheckPoint.x = (int)getX() + 64;
            if(game.player.getY() < getY())
                CheckPoint.y = (int)getY() - 32;
            else
                Wait = 2000;
            DownFrame = 0;
        }
        if(Wait <= 0)
        {
            moveTo(l, CheckPoint.getX(), CheckPoint.getY(), 0.20000000000000001D);
        } else
        {
            moveY(2D);
            DownFrame++;
            if((DownFrame > 5) & (DownFrame < 20))
                setFrame(1);
            else
                setFrame(0);
        }
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
        game.AnimationGroup.add(new DirectFalling(getX(), getY(), getImage()));
        setActive(false);
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

    
    public int getType()
    {
        return getID();
    }

    
    public void CollidedWithMovingShell()
    {
        game.AnimationGroup.add(new DirectFalling(getX(), getY(), getImage()));
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
            game.AnimationGroup.add(new DirectFalling(getX(), getY(), getImage()));
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
            game.AnimationGroup.add(new DirectFalling(getX(), getY(), getImage()));
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

    boolean PositiveX;
    Mario game;
    Point CheckPoint;
    private int Wait;
    private int DownFrame;
}
