


// Source File Name:   PrincessAnim.java

package Animations;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import com.golden.gamedev.object.sprite.AdvanceSprite;
import java.awt.image.BufferedImage;

// Referenced classes of package Animations:
//            Kiss

public class PrincessAnim extends AdvanceSprite
{

    public PrincessAnim(int x, int y, BufferedImage storedImages[], Mario M)
    {
        GotToLeft = false;
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(250));
        setAnimationFrame(anim);
        game = M;
    }

    public void Play()
    {
        setAnimate(true);
        GotToLeft = true;
    }

    
    public void update(long l)
    {
        if(getFrame() == getFinishAnimationFrame())
        {
            game.AnimationGroup.add(new Kiss((int)getX() - 100, (int)getY() - 100, game));
            game.player.setActive(false);
            setActive(false);
        }
        if(getX() < game.player.getX() + 32D)
            GotToLeft = false;
        if(GotToLeft && !((anim[getFrame()] == 0) | (anim[getFrame()] == 1) | (anim[getFrame()] == 4)))
            moveX(-1D);
        super.update(l);
    }

    Mario game;
    int anim[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 1, 1, 1, 2, 3, 
        2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 
        4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 
        4, 4
    };
    boolean GotToLeft;
}
