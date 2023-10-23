/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enricledo.mp3_project.utils;

import javafx.scene.image.ImageView;

/**
 *
 * @author enricledo
 */
public class FileUtils {
    public static String getIcona(Object instance, String nom)
    {
        return instance.getClass().getClassLoader().getResource("images/" + nom).toString();
    }
    
    public static ImageView setSizeImageView(ImageView imageView, int d) {
        imageView.setFitHeight(d);
        imageView.setFitWidth(d);
        return imageView;
    }
}
