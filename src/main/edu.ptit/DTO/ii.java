package DTO;

public class ii {
    private Integer x;
    private Integer y;

    public ii(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public ii() {
    }

    @Override
    public String toString() {
        return "ii{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
