


// Source File Name:   Boss.java

package Objects;

import Animations.*;
import ExtendedObjects.Daze;
import SandBox.Mario;
import com.golden.gamedev.object.*;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.Utility;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            Hammer, Fire, BasicEnemy, Player

public class Boss extends AnimatedSprite
    implements BasicEnemy
{

    public Boss(BufferedImage storedImages[], int x, int y, Mario g)
    {
        Life = 4;
        left = 64;
        right = 64;
        PositiveX = true;
        Move = true;
        DazeState = 0;
        JumpTime = 20;
        Delay = 40;
        GoNearMario = false;
        Hammer = false;
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        setID(119);
        game = g;
        left = x - 96;
        right = x + 96;
        JumpTime = Utility.getRandom(3, 6) * 20;
        FireThrowTime = Utility.getRandom(1, 10) * 10;
        HammerThrowTime = Utility.getRandom(1, 10) * 10;
    }

    private void HammerThrow()
    {
        HammerThrowTime--;
        if(HammerThrowTime < 0)
        {
            HammerThrowTime = Utility.getRandom(2, 10) * 20;
            HammerGravity = Utility.getRandom(-10, -7);
            Hammerxspeed = Utility.getRandom(-4, -2);
        }
    }

    private void ContinuousHammerThrow()
    {
        if(HammerThrowTime < 10 && game.player.getX() < getX())
        {
            game.HammerGroup.add(new Hammer(getX(), getY(), Hammerxspeed, HammerGravity, game.bsLoader.getStoredImages("BWHammer")));
            System.out.println(hammerThrown++);
        }
    }

    
    public void update(long l)
    {
        if(DazeState < 1)
        {
            if(Hammer)
            {
                HammerThrow();
                ContinuousHammerThrow();
            }
            LookAtMario();
            if(Gravity < 8)
                Gravity = Gravity + 1;
            moveY(Gravity);
            if(GoNearMario)
            {
                moveX(1.0D);
            } else
            {
                JumpTime--;
                if(JumpTime < 0)
                    Jump();
            }
            if(!GoNearMario)
            {
                if(getX() < (double)left)
                    PositiveX = false;
                if(getX() > (double)right)
                    PositiveX = true;
                if(PositiveX)
                    moveX(-1D);
                else
                    moveX(1.0D);
            }
            HammerFire();
            MarioToRight();
        }
        if(DazeState > 0)
        {
            if(game.player.getX() < getX())
                setAnimationFrame(12, 13);
            else
                setAnimationFrame(14, 15);
            DazeState--;
        } else
        {
            Move = true;
        }
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
        if(game.player.HasStar())
        {
            game.player.Jump(-8);
            game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY()));
            game.playSound("music/smb_bowserfalls.mp3");
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
            for(int i = 0; i < game.EnemyGroup.getSize(); i++)
                if(game.EnemyGroup.getSprites()[i] != null)
                    game.EnemyGroup.getSprites()[i].setActive(false);

        } else
        {
            game.player.Decerease();
        }
    }

    
    public void KilledByFireBall()
    {
        Life--;
        DazeState = 30;
        Move = false;
        if(Life == 0)
        {
            for(int i = 0; i < 10; i++)
                game.AnimationGroup.add(new Daze(game, this));

        }
        if(Life < 0)
        {
            game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));
            game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY(), -10));
            game.playSound("music/smb_bowserfalls.mp3");
            setActive(false);
            for(int i = 0; i < game.EnemyGroup.getSize(); i++)
                if(game.EnemyGroup.getSprites()[i] != null)
                    game.EnemyGroup.getSprites()[i].setActive(false);

        }
    }

    
    public void bounce()
    {
    }

    
    public void setYloc(double d)
    {
        setY(d);
    }

    private void LookAtMario()
    {
        if(game.player.getX() < getX())
            setAnimationFrame(0, 3);
        else
            setAnimationFrame(4, 7);
    }

    private void Jump()
    {
        if(game.player.getX() < getX())
            Gravity = -16;
        JumpTime = Utility.getRandom(3, 6) * 20;
    }

    private void HammerFire()
    {
        FireThrowTime--;
        if((Delay > 20) & (Delay < 39))
            setAnimationFrame(8, 8);
        else
        if((Delay > 0) & (Delay < 20))
            setAnimationFrame(9, 9);
        if(FireThrowTime < 0)
            if(game.player.getX() < getX())
            {
                Delay--;
                if(Delay == 20)
                    game.HammerGroup.add(new Fire(getX() - 32D, (getY() / 32D) * 32D, game.bsLoader.getStoredImages("Fire"), game));
                if(Delay < 0)
                {
                    Delay = 40;
                    FireThrowTime = Utility.getRandom(5, 10) * 10;
                    game.playSound("music/smb_bowserfire.mp3");
                }
            } else
            {
                Delay = 0;
            }
    }

    
    public void CollidedWithShell()
    {
    }

    
    public void CollidedWithMovingShell()
    {
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
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
            game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY(), -10));
            game.playSound("music/smb_bowserfalls.mp3");
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
            game.AnimationGroup.add(new DirectFalling(getImage(), getX(), getY(), -10));
            game.playSound("music/smb_bowserfalls.mp3");
            game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
            setActive(false);
        } else
        {
            game.player.Decerease();
        }
    }

    
    public void EnemyJumperOnMario()
    {
        MarioJumpedOnEnemy();
    }

    private void MarioToRight()
    {
        if(game.player.getX() > getX())
            GoNearMario = true;
        else
            GoNearMario = false;
    }

    
    public int Life()
    {
        Life--;
        return Life;
    }

    public void BadGameGlitch()
    {
        setActive(false);
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

    public void SetHammer(boolean b)
    {
        Hammer = true;
    }

    int Life;
    Mario game;
    int left;
    int right;
    boolean PositiveX;
    boolean Move;
    int DazeState;
    int JumpTime;
    private int Gravity;
    int FireThrowTime;
    private int Delay;
    private boolean GoNearMario;
    private boolean Hammer;
    private int HammerThrowTime;
    int Hammerxspeed;
    int HammerGravity;
    int hammerThrown;
}
