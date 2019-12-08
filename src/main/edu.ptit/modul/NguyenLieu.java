package modul;

public class NguyenLieu {
    private int id;
    private String tenNL;
    private String donVi;
    private int donGia;
    private String moTa;

    public NguyenLieu(int id, String tenNL, String donVi, int donGia, String moTa) {
        this.id = id;
        this.tenNL = tenNL;
        this.donVi = donVi;
        this.donGia = donGia;
        this.moTa = moTa;
    }

    public NguyenLieu(String tenNL, String donVi, int donGia, String moTa) {
        this.tenNL = tenNL;
        this.donVi = donVi;
        this.donGia = donGia;
        this.moTa = moTa;
    }

    public NguyenLieu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "NguyenLieu{" +
                "id=" + id +
                ", tenNL='" + tenNL + '\'' +
                ", donVi='" + donVi + '\'' +
                ", donGia=" + donGia +
                ", moTa='" + moTa + '\'' +
                '}';
    }
}

