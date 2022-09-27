


// Source File Name:   TurtelShell.java

package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;

// Referenced classes of package Objects:
//            MovingTurtelShell, BasicEnemy, Player

public class TurtelShell extends Sprite
    implements BasicEnemy
{

    public TurtelShell(double x, double y, Mario g, boolean Direction, boolean standing, 
            boolean isGreen)
    {
        super(x, y);
        Jump = false;
        PositiveX = true;
        Gravity = 6;
        Standing = true;
        Green = true;
        setID(103);
        PositiveX = Direction;
        Standing = standing;
        game = g;
        Green = isGreen;
        if(Standing)
        {
            if(Green)
                setImage(game.bsLoader.getStoredImage("TurtelShell"));
            else
                setImage(game.bsLoader.getStoredImage("TurtelShellRed"));
        } else
        if(Green)
            setImage(game.bsLoader.getStoredImage("TurtelShellFilp"));
        else
            setImage(game.bsLoader.getStoredImage("TurtelShellFilpRed"));
    }

    TurtelShell(double x, double y, Mario game, boolean PositiveX, boolean Standing, 
            String jump, boolean isGreen)
    {
        this(x, y, game, PositiveX, Standing, isGreen);
        Gravity = -10;
    }

    
    public void update(long l)
    {
        if(Gravity > 4)
        {
            moveY(Gravity);
        } else
        {
            Gravity = Gravity + 1;
            moveY(Gravity);
            if(PositiveX)
                moveX(-2D);
            else
                moveX(2D);
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
        if(game.getPlayer().getX() < getX())
            game.EnemyGroup.add(new MovingTurtelShell(game.getPlayer().getX() + (double)game.getPlayer().getWidth(), getY(), game, false, Standing, Green));
        else
            game.EnemyGroup.add(new MovingTurtelShell(game.getPlayer().getX() - (double)getWidth(), getY(), game, true, Standing, Green));
        setActive(false);
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
    }

    
    public void KilledByFireBall()
    {
        if(Green)
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
        else
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
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

    
    public void CollidedWithMovingShell()
    {
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        if(Green)
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShell"), MariotoRight()));
        else
            game.AnimationGroup.add(new FallingDeadSprites(getX(), getY(), game.bsLoader.getStoredImage("TurtelShellRed"), MariotoRight()));
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
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        game.EnemyGroup.add(new MovingTurtelShell(game.getPlayer().getX() + (double)game.getPlayer().getWidth(), getY(), game, false, Standing, Green));
        setActive(false);
    }

    
    public void CollidedWithMarioTORight()
    {
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        game.EnemyGroup.add(new MovingTurtelShell(game.getPlayer().getX() - (double)getWidth(), getY(), game, true, Standing, Green));
        setActive(false);
    }

    
    public void EnemyJumperOnMario()
    {
    }

    
    public int Life()
    {
        return 0;
    }

    
    public void CollidedWithJumping_Brick()
    {
        if(PositiveX)
            PositiveX = false;
        else
            PositiveX = true;
        game.EnemyGroup.add(new TurtelShell(getX(), getY(), game, MariotoRight(), Standing, "Jump", Green));
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

    boolean Jump;
    Mario game;
    boolean PositiveX;
    private int Gravity;
    boolean Standing;
    public boolean Green;
}
