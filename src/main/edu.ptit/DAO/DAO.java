package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
    protected static Connection connect;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    final private String host = "118.70.125.195:43306";
//    final private String host = "localhost";
    final private String user = "root";
//    final private String passwd = "";
    final private String passwd = "11223344";
    final private String database = "LTM";

    public DAO(Connection connect, Statement statement, PreparedStatement preparedStatement, ResultSet resultSet) {
        this.connect = connect;
        this.statement = statement;
        this.preparedStatement = preparedStatement;
        this.resultSet = resultSet;
    }

    public DAO() {
    	try {
			connectToDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }



    public void connectToDB() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
                    + database + "?" + "user=" + user + "&password=" + passwd);
        } catch (Exception e) {
            throw e;
        }
    }

}
