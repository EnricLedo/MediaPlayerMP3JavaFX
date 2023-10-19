/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.enricledo.mp3_project;

import com.sun.javafx.scene.control.LabeledText;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;


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
    private Text TextPlaylistTitle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] songs = {"Dream On - Aerosmith","Demasiadas Mujeres - C.Tangana","Neverita - Bad Bunny","Bohemian Rhapsody - Queen","Smooth - Santana, Rob Thomas","Shape of You - Ed Sheeran","Imagine - John Lennon","Rolling in the Deep - Adele","Hotel California - Eagles","Billie Jean - Michael Jackson","Stairway to Heaven - Led Zeppelin","Thinking Out Loud - Ed Sheeran","Purple Haze - Jimi Hendrix","Hey Jude - The Beatles","I Want to Hold Your Hand - The Beatles","Thriller - Michael Jackson","Hotel California - Eagles","Livin' on a Prayer - Bon Jovi","Sweet Child o' Mine - Guns N' Roses","Bohemian Rhapsody - Queen","Despacito - Luis Fonsi, Daddy Yankee"};
        LVSongs.getItems().addAll(songs);
        
        ContextMenu contextMenu = new ContextMenu();
        MenuItem playMenuItem = new MenuItem("Play");
        MenuItem deleteMenuItem = new MenuItem("Delete");

        contextMenu.getItems().addAll(playMenuItem, deleteMenuItem);

        LVSongs.setContextMenu(contextMenu);
        
        LVSongs.setOnMouseClicked(new DoubleClickEventHandler(() -> {
            String selectedSong = LVSongs.getSelectionModel().getSelectedItem();
            TextPlaylistTitle.setText(selectedSong);//Ejemplo
        }));
    }

    public class DoubleClickEventHandler implements EventHandler<MouseEvent> {
        private Runnable onDoubleClick;

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
    
