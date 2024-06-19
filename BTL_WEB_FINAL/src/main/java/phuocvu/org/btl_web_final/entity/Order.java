package phuocvu.org.btl_web_final.entity;

public class Order {
    private int id;
    private String data;
    private int cusid;
    private double totalmoney;

    public Order() {
    }

    public Order(int id, String data, int cusid, double totalmoney) {
        this.id = id;
        this.data = data;
        this.cusid = cusid;
        this.totalmoney = totalmoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }
}
