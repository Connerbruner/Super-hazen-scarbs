
package Lifts;

import SandBox.Mario;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Timer;

public class LiftCar extends AnimatedSprite implements BasicLift{

    boolean MarioOnLift = false ;

    Mario game ;
    
    boolean isTouched = false ;

//    public LiftCar( int x, int y, Mario g) {
//        game = g ;
////        this.setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), 6 ));
//setImages(game.bsLoader.getStoredImages("LiftClowd"));
//        this.setLocation(x, y);
//        
//        setAnimate(true);
//        setAnimationTimer(new Timer(150));
//        setLoopAnim(true);
//    }
    
    public LiftCar( int x, int y, Mario g , int Points) {
        game = g ;
        
//        this.setImage(ImageUtil.TileImage(game.bsLoader.getStoredImage("Lift"), Points ));
        setImages(game.bsLoader.getStoredImages("LiftClowd"));

         setAnimate(true);
        setAnimationTimer(new Timer(160));
        setLoopAnim(true);
        
        this.setLocation(x+24, y);
    }
    

   
    
    public void update(long elapsedTime) {
                
//        // System.out.println("this.getOldX() ="+this.getOldX() +" , x = "+this.getX());

        if(this.getX()>(32*100)){
            this.setActive(false);
        }
        if(MarioOnLift){
            isTouched = true ;
            
//            this.moveX(1);
            game.player.moveX(2);
//            game.player.moveX(this.getOldX() - this.getX() );
            MarioOnLift = false ;
        }
        
        if(isTouched){
            this.moveX(2);
        }
//        this.moveX(1);
//        
//        if(this.getX() > 400){
//            this.setX(100);
//        }
//        
//        if(MarioOnLift){
//            game.player.moveX(1);
//            MarioOnLift = false ;
//        }
        super.update(elapsedTime);
    }
    
    public boolean OnLift() {
        return MarioOnLift ;
    }
    
    
    public void MarioIsOnLift() {
        MarioOnLift  = true;
    }

    
}