


// Source File Name:   HelmetShell.java

package Objects;

import Animations.FallingDeadSprites;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;
import com.golden.gamedev.util.ImageUtil;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            MovingHelmetShell, BasicEnemy, Player

public class HelmetShell extends Sprite
    implements BasicEnemy
{

    public HelmetShell(double x, double y, BufferedImage storedImage, Mario g, boolean direction)
    {
        super(storedImage, x, y);
        PositiveX = true;
        setID(106);
        PositiveX = direction;
        game = g;
    }

    
    public void update(long l)
    {
        moveY(6D);
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
            game.EnemyGroup.add(new MovingHelmetShell(game.getPlayer().getX() + (double)game.getPlayer().getWidth(), getY(), game.bsLoader.getStoredImage("HelmetShell"), game, false));
        else
            game.EnemyGroup.add(new MovingHelmetShell(game.getPlayer().getX() - (double)getWidth(), getY(), game.bsLoader.getStoredImage("HelmetShell"), game, true));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
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
    }

    
    public void OtherEnemyTouchedFromLeft()
    {
    }

    
    public void CollidedWithMarioFromTOLeft()
    {
        game.EnemyGroup.add(new MovingHelmetShell(game.getPlayer().getX() + (double)game.getPlayer().getWidth(), getY(), game.bsLoader.getStoredImage("HelmetShell"), game, false));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
        setActive(false);
    }

    
    public void CollidedWithMarioTORight()
    {
        game.EnemyGroup.add(new MovingHelmetShell(game.getPlayer().getX() - (double)getWidth(), getY(), game.bsLoader.getStoredImage("HelmetShell"), game, true));
        game.AnimationGroup.add(new VolatileSprite(game.bsLoader.getStoredImages("Twink"), getX(), getY()));
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

    Mario game;
    boolean PositiveX;
}
