package inclassdemos.midterm.probpart2sec5;


public abstract class Service {
    private int daily_Price;

    public int getDaily_Price() {
        return daily_Price;
    }

    public void setDaily_Price(int daily_Price) {
        this.daily_Price = daily_Price;
    }



    abstract double calcFee();
}
