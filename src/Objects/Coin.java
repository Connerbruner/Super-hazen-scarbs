
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Coin.java

package Objects;

import Animations.CoinAnim;
import SandBox.Mario;
import com.golden.gamedev.GameEngine;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Objects:
//            BasicEnemy, Player

public class Coin extends AdvanceSprite
    implements BasicEnemy
{

    public Coin(int x, int y, BufferedImage storedImages[], Mario M)
    {
        setLocation(x, y);
        setImages(storedImages);
        int animation[] = {
            0, 0, 0, 0, 1, 2, 1, 0
        };
        setAnimationFrame(animation);
        setAnimate(true);
        setLoopAnim(true);
        setAnimationTimer(new Timer(150));
        game = M;
        setID(21);
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
        super.setActive(false);
        game.parent.CoinInc();
        game.playSound("music/smb_coin.mp3");
    }

    public void KilledByFireBall()
    {
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
    }

    public void OtherEnemyTouchedFromRight()
    {
    }

    public void OtherEnemyTouchedFromLeft()
    {
    }

    public void CollidedWithMarioFromTOLeft()
    {
        EnemyJumperOnMario();
    }

    public void CollidedWithMarioTORight()
    {
        EnemyJumperOnMario();
    }

    public void EnemyJumperOnMario()
    {
        super.setActive(false);
        game.parent.CoinInc();
        game.playSound("music/smb_coin.mp3");
    }

    public int Life()
    {
        return 0;
    }

    public void CollidedWithJumping_Brick()
    {
        game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));
        setActive(false);
        game.parent.CoinInc();
        game.playSound("music/smb_coin.mp3");
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
}
