package AppPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainClass 
{
    
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    
    public long pauseLocation;
    public long songTotalLength;
    
    public int playbutton = 0;
    
    public String fileLocation;
    
    public void playthread ()
    {
    new Thread()
    {
        @Override
        public void run()
        {
            Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            try
            {
                player.play();
                
                if (player.isComplete() && MP3PlayerGUI.loopSwitch == 1)
                {
                    Play(fileLocation,0);
                }

            }
            catch (JavaLayerException ex)
            {
                    
            }
        }
            
    }.start();
    }
    
    public void Pause()
    {
        if(player != null)
        {
            try 
            {
                pauseLocation = FIS.available();
                player.close();
            } 
            catch (IOException ex) 
            {
                
            }
        }
    }
    public void Start ()
    {
        try
        {
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream (FIS);
            
            player = new Player (BIS);

            songTotalLength = FIS.available();
        }
        catch (FileNotFoundException | JavaLayerException ex)
        {
            
        }
        catch (IOException ex)
        {
            
        }
        playthread();
    }
    
    public void Resume()
    {
        try
        {
            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream (FIS);
            
            player = new Player (BIS);
            
            try 
            {
                FIS.skip (songTotalLength - pauseLocation);
            } 
            catch (IOException ex) 
            {
                
            }
        }
        catch (FileNotFoundException | JavaLayerException ex)
        {
            
        }        
        playthread();
    }
    
    public void Stop()
    {
        if (player != null)
        {
            player.close();
            
            pauseLocation = 0;
            songTotalLength = 0;
        }
    }
    
    public void Play (String Address,int button)
    {
        playbutton = button;
            if (playbutton == 0)
            {
                Stop();
                fileLocation = Address;
                Start();
                playbutton = 1;
            }
            else if (playbutton == 1)
            {
                Pause();
                playbutton = 2;
            }
            else if (playbutton == 2)
            {
                Resume();
                playbutton = 1;
            }
            System.gc();
    }
}
