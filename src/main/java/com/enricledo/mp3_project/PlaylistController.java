/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.enricledo.mp3_project;

import com.enricledo.mp3_project.utils.FileUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author enricledo
 */
public class PlaylistController implements Initializable {

    @FXML
    private ImageView IVSongImage;
    @FXML
    private ImageView IVPlaylistImage;
    @FXML
    private ListView<String> LVSongs;
    @FXML
    private ListView<String> LVPlaylists;
    @FXML
    private Text TextPlaylistTitle;    
    @FXML
    private Button BTNSave;    
    @FXML
    private Button BTNPlayPlaylist;
    @FXML
    private Button BTNAddPlaylist;
    @FXML
    private Button BTNAddSong;
    @FXML
    private Button BTNAddedSongs;
    @FXML
    private ChoiceBox<String> CBMood;
    @FXML
    private TextField TFChangeTitle;
    @FXML
    private ImageView IVPrevious;
    @FXML
    private ImageView IVBackward;
    @FXML
    private ImageView IVPlayPause;
    @FXML
    private ImageView IVForward;
    @FXML
    private ImageView IVNext;    
    
    //Images Play Pause
    Image playImage = new Image(FileUtils.getIcona(this,"playButton.png"));
    Image pauseImage = new Image(FileUtils.getIcona(this,"pauseButton.png"));
            
    private final String[] moods = {"Crying", "Glasses", "Stunned", "Surprised", "Tongue"};
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Values of Edit Mode
        CBMood.getItems().addAll(moods);
        CBMood.setValue("Crying");
        CBMood.setVisible(false);
        
        BTNSave.setVisible(false);
        BTNSave.setOnAction(e -> saveChangesToPlaylist());
        
        TFChangeTitle.setVisible(false);
        TFChangeTitle.setPromptText(TextPlaylistTitle.getText());
        /////////////////////////////
        
        //Bottom "Buttons"
        IVPrevious.setImage(new Image(FileUtils.getIcona(this,"previousButton.png")));
        IVBackward.setImage(new Image(FileUtils.getIcona(this,"backwardButton.png")));
        IVPlayPause.setImage(playImage);
        IVForward.setImage(new Image(FileUtils.getIcona(this,"forwardButton.png")));
        IVNext.setImage(new Image(FileUtils.getIcona(this,"nextButton.png")));
        
        
        //View with mock information
        IVSongImage.setImage(new Image(FileUtils.getIcona(this,"cryingEmoji.png")));
        IVPlaylistImage.setImage(new Image(FileUtils.getIcona(this,"tongueEmoji.png")));
        
        
        
        TextPlaylistTitle.setText("La mejor playlist");
        String[] songs = {"Dream On - Aerosmith","Demasiadas Mujeres - C.Tangana","Neverita - Bad Bunny","Bohemian Rhapsody - Queen","Smooth - Santana, Rob Thomas","Shape of You - Ed Sheeran","Imagine - John Lennon","Rolling in the Deep - Adele","Hotel California - Eagles","Billie Jean - Michael Jackson","Stairway to Heaven - Led Zeppelin","Thinking Out Loud - Ed Sheeran","Purple Haze - Jimi Hendrix","Hey Jude - The Beatles","I Want to Hold Your Hand - The Beatles","Thriller - Michael Jackson","Hotel California - Eagles","Livin' on a Prayer - Bon Jovi","Sweet Child o' Mine - Guns N' Roses","Bohemian Rhapsody - Queen","Despacito - Luis Fonsi, Daddy Yankee"};
        LVSongs.getItems().addAll(songs);
        
        String[] playlists = {"La mejor playlist","Fiesta Pedro", "Ochenteraaaa","Temones de fiesta","Raeggeton"};
        LVPlaylists.getItems().addAll(playlists);
        
        
        //Menu songs and PlaylistMenu
        LVSongs.setContextMenu(songMenu());
        LVPlaylists.setContextMenu(playlistMenu());

        
        //Double Click just to have this as we will use it in the future
        LVSongs.setOnMouseClicked(new DoubleClickEventHandler(() -> {
            String selectedSong = LVSongs.getSelectionModel().getSelectedItem();
            TextPlaylistTitle.setText(selectedSong); // Example
        }));
    }

    private ContextMenu songMenu() {
        MenuItem cryingMenuItem = new MenuItem() {{ setGraphic(FileUtils.setSizeImageView(new ImageView(new Image(FileUtils.getIcona(this, "cryingEmoji.png"))), 32)); }};
        MenuItem glassesMenuItem = new MenuItem() {{ setGraphic(FileUtils.setSizeImageView(new ImageView(new Image(FileUtils.getIcona(this, "glassesEmoji.png"))), 32)); }};
        MenuItem stunnedMenuItem = new MenuItem() {{ setGraphic(FileUtils.setSizeImageView(new ImageView(new Image(FileUtils.getIcona(this, "stunnedEmoji.png"))), 32)); }};
        MenuItem surprisedMenuItem = new MenuItem() {{ setGraphic(FileUtils.setSizeImageView(new ImageView(new Image(FileUtils.getIcona(this, "surprisedEmoji.png"))), 32)); }};
        MenuItem tongueMenuItem = new MenuItem() {{ setGraphic(FileUtils.setSizeImageView(new ImageView(new Image(FileUtils.getIcona(this, "tongueEmoji.png"))), 32)); }};

        ContextMenu songMenu = new ContextMenu();
        MenuItem playMenuItem = new MenuItem("Play song");
        MenuItem deleteMenuItem = new MenuItem("Delete song");

        songMenu.getItems().addAll(playMenuItem, deleteMenuItem, cryingMenuItem, glassesMenuItem, stunnedMenuItem, surprisedMenuItem, tongueMenuItem);
        return songMenu;
    }
    
    private ContextMenu playlistMenu() {
        ContextMenu playlistMenu = new ContextMenu();
        MenuItem playMenuItem = new MenuItem("Play playlist");
        MenuItem deleteMenuItem = new MenuItem("Delete playlist");
        MenuItem editMenuItem = new MenuItem("Edit playlist");
        
        editMenuItem.setOnAction(event -> {
            editPlaylist();
        });
        
        playlistMenu.getItems().addAll(playMenuItem, deleteMenuItem, editMenuItem);
        return playlistMenu;
    }

    private void editPlaylist() {
        LVSongs.setDisable(true);
        LVPlaylists.setDisable(true);
        BTNAddPlaylist.setDisable(true); 
        
        BTNSave.setVisible(true);
        BTNPlayPlaylist.setVisible(false);
        BTNAddSong.setVisible(false);
        
        CBMood.setVisible(true);
        TFChangeTitle.setVisible(true);
        BTNAddedSongs.setDisable(true);
    }
    
    private void saveChangesToPlaylist(){
        LVPlaylists.setDisable(false);
        LVSongs.setDisable(false);
        BTNAddPlaylist.setDisable(false);
        
        BTNSave.setVisible(false);
        BTNPlayPlaylist.setVisible(true);
        BTNAddSong.setVisible(true);
        
        CBMood.setVisible(false);
        TFChangeTitle.setVisible(false);
        BTNAddedSongs.setDisable(false);
    }
    
    @FXML
    public void playToPause() {
        if(IVPlayPause.getImage().equals(playImage))
            IVPlayPause.setImage(pauseImage);
        else if(!IVPlayPause.getImage().equals(playImage))
            IVPlayPause.setImage(playImage);
    }

    public class DoubleClickEventHandler implements EventHandler<MouseEvent> {
        private final Runnable onDoubleClick;

        public DoubleClickEventHandler(Runnable onDoubleClick) {
            this.onDoubleClick = onDoubleClick;
        }

        @Override
        public void handle(MouseEvent event) {
            if (event.getClickCount() == 2) {
                onDoubleClick.run();
            }
        }
    }
}
    
