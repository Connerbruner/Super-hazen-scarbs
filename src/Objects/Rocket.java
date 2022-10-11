


// Source File Name:   Rocket.java

package Objects;

import Animations.*;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import com.golden.gamedev.object.sprite.VolatileSprite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class Rocket extends AdvanceSprite
    implements BasicEnemy
{

    public Rocket(double x, double y, String direction, BufferedImage bufferedImage[], Mario g)
    {
        XSpeed = -5;
        delay = 10;
        setImages(bufferedImage);
        setLocation(x, y);
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(150));
        if("gotoleft".equals(direction))
        {
            XSpeed = -5;
            setAnimationFrame(animLeft);
        } else
        {
            XSpeed = 5;
            setAnimationFrame(animRight);
        }
        setID(109);
        game = g;
        game.AnimationGroup.add(new Smoke(getX(), getY(), game.bsLoader.getStoredImages("Smoke")));
    }

    
    public void update(long l)
    {
        if(delay > -1)
            delay--;
        if(delay < 0)
        {
            moveX(XSpeed);
            RemoveIfTooAway();
            super.update(l);
        }
    }

    
    public void render(Graphics2D g)
    {
        if(delay < 0)
            super.render(g);
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
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));        game.player.Jump(-8);
        game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY()));
        setActive(false);
        if(game.player.HasStar())
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
    }

    
    public void KilledByFireBall()
    {
    }

    private void RemoveIfTooAway()
    {
        if(getScreenX() < -32D)
            setActive(false);
        if(getScreenX() > 640D)
            setActive(false);
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
        game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), false));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
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
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), false));
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
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), false));
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
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), false));
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
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

    Mario game;
    int XSpeed;
    int delay;
    int animLeft[] = {
        0, 1, 2, 1
    };
    int animRight[] = {
        3, 4, 5, 4
    };
}
