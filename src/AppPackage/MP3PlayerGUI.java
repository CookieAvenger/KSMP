package AppPackage;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalFileChooserUI;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;
import static org.imgscalr.Scalr.OP_ANTIALIAS;
import static org.imgscalr.Scalr.OP_BRIGHTER;
import javax.swing.Timer;

public class MP3PlayerGUI extends javax.swing.JDialog
{
    MainClass MC = new MainClass();
    
    DisplayTrayIcon DTI = new DisplayTrayIcon();

    public int id;
    public static int loopSwitch = 1;

    public String song = null;
    public String name = null;
    String prevLocation;
    
    String txtPath, fulltxtpath, fullsopath = null;
    int FileCount, SFileCount = 0;
    
    Point point = new Point();
    
    int x;
    int y;
    
    int a = 0;
    int f = 0;
   
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
    int taskBarHeight = (scrnSize.height) - (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
    final Rectangle screen = new Rectangle (scrnSize.width - 350, scrnSize.height - taskBarHeight - 364);
        
    Timer timers, timere, timerexi;
    boolean b, c;
    boolean k = false;
    private int higher = 364;
    
    Color Frost = new Color (255,255,255,150);
    
    public MP3PlayerGUI(java.awt.Frame parent, boolean modal) 
    { 
        super(parent, modal);       
        initComponents();
                
        setTheme();

        ReadTxt();
        ReadLP();

        this.setLocation(screen.width, screen.height);
        
        b = true;

        timers = new Timer(2, (ActionEvent ae) -> {
            higher-= 15;
            if (higher > 44) 
            {
                Dimension d = new Dimension (350,higher);
                MP3PlayerGUI.this.setSize(d);
            }
            else if (higher <= 44)
            {
                higher = 44;
                Dimension d = new Dimension (350,higher);
                MP3PlayerGUI.this.setSize(d);
                b = false;
                topinf();
                System.gc();
                timers.stop();
            }
        });
        timere = new Timer(2, (ActionEvent ae) -> {
            higher+= 15;
            if (higher < 364)
            {
                Dimension d = new Dimension (350,higher);
                MP3PlayerGUI.this.setSize(d);
            }
            else if (higher >= 364)
            {
                higher = 364;
                Dimension d = new Dimension (350,higher);
                MP3PlayerGUI.this.setSize(d);
                b = true;
                topinfrem();
                System.gc();
                timere.stop();
            }
        });
        timerexi = new Timer(3000, (ActionEvent ae) -> {
            if (b == true)
            {
                timere.stop();
                timers.start();
            }
        });
        System.gc();
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Notes = new javax.swing.JScrollPane();
        Reminders = new javax.swing.JTextArea();
        Bar = new javax.swing.JLabel();
        Play = new javax.swing.JLabel();
        Back = new javax.swing.JLabel();
        Loop = new javax.swing.JLabel();
        Select = new javax.swing.JLabel();
        Info = new javax.swing.JLabel();
        Close = new javax.swing.JLabel();
        SongInfo = new javax.swing.JLabel();
        AlbumName = new javax.swing.JLabel();
        LOO = new javax.swing.JLabel();
        Look4 = new javax.swing.JLabel();
        AlbumArt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MPL Alpha");
        setIconImage(Toolkit.getDefaultToolkit().getImage(MP3PlayerGUI.class.getResource("/AppPackage/Icon.png")));
        setMinimumSize(new java.awt.Dimension(350, 44));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Notes.setBorder(null);
        Notes.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Notes.setToolTipText("Notes/Reminders");
        Notes.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        Notes.setHorizontalScrollBar(null);
        Notes.setOpaque(false);
        Notes.setPreferredSize(new java.awt.Dimension(290, 290));

        Reminders.setColumns(20);
        Reminders.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        Reminders.setLineWrap(true);
        Reminders.setRows(2);
        Reminders.setToolTipText("Notes/Reminders");
        Reminders.setWrapStyleWord(true);
        Reminders.setBorder(null);
        Reminders.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Reminders.setMargin(new java.awt.Insets(1, 5, 1, 5));
        Reminders.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                RemindersMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                RemindersMouseMoved(evt);
            }
        });
        Reminders.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RemindersFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                RemindersFocusLost(evt);
            }
        });
        Reminders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemindersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RemindersMouseEntered(evt);
            }
        });
        Reminders.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RemindersKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RemindersKeyReleased(evt);
            }
        });
        Notes.setViewportView(Reminders);

        getContentPane().add(Notes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, -1, -1));

        Bar.setForeground(new java.awt.Color(255, 255, 255));
        Bar.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        Bar.setMaximumSize(new java.awt.Dimension(350, 14));
        Bar.setMinimumSize(new java.awt.Dimension(350, 14));
        Bar.setPreferredSize(new java.awt.Dimension(350, 14));
        Bar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarMouseDragged(evt);
            }
        });
        Bar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BarMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BarMouseReleased(evt);
            }
        });
        getContentPane().add(Bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Play.setToolTipText("Play/Pause");
        Play.setMaximumSize(new java.awt.Dimension(30, 30));
        Play.setMinimumSize(new java.awt.Dimension(30, 30));
        Play.setPreferredSize(new java.awt.Dimension(30, 30));
        Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlayMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PlayMouseReleased(evt);
            }
        });
        getContentPane().add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 334, -1, -1));

        Back.setToolTipText("Start Song Again");
        Back.setMaximumSize(new java.awt.Dimension(30, 30));
        Back.setMinimumSize(new java.awt.Dimension(30, 30));
        Back.setPreferredSize(new java.awt.Dimension(30, 30));
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BackMouseReleased(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 334, -1, -1));

        Loop.setToolTipText("Loop");
        Loop.setMaximumSize(new java.awt.Dimension(30, 30));
        Loop.setMinimumSize(new java.awt.Dimension(30, 30));
        Loop.setPreferredSize(new java.awt.Dimension(30, 30));
        Loop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoopMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                LoopMouseReleased(evt);
            }
        });
        getContentPane().add(Loop, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 334, -1, -1));

        Select.setToolTipText("Select MP3");
        Select.setMaximumSize(new java.awt.Dimension(30, 30));
        Select.setMinimumSize(new java.awt.Dimension(30, 30));
        Select.setPreferredSize(new java.awt.Dimension(30, 30));
        Select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SelectMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SelectMouseReleased(evt);
            }
        });
        getContentPane().add(Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 334, -1, -1));

        Info.setToolTipText("Edit Tags");
        Info.setMaximumSize(new java.awt.Dimension(30, 30));
        Info.setMinimumSize(new java.awt.Dimension(30, 30));
        Info.setPreferredSize(new java.awt.Dimension(30, 30));
        Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                InfoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                InfoMouseReleased(evt);
            }
        });
        getContentPane().add(Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 334, -1, -1));

        Close.setToolTipText("Exit");
        Close.setMaximumSize(new java.awt.Dimension(30, 30));
        Close.setMinimumSize(new java.awt.Dimension(30, 30));
        Close.setPreferredSize(new java.awt.Dimension(30, 30));
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CloseMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CloseMouseReleased(evt);
            }
        });
        getContentPane().add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 14, -1, -1));

        SongInfo.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        SongInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SongInfo.setToolTipText("Title - Artist");
        SongInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SongInfo.setMaximumSize(new java.awt.Dimension(290, 15));
        SongInfo.setMinimumSize(new java.awt.Dimension(290, 15));
        SongInfo.setOpaque(true);
        SongInfo.setPreferredSize(new java.awt.Dimension(290, 15));
        SongInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SongInfoMouseEntered(evt);
            }
        });
        getContentPane().add(SongInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 14, -1, -1));

        AlbumName.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        AlbumName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AlbumName.setToolTipText("Album");
        AlbumName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AlbumName.setMaximumSize(new java.awt.Dimension(290, 15));
        AlbumName.setMinimumSize(new java.awt.Dimension(290, 15));
        AlbumName.setOpaque(true);
        AlbumName.setPreferredSize(new java.awt.Dimension(290, 15));
        AlbumName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AlbumNameMouseEntered(evt);
            }
        });
        getContentPane().add(AlbumName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 29, -1, -1));

        LOO.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        LOO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LOO.setMaximumSize(new java.awt.Dimension(200, 30));
        LOO.setMinimumSize(new java.awt.Dimension(200, 30));
        LOO.setPreferredSize(new java.awt.Dimension(200, 30));
        getContentPane().add(LOO, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 334, -1, -1));

        Look4.setFont(new java.awt.Font("Source Sans Pro", 0, 24)); // NOI18N
        Look4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Look4.setMaximumSize(new java.awt.Dimension(30, 30));
        Look4.setMinimumSize(new java.awt.Dimension(30, 30));
        Look4.setPreferredSize(new java.awt.Dimension(30, 30));
        Look4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Look4MouseEntered(evt);
            }
        });
        getContentPane().add(Look4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, -1, -1));

        AlbumArt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AlbumArt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AlbumArt.setMaximumSize(new java.awt.Dimension(350, 350));
        AlbumArt.setMinimumSize(new java.awt.Dimension(350, 350));
        AlbumArt.setPreferredSize(new java.awt.Dimension(350, 350));
        getContentPane().add(AlbumArt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 14, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMousePressed
        PPlay();
    }//GEN-LAST:event_PlayMousePressed

    private void PlayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayMouseReleased
        RPlay();
    }//GEN-LAST:event_PlayMouseReleased

    private void SelectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectMousePressed
        PSelect();
    }//GEN-LAST:event_SelectMousePressed

    private void SelectMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectMouseReleased
        RSelect();
    }//GEN-LAST:event_SelectMouseReleased

    private void CloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMousePressed
        PClose();
    }//GEN-LAST:event_CloseMousePressed

    private void CloseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseReleased
        RClose();
    }//GEN-LAST:event_CloseMouseReleased

    private void BarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarMousePressed
        point.x=evt.getX();
        point.y = evt.getY();
    }//GEN-LAST:event_BarMousePressed

    private void BarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarMouseDragged
        Point p = getLocation();
        x = p.x+evt.getX()-point.x;
        y = p.y+evt.getY()-point.y;
        setLocation(x, y);
    }//GEN-LAST:event_BarMouseDragged

    private void BarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarMouseReleased
        if (!screen.contains(this.getBounds()))
            {
                    if ((x>screen.width) && (y>screen.height))
                    {
                        ScrnOutAn(screen.width, screen.height);
                    }
                    else if ((y<0) && (x<0))
                    {
                        ScrnOutAn(0, 0);
                    }
                    else if ((y<0) && (x>screen.width))
                    {
                        ScrnOutAn(screen.width, 0);
                    }
                    else if ((x<0) && (y>screen.height))
                    {
                        ScrnOutAn(0, screen.height);
                    }
                    else if (x>screen.width)
                    {
                        ScrnOutAn(screen.width, y);
                    }
                    else if (y>screen.height)
                    {
                        ScrnOutAn(x, screen.height);
                    }
                    else if (x<0)
                    {
                        ScrnOutAn(0, y);
                    }
                    else if (y<0)
                    {
                        ScrnOutAn(x, 0);
                    }
            }
    }//GEN-LAST:event_BarMouseReleased

    private void BackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMousePressed
        PBack();
    }//GEN-LAST:event_BackMousePressed

    private void BackMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseReleased
        RBack();  
    }//GEN-LAST:event_BackMouseReleased

    private void LoopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoopMousePressed
        PLoop();
    }//GEN-LAST:event_LoopMousePressed

    private void LoopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoopMouseReleased
        RLoop();
    }//GEN-LAST:event_LoopMouseReleased

    private void InfoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoMousePressed
        PInfo();
    }//GEN-LAST:event_InfoMousePressed

    private void InfoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InfoMouseReleased
        RInfo();
    }//GEN-LAST:event_InfoMouseReleased

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        opener();
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        closer();
    }//GEN-LAST:event_formMouseExited

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        opener();
    }//GEN-LAST:event_formMouseMoved

    private void BarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarMouseEntered
        opener();
    }//GEN-LAST:event_BarMouseEntered

    private void SongInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SongInfoMouseEntered
        opener();
    }//GEN-LAST:event_SongInfoMouseEntered

    private void AlbumNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AlbumNameMouseEntered
        opener();
    }//GEN-LAST:event_AlbumNameMouseEntered

    private void RemindersFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RemindersFocusGained
        opener();
    }//GEN-LAST:event_RemindersFocusGained

    private void RemindersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RemindersFocusLost
        closer();
    }//GEN-LAST:event_RemindersFocusLost

    private void RemindersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemindersMouseEntered
        opener();
    }//GEN-LAST:event_RemindersMouseEntered

    private void RemindersMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemindersMouseMoved
        opener();
    }//GEN-LAST:event_RemindersMouseMoved

    private void RemindersMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemindersMouseDragged
        alphacontainer();
    }//GEN-LAST:event_RemindersMouseDragged

    private void RemindersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemindersMouseClicked
        alphacontainer();
    }//GEN-LAST:event_RemindersMouseClicked

    private void RemindersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RemindersKeyReleased
        if (c = true)
        {
            RemEmpty();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            alphacontainer();
        }
        else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            alphacontainer();
            RemEmpty();
        }
    }//GEN-LAST:event_RemindersKeyReleased

    private void RemindersKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RemindersKeyPressed
        opener();
        alphacontainer();
    }//GEN-LAST:event_RemindersKeyPressed

    private void Look4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Look4MouseEntered
        opener();
    }//GEN-LAST:event_Look4MouseEntered
    
    public void topinf()
    {
        if (loopSwitch == 1)
        {
            Look4.setText("∞");
        }
    }
    
    public void topinfrem()
    {
        Look4.setText("");
    }
    
    public void PClose()
    {
        try 
        {
            Close.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/x light.png"))));
        }
        catch (IOException ex) 
        {
            
        }
    }
    
    public void RClose()
    {
        try 
        {
            Close.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/x dark.png"))));
        } 
        catch (IOException ex) 
        {
            
        }
        saveLP();
        saveTxt();
        System.exit(0);
    }
    
    public void PPlay()
    {
        try
        {
        if (MC.playbutton == 1)
        {
            Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/play light.png"))));
        }
        else if (MC.playbutton == 2)
        {
            Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/pause light.png"))));
        }
        }
        catch (IOException ex) 
        {
            
        }
    }
    
    public void RPlay()
    {
        testPlay(1);
        try
        {
        if (MC.playbutton == 1)
        {
            Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/puase dark.png")))); 
        }
        else if (MC.playbutton == 2)
        {
            Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/play dark.png"))));
        }
        }
        catch (IOException ex) 
        {
            
        }
    }
    
    public void PSelect()
    {
        try 
        {
            Select.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/+ light.png"))));
        }
        catch (IOException ex) 
        {
            
        }
    }
    
    public void RSelect()
    {
        try 
        {
            Select.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/+ dark.png"))));
        }
        catch (IOException ex) 
        {
            
        }
        chooseMP3();
        System.gc();
    }
    
    public void PBack()
    {
        try 
        {
            Back.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/back light.png"))));
        } 
        catch (IOException ex) 
        {
            
        }
    }
    
    public void RBack()
    {
        testPlay(0);
        try 
        {
            Back.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/back dark.png"))));
        } 
        catch (IOException ex) 
        {
            
        }
    }
    
    public void PLoop()
    {
        try 
        {
            Loop.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/repeat light.png"))));
        } 
        catch (IOException ex) 
        {
            
        }
    }
    
    public void RLoop()
    {
        try 
        {
            Loop.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/repeat dark.png"))));
        } 
        catch (IOException ex) 
        {
            
        }
        switch (loopSwitch)
        {
            case 0:
                loopSwitch = 1;
                LOO.setText("Looping on");
                break;
                
            case 1:
                loopSwitch = 0;
                LOO.setText("");
                break;
        }
    }
    
    public void PInfo ()
    {
        try 
        {
            Info.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/i light.png"))));
        } 
        catch (IOException ex) 
        {
            
        }
    }
    
    public void RInfo ()
    {
        try 
        {
            Info.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/i dark.png"))));
        } 
        catch (IOException ex) 
        {
            
        }
        if (song == null)
        {
            JOptionPane.showMessageDialog(null, "Error: No MP3 File Loaded");
        }
        else
        {
            try 
            {
                Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/play dark.png"))));
                GetInfo();
                Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/puase dark.png"))));
            }
            catch (IOException ex) 
            {
                
            }
        }
    }
    
    public void alphacontainer ()
    {
        Notes.getViewport().setOpaque(false);
        Notes.repaint();
        a++;
        if (a == 50)
        {
            a = 0;
            System.gc();
        }
    }
    
    public void opener ()
    {
        timerexi.stop();
        timers.stop();
        timere.start();
    }
    
    public void closer ()
    {
        timere.stop();
        timerexi.start();
    }
    
    public void ScrnOutAn(int w, int h)
    {
        timerexi.stop();
        timers.stop();
        higher = 44;
        Dimension d1 = new Dimension (350,higher);
        MP3PlayerGUI.this.setSize(d1);
        this.setLocation(w, h);
        timere.start();
    }
    
    private void setTheme()
    {
            try 
            {
                KeyListener listener = getKeyListener();
        
                Notes.getViewport().setOpaque(false);
                SongInfo.setBackground(Frost);
                AlbumName.setBackground(Frost);
        
                Reminders.addKeyListener(listener);
                
                LOO.setText("Looping on");
        
                Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/play dark.png"))));
                Back.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/back dark.png"))));
                Loop.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/repeat dark.png"))));
                Select.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/+ dark.png"))));
                Info.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/i dark.png"))));
                Close.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/x dark.png"))));
            }
            catch (IOException ex) 
            {
                
            }
    }
    
    public void testPlay(int pie)
    {
        if (song == null)
        {
            JOptionPane.showMessageDialog(null, "Error: No MP3 File Loaded");
            return;
        }
        else if (MC.player.isComplete() && loopSwitch == 0)
        {
            pie = 0;
        }
        if (pie == 1)
        {
            pie = MC.playbutton;
        }
        MC.Play(song, pie);  
        try 
        {
            Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/puase dark.png"))));
        }
        catch (IOException ex) 
        {
            
        }
    }
    
    
    public void SetInfo(String File, String FileName) throws IOException, UnsupportedTagException, InvalidDataException
    {
        String FileTitle = FileName.substring(0, (FileName.length() - 4));
        Mp3File mp3file = new Mp3File(File);
        
        if (mp3file.hasId3v2Tag())
        {
            id = 2;
        }
        else if (mp3file.hasId3v1Tag())
        {
            id = 1;
        }
        else if(mp3file.hasCustomTag())
        {
            mp3file.removeCustomTag();
            id = 0;
        }
        else
        {
            id = 0;
        }
        
        String Title, Artist;
        
        if (id == 2) 
        {
        	ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                
                if ((id3v2Tag.getArtist() == null) && (id3v2Tag.getAlbumArtist() == null))
                {
                    Artist = "Unknown";
                }
                else if (id3v2Tag.getArtist() == null)
                {
                    Artist = id3v2Tag.getAlbumArtist();
                }
                else
                {
                    Artist = id3v2Tag.getArtist();
                }
                
                if (id3v2Tag.getTitle() == null)
                {
                    Title = "Unknown";
                }
                else
                {
                    Title = id3v2Tag.getTitle();
                }
                
                if (("Unknown".equals(Artist)) && ("Unknown".equals(Title)))
                {
                    SongInfo.setText(FileTitle);
                }
                else
                {
                    SongInfo.setText(Title + " - " + Artist);
                }
                
                if (id3v2Tag.getAlbum() == null)
                {
                    AlbumName.setText("Unknown");
                }
                else
                {
                    AlbumName.setText(id3v2Tag.getAlbum());
                }
                
                byte[] imageData = id3v2Tag.getAlbumImage();
                if (imageData != null)
                {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                    BufferedImage thumbnail = null;
                    if (img.getHeight() == img.getWidth())
                    {
                         thumbnail = Scalr.resize(img, Method.ULTRA_QUALITY, Mode.FIT_EXACT,350, 350, OP_ANTIALIAS, OP_BRIGHTER);
                    }
                    else if (img.getHeight() > img.getWidth())
                    {
                        thumbnail = Scalr.resize(img, Method.ULTRA_QUALITY, Mode.FIT_TO_HEIGHT,350, 350, OP_ANTIALIAS, OP_BRIGHTER);
                    }
                    else if (img.getHeight() < img.getWidth())
                    {
                        thumbnail = Scalr.resize(img, Method.ULTRA_QUALITY, Mode.FIT_TO_WIDTH,350, 350, OP_ANTIALIAS, OP_BRIGHTER);
                    }
                    ImageIcon icon = new ImageIcon(thumbnail);
                    AlbumArt.setIcon(icon);
                }
                else
                {
                    AlbumArt.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/AppPackage/Standard Art.png"))));
                }
        }
        
        else if (id == 1) 
        {
            	ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                
                if ("".equals(id3v1Tag.getTitle()) && "".equals(id3v1Tag.getArtist()))
                {
                    SongInfo.setText(FileTitle);
                }
                else if ("".equals(id3v1Tag.getTitle()))
                {
                    SongInfo.setText("Unknown" + " - " + id3v1Tag.getArtist());
                }
                else if ("".equals(id3v1Tag.getArtist()))
                {
                    SongInfo.setText(id3v1Tag.getTitle() + " - " + "Unknown");
                }
                else
                {
                    SongInfo.setText(id3v1Tag.getTitle() + " - " + id3v1Tag.getArtist());
                }
                
                if ("".equals(id3v1Tag.getAlbum()))
                {
                    AlbumName.setText("Unknown");
                }
                else
                {
                    AlbumName.setText(id3v1Tag.getAlbum());
                }
                
                AlbumArt.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/AppPackage/Standard Art.png"))));
        }
        
        else if (id == 0)
        {
            SongInfo.setText(FileTitle);
            AlbumName.setText("Unknown");
        }    
    }
    
    public void RemoveInfo()
    {
        SongInfo.setText("");
        AlbumName.setText("");
        AlbumArt.setIcon(null);
    }
    
    public void GetInfo()
    {
            MC.Pause();
            Infov1 infoTag1 = new Infov1(this, true, song, name, id);
            infoTag1.setVisible(true);
            try 
            {
                SetInfo(song, name);
            } 
            catch (IOException | UnsupportedTagException | InvalidDataException ex) 
            {

            }
            MC.Resume();
            System.gc();
    }
    
    public void setFileChooserFont(Component[] comp)
    {
        Font font = new Font ("Source Sans Pro", Font.PLAIN, 15);
        for (Component comp1 : comp) 
        {
            if (comp1 instanceof Container) 
            {
                setFileChooserFont(((Container) comp1).getComponents());
            }
            try 
            {
                comp1.setFont(font);
            }
            catch(Exception e)
            {
            
            }
        }
    }
    
    private void ReadTxt()
    {
        txtPath = (System.getProperty("user.home")) + System.getProperty("file.separator") + "Music" + System.getProperty("file.separator") + "KSMP" + System.getProperty("file.separator")+ "AppData" + System.getProperty("file.separator");
        
        File startpath = new File(txtPath);
        if (!startpath.exists())
        {
        startpath.getParentFile().mkdirs();
        new File(txtPath).mkdirs();
        try 
        {   
            FileWriter writer = new FileWriter(txtPath);
            writer.close();
        } 
        catch (IOException ex) 
        {
            
        }
        }
        fulltxtpath = txtPath+"Reminders.txt";
        File txt = new File(fulltxtpath);
        try 
        {
            if (txt.createNewFile())
            {
                FileCount = 0;
            }
            else
            {
                FileCount = 1;
            }
        }
        catch (IOException ex) 
        {
            
        }
        
        if (FileCount == 1)
        {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fulltxtpath), StandardCharsets.UTF_8))) 
                {
                    String line;
                    while((line = bufferedReader.readLine()) != null)
                    {
                        Reminders.append(line + "\n");
                        Notes.getViewport().setOpaque(false);
                        Notes.repaint();
                    }
                    bufferedReader.close();
                }
            catch (IOException ex) 
            {
                
            }
        }
        RemEmpty();
    }
    
    public void RemEmpty()
    {
        if ((Reminders.getText()).trim().isEmpty())
            {
                Reminders.setText("");
                Reminders.setBackground(new Color (0,0,0,0));
                c = true;
            }
        else
        {
            Reminders.setBackground(Frost);
            c = false;
        }
    }
    
    public void saveTxt()
    {
        if (Reminders.getText() != null)
        {
            BufferedWriter bufferedWriter = null;
            try 
            {
                String[] txtLines = Reminders.getText().split("\\n");
                bufferedWriter = new BufferedWriter(new FileWriter(fulltxtpath));
                for (String txtLine : txtLines)
                {
                    bufferedWriter.write(txtLine);
                    bufferedWriter.newLine();
                }
            }
            catch (IOException ex) 
            {
                
            } 
            finally 
            {
                try 
                {
                    if (bufferedWriter!=null)
                    {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    }
                }
                catch (IOException ex) 
                {
                    
                }
            }     
        }
    }
    
    private void ReadLP()
    {
        fullsopath = txtPath+"LastSong.txt";
        File txt = new File(fullsopath);
        try 
        {
            if (txt.createNewFile())
            {
                SFileCount = 0;
            }
            else
            {
                SFileCount = 1;
            }
        }
        catch (IOException ex) 
        {
            
        }
        
        if (SFileCount == 1)
        {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fullsopath), StandardCharsets.UTF_8))) 
                {
                    String prevsong = bufferedReader.readLine();
                    bufferedReader.close();
                    if (prevsong != null)
                    {
                    File sfile = new File (prevsong);
                    if (sfile.exists())
                    {
                        song = prevsong;
                        name = sfile.getName();
                        
                        try 
                        {
                            SetInfo(song, name);
                        } 
                        catch (IOException | UnsupportedTagException | InvalidDataException ex) 
                        {
                
                        }
                        MC.Play(song, 0);
                        try 
                        {
                        Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/puase dark.png"))));
                        }
                        catch (IOException ex) 
                        {
            
                        }
                        prevLocation = sfile.getParent();
                        f = 1;
                    }  
                }
                }
                catch (FileNotFoundException ex) 
                {
                
                }
                catch (IOException ex) 
                {
                
                }
        }
    }
    
    public void saveLP()
    {
        if (song != null)
        {
            BufferedWriter sbufferedWriter = null; 
            try 
            {
                sbufferedWriter = new BufferedWriter(new FileWriter (fullsopath));
                sbufferedWriter.write(song);
            }
            catch (IOException ex) 
            {
                
            }
            finally 
            {
                try 
                {
                    if (sbufferedWriter != null)
                    {
                    sbufferedWriter.flush();
                    sbufferedWriter.close();
                    }
                }
                catch (IOException ex) 
                {
                    
                }
            }               
        }
    }
    
    public void chooseMP3()
    {
        String wantedPath = null;
        if (f == 0)
        {         
        wantedPath = (System.getProperty("user.home")) + System.getProperty("file.separator") + "Music" + System.getProperty("file.separator") + "KSMP";
        
        f =1;
        }
        
        else if (f == 1)
        {
            if (prevLocation != null)
            {
                wantedPath = prevLocation;
            }
            else
            {
                f = 0;
                chooseMP3();
            }   
        }
        
        Boolean read = UIManager.getBoolean("FileChooser.readOnly");  
        UIManager.put("FileChooser.readOnly", read);  
        JFileChooser chooser = new JFileChooser(wantedPath);
        MetalFileChooserUI ui = (MetalFileChooserUI)chooser.getUI();
        
        try 
        {
            Field field = MetalFileChooserUI.class.getDeclaredField("fileNameTextField");
            field.setAccessible(true);
            JTextField tf = (JTextField) field.get(ui);
            tf.setEditable(false);
        }
        catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) 
        {
            
        }        
        
        chooser.setAccessory(new RealInfo(chooser));
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("MP3 Files", "mp3", "mpeg3");
        chooser.setFileFilter(filter);
        chooser.setApproveButtonText("Play");
        chooser.setApproveButtonToolTipText("Play MP3 File");
        chooser.setDialogTitle("Select MP3");
        chooser.setDragEnabled(rootPaneCheckingEnabled);
        chooser.setPreferredSize(new Dimension(screen.width+350-10, screen.height+364-taskBarHeight));
       
        setFileChooserFont(chooser.getComponents());
        
        Action details = chooser.getActionMap().get("viewTypeDetails");
        if(details != null) details.actionPerformed(null);
        
        int returnVal = chooser.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File myFile = chooser.getSelectedFile();
            song = myFile + "";
            
            name = chooser.getSelectedFile().getName();
            
            prevLocation = myFile.getParent();
            
            if (name.toLowerCase().endsWith(".mp3"))
            {
            
            RemoveInfo();
            
            try 
            {
                SetInfo(song, name);
            } 
            catch (IOException | UnsupportedTagException | InvalidDataException ex) 
            {
                
            }
            MC.Play(song, 0);
            try 
            {
            Play.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/LightTheme/puase dark.png"))));
            }
            catch (IOException ex) 
            {
            
            }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select an MP3 File");
                chooseMP3();
            }
        }
    }
     
   
    public static void main(String args[]) 
    {
        try 
        {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
        {
            
        }
        
        UIManager.put("ToolTip.font", new FontUIResource("Source Sans Pro", Font.PLAIN, 15));
        UIManager.put("OptionPane.messageFont", new FontUIResource("Source Sans Pro", Font.PLAIN, 15));
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            MP3PlayerGUI dialog = new MP3PlayerGUI(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() 
            {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) 
                {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlbumArt;
    private javax.swing.JLabel AlbumName;
    private javax.swing.JLabel Back;
    private javax.swing.JLabel Bar;
    private javax.swing.JLabel Close;
    private javax.swing.JLabel Info;
    private javax.swing.JLabel LOO;
    private javax.swing.JLabel Look4;
    private javax.swing.JLabel Loop;
    private javax.swing.JScrollPane Notes;
    private javax.swing.JLabel Play;
    private javax.swing.JTextArea Reminders;
    private javax.swing.JLabel Select;
    private javax.swing.JLabel SongInfo;
    // End of variables declaration//GEN-END:variables
private KeyListener getKeyListener() 
    {
        return new KeyAdapter()
        {
            @Override
            public void keyPressed (KeyEvent ev)
            {
                int ke = ev.getKeyCode();
                if ((ke == KeyEvent.VK_SPACE)&&ev.isControlDown())
                {
                    k = true;
                    PPlay();
                }
                else if ((ke == KeyEvent.VK_LEFT)&&ev.isControlDown())
                {
                    k = true;
                    PBack();
                }
                else if ((ke == KeyEvent.VK_R)&&ev.isControlDown())
                {
                    k = true;
                    PLoop();
                }
                else if ((ke == KeyEvent.VK_I)&&ev.isControlDown())
                {
                    k = true;
                    PInfo();
                }
                else if ((ke == KeyEvent.VK_F)&&ev.isControlDown())
                {
                    k = true;
                    PSelect();
                }
                else if ((ke == KeyEvent.VK_E)&&ev.isControlDown())
                {
                    k = true;
                   PClose();
                }
            }
            @Override
            public void keyReleased (KeyEvent evt)
            {
                if (k == true)
                {
                int key = evt.getKeyCode();
                if (key == KeyEvent.VK_SPACE)
                {
                    k = false;
                    RPlay();
                }
                else if (key == KeyEvent.VK_LEFT)
                {
                    k = false;
                    RBack();
                }
                else if (key == KeyEvent.VK_R)
                {
                    k = false;
                    RLoop();
                }
                else if (key == KeyEvent.VK_I)
                {
                    k = false;
                    RInfo();
                }
                else if (key == KeyEvent.VK_F)
                {
                    k = false;
                    RSelect();
                }
                else if (key == KeyEvent.VK_E)
                {
                    k = false;
                    RClose();
                }                           
                }
            }
        };
    }
}
