


// Source File Name:   FishyGround.java

package Objects;

import Animations.DirectFalling;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.ImageUtil;
import com.golden.gamedev.util.Utility;
import java.awt.image.BufferedImage;
import java.util.Random;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class FishyGround extends AnimatedSprite
    implements BasicEnemy
{

    public FishyGround(int x, int y, BufferedImage Enemy_Image[], Mario g)
    {
        PositiveX = true;
        Gravity = -10D;
        XSpeed = 0;
        setLocation(x, y);
        setImages(Enemy_Image);
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 1);
        game = g;
        setID(100);
    }

    public FishyGround(Mario g)
    {
        PositiveX = true;
        Gravity = -10D;
        XSpeed = 0;
        game = g;
        setLocation(game.player.getX(), 512D);
        Random r = new Random();
        if(r.nextBoolean())
        {
            PositiveX = true;
            XSpeed = Utility.getRandom(1, 3);
            setImages(ImageUtil.flipHorizontal(game.bsLoader.getStoredImages("FishRed")));
        } else
        {
            PositiveX = false;
            XSpeed = Utility.getRandom(-3, -1);
            setImages(game.bsLoader.getStoredImages("FishRed"));
        }
        if(XSpeed < 0)
            moveX(Utility.getRandom(128, 256));
        else
            moveX(Utility.getRandom(-256, -128));
        setAnimationTimer(new Timer(300));
        setAnimate(true);
        setLoopAnim(true);
    }

    
    public void update(long l)
    {
        if(Gravity < 10D)
            Gravity = Gravity + 0.10000000000000001D;
        moveY(Gravity);
        moveX(XSpeed + game.player.speed / 20);
        if(getY() > 576D || getScreenX() < -32D || getScreenX() > 640D)
            setActive(false);
        super.update(l);
    }

    
    public void MarioJumpedOnEnemy()
    {
        if(game.player.HasStar())
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        game.player.Jump(-8);
        game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY()));
        setActive(false);
    }

    
    public void KilledByFireBall()
    {
        game.AnimationGroup.add(new DirectFalling(getX(), getY(), getImage()));
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
            game.AnimationGroup.add(new DirectFalling(getX(), getY(), getImage()));
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

    boolean PositiveX;
    Mario game;
    double Gravity;
    public int XSpeed;
}
