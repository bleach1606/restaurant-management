package DTO;

import modul.NhaCungCap;
import modul.User;

import java.util.ArrayList;

public class StockDTO {
    private String token;
    private User user;
    private ArrayList<NhaCungCap> nhaCungCaps;

    public StockDTO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public StockDTO(User user, ArrayList<NhaCungCap> nhaCungCaps) {
        this.user = user;
        this.nhaCungCaps = nhaCungCaps;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<NhaCungCap> getNhaCungCaps() {
        return nhaCungCaps;
    }

    public void setNhaCungCaps(ArrayList<NhaCungCap> nhaCungCaps) {
        this.nhaCungCaps = nhaCungCaps;
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "user=" + user +
                ", nhaCungCaps=" + nhaCungCaps +
                '}';
    }
}
