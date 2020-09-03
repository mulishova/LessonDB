package Server.Service;

import Lesson2.DBConn;
import Lesson2.dao.UsersDAO;
import Server.Inter.AuthService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AuthServiceImpl implements AuthService {

    private List<UserEntity> usersList;

    public AuthServiceImpl(UsersDAO usersDAO) throws SQLException {
        usersList = new LinkedList<>();

        PreparedStatement ps = DBConn.getInstance().connection().prepareStatement("SELECT * FROM users");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            usersList.add(new UserEntity(rs));
        }

        //this.usersList.add(new UserEntity("login1", "pass1", "nick1"));
        //this.usersList.add(new UserEntity("login2", "pass2", "nick2"));
        //this.usersList.add(new UserEntity("login3", "pass3", "nick3"));
    }

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public String getNick(String login, String password) {
        for (UserEntity u : usersList) {

            if (u.login.equals(login) && u.password.equals(password)) {
                return u.nick;
            }

        }
        return null;
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");

    }

    private class UserEntity {
        private String login;
        private String password;
        private String nick;

        public UserEntity(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }

        public UserEntity (ResultSet rs) throws SQLException {
            if (rs != null) {
                this.login = rs.getString("login");
                this.password = rs.getString("password");
                this.nick = rs.getString("nick");
            }
        }
    }
}