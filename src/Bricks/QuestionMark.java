


// Source File Name:   QuestionMark.java

package Bricks;

import Animations.*;
import Gears.Codes;
import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Bricks:
//            Iron, BasicBrick

public class QuestionMark extends AdvanceSprite
    implements BasicBrick
{

    public QuestionMark(int x, int y, Mario g)
    {
        InsideItem = "CoinInside";
        setLocation(x, y);
        game = g;
        if("UnderGround".equals(game.GetAttribute()) || "Castle".equals(game.GetAttribute()))
            setImages(game.bsLoader.getStoredImages("QuestionMarkGrey"));
        else
            setImages(game.bsLoader.getStoredImages("QuestionMark"));
        setAnimate(true);
        setLoopAnim(true);
        int a[] = {
            0, 0, 1, 2, 1, 0
        };
        setAnimationFrame(a);
        setAnimationTimer(new Timer(200));
        setID(1);
    }

    public QuestionMark(int x, int y, BufferedImage storedImages[], String item, Mario g)
    {
        this(x, y, g);
        InsideItem = item;
    }

    
    public void RemoveIt()
    {
        setActive(false);
    }

    
    public String getInsideItem()
    {
        return InsideItem;
    }

    public void setInsideItem(String insideitem)
    {
        InsideItem = insideitem;
    }

    
    public void HitFromDown()
    {
        game.BrickGroup.add(new Iron((int)getX(), (int)getY(), game.bsLoader.getStoredImages("Iron"), "red", game));
        setActive(false);
        switch(Codes.GetCode(getInsideItem()))
        {
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
        }
    }

    
    public boolean isJump()
    {
        return false;
    }

    private String InsideItem;
    Mario game;
}
