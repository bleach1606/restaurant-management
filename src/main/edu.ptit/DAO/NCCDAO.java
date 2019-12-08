package DAO;

import modul.NhaCungCap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NCCDAO extends DAO{

    public NCCDAO() {
        super();
    }

    public ArrayList<NhaCungCap> getALl() {
        String sql = "SELECT * FROM `tblnhacungcap`";
        ArrayList<NhaCungCap> nhaCungCaps = null;
        try{
            nhaCungCaps = new ArrayList<>();
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setId(rs.getInt(1));
                nhaCungCap.setTen(rs.getString(2));
                nhaCungCap.setDiaChi(rs.getString(3));
                nhaCungCap.setSdt(rs.getString(4));
                nhaCungCap.setMota(rs.getString(5));
                nhaCungCaps.add(nhaCungCap);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nhaCungCaps;

    }
}
