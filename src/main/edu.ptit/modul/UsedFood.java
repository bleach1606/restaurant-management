package modul;

public class UsedFood {
    private int id;
    private Food food;
    private int number;

    public UsedFood(int id, Food food, int number) {
        this.id = id;
        this.food = food;
        this.number = number;
    }

    public UsedFood() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "UsedFood{" +
                "id=" + id +
                ", food=" + food +
                ", number=" + number +
                '}';
    }
}
