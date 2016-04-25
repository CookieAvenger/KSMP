package AppPackage;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import javax.swing.*;
import java.beans.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;
import static org.imgscalr.Scalr.OP_ANTIALIAS;

public final class RealInfo extends JComponent implements PropertyChangeListener
{
    File filepicked = null;
    String Specs = null;
    ImageIcon icon = null;
    String Track,Title,Album,Artist,Year,Time,Bitrate,SampleRate,Art,Inv = "";
    
    Mp3File mp3file2;
    
    Timer tout;
    
        public RealInfo (JFileChooser fp) 
        {
        setPreferredSize(new Dimension(350, 400));
        
        tout = new Timer(2, (ActionEvent ae) -> {
            loadInfo();
            repaint();
            tout.stop();
        });
        
        fp.addPropertyChangeListener(this);
        }
    
    
    
    public void loadInfo() {
        if (filepicked == null)
        {
            Specs = "Select an MP3 File to preview";
        }
        else if (filepicked.getName().toLowerCase().endsWith(".mp3"))
        {
        try 
        {
            mp3file2 = new Mp3File(filepicked.getPath());
            
            long time = mp3file2.getLengthInSeconds();
            long min = time/60;
            long sec = time%60;
            String s = Objects.toString(sec, null);
            if (sec < 10)
            {
                s = "0"+s;
            }
            Specs = "Song Specifications:";
            Time = "    Time: " + min+":"+s;
            Bitrate = "    Bitrate: " + mp3file2.getBitrate() + " kbps " + (mp3file2.isVbr() ? "(VBR)" : "(CBR)");
            SampleRate ="    Sample Rate: " + mp3file2.getSampleRate() + " Hz";
            
            if (mp3file2.hasId3v2Tag()) 
            {
            ID3v2 id3v2Tag2 = mp3file2.getId3v2Tag();
            
            String CheckTrack = id3v2Tag2.getTrack();
            String CheckTitle = id3v2Tag2.getTitle();
            String CheckAlbum = id3v2Tag2.getAlbum();
            String CheckArtist = id3v2Tag2.getArtist();
            String CheckYear = id3v2Tag2.getYear();
            
            if (CheckTrack == null)
            {
                CheckTrack = "Unknown";
            }
            if (CheckTitle == null)
            {
                CheckTitle = "Unknown";
            }
            if (CheckAlbum == null)
            {
                CheckAlbum = "Unknown";
            }
            if (CheckArtist == null)
            {
                CheckArtist = "Unknown";
            }
            if (CheckYear == null)
            {
                CheckYear = "Unknown";
            }
            
            Inv ="Track Info:";
            Track = "    Track: " + CheckTrack;
            Title = "    Title: " + CheckTitle;
            Album = "    Album: " + CheckAlbum;
            Artist ="    Artist: " + CheckArtist;
            Year =  "    Year: "+ CheckYear;
            
            byte[] imageData = id3v2Tag2.getAlbumImage();
                if (imageData != null)
                {
                    Art = "Album Art:";
                    BufferedImage thumb = null;
                try 
                {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                    if (img.getHeight() == img.getWidth())
                    {
                         thumb = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT,200, 200, OP_ANTIALIAS);
                    }
                    else if (img.getHeight() > img.getWidth())
                    {
                        thumb = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,200, 200, OP_ANTIALIAS);
                    }
                    else if (img.getHeight() < img.getWidth())
                    {
                        thumb = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH,200, 200, OP_ANTIALIAS);
                    }
                }
                catch (IOException ex) 
                {

                }
                    icon = new ImageIcon(thumb);
                }
                else
                {
                try 
                {
                    BufferedImage imgf = ImageIO.read(getClass().getResource("/AppPackage/Standard Art.png"));
                    BufferedImage thumb = Scalr.resize(imgf, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT,200, 200, OP_ANTIALIAS);
                    icon = new ImageIcon(thumb);
                }
                catch (IOException ex) 
                {

                }   
                    Art = "No Art";
                }
                }
                else if (mp3file2.hasId3v1Tag())
                {
                    icon = null;
            
                    ID3v1 id3v1Tag2 = mp3file2.getId3v1Tag();
            
                    String CheckTrack = id3v1Tag2.getTrack();
                    String CheckTitle = id3v1Tag2.getTitle();
                    String CheckAlbum = id3v1Tag2.getAlbum();
                    String CheckArtist = id3v1Tag2.getArtist();
                    String CheckYear = id3v1Tag2.getYear();
            
                if ("".equals(CheckTrack))
                {
                    CheckTrack = "Unknown";
                }
                if ("".equals(CheckTitle))
                {
                    CheckTitle = "Unknown";
                }
                if ("".equals(CheckAlbum))
                {
                    CheckAlbum = "Unknown";
                }
                if ("".equals(CheckArtist))
                {
                    CheckArtist = "Unknown";
                }
                if ("".equals(CheckYear))
                {
                    CheckYear = "Unknown";
                }
                        
                Inv ="Track Info:";
                Track = "    Track: " + CheckTrack;
                Title = "    Title: " + CheckTitle;
                Album = "    Album: " + CheckAlbum;
                Artist ="    Artist: " + CheckArtist;
                Year =  "    Year: "+ CheckYear;
                }
        else 
        {
            Inv = "No Tags Set";
        }
            
        } 
        catch (IOException | UnsupportedTagException | InvalidDataException ex) 
        {
            
        }
        }
        else
        {
            Specs = "Select an MP3 File to preview";
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        boolean update = false;
        String prop = e.getPropertyName();

        if (null != prop) switch (prop) 
        {
            case JFileChooser.DIRECTORY_CHANGED_PROPERTY:
                tout.stop();
                filepicked = null;
                update = true;
                break;
            case JFileChooser.SELECTED_FILE_CHANGED_PROPERTY:
                tout.stop();
                filepicked = (File) e.getNewValue();
                update = true;
                break;
        }
        if (update) 
        {
            Specs = null;
            Track = Title = Album = Artist = Year = Time = Bitrate = Art = SampleRate = Inv = "";
            icon = null;
            if (isShowing()) 
            {
                tout.start();
            }
        }
    }
        
        @Override
        protected void paintComponent(Graphics g) 
        {
        if (Specs != null) 
        {
            super.paintComponent(g);
            Font font = new Font("Source Sans Pro",Font.PLAIN,15);
            g.setFont(font);
            g.drawString(Specs, 5, 15);
            g.drawString(Time, 5, 30);
            g.drawString(Bitrate, 5, 45);
            g.drawString(SampleRate, 5, 60);
            g.drawString(Inv, 5, 85);
            g.drawString(Track, 5, 100);
            g.drawString(Title, 5, 115);
            g.drawString(Album, 5, 130);
            g.drawString(Artist, 5, 145);
            g.drawString(Year, 5, 160);
            g.drawString(Art, 5, 175);
            if (icon!=null)
                    {
                        icon.paintIcon(this, g, 35, 180);
                    }
        }
        }   
}
