// Source File Name:   Player.java
package Objects;

import Animations.*;
import Levels.BasicLevel;
import SandBox.Mario;
import com.golden.gamedev.GameEngine;
import com.golden.gamedev.engine.BaseAudio;
import com.golden.gamedev.engine.BaseLoader;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.util.Utility;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

// Referenced classes of package Objects:
//            FireBall
public class Player extends AnimatedSprite {
    public boolean KeyPressedUP;
    public boolean doubleJump = true;

    public Player( int x , int y , BufferedImage Player_Image[] , Mario g ) {
        Water                = false;
        swimmDelay           = 4;
        delay                = 500;
        Fps                  = 2;
        BigBlackMario        = new BufferedImage[ 12 ];
        FirePlayer           = new BufferedImage[ 12 ];
        BigGreenMario        = new BufferedImage[ 12 ];
        BigRedMario          = new BufferedImage[ 12 ];
        SmallBlackMario      = new BufferedImage[ 12 ];
        player2              = new BufferedImage[ 12 ];
        SmallGreenMario      = new BufferedImage[ 12 ];
        SmallRedMario        = new BufferedImage[ 12 ];
        currentFrame         = 1;
        type                 = 1;
        Frame                = 1;
        something            = 1;
        speed                = 0;
        breaks               = true;
        OnGround             = true;
        OnLift               = false;
        Gravity              = 0.0F;
        turbo                = false;
        LeftActivated        = false;
        RightActivated       = true;
        skating              = false;
        invincible           = 0;
        blink                = true;
        Life                 = 0;
        ControlleByKeyboard  = true;
        AutomaticMoveForward = false;
        KeyPressedDown       = false;
        setLocation( x , y );
        setImages( Player_Image );
        setAnimate( false );
        game = g;
        setID( game.parent.MarioStatus );
        SetStatus( game.parent.MarioStatus );
        BigBlackMario   = game.bsLoader.getStoredImages( "BigBlackMario" );
        FirePlayer      = game.bsLoader.getStoredImages( "FirePlayer" );
        BigGreenMario   = game.bsLoader.getStoredImages( "BigGreenMario" );
        BigRedMario     = game.bsLoader.getStoredImages( "BigRedMario" );
        SmallBlackMario = game.bsLoader.getStoredImages( "SmallBlackMario" );
        player2         = game.bsLoader.getStoredImages( "player" );
        SmallGreenMario = game.bsLoader.getStoredImages( "SmallGreenMario" );
        SmallRedMario   = game.bsLoader.getStoredImages( "SmallRedMario" );
    }


    public void update( long l ) {
        if ( Water ) {
            AddBubbles( );
            if ( ! OnGround ) {
                swimmDelay--;
                if ( swimmDelay < 0 ) {
                    Swim( );
                    WaterJump( );
                    swimmDelay = 2;
                }
            }
            if ( getY( ) < 32D ) {
                Gravity = 2.0F;
            }

            // to make mario not go outside of water
            if ( this.getY( ) < 64 ) {
                this.setY( 64 );
            }

        }
        if ( invincible > 0 ) {
            invincible--;
        }
        AutomaticGoRight( );
        moveX( (float) speed / 10F );
        Gravity( );
        moveY( Gravity );
        if ( ! Water ) {
            if ( breaks ) {
                if ( speed < 0 ) {
                    speed = speed + 1;
                } else if ( speed > 0 ) {
                    speed = speed - 1;
                }
            }
        } else if ( ! ( Water & ( ! OnGround ) ) && ( OnGround && breaks ) ) {
            if ( speed < 0 ) {
                speed = speed + 1;
            } else if ( speed > 0 ) {
                speed = speed - 1;
            }
        }
        something = something + speed;
        if ( OnGround ) {
            doubleJump = true;
            if ( something > 80 ) {
                something = 0;
                AdvanceFrame( );
            }
            if ( something < - 80 ) {
                something = 0;
                DeAdvanceFrame( );
            }
        }
        if ( speed == 0 ) {
            if ( LeftActivated && OnGround ) {
                setFrame( 1 );
            } else if ( RightActivated && OnGround ) {
                setFrame( 0 );
            }
        }
        if ( KeyPressedDown ) {
            if ( LeftActivated ) {
                setFrame( 25 );
            } else if ( RightActivated ) {
                setFrame( 24 );
            }
        }
        if ( getFrame( ) == 11 || getFrame( ) == 7 ) {
            AddDust( );
        }
        OnGround = false;
        breaks   = true;
        if ( ShowThumbs > 0 ) {
            ShowThumbs--;
            if ( ShowThumbs > 100 ) {
                setFrame( 26 );
            } else if ( ShowThumbs > 0 ) {
                setFrame( 27 );
            }
        }
        if ( Dustdelay > - 1 ) {
            Dustdelay--;
        }
        super.update( l );
    }

    private void nextFrame( ) {
        if ( currentFrame == 1 ) {
            currentFrame = 2;
        } else if ( currentFrame == 2 ) {
            currentFrame = 3;
        } else if ( currentFrame == 3 ) {
            currentFrame = 4;
        } else if ( currentFrame == 4 ) {
            currentFrame = 1;
        }
    }


    public void render( Graphics2D g ) {
        if ( invincible > 0 ) {
            if ( blink ) {
                super.render( g );
            }
            if ( blink ) {
                blink = false;
            } else {
                blink = true;
            }
        } else {
            super.render( g );
        }
        if ( Star ) {
            Fps--;
            if ( Fps < 0 ) {
                nextFrame( );
                if ( ( delay > 200 ) & ( delay < 510 ) ) {
                    Fps = 1;
                } else if ( ( delay > 100 ) & ( delay < 200 ) ) {
                    Fps = 3;
                } else if ( ( delay > - 10 ) & ( delay < 100 ) ) {
                    Fps = 5;
                }
            }
            delay--;
            if ( delay < 0 ) {
                game.player.HasStar( false );
                game.bsMusic.stopAll( );
                game.playMusic( "music/" + game.CurrentLevel.attribute + ".mp3" );
            }
            if ( getID( ) == 1 ) {
                if ( currentFrame == 1 ) {
                    g.drawImage( SmallBlackMario[ game.player.getFrame( ) ] , null , (int) getScreenX( ) , (int) getScreenY( ) );
                } else if ( currentFrame == 2 ) {
                    g.drawImage( player2[ game.player.getFrame( ) ] , null , (int) getScreenX( ) , (int) getScreenY( ) );
                } else if ( currentFrame != 3 && currentFrame == 4 ) {
                    g.drawImage( SmallRedMario[ game.player.getFrame( ) ] , null , (int) getScreenX( ) , (int) getScreenY( ) );
                }
            } else if ( currentFrame == 1 ) {
                g.drawImage( BigBlackMario[ game.player.getFrame( ) ] , null , (int) getScreenX( ) , (int) getScreenY( ) );
            } else if ( currentFrame == 2 ) {
                g.drawImage( FirePlayer[ game.player.getFrame( ) ] , null , (int) getScreenX( ) , (int) getScreenY( ) );
            } else if ( currentFrame == 3 ) {
                g.drawImage( BigGreenMario[ game.player.getFrame( ) ] , null , (int) getScreenX( ) , (int) getScreenY( ) );
            } else if ( currentFrame == 4 ) {
                g.drawImage( BigRedMario[ game.player.getFrame( ) ] , null , (int) getScreenX( ) , (int) getScreenY( ) );
            }
        }
    }

    public void GoToLeft( ) {
        go( - 1 );
    }

    public void GoToRight( ) {
        go( 1 );
    }

    public void go( double mul ) {
        if ( ControlleByKeyboard ) {
            RightActivated = mul > 0;
            LeftActivated  = mul < 0;
            if ( speed < 0 && RightActivated ) {
                if ( OnGround ) {
                    setFrame( 7 );
                    skating = true;
                }
            } else if ( speed > 0 && LeftActivated ) {
                if ( OnGround ) {
                    setFrame( 11 );
                    skating = true;
                }
            } else if ( OnGround ) {
                skating = false;
            }
            if ( turbo ) {
                if ( speed > ( 80 + ( getID( ) - 1 ) * 25 ) ) {
                    AddDust( );
                    speed = ( 80 + ( getID( ) - 1 ) * 25 );
                } else if(speed < -80 + -(( getID( ) - 1 ) * 25 )) {
                    AddDust( );
                    speed = -80 + -(( getID( ) - 1 ) * 25 );
                } else {
                    speed += ( 2 + speed / 60 ) * mul;
                }
            } else if ( speed > 50 ) {
                speed = 50;
            } else if ( speed < - 50 ) {
                speed = - 50;
            } else {
                speed += ( 2 + speed / 75 ) * mul;
            }
            breaks = false;
        }
    }

    public void Down( ) {
        KeyPressedDown = true;
        if ( getID( ) != 1 && ! turbo ) {
            setFrame( 24 );
        }
        speed/=2;
        if ( isFalling( ) ) {
            Gravity += 1;
        }
    }

    public void Up( ) {
        KeyPressedUP = true;
        Jump( );
    }

    public void Jump( ) {
        if ( ControlleByKeyboard ) {
            if ( Water ) {
                Gravity = - 7F;
            } else {
                if ( OnGround || doubleJump ) {
                    Gravity = - 14 + speed / 20;
                    if ( getID( ) == 1 ) {
                        game.playSound( "music/smb_jump-small.mp3" );
                    } else {
                        game.playSound( "music/smb_jump-super.mp3" );
                    }
                    if ( KeyPressedDown ) {
                        Gravity += 5;
                    }
                    if ( ! OnGround ) {
                        doubleJump = false;
                    }
                }
                if ( LeftActivated && ! OnGround ) {
                    setFrame( 3 );
                } else if ( RightActivated && ! OnGround ) {
                    setFrame( 2 );
                }
            }
        }
    }

    public void OnGround( ) {
        OnGround = true;
        Gravity  = 0.0F;
    }

    public void StopSpeed( ) {
        speed = 0;
    }

    private void Gravity( ) {
        if ( Water ) {
            if ( Gravity < 7F ) {
                Gravity += 0.5F;
            }
        } else if ( Gravity < 10F ) {
            Gravity += 0.7F;
        }
    }

    public boolean ComingDown( ) {
        return Gravity >= 0.0F;
    }

    public void Jump( int i ) {
        Gravity = i;
        game.playSound( "music/smb_stomp.mp3" );
    }

    public void GoDown( ) {
        Gravity = 0.0F;
    }

    public boolean isFalling( ) {
        return Gravity >= 0.0F;
    }

    public void Speed( boolean b ) {
        if ( ControlleByKeyboard ) {
            turbo = b;
        }
    }

    private void AdvanceFrame( ) {
        if ( Frame == 4 ) {
            Frame = 5;
        } else if ( Frame == 5 ) {
            Frame = 6;
        } else if ( Frame == 6 ) {
            Frame = 4;
        } else {
            Frame = 4;
        }
        if ( ! skating ) {
            setFrame( Frame );
        }
    }

    private void DeAdvanceFrame( ) {
        if ( Frame == 8 ) {
            Frame = 9;
        } else if ( Frame == 9 ) {
            Frame = 10;
        } else if ( Frame == 10 ) {
            Frame = 8;
        } else {
            Frame = 8;
        }
        if ( ! skating ) {
            setFrame( Frame );
        }
    }

    public void Grow( ) {
        if(getID() != 3) {
            game.playSound( "music/smb_powerup.mp3" );
            game.pauseEnemys( );
            if ( getID( ) == 1 ) {
                setY( getY( ) - 32D );
                game.AnimationGroup.add( new SmallToBigMarioAnim( getX( ) , getY( ) , game.bsLoader.getStoredImages( "SmallToBigMarioAnim" ) , game , RightActivated ) );
            } else if ( getID( ) == 2 ) {
                game.AnimationGroup.add( new BigToFireMarioAnim( getX( ) , getY( ) , game ) );
            }
            setID(getID()+1);
            game.parent.MarioStatus=getID();
        }
    }

    public void Decerease( ) {
        if ( invincible <= 0 ) {
            setID( getID()-1 );
            game.parent.MarioStatus=getID();
            game.pauseEnemys( );
            if ( getID( ) == 0 ) {
                game.Restart( );
            } else {
                game.AnimationGroup.add( new BigToSmallMarioAnim( getX( ) , getY( ) , game.bsLoader.getStoredImages( "BigToSmallMarioAnim" ) , game , RightActivated ) );
                invincible = 50;
                game.playSound( "music/smb_pipe.mp3" );
            }
        }
    }

    public boolean isInvincible( ) {
        return invincible > 0;
    }

    public void setInvincible( ) {
        invincible = 50;
    }

    public void Fire( ) {
        game.FireBall.removeImmutableSprites( );
        if ( getID( ) == 3 && game.FireBall.getSize( ) < 2 ) {
            game.FireBall.add( new FireBall( getX( ) , getY( ) , RightActivated , game.bsLoader.getStoredImages( "FireBall" ) , game ) );
            game.playSound( "music/smb_fireball.mp3" );
        }
    }

    public boolean HasStar( ) {
        return Star;
    }

    void IncreaseLife( ) {
    }

    private void AutomaticGoRight( ) {
        if ( AutomaticMoveForward ) {
            if ( speed < 0 ) {
                setFrame( 7 );
                skating = true;
            } else {
                skating = false;
            }
            RightActivated = true;
            LeftActivated  = false;
            if ( speed > 40 ) {
                speed = 40;
            } else {
                speed += 4;
            }
            breaks = false;
        }
    }

    public void NoControlling( ) {
        ControlleByKeyboard = false;
        speed               = 0;
        Gravity             = 0.0F;
    }


    public void MoveForward( ) {
        AutomaticMoveForward = true;
    }

    public void StopMoveForward( ) {
        AutomaticMoveForward = false;
        speed                = 0;
        Gravity              = 0.0F;
    }

    public boolean KeyPressedDown( ) {
        return KeyPressedDown;
    }

    public void ResetStatus( ) {
        invincible           = 200;
        Frame                = 1;
        something            = 1;
        speed                = 0;
        breaks               = true;
        OnGround             = true;
        Gravity              = 0.0F;
        turbo                = false;
        LeftActivated        = false;
        RightActivated       = true;
        skating              = false;
        blink                = true;
        Star                 = false;
        Life                 = 0;
        ControlleByKeyboard  = true;
        AutomaticMoveForward = false;
        KeyPressedDown       = false;
        game.getPlayer( ).setImages( game.bsLoader.getStoredImages( "player" ) );
        setID( 1 );
        game.parent.MarioStatus = 1;
    }

    public void SetStatus( int MarioStatus ) {
        if ( MarioStatus == 1 ) {
            setID( MarioStatus );
            setY( getY( ) - 32D );
        } else if ( MarioStatus == 2 ) {
            setID( MarioStatus );
            setImages( game.bsLoader.getStoredImages( "BigPlayer" ) );
        } else if ( MarioStatus == 3 ) {
            setID( MarioStatus );
            setImages( game.bsLoader.getStoredImages( "FirePlayer" ) );
        }
    }

    public void STAR( ) {
        Star  = true;
        delay = 500;
        game.bsMusic.stopAll( );
        game.bsMusic.play( "music/Star.mp3" );
        game.playSound( "music/smb_powerup.mp3" );
    }

    public void HasStar( boolean b ) {
        Star = false;
    }

    private void Swim( ) {
        if ( isFalling( ) ) {
            if ( LeftActivated ) {
                if ( getFrame( ) == 18 ) {
                    setFrame( 19 );
                } else if ( getFrame( ) == 19 ) {
                    setFrame( 18 );
                } else {
                    setFrame( 18 );
                }
            } else if ( RightActivated ) {
                if ( getFrame( ) == 16 ) {
                    setFrame( 17 );
                } else if ( getFrame( ) == 17 ) {
                    setFrame( 16 );
                } else {
                    setFrame( 16 );
                }
            }
        }
    }

    private void WaterJump( ) {
        if ( ( ! isFalling( ) ) & ( ! OnGround ) ) {
            if ( LeftActivated ) {
                if ( getFrame( ) == 22 ) {
                    setFrame( 23 );
                } else if ( getFrame( ) == 23 ) {
                    setFrame( 22 );
                } else {
                    setFrame( 22 );
                }
            } else if ( RightActivated ) {
                if ( getFrame( ) == 20 ) {
                    setFrame( 21 );
                } else if ( getFrame( ) == 21 ) {
                    setFrame( 20 );
                } else {
                    setFrame( 20 );
                }
            }
        }
    }

    private void AddBubbles( ) {
        BubbleDelay--;
        if ( BubbleDelay < 0 ) {
            game.BackGroundSpriteGroup.add( new Bubble( (int) getX( ) , (int) getY( ) , game ) );
            BubbleDelay = Utility.getRandom( 1 , 2 ) * 30;
        }
    }

    public void ShowThumbs( ) {
        ShowThumbs = 150;
    }

    private void AddDust( ) {
        if ( OnGround && Dustdelay < 0 ) {
            Dustdelay = 3;
            Random r  = new Random( );
            int    Up = Utility.getRandom( 0 , 1 ) * 4;
            if ( getID( ) == 1 ) {
                game.AnimationGroup.add( new Dust( getX( ) , getY( ) + 16D + (double) Up , game.bsLoader.getStoredImages( "Dust" ) ) );
            } else {
                game.AnimationGroup.add( new Dust( getX( ) , getY( ) + 48D + (double) Up , game.bsLoader.getStoredImages( "Dust" ) ) );
            }
        }
    }


    public boolean Water;
    int           swimmDelay;
    int           delay;
    int           Fps;
    BufferedImage BigBlackMario[];
    BufferedImage FirePlayer[];
    BufferedImage BigGreenMario[];
    BufferedImage BigRedMario[];
    private BufferedImage SmallBlackMario[];
    private BufferedImage player2[];
    private BufferedImage SmallGreenMario[];
    private BufferedImage SmallRedMario[];
    private int           currentFrame;
    int type;
    int Frame;
    int something;
    public int speed;
    boolean breaks;
    public boolean OnGround;
    public boolean OnLift;
    float   Gravity;
    boolean turbo;
    private boolean LeftActivated;
    private boolean RightActivated;
    private boolean skating;
    Mario   game;
    int     invincible;
    boolean blink;
    private int     Life;
    private boolean ControlleByKeyboard;
    private boolean AutomaticMoveForward;
    private boolean Star;
    public  boolean KeyPressedDown;
    private int     BubbleDelay;
    private int     ShowThumbs;
    private int     Dustdelay;
}
