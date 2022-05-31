package inclassdemos.midterm.probpart2sec5;

public class Monthly extends Service{

    @Override
    double calcFee() {
        return getDaily_Price() * 30;
    }
}
