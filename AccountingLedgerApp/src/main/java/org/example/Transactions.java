package org.example;

    public class Transactions {
    private String date;
    private String time;
    private String desc;
    private String vendor;
    private double amount;

    public Transactions(String date, String time, String desc, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
        public String toString(){
        return String.format("%s | %s | %s | %s | %.2f",
                this.getDate(), this.getTime(), this.getDesc(), this.getVendor(), this.getAmount());
    }
}
