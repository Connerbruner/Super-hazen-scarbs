// Source File Name:   Player_InvisibleObjects.java
package Collusion;

import Animations.QuestCompleteText;
import Objects.*;
import SandBox.Mario;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

public class Player_InvisibleObjects extends BasicCollisionGroup {

    public Player_InvisibleObjects(Mario aThis) {
        M = aThis;
    }

    
    public void collided(Sprite player, Sprite invisibleSprite) {

        if (invisibleSprite.getDataID() == "StopScrollAndNumber") {
            M.BackGroundSpriteGroup.add(new Sprite(M.bsLoader.getStoredImage("numbers432"), (178 * 32) + 8, (8 * 32)-84));
            M.Scroll(false);
            M.KillAllEnemies();
            // kill all enemies in game 
//            System.out.println("StopScroll");
        }

        // StopScrollAndNumber2 = for clowd level 4-2
        if (invisibleSprite.getDataID() == "StopScrollAndNumber2") {
            M.BackGroundSpriteGroup.add(new Sprite(M.bsLoader.getStoredImage("numbers876"), (50 * 32) + 8, (8 * 32)-64));
            M.Scroll(false);
            M.KillAllEnemies();
//            System.out.println("StopScroll");
        }

        Player p = (Player) player;
        if (invisibleSprite.getDataID() == "StopScroll") {
            M.Scroll(false);
        }
        if (invisibleSprite.getDataID() == "StopScrollandSmoothScroll") {
            M.Scroll(false);
            M.SmoothScroll = false;
        }
        if (invisibleSprite.getDataID() == "scroll") {
            M.SmoothScroll();
        }
        if (invisibleSprite.getDataID() == "Jump") {
            M.player.Jump(-14);
        }
        if (invisibleSprite.getDataID() == "StopMario") {
            M.boss.BadGameGlitch();
            M.KageGroup.add(new QuestCompleteText(M.bsLoader.getStoredImage("QuestCompleteText"), invisibleSprite.getX() - 320D - 224D, 128D));
            p.setX(invisibleSprite.getX() - (double) p.getWidth());
            p.StopSpeed();
            p.NoControlling();
            p.StopMoveForward();
            M.PrincessComeNearMario();
            if (p.getID() == 1) {
                M.EnemyGroup.add(new Mashroom((int) p.getX(), (int) p.getY() - 96, M.bsLoader.getStoredImages("Mashrooms"), M));
            }
        }
        invisibleSprite.setActive(false);
    }
    Mario M;
}
