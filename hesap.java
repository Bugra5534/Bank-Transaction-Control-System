abstract class hesap {
    protected String musteriAdi;
    protected int hesapNumarasi;
    protected double bakiye;

    public hesap(String musteriAdi, int hesapNumarasi) {
        this.musteriAdi = musteriAdi;
        this.hesapNumarasi = hesapNumarasi;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public int getHesapNumarasi() {
        return hesapNumarasi;
    }
}
class cariHesabi extends hesap {
    public cariHesabi(String musteriAdi, int hesapNumarasi) {
        super(musteriAdi, hesapNumarasi);
    }
}
class tasarrufHesabi extends hesap {
    public tasarrufHesabi(String musteriAdi, int hesapNumarasi) {
        super(musteriAdi, hesapNumarasi);
    }
}