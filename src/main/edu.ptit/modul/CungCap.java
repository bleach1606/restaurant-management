package modul;

public class CungCap {
    private int nguyenLieuID;
    private int nccID;

    public CungCap(int nguyenLieuID, int nccID) {
        this.nguyenLieuID = nguyenLieuID;
        this.nccID = nccID;
    }

    public CungCap() {
    }

    public int getNguyenLieuID() {
        return nguyenLieuID;
    }

    public void setNguyenLieuID(int nguyenLieuID) {
        this.nguyenLieuID = nguyenLieuID;
    }

    public int getNccID() {
        return nccID;
    }

    public void setNccID(int nccID) {
        this.nccID = nccID;
    }

    @Override
    public String toString() {
        return "CungCap{" +
                "nguyenLieuID=" + nguyenLieuID +
                ", nccID=" + nccID +
                '}';
    }
}
