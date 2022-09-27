


// Source File Name:   CoinAnim.java

package Animations;

import SandBox.Mario;
import com.golden.gamedev.GameEngine;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;
import java.awt.image.BufferedImage;

public class CoinAnim extends AnimatedSprite
{

    public CoinAnim(int x, int y, BufferedImage storedImages[], Mario M)
    {
        Gravity = -15;
        setLocation(x, y);
        setImages(storedImages);
        setAnimationTimer(new Timer(100));
        setAnimate(true);
        game = M;
        game.parent.CoinInc();
        game.playSound("music/smb_coin.mp3");
    }

    
    public void update(long l)
    {
        if(Gravity <= 0)
        {
            Gravity = Gravity + 1;
            moveY(Gravity);
        } else
        if(getFrame() == getFinishAnimationFrame())
            setActive(false);
        super.update(l);
    }

    int Gravity;
    Mario game;
}
