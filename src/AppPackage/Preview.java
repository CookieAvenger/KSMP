package AppPackage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import org.imgscalr.Scalr;
import static org.imgscalr.Scalr.OP_ANTIALIAS;

public final class Preview extends JComponent implements PropertyChangeListener {
    ImageIcon thumbnail2 = null;
    File file3 = null;
    String Dim = null;
    
    Timer tout2;
    
    public Preview(JFileChooser fp1) 
    {
        setPreferredSize(new Dimension(300, 320));
        
        tout2 = new Timer(100, (ActionEvent ae) -> {
            loadImage();
            repaint();
            tout2.stop();
        });
        
        fp1.addPropertyChangeListener(this);
    }

    public void loadImage() 
    {
        if (file3 == null) 
        {
            thumbnail2 = null;
        }
        else if (file3.getName().toLowerCase().endsWith(".jpg")||file3.getName().toLowerCase().endsWith(".jpeg"))
        {
        try 
        {
            BufferedImage tmp = ImageIO.read(new File (file3.getPath()));
            if (tmp != null) 
            {
            int ChoHeight = tmp.getHeight();
            int ChoWidth = tmp.getWidth();
            if (ChoHeight == ChoWidth)
            {
                thumbnail2 = new ImageIcon(Scalr.resize(tmp, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT,300, 300, OP_ANTIALIAS));
            }
            else if (ChoHeight > ChoWidth)
            {
                thumbnail2 = new ImageIcon(Scalr.resize(tmp, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,300, 300, OP_ANTIALIAS));
            }
            else if (ChoHeight < ChoWidth)
            {
                thumbnail2 = new ImageIcon(Scalr.resize(tmp, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH,300, 300, OP_ANTIALIAS));
            }
            Dim = ("Dimension: "+ChoWidth+" x "+ChoHeight);
            }
        }
        catch (IOException ex) 
        {
            
        }
        }
        else
        {
            thumbnail2 = null;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        boolean update2 = false;
        String prop = e.getPropertyName();

        if (null != prop) 
        switch (prop) 
        {
            case JFileChooser.DIRECTORY_CHANGED_PROPERTY:
                tout2.stop();
                file3 = null;
                update2 = true;
                break;
            case JFileChooser.SELECTED_FILE_CHANGED_PROPERTY:
                tout2.stop();
                file3 = (File) e.getNewValue();
                update2 = true;
                break;
        }
        
        if (update2) 
        {
            thumbnail2 = null;
            if (isShowing()) 
            {
                tout2.start();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (thumbnail2 != null) 
        {
            thumbnail2.paintIcon(this, g, 0, 0);
            Font font = new Font("Source Sans Pro",Font.PLAIN,15);
            g.setFont(font);
            g.drawString(Dim, 5, 315);
        }
    }
}
