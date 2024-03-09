/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.GameDetail;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.GamePopular;

/**
 *
 * @author thanh
 */
public class accounttest extends DBConnect {

//    public List<GameDetail> getAll() {
//        List<GameDetail> list = new ArrayList<>();
//        String sql = "select * from Game";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                GameDetail c = new GameDetail(rs.getInt("gameID"), rs.getString("gameName"), rs.getString("gameGenre"), rs.getString("publisher"), rs.getFloat("price"), rs.getString("description"), rs.getString("os"), rs.getString("processor"), rs.getString("memory"), rs.getString("graphics"), rs.getString("directX"), rs.getString("network"), rs.getString("storage"), rs.getString("releaseDay"), rs.getString("image1"), rs.getString("image2"), rs.getString("image3"), rs.getString("image4"), rs.getString("link"));
//                list.add(c);
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//    }

    public ArrayList<GamePopular> getAllList() {
        ArrayList<GamePopular> list = new ArrayList<>();
        try {
            String sql = "SELECT g.GameID, g.GameName, g.GameGenre, g.Price, i.image1 FROM Game g INNER JOIN ImgOfGame i ON g.GameID = i.GameID";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new GamePopular(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public static void main(String[] args) {
        accounttest c = new accounttest();
        List<GamePopular> list = c.getAllList();
        System.out.println(list.get(1).getGameName());
    }
}
