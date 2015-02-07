/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package auctionsystem.entity;

import java.io.Serializable;

/**
 *
 * @author Cursos Montoya
 */
public class Item implements Serializable {
    
    private int id;
    private String description;
    private String image;
    private static int countId = 0;

    public Item() {
        countId++;
    }

    public Item(String description, String image) {
        this();
        this.description = description;
        this.image = image;
        this.id = countId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
    
    

}
