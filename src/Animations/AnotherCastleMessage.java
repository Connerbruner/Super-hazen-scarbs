


// Source File Name:   AnotherCastleMessage.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import java.awt.image.BufferedImage;

public class AnotherCastleMessage extends AnimatedSprite
{

    public AnotherCastleMessage(BufferedImage storedImages[], double x, double y, Mario M)
    {
        Gravity = -15;
        delay = 100;
        setLocation(x, y);
        setImages(storedImages);
        game = M;
        game.parent.CoinInc();
        game.playSound("music/smb_coin.mp3");
    }

    
    public void update(long elapsedTime)
    {
        if(delay > 0)
        {
            delay--;
            setFrame(0);
        } else
        {
            setFrame(1);
        }
        super.update(elapsedTime);
    }

    int Gravity;
    Mario game;
    int delay;
}
