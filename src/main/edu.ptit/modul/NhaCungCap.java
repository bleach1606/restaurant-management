package modul;

public class NhaCungCap {
    private int id;
    private String ten;
    private String diaChi;
    private String sdt;
    private String mota;

    public NhaCungCap() {
    }

    public NhaCungCap(int id, String ten, String diaChi, String sdt, String mota) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" + "id=" + id + ", ten=" + ten + ", diaChi=" + diaChi + ", sdt=" + sdt + ", mota=" + mota + '}';
    }

    
}
