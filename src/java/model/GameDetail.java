/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBConnect;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class GameDetail {

    private int gameID;
    private String gameName;
    private String gameGenre;
    private String publisher;
    private float price;
    private String description;
    private String os;
    private String processor;
    private String memory;
    private String graphics;
    private String directX;
    private String network;
    private String storage;
    private String releaseDay;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String link;

    public GameDetail(int gameID, String image1, String image2, String image3, String image4, String link) {
        this.gameID = gameID;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.link = link;
    }

    public GameDetail(int gameID, String gameName, String gameGenre, String publisher, float price, String description, String os, String processor, String memory, String graphics, String directX, String network, String storage, String releaseDay, String image1, String image2, String image3, String image4, String link) {
        this.gameID = gameID;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.publisher = publisher;
        this.price = price;
        this.description = description;
        this.os = os;
        this.processor = processor;
        this.memory = memory;
        this.graphics = graphics;
        this.directX = directX;
        this.network = network;
        this.storage = storage;
        this.releaseDay = releaseDay;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.link = link;
    }

    public GameDetail() {
    }

    public GameDetail(int gameID, String gameName, String gameGenre, String publisher, float price, String description, String os, String processor, String memory, String graphics, String directX, String network, String storage, String releaseDay) { //, String image1, String image2, String image3, String image4, String link
        this.gameID = gameID;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.publisher = publisher;
        this.price = price;
        this.description = description;
        this.os = os;
        this.processor = processor;
        this.memory = memory;
        this.graphics = graphics;
        this.directX = directX;
        this.network = network;
        this.storage = storage;
        this.releaseDay = releaseDay;
//        this.image1 = image1;
//        this.image2 = image2;
//        this.image3 = image3;
//        this.image4 = image4;
//        this.link = link;
    }

    public GameDetail(String gameName, String gameGenre, String publisher, float price, String description, String os, String processor, String memory, String graphics, String directX, String network, String storage, String releaseDay) {
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.publisher = publisher;
        this.price = price;
        this.description = description;
        this.os = os;
        this.processor = processor;
        this.memory = memory;
        this.graphics = graphics;
        this.directX = directX;
        this.network = network;
        this.storage = storage;
        this.releaseDay = releaseDay;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getDirectX() {
        return directX;
    }

    public void setDirectX(String directX) {
        this.directX = directX;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(String releaseDay) {
        this.releaseDay = releaseDay;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isValidGame() {
        Connection conn = null;
        CallableStatement callableStatement = null;
        Boolean checkGame = false;

        try {
            DBConnect db = new DBConnect();
            conn = db.getConnection();
            callableStatement = conn.prepareCall("{call CheckGame(?, ?)}");
            callableStatement.setInt(1, this.gameID);
            callableStatement.setString(2, this.gameName);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                checkGame = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return checkGame;
    }

}
