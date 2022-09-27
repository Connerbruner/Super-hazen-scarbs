


// Source File Name:   SoundPlayer.java

package Utility;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.sound.sampled.*;

public class SoundPlayer
    implements LineListener
{

    public SoundPlayer()
    {
        myClips = new Hashtable();
    }

    public void play(String fileName)
    {
        Clip clip = getClip(fileName);
        if(clip != null)
            clip.start();
    }

    public void playAndWait(String fileName)
    {
        Clip clip = getClip(fileName);
        if(clip != null)
        {
            clip.start();
            try
            {
                synchronized(clip)
                {
                    clip.wait();
                }
            }
            catch(InterruptedException ie) { }
        }
    }

    public void loop(String fileName)
    {
        loop(fileName, -1);
    }

    public void loop(String fileName, int numTimes)
    {
        Clip clip = getClip(fileName);
        if(clip != null)
            clip.loop(numTimes);
    }

    public void loopAndWait(String fileName)
    {
        loopAndWait(fileName, -1);
    }

    public void loopAndWait(String fileName, int numTimes)
    {
        Clip clip = getClip(fileName);
        if(clip != null)
        {
            clip.loop(numTimes);
            try
            {
                clip.wait();
            }
            catch(InterruptedException ie) { }
        }
    }

    public void pause(String fileName)
    {
        Clip clip = getClip(fileName);
        if(clip != null)
        {
            int pos = clip.getFramePosition();
            clip.stop();
            clip.setFramePosition(pos);
        }
    }

    public void stop(String fileName)
    {
        Clip clip = getClip(fileName);
        stopClip(clip);
    }

    public void stopAll()
    {
        Clip clip;
        for(Enumeration clips = myClips.elements(); clips.hasMoreElements(); stopClip(clip))
            clip = (Clip)clips.nextElement();

    }

    public void preLoad(String fileName)
    {
        getClip(fileName);
    }

    public boolean contains(String fileName)
    {
        return myClips.containsKey(fileName);
    }

    public void clear()
    {
        myClips.clear();
    }

    
    public void update(LineEvent le)
    {
        if(le.getType() == javax.sound.sampled.LineEvent.Type.STOP)
            stopClip((Clip)le.getSource());
    }

    private Clip getClip(String fileName)
    {
        Clip clip = null;
        javax.sound.sampled.AudioInputStream ais = null;
        if(myClips.containsKey(fileName))
            clip = (Clip)myClips.get(fileName);
        else
            try
            {
                ais = AudioSystem.getAudioInputStream((SandBox.Mario.class).getResource(fileName));
                clip = (Clip)AudioSystem.getLine(new javax.sound.sampled.Line.Info(javax.sound.sampled.Clip.class));
                clip.open(ais);
                clip.addLineListener(this);
                myClips.put(fileName, clip);
            }
            catch(UnsupportedAudioFileException uafe)
            {
                throw new RuntimeException("Not a valid supported audio file: \"" + fileName + "\"");
            }
            catch(LineUnavailableException lue)
            {
                throw new RuntimeException("Line is not available to play sound \"" + fileName + "\"");
            }
            catch(IOException ioe)
            {
                throw new RuntimeException("I/O error while reading file: \"" + fileName + "\"");
            }
        return clip;
    }

    private void stopClip(Clip clip)
    {
        if(clip != null)
        {
            clip.stop();
            clip.setFramePosition(0);
            synchronized(clip)
            {
                clip.notifyAll();
            }
        }
    }

    private Hashtable myClips;
}
