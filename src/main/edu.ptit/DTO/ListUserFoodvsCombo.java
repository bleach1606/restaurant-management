package DTO;

import modul.ComboOrder;
import modul.FoodOrder;

import java.util.ArrayList;

public class ListUserFoodvsCombo {
    private ArrayList<FoodOrder> foodOrders;
    private ArrayList<ComboOrder> comboOrders;

    public ListUserFoodvsCombo(ArrayList<FoodOrder> foodOrders, ArrayList<ComboOrder> comboOrders) {
        this.foodOrders = foodOrders;
        this.comboOrders = comboOrders;
    }

    public ListUserFoodvsCombo() {
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
        return "listUserFoodvsCombo{" +
                "foodOrders=" + foodOrders +
                ", comboOrders=" + comboOrders +
                '}';
    }
}
