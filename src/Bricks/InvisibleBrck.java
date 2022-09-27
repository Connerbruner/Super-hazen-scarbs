


// Source File Name:   InvisibleBrck.java

package Bricks;

import Animations.*;
import Gears.Codes;
import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.util.ImageUtil;

// Referenced classes of package Bricks:
//            Iron, BasicBrick

public class InvisibleBrck extends Sprite
    implements BasicBrick
{

    public InvisibleBrck(int x, int y, String item, Mario g)
    {
        setLocation(x, y);
        setImage(ImageUtil.createImage(32, 32, 3));
        setID(17);
        game = g;
        this.item = item;
    }

    
    public void HitFromDown()
    {
        game.BrickGroup.add(new Iron((int)getX(), (int)getY(), game.bsLoader.getStoredImages("Iron"), game));
        switch(Codes.GetCode(getInsideItem()))
        {
        case 0: // '\0'
        default:
            break;

        case 1: // '\001'
            if(game.player.getID() == 1)
            {
                game.VolitileGroup.add(new MashroomAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImage("Mashroom"), game));
                break;
            }
            if(game.player.getID() == 2 || game.player.getID() == 3)
                game.VolitileGroup.add(new FlowerAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("Flower"), game));
            break;

        case 2: // '\002'
            game.AnimationGroup.add(new CoinAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("CoinAnim"), game));
            break;

        case -1: 
            game.VolitileGroup.add(new LifeAnim((int)getX(), (int)getY(), game.bsLoader.getStoredImages("1UP")[0], game));
            break;
        }
        RemoveIt();
    }

    
    public void RemoveIt()
    {
        setActive(false);
    }

    
    public String getInsideItem()
    {
        return item;
    }

    
    public boolean isJump()
    {
        return false;
    }

    Mario game;
    String item;
}
