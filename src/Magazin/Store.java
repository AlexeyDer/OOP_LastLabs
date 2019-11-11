package Magazin;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Store {

    public static void main(String[] args) {
        int n = 6;
        int revenue = 0; // выручка
        Random rand = new Random();

        Products[] products = new Products[n];
        String[] storage = new String[n];
        Buyer buyer = new Buyer();
        buyer.setBag(new ArrayList<>());

        storage[0] = "milk";
        storage[1] = "bread";
        storage[2] = "guns";
        storage[3] = "water";
        storage[4] = "sandiches";
        storage[5] = "apples";


        for (int i = 0; i < n; i++) {
            int cost = rand.nextInt(20) + 1;
            int amount = rand.nextInt(10) + 1;
            products[i] = new Products(storage[i], amount, cost);
        }

        Scanner sc = new Scanner(System.in);
        int c = 0;


        while (true) {
            System.out.println("----------------------M-E-N-U-------------------------------");
            System.out.println("1.Store");
            System.out.println("2.Buyer");
            System.out.println("3.Give some cash to Buyer");
            System.out.println("0.Exit");
            c = sc.nextInt();

            switch (c) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("---------------------S-T-O-R-E------------------------------");
                    System.out.println("Выручка: " + revenue);
                    System.out.println("\t Продукт\tКоличество\tСтоимость");
                    for (int i = 0; i < n; i++) {
                        if (products[i].getAmount() != 0) {
                            System.out.println("-----------------------------------------------------------------------");
                            System.out.println(i + ".\t" + products[i].getName() + "\t" + products[i].getAmount() + "\t" + products[i].getCost());
                        }
                    }

                    System.out.println("Want to buy or sell some one?");
                    System.out.println("1.Buy");
                    System.out.println("2.Sell");
                    System.out.println("3.Go to menu!");
                    System.out.println("\n0.Exit");

                    try {
                        c = sc.nextInt();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    switch (c) {
                        case 1:
                            System.out.println("Select what do you want!");
                            int a = 0;
                            try {
                                a = sc.nextInt();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                            for (int i = 0; i < n; i++) {
                                if (i == a) {
                                    if (products[i].getAmount() != 0) {
                                        if (buyer.getCash() >= products[i].getCost()) {
                                            buyer.setCash(buyer.getCash() - products[i].getCost());
                                            revenue += products[i].getCost();

                                            boolean b = true;
                                            for (int j = 0; j < buyer.getBag().size(); j++) {
                                                if (buyer.getBag().get(j).getName() == products[i].getName()) {
                                                    buyer.getBag().get(j).setAmount(buyer.getBag().get(j).getAmount() + 1);
                                                    b = false;
                                                }
                                            }
                                            if (b) {
                                                buyer.getBag().add(new Products(products[i].getName(), 1, products[0].getCost() / 2));
                                            }
                                            products[i].setAmount(products[i].getAmount() - 1);
                                        } else {
                                            System.out.println("You don't have that much money!");
                                        }
                                    } else {
                                        System.out.println("Dont't have this product!");
                                    }
                                    break;
                                }
                            }
                            break;
                            
                        case 2:
                            System.out.println("Bag: ");

                            if (buyer.getBag().size() == 0) {
                                System.out.println("Nothing to sell!");
                                break;
                            }
                            for (int i = 0; i < buyer.getBag().size(); i++) {
                                System.out.println(i + ". " + buyer.getBag().get(i).getName() + " "
                                        + buyer.getBag().get(i).getAmount() + " "
                                        + buyer.getBag().get(i).getCost());
                            }

                            System.out.println("Sell some one: " );
                            int numSell = -1;
                            
                            try {
                                numSell = sc.nextInt();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            

                            for (int i = 0; i < buyer.getBag().size(); i++) {
                                if (i == numSell) {
                                    if (buyer.getBag().get(i).getAmount() == 1) {
                                        revenue -= buyer.getBag().get(i).getCost();
                                        buyer.setCash(buyer.getCash() + buyer.getBag().get(i).getCost());

                                        for(int k = 0; k < n; k++) {
                                            if (products[k].getName() == buyer.getBag().get(i).getName()){
                                                products[k].setAmount(products[k].getAmount() + 1);
                                            }
                                        }
                                        buyer.getBag().remove(i);
                                    } else {
                                        revenue -= buyer.getBag().get(i).getCost();
                                        buyer.setCash(buyer.getCash() + buyer.getBag().get(i).getCost());

                                        for(int k = 0; k < n; k++) {
                                            if (products[k].getName() == buyer.getBag().get(i).getName()){
                                                products[k].setAmount(products[k].getAmount() + 1);
                                                buyer.getBag().get(i).setAmount(buyer.getBag().get(i).getAmount() - 1);
                                            }
                                        }
                                    }

                                }
                            }


                            break;
                        case 0:
                            System.exit(0);
                    }


                    break;
                case 2:
                    System.out.println("---------------------B-U-Y-E-R------------------------------");
                    System.out.println("Cash: " + buyer.getCash());
                    System.out.println("Bag: ");

                    for (int i = 0; i < buyer.getBag().size(); i++) {
                        System.out.println(i + ". " + buyer.getBag().get(i).getName() + " "
                                + buyer.getBag().get(i).getAmount() + " "
                                + buyer.getBag().get(i).getCost());
                    }
                    break;
                case 3:
                    System.out.println("Input. How much buyer is earned?");
                    buyer.setCash(sc.nextInt());
                    break;
                default:
                    System.out.println("Try again!");
            }
        }


    }

}
