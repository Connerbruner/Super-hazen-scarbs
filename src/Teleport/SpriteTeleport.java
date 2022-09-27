


// Source File Name:   SpriteTeleport.java

package Teleport;

import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.util.ImageUtil;

// Referenced classes of package Teleport:
//            Teleport

public class SpriteTeleport extends Sprite
{

    public SpriteTeleport(Teleport tele, Mario aThis)
    {
        game = aThis;
        teleport = tele;
        setImage(ImageUtil.createImage(32, 96, 3));
        setLocation(teleport.getINx() + 32, teleport.INy);
    }

    public Teleport teleport;
    Mario game;
}
