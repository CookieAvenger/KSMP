package AppPackage;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class DisplayTrayIcon 
{
    
    static TrayIcon trayIcon;
    
    public DisplayTrayIcon()
    {
        ShowTrayIcon();
    }
    
    
    public static void ShowTrayIcon()
    {
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Source Sans Pro", Font.PLAIN, 15)));
        UIManager.put("ToolTip.font", new FontUIResource("Source Sans Pro", Font.PLAIN, 15));
        if (!SystemTray.isSupported())
        {
            JOptionPane.showMessageDialog(null, "Error; your system is not supported. \n"
            +"Press 'OK' to close the program and dispose all running data.");
            System.exit(0);
            return;
        }
              
        final PopupMenu popup = new PopupMenu();
        trayIcon = new TrayIcon (CreateIcon("/AppPackage/Icon.png","Tray Icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        trayIcon.setToolTip("Running "+"\nVersion - 1.0.2");
        
       MenuItem SupportItem = new MenuItem ("Support");
       MenuItem AboutItem = new MenuItem("About");
       MenuItem ExitItem = new MenuItem("Quick Exit");
       
       popup.add(SupportItem);
       popup.add(AboutItem);
       popup.addSeparator();
       popup.add(ExitItem);
       
        trayIcon.setPopupMenu(popup);
        
        SupportItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "For support please contact me at: kshukla@cisb.org.in");
        });
                
        AboutItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Created by Krishna Shukla \n "
                    + "Krishna's Study MP3 Player (KSMP) is an open source, lightweight MP3 player that is still in Aplha development stage. \n "
                    + "It is a simple application with widget like properties designed so it does not clutter your taskbar or drain your CPU. \n "
                    + "The application is created to control distraction from music by keeping a one song playlist, by hiding the player and by keeping reminders on it");
        });

        ExitItem.addActionListener((ActionEvent e) -> {
            Object[] options = {"Yes","No"};
            int quicke = JOptionPane.showOptionDialog(new JFrame(), "Quick Exit will not save any data. \n"
                    +"Would you like to proceed?", "Quick Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (quicke == JOptionPane.YES_OPTION)
            {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
        
        try
        {
            tray.add(trayIcon);
        }
        catch(AWTException e)
        {
            
        }
    }
    
    protected static Image CreateIcon (String path, String desc)
    {
        URL ImageURL = DisplayTrayIcon.class.getResource(path);
        return (new ImageIcon (ImageURL, desc).getImage());
    }
}
