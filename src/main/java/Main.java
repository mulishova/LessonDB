import Lesson2.DBConn;
import Lesson2.User;
import Lesson2.dao.UsersDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println(DBConn.getInstance().connection());
        /*DBConn
                .getInstance()
                .connection()
                .prepareStatement("create TABLE USERS ( " +
                        " LOGIN VARCHAR(30) UNIQUE NOT NULL, " +
                        " PASS VARCHAR(10) NOT NULL, " +
                        " NICK VARCHAR(10) UNIQUE NOT NULL " +
                        " );").execute();*/

        /*UsersDAO usersDAO = new UsersDAO();
        DBConn.getInstance().connection().setAutoCommit(false);

        try {
            usersDAO.addUser(new User("l", "p", "n"));
            usersDAO.addUser(new User("ll", "pp", "nn"));
            DBConn.getInstance().connection().commit();
        } catch (Throwable e) {
            e.printStackTrace();
            DBConn.getInstance().connection().rollback();
        }*/

        //System.out.println(usersDAO.getUserByNick("nn"));
        //System.out.println(usersDAO.getAllUser());
    }
}