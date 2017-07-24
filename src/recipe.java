/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vasu
 */
public class recipe {

    String rID;
    String title;
    String imageUrl;

    public recipe(String rID, String title, String imageUrl) {
        this.imageUrl = imageUrl;
        this.rID = imageUrl;
        this.title = title;
    }

    public recipe(String recipe_id, String title) {
        this.rID = recipe_id;
        this.title = title;
    }

}
