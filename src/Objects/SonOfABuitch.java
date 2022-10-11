


// Source File Name:   SonOfABuitch.java

package Objects;

import Animations.*;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.Utility;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            SpikeyEgg, BasicEnemy, Player

public class SonOfABuitch extends AnimatedSprite
    implements BasicEnemy
{

    public SonOfABuitch(int x, int y, BufferedImage Enemy_Image[], Mario g)
    {
        PositiveX = true;
        goLeft = true;
        Delay = 100;
        setLocation(x, 80D);
        setImages(Enemy_Image);
        game = g;
        setID(115);
        Movement = 100;
    }

    
    public void update(long l)
    {
        Delay--;
        if(Delay < 0)
        {
            ThrowSpikes();
            setFrame(0);
        }
        if((Delay > 1) & (Delay < 10))
            setFrame(1);
        if(goLeft)
            Movement--;
        else
            Movement++;
        if(Movement < -100)
            goLeft = false;
        else
        if(Movement > 100)
            goLeft = true;
        setX(game.player.getX() + (double)(Movement * 2));
        super.update(l);
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
        game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY()));
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
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY()));
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
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            KilledByFireBall();
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
            KilledByFireBall();
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

    private void ThrowSpikes()
    {
        Delay = Utility.getRandom(1, 5) * 50;
        game.EnemyGroup.add(new SpikeyEgg((int)getX(), (int)getY(), game.bsLoader.getStoredImages("SpikeyEgg"), game, PositiveX));
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
    int Movement;
    boolean goLeft;
    int Delay;
}
