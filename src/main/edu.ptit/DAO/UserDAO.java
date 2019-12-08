package DAO;
import DAO.DAO;
import modul.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {
    final private String database = "LTM";
    public UserDAO(){
        super();
    }

    public User CheckUser(String username, String password){
    	User user = null;
        String sql = "select * from tblthanhvien where username = ? and password = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            if(rs.next()) {
            	user = new User();
            	user.setId(rs.getInt(1));
            	user.setUsername(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setRole(rs.getString(4));
            	user.setName(rs.getString(5));
            	user.setAddress(rs.getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public User getUser(int id){
        User user = null;
        String sql = "select * from tblthanhvien where id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRole(rs.getString(4));
                user.setName(rs.getString(5));
                user.setAddress(rs.getString(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }

//    public static void main(String[] args) throws Exception {
//    	UserDAO test = new UserDAO();
//        System.out.println(test.CheckUser("admin", "123456").toString());
//    }
}
