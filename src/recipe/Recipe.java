/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

import java.net.*;
import java.io.*;
import org.json.simple.JSONArray;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Recipe {
    public static void main(String[] args) throws Exception {
        
        URL url = new URL("http://food2fork.com/api/search?key=d85c5181059fe178c852553259bba2e5&q=pasta");
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_5_8; en-US) AppleWebKit/532.5 (KHTML, like Gecko) Chrome/4.0.249.0 Safari/532.5");
        BufferedReader br = new BufferedReader(
        new InputStreamReader(conn.getInputStream()));
        JSONParser jsonParser = new JSONParser();
        
        JSONObject jsonObject = (JSONObject) jsonParser.parse(br.readLine());//Full Search Object
        
        long count = (long) jsonObject.get("count");
        System.out.println(count);
        
        JSONArray recipes = (JSONArray) jsonObject.get("recipes");//Object of recipes array[objects]
        String title="";
        String image_url="";
        Double social_rank;
        
        for(int i=0; i<recipes.size();i++){
            JSONObject recipesObject = (JSONObject) recipes.get(i);
//            JSONObject recipesObject = (JSONObject) jsonParser.parse(recipes[i]);
            title = (String) recipesObject.get("title");
            image_url = (String) recipesObject.get("image_url");
            social_rank = (Double) recipesObject.get("social_rank");
            System.out.println(title);  
            System.out.println(image_url);
            System.out.println(social_rank);  

        }
        br.close();
    }
}