package appli.todolistjx.repository;

import appli.todolistjx.model.User;
import appli.todolistjx.utils.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.Objects;

public class UserRepository {
    public static User userConnected;

    public static User login(String mail, String mdp) throws SQLException {
        Connection conn = Database.connectDatabase();
        PreparedStatement requete = conn.prepareStatement(
                "SELECT * FROM user WHERE mail = ? AND mdp = ?"
        );
        requete.setString(1, mail);
        requete.setString(2, mdp);
        ResultSet sqlUser = requete.executeQuery();
        while(sqlUser.next()){
            if(Objects.equals(mail, sqlUser.getString("mail")) && Objects.equals(mdp, sqlUser.getString("mdp"))){
                System.out.println("ok");
                User user = new User(sqlUser.getInt("id"), sqlUser.getString("mail"), sqlUser.getString("mdp"));
                return user;
            }
            else{
                System.out.println("Mot de passe ou mail incorrect !!!");
                return null;
            }
        }
        return null;
    }
    public static void register(String mail, String mdp) throws SQLException {
        Connection conn = Database.connectDatabase();
        PreparedStatement requete_insert = conn.prepareStatement(
                "INSERT INTO `user`( `mail`, `mdp`) VALUES (?,?)"
        );
        requete_insert.setString(1,mail);
        requete_insert.setString(2,mdp);
        requete_insert.executeUpdate();


    }
}
