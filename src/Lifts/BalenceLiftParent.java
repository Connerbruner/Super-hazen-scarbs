


// Source File Name:   BalenceLiftParent.java

package Lifts;

import Animations.DirectFalling;
import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.util.ImageUtil;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// Referenced classes of package Lifts:
//            BalenceLiftChild, BasicLift

public class BalenceLiftParent extends Sprite
    implements BasicLift
{

    public BalenceLiftParent(int x, int y, Mario g, int Distance)
    {
        MarioOnLift = false;
        MaxY = 96;
        MinY = 352;
        SpeedY = 0;
        Break = false;
        game = g;
        setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6));
        setLocation(x, y);
        Child = new BalenceLiftChild(x + 32 * Distance, y, game, this);
        game.LiftGroup.add(Child);
        AddBlackBoxes();
        AddHooksAndChain(Distance);
        chain = ImageUtil.resize(game.bsLoader.getStoredImages("Chain")[0], 32, 32);
    }

    
    public void update(long elapsedTime)
    {
        if(!Break)
        {
            if(getY() < (double)MaxY)
            {
                Break();
                Child.Break();
            }
            if(getY() > (double)MinY)
            {
                Break();
                Child.Break();
            }
            if(MarioOnLift)
            {
                SpeedY++;
                if(SpeedY > 60)
                    SpeedY = 60;
                game.player.moveY(SpeedY / 12);
                moveY(SpeedY / 12);
                Child.moveY(-SpeedY / 12);
                MarioOnLift = false;
            } else
            if(!MarioOnLift)
            {
                if(SpeedY > 0)
                    SpeedY--;
                Child.moveY(-SpeedY / 12);
                moveY(SpeedY / 12);
            }
        }
        SpriteBlackBoxes.setY(getY());
        super.update(elapsedTime);
    }

    
    public boolean OnLift()
    {
        return MarioOnLift;
    }

    
    public void render(Graphics2D g)
    {
        g.drawImage(chain, (int)getScreenX() + 32, 96, 32, (int)SpriteBlackBoxes.getScreenY() - 96, null);
        super.render(g);
    }

    
    public void MarioIsOnLift()
    {
        MarioOnLift = true;
    }

    public void Break()
    {
        game.AnimationGroup.add(new DirectFalling(getX(), getY(), getImage()));
        game.AnimationGroup.add(new DirectFalling(Child.getX(), Child.getY(), Child.getImage()));
        if((int)SpriteBlackBoxes.getScreenY() - 96 > 32)
            game.BackGroundSpriteGroup.add(new Sprite(ImageUtil.resize(game.bsLoader.getStoredImages("Chain")[0], 32, (int)SpriteBlackBoxes.getScreenY() - 96), getX() + 32D, 96D));
        setActive(false);
        Child.setActive(false);
    }

    private void AddChain()
    {
        BufferedImage Chain = ImageUtil.resize(game.bsLoader.getStoredImages("Chain")[0], 32, 480);
        game.BackGroundSpriteGroup.add(new Sprite(Chain, getX() + 32D, 96D));
    }

    private void AddBlackBoxes()
    {
        BufferedImage BlackBoxes = ImageUtil.createImage(32, 480, 3);
        SpriteBlackBoxes = new Sprite(BlackBoxes, getX() + 32D, getY());
        game.BackGroundSpriteGroup.add(SpriteBlackBoxes);
    }

    private void AddHooksAndChain(int Distance)
    {
        int realdis = Distance + 1;
        BufferedImage HooksAndChainimage = ImageUtil.createImage(32 * realdis, 32, 3);
        Graphics2D g = (Graphics2D)HooksAndChainimage.getGraphics();
        for(int i = 0; i <= realdis; i++)
        {
            if(i == 0)
            {
                g.drawImage(game.bsLoader.getStoredImages("Chain")[1], null, i * 32, 0);
                continue;
            }
            if(i == realdis - 1)
                g.drawImage(game.bsLoader.getStoredImages("Chain")[3], null, i * 32, 0);
            else
                g.drawImage(game.bsLoader.getStoredImages("Chain")[2], null, i * 32, 0);
        }

        g.dispose();
        Sprite HooksAndChain = new Sprite(HooksAndChainimage, getX() + 32D, 64D);
        game.BackGroundSpriteGroup.add(HooksAndChain);
    }

    boolean MarioOnLift;
    Mario game;
    BalenceLiftChild Child;
    int MaxY;
    int MinY;
    int SpeedY;
    boolean Break;
    Sprite SpriteBlackBoxes;
    BufferedImage chain;
}
