


// Source File Name:   Helmet.java

package Objects;

import Animations.*;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            HelmetShell, BasicEnemy, Player

public class Helmet extends AnimatedSprite
    implements BasicEnemy
{

    public Helmet(int x, int y, BufferedImage Enemy_Image[], Mario g)
    {
        super(Enemy_Image, x, y);
        PositiveX = true;
        Gravity = 6;
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 1);
        setID(105);
        game = g;
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

    
    public void MarioJumpedOnEnemy()
    {
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));        game.player.Jump(-8);
        game.player.Jump(-8);
        game.EnemyGroup.add(new HelmetShell(getX(), getY(), game.bsLoader.getStoredImage("HelmetShell"), game, MariotoRight()));
        if(game.player.HasStar())
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
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
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d)
    {
        setY(d);
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
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), getImage(), MariotoRight()));
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
        game.EnemyGroup.add(new HelmetShell(getX(), getY(), ImageUtil.flipHorizontal(game.bsLoader.getStoredImage("HelmetShell")), game, MariotoRight()));
        setActive(false);
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
