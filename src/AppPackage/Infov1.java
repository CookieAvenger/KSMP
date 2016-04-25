package AppPackage;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.ID3v24Tag;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Icon;
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
import static org.imgscalr.Scalr.OP_ANTIALIAS;

public final class Infov1 extends javax.swing.JDialog 
{       
    String Source1, FileName1;
    Mp3File mp3file1;
    ID3v2 id3v2Tag1;
    int Artcount = 0;
    int ArtHeight;
    int ArtWidth;
    
    String path;
    
    String wantedPath = null;
    
    Point point = new Point();
    
    int x;
    int y;
    
    Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
    int taskBarHeight = (scrnSize.height) - (GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
    final Rectangle screen1 = new Rectangle (scrnSize.width - 495, scrnSize.height - taskBarHeight - 212);
    
    int width = (Toolkit.getDefaultToolkit().getScreenSize().width)/2 - 265;
    int height = (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - 106;
    
    public Infov1(java.awt.Dialog parent, boolean modal, String Source, String FileName, int tag)
    {
        super(parent, modal);
        initComponents();
        
        this.setLocation(width, height);
        
        Source1 = Source;
        FileName1 = FileName;
        
        wantedPath = (System.getProperty("user.home") + System.getProperty("file.separator") + "Pictures");
        
        try 
        {
            mp3file1 = new Mp3File(Source1);
        }
        catch (IOException | UnsupportedTagException | InvalidDataException ex) 
        {
            
        }
        if (tag == 2)
        {
            id3v2Tag1 = mp3file1.getId3v2Tag();
            set2();
        }
        else if (tag == 1)
        {
            ID3v1 id3v1Tag1 = mp3file1.getId3v1Tag();
            String Track3 = id3v1Tag1.getTrack();
            String Title3 = id3v1Tag1.getTitle();
            String Album3 = id3v1Tag1.getAlbum();
            String Artist3 = id3v1Tag1.getArtist();
            String Year3 = id3v1Tag1.getYear();
            String Comment3 = id3v1Tag1.getComment();
            
            mp3file1.removeId3v1Tag();
            
            id3v2Tag1 = new ID3v24Tag();
            mp3file1.setId3v2Tag(id3v2Tag1);
            id3v2Tag1.setTrack(Track3);
            id3v2Tag1.setTitle(Title3);
            id3v2Tag1.setAlbum(Album3);
            id3v2Tag1.setArtist(Artist3);
            id3v2Tag1.setYear(Year3);
            id3v2Tag1.setComment(Comment3);
            
            set2();
        }
        else if (tag == 0)
        {
            id3v2Tag1 = new ID3v24Tag();
            mp3file1.setId3v2Tag(id3v2Tag1);
            id3v2Tag1.setTrack("");
            id3v2Tag1.setTitle("");
            id3v2Tag1.setAlbum("");
            id3v2Tag1.setArtist("");
            id3v2Tag1.setYear("");
            id3v2Tag1.setComment("");
            set2();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NTrack = new javax.swing.JTextField();
        NTitle = new javax.swing.JTextField();
        NAlbum = new javax.swing.JTextField();
        NArtist = new javax.swing.JTextField();
        NYear = new javax.swing.JTextField();
        NComment = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Track = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Title = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Album = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Artist = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        Year = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        Comment = new javax.swing.JTextArea();
        Save = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        Bar1 = new javax.swing.JLabel();
        SetPic = new javax.swing.JButton();
        Art = new javax.swing.JLabel();
        removeArt = new javax.swing.JButton();
        PicDim = new javax.swing.JLabel();
        Keep = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(530, 212));
        setMinimumSize(new java.awt.Dimension(530, 212));
        setUndecorated(true);
        setResizable(false);

        NTrack.setEditable(false);
        NTrack.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        NTrack.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        NTrack.setText("Track:");
        NTrack.setBorder(null);

        NTitle.setEditable(false);
        NTitle.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        NTitle.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        NTitle.setText("Title:");
        NTitle.setBorder(null);

        NAlbum.setEditable(false);
        NAlbum.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        NAlbum.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        NAlbum.setText("Album:");
        NAlbum.setBorder(null);

        NArtist.setEditable(false);
        NArtist.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        NArtist.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        NArtist.setText("Artist:");
        NArtist.setBorder(null);

        NYear.setEditable(false);
        NYear.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        NYear.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        NYear.setText("Year:");
        NYear.setBorder(null);

        NComment.setEditable(false);
        NComment.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        NComment.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        NComment.setText("Comment:");
        NComment.setBorder(null);

        jScrollPane1.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        Track.setColumns(20);
        Track.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        Track.setRows(1);
        Track.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Track.setMargin(new java.awt.Insets(1, 5, 1, 5));
        jScrollPane1.setViewportView(Track);

        jScrollPane2.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBar(null);

        Title.setColumns(20);
        Title.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        Title.setRows(1);
        Title.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Title.setMargin(new java.awt.Insets(1, 5, 1, 5));
        jScrollPane2.setViewportView(Title);

        jScrollPane3.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setHorizontalScrollBar(null);

        Album.setColumns(20);
        Album.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        Album.setRows(1);
        Album.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Album.setMargin(new java.awt.Insets(1, 5, 1, 5));
        jScrollPane3.setViewportView(Album);

        jScrollPane4.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setHorizontalScrollBar(null);

        Artist.setColumns(20);
        Artist.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        Artist.setRows(1);
        Artist.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Artist.setMargin(new java.awt.Insets(1, 5, 1, 5));
        jScrollPane4.setViewportView(Artist);

        jScrollPane5.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setHorizontalScrollBar(null);

        Year.setColumns(20);
        Year.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        Year.setRows(1);
        Year.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Year.setMargin(new java.awt.Insets(1, 5, 1, 5));
        jScrollPane5.setViewportView(Year);

        jScrollPane7.setBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setHorizontalScrollBar(null);

        Comment.setColumns(20);
        Comment.setFont(new java.awt.Font("Source Sans Pro", 0, 15)); // NOI18N
        Comment.setLineWrap(true);
        Comment.setRows(2);
        Comment.setWrapStyleWord(true);
        Comment.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Comment.setMargin(new java.awt.Insets(1, 5, 1, 5));
        jScrollPane7.setViewportView(Comment);

        Save.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        Save.setText("Save");
        Save.setToolTipText("Update Tags");
        Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SaveMouseReleased(evt);
            }
        });

        Cancel.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.setToolTipText("Discard Tag Changes");
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CancelMouseReleased(evt);
            }
        });

        Bar1.setFont(new java.awt.Font("Source Sans Pro", 0, 17)); // NOI18N
        Bar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bar1.setText("Edit Tag Information");
        Bar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Bar1.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        Bar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Bar1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Bar1MouseDragged(evt);
            }
        });
        Bar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Bar1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Bar1MouseReleased(evt);
            }
        });

        SetPic.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        SetPic.setText("Change");
        SetPic.setToolTipText("Set Album Art");
        SetPic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SetPicMouseReleased(evt);
            }
        });

        removeArt.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        removeArt.setText("Remove");
        removeArt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                removeArtMouseReleased(evt);
            }
        });

        PicDim.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        PicDim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PicDim.setText("No Art");
        PicDim.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Keep.setFont(new java.awt.Font("Source Sans Pro", 0, 12)); // NOI18N
        Keep.setText("Keep");
        Keep.setToolTipText("Save Tagged Album Art");
        Keep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                KeepMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(SetPic, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Keep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeArt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PicDim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Art, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(NTitle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NAlbum, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NArtist, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NYear, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NComment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancel)
                        .addGap(58, 58, 58))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Bar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NTrack)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NTitle)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NAlbum)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NArtist)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NYear)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Art, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PicDim)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SetPic)
                            .addComponent(Keep)
                            .addComponent(removeArt)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cancel)
                            .addComponent(Save))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseReleased
        dispose();
    }//GEN-LAST:event_CancelMouseReleased

    private void SaveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseReleased
        save2();
        System.gc();
        dispose();
    }//GEN-LAST:event_SaveMouseReleased

    private void Bar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bar1MousePressed
        point.x=evt.getX();
        point.y = evt.getY();
    }//GEN-LAST:event_Bar1MousePressed

    private void Bar1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bar1MouseDragged
        Point p = getLocation();
        x = p.x+evt.getX()-point.x;
        y = p.y+evt.getY()-point.y;
        setLocation(x, y);
    }//GEN-LAST:event_Bar1MouseDragged

    private void SetPicMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetPicMouseReleased
        path = ChooseArt();
        if (path != null)
        {
        changeArt();
        }
        System.gc();
    }//GEN-LAST:event_SetPicMouseReleased

    private void removeArtMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeArtMouseReleased
        hideart();
    }//GEN-LAST:event_removeArtMouseReleased

    private void Bar1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bar1MouseReleased
        if (!screen1.contains(this.getBounds()))
            {
                    if ((x>screen1.width) && (y>screen1.height))
                    {
                        this.setLocation(screen1.width, screen1.height);
                    }
                    else if ((y<0) && (x<0))
                    {
                        this.setLocation(0, 0);
                    }
                    else if ((y<0) && (x>screen1.width))
                    {
                        this.setLocation(screen1.width, 0);
                    }
                    else if ((x<0) && (y>screen1.height))
                    {
                        this.setLocation(0, screen1.height);
                    }
                    else if (x>screen1.width)
                    {
                        this.setLocation(screen1.width, y);
                    }
                    else if (y>screen1.height)
                    {
                        this.setLocation(x, screen1.height);
                    }
                    else if (x<0)
                    {
                        this.setLocation(0, y);
                    }
                    else if (y<0)
                    {
                        this.setLocation(x, 0);
                    }
                    System.gc();
            }  
    }//GEN-LAST:event_Bar1MouseReleased

    private void KeepMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeepMouseReleased
        keepAArt();
        System.gc();
    }//GEN-LAST:event_KeepMouseReleased
    
    public void set2 ()
    {     
        Track.setText(id3v2Tag1.getTrack());
        Title.setText(id3v2Tag1.getTitle());
        Album.setText(id3v2Tag1.getAlbum());
        Artist.setText(id3v2Tag1.getArtist());
        Year.setText(id3v2Tag1.getYear());
        Comment.setText(id3v2Tag1.getComment());
        byte[] imageData = id3v2Tag1.getAlbumImage();
                if (imageData != null)
                {
                try 
                {
                    BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                    
                    ArtHeight = img.getHeight();
                    ArtWidth = img.getWidth();
                    BufferedImage thumbnail = null;
                    if (ArtHeight == ArtWidth)
                    {
                         thumbnail = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT,130, 130, OP_ANTIALIAS);
                    }
                    else if (ArtHeight > ArtWidth)
                    {
                        thumbnail = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,130, 130, OP_ANTIALIAS);
                    }
                    else if (ArtHeight < ArtWidth)
                    {
                        thumbnail = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH,130, 130, OP_ANTIALIAS);
                    }
                    ImageIcon icon = new ImageIcon(thumbnail);
                    Art.setIcon(icon);
                    PicDim.setText("Dimension: "+ArtWidth+" x "+ArtHeight);
                }
                catch (IOException ex) 
                {
                
                }
                }
                else
                {
                try 
                {
                    BufferedImage none = ImageIO.read(getClass().getResource("/AppPackage/Standard Art.png"));
                    BufferedImage none2 = Scalr.resize(none, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT,130, 130, OP_ANTIALIAS);
                    ImageIcon icon3 = new ImageIcon(none2);
                    Art.setIcon(icon3);
                }   
                catch (IOException ex) 
                {
                    
                }
                }
    }

    
    public void save2()
    {
        String Parth = (System.getProperty("user.home") + System.getProperty("file.separator") + "Music" + System.getProperty("file.separator") + "KSMP" + System.getProperty("file.separator") + "%AppData%" + System.getProperty("file.separator"));
        
        File startparth = new File(Parth);
        startparth.getParentFile().mkdirs();
        new File(Parth.substring(0, Parth.length() - 1)).mkdirs();
        try 
        {   
            FileWriter fileWriter = new FileWriter(Parth);
            fileWriter.close();
        } 
        catch (IOException ex) 
        {
            
        }
        
        byte[] Byteimage = null;
        if (Artcount == 0)
        {
        byte[] imageData = id3v2Tag1.getAlbumImage();
        if (imageData != null) 
        {
        try 
        {
            BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos );
            Byteimage = baos.toByteArray();
        }
        catch (IOException ex) 
        {
            
        }
        }
        }

        mp3file1.removeId3v2Tag();
        ID3v24Tag id3v2Tag2 = new ID3v24Tag();
        mp3file1.setId3v2Tag(id3v2Tag2);
        
        if (Artcount == 0)
        {
            id3v2Tag2.setAlbumImage(Byteimage, "Art");
        }
        else if (Artcount == 1)
        {
            try 
            {
                File pch = new File(path);
                byte[] picContent = Files.readAllBytes(pch.toPath());
                id3v2Tag2.setAlbumImage(picContent, "Art");
            }
            catch (IOException ex) 
            {
                
            }
        }

        String tempTrack = Track.getText();
        String tempTitle = Title.getText();
        String tempAlbum = Album.getText();
        String tempArtist = Artist.getText();
        String tempYear = Year.getText();
        String tempComment = Comment.getText();
        
        if (!tempTrack.trim().isEmpty())
        {
            id3v2Tag2.setTrack(tempTrack);
        }
        if (!tempTitle.trim().isEmpty())
        {
            id3v2Tag2.setTitle(tempTitle);
        }
        if (!tempAlbum.trim().isEmpty())
        {
            id3v2Tag2.setAlbum(tempAlbum);
        }
        if (!tempArtist.trim().isEmpty())
        {
            id3v2Tag2.setArtist(tempArtist);
        }
        if (!tempYear.trim().isEmpty())
        {
            id3v2Tag2.setYear(tempYear);
        }
        if (!tempComment.trim().isEmpty())
        {
            id3v2Tag2.setComment(tempComment);            
        }
        
        try 
        {
            mp3file1.save(Parth+FileName1);
            Path origin = Paths.get(Parth+FileName1);
            Path target = Paths.get(Source1);
            Files.copy(origin, target, REPLACE_EXISTING);
            Files.deleteIfExists(origin);
        } 
        catch (IOException | NotSupportedException ex) 
        {

        }
               
        String delPath = Parth.substring(0, Parth.length() - 1);
        File dfolder = new File(delPath);
        dfolder.delete();
    }
    
    public void setFileChooserFont2(Component[] comp)
    {
        Font font = new Font("Source Sans Pro",Font.PLAIN,15);
        for (Component comp1 : comp) 
        {
            if (comp1 instanceof Container) 
            {
                setFileChooserFont2(((Container) comp1).getComponents());
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
    
    public String ChooseArt()
    { 
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
        
        chooser.setAccessory(new Preview(chooser));
        
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter filter = new FileNameExtensionFilter("JPG Files", "jpg", "jpeg");
        chooser.setFileFilter(filter);
        chooser.setApproveButtonText("Change");
        chooser.setApproveButtonToolTipText("Change Album Art to Selected Picture");
        chooser.setDialogTitle("Select New Album Art");
        chooser.setDragEnabled(rootPaneCheckingEnabled);
        chooser.setSize(800, 500);
        
        setFileChooserFont2(chooser.getComponents());
        
        Action details = chooser.getActionMap().get("viewTypeDetails");
        if(details != null) details.actionPerformed(null);
        
        int returnVal = chooser.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File myFile = chooser.getSelectedFile();
            if (myFile.getName().toLowerCase().endsWith(".jpg") || myFile.getName().toLowerCase().endsWith(".jpeg"))
            {
            return (myFile + "");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select a JPEG File");
                ChooseArt();
            }
        }
        return null;
    }

    public void changeArt()
    {
        try 
        {
            BufferedImage cha = ImageIO.read(new File (path));
            Icon cha2 = null;
            ArtHeight = cha.getHeight();
            ArtWidth = cha.getWidth();
                if (ArtHeight == ArtWidth)
                    {
                         cha2 = new ImageIcon(Scalr.resize(cha, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT,130, 130, OP_ANTIALIAS));
                    }
                    else if (ArtHeight > ArtWidth)
                    {
                        cha2 = new ImageIcon(Scalr.resize(cha, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,130, 130, OP_ANTIALIAS));
                    }
                    else if (ArtHeight < ArtWidth)
                    {
                        cha2 = new ImageIcon(Scalr.resize(cha, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH,130, 130, OP_ANTIALIAS));
                    }
                Art.setIcon(cha2);
                PicDim.setText("Dimension: "+ArtWidth+" x "+ArtHeight);
                Artcount = 1;
        }
        catch (IOException ex) 
        {
            hideart();
            PicDim.setText("Error");
        }
    }
    
    public void hideart()
    {
        try 
        {
            BufferedImage none = ImageIO.read(getClass().getResource("/AppPackage/Standard Art.png"));
            BufferedImage none2 = Scalr.resize(none, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_EXACT,130, 130, OP_ANTIALIAS);
            ImageIcon icon3 = new ImageIcon(none2);
            Art.setIcon(icon3);
        }
        catch (IOException ex) 
        {

        }
        PicDim.setText("No Art");
        Artcount = 2;
    }
    
    public void keepAArt()
    {
        byte[] imageData = id3v2Tag1.getAlbumImage();
        if (imageData != null) 
        {               
                JFileChooser saver = new JFileChooser(wantedPath);
                
                MetalFileChooserUI ui = (MetalFileChooserUI)saver.getUI();
                
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
        
                saver.setAcceptAllFileFilterUsed(false);
                saver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                saver.setApproveButtonText("Save");
                saver.setApproveButtonToolTipText("Save Art Here");
                saver.setDialogTitle("Save Current Album Art");
                saver.setDragEnabled(rootPaneCheckingEnabled);
                saver.setSize(800, 500);

                setFileChooserFont2(saver.getComponents());
        
                Action details = saver.getActionMap().get("viewTypeDetails");
                if(details != null) details.actionPerformed(null);
                
                int savey = saver.showSaveDialog(null);
                
                if (savey == saver.getApproveButtonMnemonic())
                {   
                    if (saver.getSelectedFile().isDirectory())
                    {
                    try 
                        {
                            BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                            File saveat = new File (saver.getSelectedFile().getCanonicalPath()+"\\"+(FileName1.substring(0, (FileName1.length() - 4)))+".jpg");
                            boolean Exists = saveat.exists();
                            int i = 1;
                            while (Exists == true)
                            {
                                saveat = new File (saver.getSelectedFile().getCanonicalPath()+"\\"+(FileName1.substring(0, (FileName1.length() - 4)))+" (" + i + ")" +".jpg");
                                i++;
                                Exists = saveat.exists();
                            }
                            ImageIO.write(img, "jpg", saveat);
                        } 
                        catch (IOException ex) 
                        {
                            
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please select a valid directory");
                        keepAArt();
                    }
                }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error: No Album Art");
        }
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            Infov1 dialog = new Infov1(new javax.swing.JDialog(), true, null, null, 3);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Album;
    private javax.swing.JLabel Art;
    private javax.swing.JTextArea Artist;
    private javax.swing.JLabel Bar1;
    private javax.swing.JButton Cancel;
    private javax.swing.JTextArea Comment;
    private javax.swing.JButton Keep;
    private javax.swing.JTextField NAlbum;
    private javax.swing.JTextField NArtist;
    private javax.swing.JTextField NComment;
    private javax.swing.JTextField NTitle;
    private javax.swing.JTextField NTrack;
    private javax.swing.JTextField NYear;
    private javax.swing.JLabel PicDim;
    private javax.swing.JButton Save;
    private javax.swing.JButton SetPic;
    private javax.swing.JTextArea Title;
    private javax.swing.JTextArea Track;
    private javax.swing.JTextArea Year;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton removeArt;
    // End of variables declaration//GEN-END:variables
}
