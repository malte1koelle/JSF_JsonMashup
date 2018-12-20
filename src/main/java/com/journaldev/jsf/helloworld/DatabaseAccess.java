package com.journaldev.jsf.helloworld;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class DatabaseAccess {

    private static final long serialVersionUID = 6081417964063918994L;

    public List<String> getGifs() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSF_Mashup?useSSL=false", "root", "root");
        Statement stmt = conn.createStatement();

        List<String> list = new ArrayList<>();

        ResultSet resultSet = stmt.executeQuery("SELECT * FROM favourite_gifs");
        while (resultSet.next()) {
            list.add(resultSet.getString("url"));
        }
        return list;
    }

    public void setNewLikedGif(String url) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSF_Mashup?useSSL=false", "root", "root");
        Statement stmt = conn.createStatement();

        String isLiked = checkIfGifIsAlreadyLiked(url);
        if(isLiked.equals("../resources/img/liked.png")){
            stmt.execute("DELETE FROM favourite_gifs WHERE url='"+url+"';");
        }else{
            stmt.execute("INSERT INTO favourite_gifs (url) VALUES ('" + url + "');");
        }
    }

    public String checkIfGifIsAlreadyLiked(String url) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JSF_Mashup?useSSL=false", "root", "root");
        Statement stmt = conn.createStatement();

        ResultSet resultSet = stmt.executeQuery("SELECT * FROM favourite_gifs WHERE url='" + url + "';");
        while (resultSet.next()) {
            return "../resources/img/liked.png";
        }
        return "../resources/img/unliked.png";
    }
}
