package DTO;

import modul.ComboOrder;
import modul.FoodOrder;
import modul.User;

import java.util.ArrayList;

public class KitchenDTO {

    private User user;
    private ArrayList<FoodOrder> foodOrders;
    private ArrayList<ComboOrder> comboOrders;

    public KitchenDTO(User user, ArrayList<FoodOrder> foodOrders, ArrayList<ComboOrder> comboOrders) {
        this.user = user;
        this.foodOrders = foodOrders;
        this.comboOrders = comboOrders;
    }

    public KitchenDTO() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<FoodOrder> getFoodOrders() {
        return foodOrders;
    }

    public void setFoodOrders(ArrayList<FoodOrder> foodOrders) {
        this.foodOrders = foodOrders;
    }

    public ArrayList<ComboOrder> getComboOrders() {
        return comboOrders;
    }

    public void setComboOrders(ArrayList<ComboOrder> comboOrders) {
        this.comboOrders = comboOrders;
    }

    @Override
    public String toString() {
        return "Kitchen{" +
                "user=" + user +
                ", foodOrders=" + foodOrders +
                ", comboOrders=" + comboOrders +
                '}';
    }
}
