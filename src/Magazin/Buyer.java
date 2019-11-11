package Magazin;

import java.util.List;

public class Buyer {
    private int cash;
    private List<Products>bag;


    public void setBag(List<Products> bag) {
        this.bag = bag;
    }

    public List<Products> getBag() {
        return bag;
    }

    Buyer(int startCash) {
        this.cash = startCash;
    }

    Buyer () {
        this.cash = 0;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

}
