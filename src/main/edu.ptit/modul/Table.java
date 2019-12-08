package modul;

public class Table {
    private int id;
    private String nameTable;
    private int quantitySeat;
    private String description;
    private String status;

    public Table() {
    }

    public Table(int id, String nameTable, int quantitySeat, String description, String status) {
        this.id = id;
        this.nameTable = nameTable;
        this.quantitySeat = quantitySeat;
        this.description = description;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public int getQuantitySeat() {
        return quantitySeat;
    }

    public void setQuantitySeat(int quantitySeat) {
        this.quantitySeat = quantitySeat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", nameTable='" + nameTable + '\'' +
                ", quantitySeat=" + quantitySeat +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
