package DTO;

import modul.Combo;
import modul.Food;
import modul.Table;
import modul.User;

import java.util.ArrayList;

public class Reception {
    private User user;
    private ArrayList<Table> tables;
    private ArrayList<Food> foods;
    private ArrayList<Combo> combos;

    public Reception(User user, ArrayList<Table> tables, ArrayList<Food> foods, ArrayList<Combo> combos) {
        this.user = user;
        this.tables = tables;
        this.foods = foods;
        this.combos = combos;
    }

    public Reception() {
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Combo> getCombos() {
        return combos;
    }

    public void setCombos(ArrayList<Combo> combos) {
        this.combos = combos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "Reception{" +
                "user=" + user +
                ", tables=" + tables +
                '}';
    }
}
