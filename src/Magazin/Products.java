package Magazin;

public class Products{
    private String name;
    private int amount;
    private int cost;

    Products(String name, int amount, int cost) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
    }

    Products(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.amount = 1;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getCost() {
        return cost;
    }
}
