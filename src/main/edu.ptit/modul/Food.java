package modul;

public class Food {
    private int id;
    private String name;
    private int value;
    private String unit;
    private String description;
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Food(int id, String name, int value, String unit, String description, String avatar) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.unit = unit;
        this.description = description;
        this.avatar = avatar;
    }

    public Food() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
