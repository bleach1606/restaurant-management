package modul;

public class Ordering {
    private int id;
    private Bok_Order_Bill book_order_bill;
    private Food food;
    private Combo combo;
    private int quantityFood;
    private int quantityCombo;

    public Ordering() {
    }

    public Ordering(int id, Bok_Order_Bill book_order_bill, Food food, Combo combo, int quantityFood, int quantityCombo) {
        this.id = id;
        this.book_order_bill = book_order_bill;
        this.food = food;
        this.combo = combo;
        this.quantityFood = quantityFood;
        this.quantityCombo = quantityCombo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bok_Order_Bill getBook_order_bill() {
        return book_order_bill;
    }

    public void setBook_order_bill(Bok_Order_Bill book_order_bill) {
        this.book_order_bill = book_order_bill;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public int getQuantityFood() {
        return quantityFood;
    }

    public void setQuantityFood(int quantityFood) {
        this.quantityFood = quantityFood;
    }

    public int getQuantityCombo() {
        return quantityCombo;
    }

    public void setQuantityCombo(int quantityCombo) {
        this.quantityCombo = quantityCombo;
    }

    @Override
    public String toString() {
        return "Ordering{" +
                "id=" + id +
                ", book_order_bill=" + book_order_bill +
                ", food=" + food +
                ", combo=" + combo +
                ", quantityFood=" + quantityFood +
                ", quantityCombo=" + quantityCombo +
                '}';
    }
}
