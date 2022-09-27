


// Source File Name:   RocketLauncher.java

package Bricks;

import Objects.Player;
import Objects.Rocket;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.util.Utility;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            BasicBrick

public class RocketLauncher extends Sprite
    implements BasicBrick
{

    public RocketLauncher(BufferedImage bufferedImage, int x, int y, Mario M)
    {
        super(bufferedImage, x, y);
        ShootDelay = Utility.getRandom(1, 3) * 50;
        game = M;
    }

    
    public void update(long l)
    {
        ShootDelay--;
        if(ShootDelay <= 0 && !((game.player.getX() > getX() - 100D) & (game.player.getX() < getX() + 100D)))
            ShootandUpDateDelay();
    }

    private void ShootandUpDateDelay()
    {
        if(game.player.getX() < getX())
            game.EnemyGroup.add(new Rocket(getX() - 16D, getY(), "gotoleft", game.bsLoader.getStoredImages("Rocket"), game));
        else
            game.EnemyGroup.add(new Rocket(getX() + 16D, getY(), "gotoright", game.bsLoader.getStoredImages("Rocket"), game));
        ShootDelay = Utility.getRandom(2, 5) * 100;
    }

    
    public void HitFromDown()
    {
    }

    
    public void RemoveIt()
    {
    }

    
    public String getInsideItem()
    {
        return "empty";
    }

    
    public boolean isJump()
    {
        return false;
    }

    int ShootDelay;
    Mario game;
}
