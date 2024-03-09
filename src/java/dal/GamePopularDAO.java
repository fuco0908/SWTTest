/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CodeGame;
import model.GameDetail;
import model.GamePopular;
import model.User;

/**
 *
 * @author Lenovo
 */
public class GamePopularDAO extends DBConnect {

    public ArrayList<GamePopular> getListPopular() {
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

    public ArrayList<User> getAllListUser() {
        ArrayList<User> listU = new ArrayList<>();
        try {
            String sql = "select UserID, FullName, UserName, [Password], Email, UserRole, [Status], PhoneNumber, Code from [User]";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listU.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listU;
    }

    public ArrayList<GamePopular> getNewList() {
        ArrayList<GamePopular> listN = new ArrayList<>();
        try {
            String sql = "SELECT g.GameID, g.GameName, g.GameGenre, g.Price, Img.image1 FROM ImgOfGame Img INNER JOIN Game g ON Img.GameID = g.GameID WHERE SUBSTRING(g.ReleaseDay, 4, 7) > '2017-01-01'";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listN.add(new GamePopular(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listN;
    }

    public GameDetail getGameByID(String id) {
        try {
            String sql = "SELECT G.GameID, G.GameName, G.GameGenre, G.Publisher, G.Price, G.Description, G.OS, G.Processor, G.Memory, G.Graphics, G.DirectX, G.Network, G.Storage, G.ReleaseDay,\n"
                    + "       I.image1, I.image2, I.image3, I.image4, I.link\n"
                    + "FROM Game G\n"
                    + "JOIN ImgOfGame I ON G.GameID = I.GameID\n"
                    + "WHERE G.GameID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new GameDetail(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<CodeGame> getCodeByID(String id) {
        ArrayList<CodeGame> listC = new ArrayList<>();
        try {
            String sql = "SELECT c.CodeID, c.Code, c.Status FROM Game G JOIN GameCode c ON G.GameID = c.GameID WHERE G.GameID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listC.add(new CodeGame(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listC;
    }

    public CodeGame getCodeGameByID(String id) {
        try {
            String sql = "SELECT c.CodeID, c.Code, c.Status FROM Game G JOIN GameCode c ON G.GameID = c.GameID WHERE G.GameID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new CodeGame(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public CodeGame getCodeByCodeID(String codeID) {
        try {
            String sql = "SELECT CodeID, GameID , Code, Status FROM GameCode WHERE CodeID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, codeID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new CodeGame(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateCode(String code, int status, String codeID) {
        try {
            String sql = "UPDATE GameCode SET Code = ?, Status = ? WHERE CodeID = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, code);
            st.setInt(2, status);
            st.setString(3, codeID);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateGame(int gameID, String gameName, String gameGenre, String publisher, float price, String description, String os, String processor, String memory, String graphics, String directX, String network, String storage, String releaseDay, String image1, String image2, String image3, String image4, String link) {
        try {
            String sql = "UPDATE Game SET GameName = ?,GameGenre = ?,Publisher = ?,Price = ?,[Description] = ?,OS = ?,Processor = ?,Memory = ?,Graphics = ?,DirectX = ?,Network = ?,Storage = ?,ReleaseDay = ?\n"
                    + "WHERE GameID = ?;\n"
                    + "UPDATE ImgOfGame SET image1 = ?,image2 = ?,image3 = ?,image4 = ?,link = ?\n"
                    + "WHERE GameID = ?;";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, gameName);
            st.setString(2, gameGenre);
            st.setString(3, publisher);
            st.setFloat(4, price);
            st.setString(5, description);
            st.setString(6, os);
            st.setString(7, processor);
            st.setString(8, memory);
            st.setString(9, graphics);
            st.setString(10, directX);
            st.setString(11, network);
            st.setString(12, storage);
            st.setString(13, releaseDay);
            st.setInt(14, gameID);
            st.setString(15, "img/Game/" + image1);
            st.setString(16, "img/Game/" + image2);
            st.setString(17, "img/Game/" + image3);
            st.setString(18, "img/Game/" + image4);
            st.setString(19, link);
            st.setInt(20, gameID);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public ArrayList<CodeGame> getCodeByName(String name) {
        ArrayList<CodeGame> listN = new ArrayList<>();
        try {
            String sql = "SELECT c.CodeID, c.Code, c.Status FROM Game G JOIN GameCode c ON G.GameID = c.GameID WHERE G.GameName = ?;";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listN.add(new CodeGame(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listN;
    }

    public GameDetail getGameByName(String gameName) {
        try {
            String sql = "SELECT G.GameID, G.GameName, G.GameGenre, G.Publisher, G.Price, G.Description, G.OS, G.Processor, G.Memory, G.Graphics, G.DirectX, G.Network, G.Storage, G.ReleaseDay,\n"
                    + "       I.image1, I.image2, I.image3, I.image4, I.link\n"
                    + "FROM Game G\n"
                    + "JOIN ImgOfGame I ON G.GameID = I.GameID\n"
                    + "WHERE G.GameName = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, gameName);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new GameDetail(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUserById(int userID) {
        try {
            String sql = "select UserID, FullName, UserName, [Password], Email, UserRole, [Status], PhoneNumber, Code from [User] where UserID= ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addNewGame(GameDetail g) {
        try {
            String sql = "INSERT INTO [dbo].[Game] ([GameID], [GameName], [GameGenre], [Publisher], [Price], [Description], [OS], [Processor], [Memory], [Graphics], [DirectX], [Network], [Storage], [ReleaseDay])\n"
                    + "VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, g.getGameID());
            st.setString(2, g.getGameName());
            st.setString(3, g.getGameGenre());
            st.setString(4, g.getPublisher());
            st.setFloat(5, g.getPrice());
            st.setString(6, g.getDescription());
            st.setString(7, g.getOs());
            st.setString(8, g.getProcessor());
            st.setString(9, g.getMemory());
            st.setString(10, g.getGraphics());
            st.setString(11, g.getDirectX());
            st.setString(12, g.getNetwork());
            st.setString(13, g.getStorage());
            st.setString(14, g.getReleaseDay());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void addNewGameImg(GameDetail g) {//, 
        try {
            String sql = "INSERT INTO [dbo].[ImgOfGame] ([GameID], [image1], [image2], [image3], [image4], [link])\n"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, g.getGameID());
            st.setString(2, "img/Game/" + g.getImage1());
            st.setString(3, "img/Game/" + g.getImage2());
            st.setString(4, "img/Game/" + g.getImage3());
            st.setString(5, "img/Game/" + g.getImage4());
            st.setString(6, g.getLink());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void addNewCode(CodeGame cg) {//, 
        try {
            String sql = "INSERT INTO [dbo].[GameCode] ([CodeID], [GameID], [Code], [Status]) VALUES (?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cg.getCodeID());
            st.setInt(2, cg.getGameID());
            st.setString(3, cg.getCode());
            st.setInt(4, cg.getStatus());
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public GameDetail checkGameID(int gameID) {
        try {
            String sql = "SELECT TOP (1000)\n"
                    + "      [GameName]\n"
                    + "      ,[GameGenre]\n"
                    + "      ,[Publisher]\n"
                    + "      ,[Price]\n"
                    + "      ,[Description]\n"
                    + "      ,[OS]\n"
                    + "      ,[Processor]\n"
                    + "      ,[Memory]\n"
                    + "      ,[Graphics]\n"
                    + "      ,[DirectX]\n"
                    + "      ,[Network]\n"
                    + "      ,[Storage]\n"
                    + "      ,[ReleaseDay]\n"
                    + "  FROM [WebProject].[dbo].[Game]\n"
                    + "  Where GameID = ?\n"
                    + "\n"
                    + "  ";
            PreparedStatement st = connection.prepareCall(sql);
            st.setInt(1, gameID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                GameDetail gd = new GameDetail(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
                return gd;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public GameDetail checkGameName(String gameName) {
        try {
            String sql = "SELECT TOP (1000)\n"
                    + "      [GameName]\n"
                    + "      ,[GameGenre]\n"
                    + "      ,[Publisher]\n"
                    + "      ,[Price]\n"
                    + "      ,[Description]\n"
                    + "      ,[OS]\n"
                    + "      ,[Processor]\n"
                    + "      ,[Memory]\n"
                    + "      ,[Graphics]\n"
                    + "      ,[DirectX]\n"
                    + "      ,[Network]\n"
                    + "      ,[Storage]\n"
                    + "      ,[ReleaseDay]\n"
                    + "  FROM [WebProject].[dbo].[Game]\n"
                    + "  Where GameName = ?\n"
                    + "\n"
                    + "  ";
            PreparedStatement st = connection.prepareCall(sql);
            st.setString(1, gameName);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                GameDetail gd = new GameDetail(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13));
                return gd;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public ArrayList<GamePopular> getRelatedGame() {
        ArrayList<GamePopular> listR = new ArrayList<>();
        try {
            String sql = "SELECT g.GameID, g.GameName, g.GameGenre, g.Price, Img.image1 FROM ImgOfGame Img INNER JOIN Game g ON Img.GameID = g.GameID WHERE SUBSTRING(g.ReleaseDay, 4, 7) > '2017-01-01'";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listR.add(new GamePopular(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listR;
    }

    public ArrayList<GamePopular> getSearchByName(String search) {
        ArrayList<GamePopular> list = new ArrayList<>();
        try {
            String sql = "SELECT g.GameID, g.GameName, g.GameGenre, g.Price, i.image1\n"
                    + "FROM Game g\n"
                    + "INNER JOIN ImgOfGame i ON g.GameID = i.GameID\n"
                    + "WHERE g.GameName LIKE ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new GamePopular(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return list;
    }

    public ArrayList<GamePopular> getLikeGame() {
        ArrayList<GamePopular> listL = new ArrayList<>();
        try {
            String sql = "SELECT TOP 6\n"
                    + "    G.GameID,\n"
                    + "    G.GameName,\n"
                    + "    G.GameGenre,\n"
                    + "    G.Price,\n"
                    + "    I.image1\n"
                    + "FROM\n"
                    + "    [dbo].[Game] G\n"
                    + "INNER JOIN\n"
                    + "    [dbo].[ImgOfGame] I ON G.GameID = I.GameID\n"
                    + "WHERE\n"
                    + "    G.GameID IN (\n"
                    + "        SELECT GameID\n"
                    + "        FROM [dbo].[GameCode]\n"
                    + "        WHERE Status = 0\n"
                    + "    )\n"
                    + "ORDER BY\n"
                    + "    (SELECT COUNT(*) FROM [dbo].[GameCode] WHERE GameID = G.GameID AND Status = 0) DESC;";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listL.add(new GamePopular(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return listL;
    }

    public void updatestatus(User user) {
        String sql = "UPDATE [dbo].[User] SET [Status]= ?, [Code] = ? WHERE [Email] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user.getStatus());
            st.setString(2, user.getCode());
            st.setString(3, user.getEmail());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateUserStatus(int status, String code, int userID) {
        String sql = "UPDATE [dbo].[User] SET [Status]= ?, [Code] = ? WHERE [UserID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setString(2, code);
            st.setInt(3, userID);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean checkExistUserName(String username) {
        boolean duplicate = false;

        String sql = "Select * From [dbo].[User] where [UserName] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                duplicate = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return duplicate;
    }

    public void insertregister(User user) {
        try {
            String sql = "INSERT INTO [dbo].[User] ([UserID], [FullName], [UserName], [Password], [PhoneNumber], [Email], [UserRole], [Status], [Code]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user.getUserID());
            st.setString(2, user.getFullName());
            st.setString(3, user.getUserName());
            st.setString(4, user.getPassword());
            st.setString(5, user.getPhone());
            st.setString(6, user.getEmail());
            st.setString(7, user.getUserRole());
            st.setInt(8, user.getStatus());
            st.setString(9, user.getCode());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        try {
            String sql = "Select * From [dbo].[User] where [Email] = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                duplicate = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return duplicate;
    }

    public boolean register(String userName, String password, String email, String phone, String code) {
        if (checkExistEmail(email)) {
            return false;
        }
        if (checkExistUserName(userName)) {
            return false;
        }
        int userID = 7;
        insertregister(new User(userID++, null, userName, password, email, "User", 0, phone, code));
        return true;
    }

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e1) {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }

    public boolean checkEmail(String email) {
        return checkExistEmail(email);
    }

    public boolean checkUserName(String userName) {
        return checkExistUserName(userName);
    }

    public void updateStatus(User user) {
        updatestatus(user);
    }
}
