


// Source File Name:   FishyWater.java

package Objects;

import Animations.*;
import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class FishyWater extends AnimatedSprite
    implements BasicEnemy
{

    public FishyWater(int x, int y, Mario g, int Type)
    {
        Xspeed = 1;
        type = "grey";
        UpDown = false;
        Up = 0;
        Down = 0;
        goingUp = true;
        game = g;
        switch(Type)
        {
        case 1: // '\001'
            Xspeed = -1;
            type = "grey";
            UpDown = false;
            setImages(game.bsLoader.getStoredImages("FishGrey"));
            setAnimationTimer(new Timer(200));
            break;

        case 2: // '\002'
            Xspeed = -1;
            type = "grey";
            UpDown = true;
            setImages(game.bsLoader.getStoredImages("FishGrey"));
            setAnimationTimer(new Timer(200));
            break;

        case 3: // '\003'
            Xspeed = -2;
            type = "red";
            UpDown = false;
            setImages(game.bsLoader.getStoredImages("FishRed"));
            setAnimationTimer(new Timer(100));
            break;

        case 4: // '\004'
            Xspeed = -2;
            type = "red";
            UpDown = true;
            setImages(game.bsLoader.getStoredImages("FishRed"));
            setAnimationTimer(new Timer(100));
            break;
        }
        Up = y - 32;
        Down = y + 32;
        setLocation(x, y);
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(0, 1);
        setID(112);
    }

    
    public void update(long l)
    {
        moveX(Xspeed);
        if(UpDown)
        {
            if(getY() < (double)Up)
                goingUp = false;
            if(getY() > (double)Down)
                goingUp = true;
            if(goingUp)
                moveY(-0.5D);
            if(!goingUp)
                moveY(0.5D);
        }
        super.update(l);
    }

    
    public void MarioJumpedOnEnemy()
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

    
    public void KilledByFireBall()
    {
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));        game.AnimationGroup.add(new DirectFalling(getX(), getY(), getImage()));
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
        MarioJumpedOnEnemy();
    }

    
    public void CollidedWithMarioTORight()
    {
        MarioJumpedOnEnemy();
    }

    
    public void EnemyJumperOnMario()
    {
        MarioJumpedOnEnemy();
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
    int Xspeed;
    String type;
    boolean UpDown;
    int Up;
    int Down;
    boolean goingUp;
}
