


// Source File Name:   FireBallToEnemys.java

package Collusion;

import Animations.Explosion;
import Objects.BasicEnemy;
import SandBox.Mario;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

public class FireBallToEnemys extends BasicCollisionGroup
{

    public FireBallToEnemys(Mario g)
    {
        game = g;
    }

    
    public void collided(Sprite FireBall, Sprite Enemys)
    {
        BasicEnemy e1 = (BasicEnemy)Enemys;
        boolean Kill = false;
        switch(e1.getType())
        {
        case 100: // 'd'
            Kill = true;
            break;

        case 101: // 'e'
            Kill = true;
            break;

        case 102: // 'f'
            Kill = true;
            break;

        case 103: // 'g'
            Kill = true;
            break;

        case 104: // 'h'
            Kill = true;
            break;

        case 105: // 'i'
            e1.OtherEnemyTouchedFromRight();
            break;

        case 106: // 'j'
            e1.CollidedWithShell();
            break;

        case 108: // 'l'
            Kill = true;
            break;

        case 110: // 'n'
            Kill = true;
            break;

        case 111: // 'o'
            Kill = true;
            break;

        case 112: // 'p'
            Kill = true;
            break;

        case 113: // 'q'
            Kill = true;
            break;

        case 115: // 's'
            Kill = true;
            break;

        case 117: // 'u'
            Kill = true;
            break;

        case 118: // 'v'
            Kill = true;
            break;

        case 119: // 'w'
            e1.KilledByFireBall();
            FireBall.setActive(false);
            game.AnimationGroup.add(new Explosion(FireBall.getX(), FireBall.getY(), game.bsLoader.getStoredImages("Explosion")));
            break;
        }
        if(Kill)
        {
            e1.KilledByFireBall();
            FireBall.setActive(false);
            game.playSound("music/smb_kick.mp3");
            Enemys.setActive(false);
            game.AnimationGroup.add(new Explosion(FireBall.getX(), FireBall.getY(), game.bsLoader.getStoredImages("Explosion")));
        }
    }

    Mario game;
}
