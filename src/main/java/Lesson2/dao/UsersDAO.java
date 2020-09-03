package Lesson2.dao;

import Lesson2.DBConn;
import Lesson2.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private PreparedStatement ps = null;

    public void addUser(User user) throws SQLException {
        ps = DBConn
                .getInstance()
                .connection()
                .prepareStatement("INSERT INTO users (login, pass, nick) VALUES (?, ?, ?)");
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getPass());
        ps.setString(3, user.getNick());
        int a = ps.executeUpdate();
    }

    public User getUserByNick(String nick) throws SQLException {
        ps = DBConn
                .getInstance()
                .connection()
                .prepareStatement("SELECT * FROM users WHERE nick = ?");
        ps.setString(1, nick);
        ResultSet set = ps.executeQuery();

        User user = new User();

        if (set.next()) {
            user.setLogin(set.getString("LOGIN"));
            user.setPass("PASS");
            user.setNick("NICK");
        }

        return user;
    }

    public List<User> getAllUser() throws SQLException {
        List<User> list = new ArrayList<User>(2);

        ps = DBConn
                .getInstance()
                .connection()
                .prepareStatement("SELECT * FROM users");

        ResultSet set = ps.executeQuery();

        while (set.next()) {
            User user = new User();
            user.setLogin(set.getString("LOGIN"));
            user.setPass("PASS");
            user.setNick("NICK");
            list.add(user);
        }

        return null;
    }
}
