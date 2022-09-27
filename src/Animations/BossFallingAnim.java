


// Source File Name:   BossFallingAnim.java

package Animations;

import Objects.Player;
import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class BossFallingAnim extends AnimatedSprite
{

    public BossFallingAnim(BufferedImage storedImages[], double x, double y, Mario g)
    {
        super(storedImages, x, y);
        delay = 50;
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        setLoopAnim(true);
        setAnimationFrame(14, 15);
        game = g;
    }

    
    public void update(long l)
    {
        delay--;
        if(delay < 0)
            moveY(4D);
        if(delay == 2)
            game.playSound("music/smb_bowserfalls.mp3");
        super.update(l);
        if(getY() > 700D)
        {
            game.PlayEnemys();
            game.player.MoveForward();
            setActive(false);
            game.removeDemoMario();
        }
    }

    Mario game;
    int delay;
}
