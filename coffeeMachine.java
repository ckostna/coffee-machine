import java.util.Scanner;

public class coffeeMachine {
    static boolean stop;
    static int totalWater = 400;
    static int totalMilk = 540;
    static int totalBeans = 120;
    static int totalCups = 9;
    static int totalMoney = 550;

    public static void main(String[] args) {
        stop = false;
        while(!stop){
            coffeeActions();
            System.out.println("");
        }
    }

    public static void coffeeProcess(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public static void changeCoffeeInventory(int w, int mil, int b, int c, int mon){
        totalWater += w;
        totalMilk += mil;
        totalBeans += b;
        totalCups += c;
        totalMoney += mon;
    }

    public static void printCoffeeMachineInventory(){
        System.out.println("The coffee machine has:");
        System.out.println(totalWater + " of water");
        System.out.println(totalMilk + " of milk");
        System.out.println(totalBeans + " of beans");
        System.out.println(totalCups + " of cups");
        System.out.println(totalMoney + " of money");
    }

    public static void coffeeActions(){
        Scanner user = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = user.next();
        System.out.println("");
        switch(action){
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String type = user.next();
                System.out.println("");
                switch(type){
                    case "1":
                        if(totalWater < 250){
                            System.out.println("Sorry, not enough water!");
                        }
                        else if(totalBeans < 16){
                            System.out.println("Sorry, not enough beans!");
                        }
                        else if(totalCups < 1){
                            System.out.println("Sorry, not enough cups!");
                        }
                        else{
                            System.out.println("I have enough resources, making you a coffee!");
                            changeCoffeeInventory(-250, 0, -16, -1, 4);
                        }
                        break;
                    case "2":
                        if(totalWater < 350){
                            System.out.println("Sorry, not enough water!");
                        }
                        else if(totalMilk < 75){
                            System.out.println("Sorry, not enough milk!");
                        }
                        else if(totalBeans < 20){
                            System.out.println("Sorry, not enough beans!");
                        }
                        else if(totalCups < 1){
                            System.out.println("Sorry, not enough cups!");
                        }
                        else{
                            System.out.println("I have enough resources, making you a coffee!");
                            changeCoffeeInventory(-350, -75, -20, -1, 7);
                        }
                        break;
                    case "3":
                        if(totalWater < 200){
                            System.out.println("Sorry, not enough water!");
                        }
                        else if(totalMilk < 100){
                            System.out.println("Sorry, not enough milk!");
                        }
                        else if(totalBeans < 12){
                            System.out.println("Sorry, not enough beans!");
                        }
                        else if(totalCups < 1){
                            System.out.println("Sorry, not enough cups!");
                        }
                        else{
                            System.out.println("I have enough resources, making you a coffee!");
                            changeCoffeeInventory(-200, -100, -12, -1, 6);
                        }
                        break;
                    case "back":
                        coffeeActions();
                        break;
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                int addWater = user.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int addMilk = user.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int addBeans = user.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int addCups = user.nextInt();
                changeCoffeeInventory(addWater, addMilk, addBeans, addCups, 0);
                break;
            case "take":
                System.out.println("I gave you $" + totalMoney);
                totalMoney = 0;
                break;
            case "remaining":
                printCoffeeMachineInventory();
                break;
            case "exit":
                stop = true;
                break;
        }
    }

    public static void canMakeCoffee(){
        Scanner values = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int currWater = values.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int currMilk = values.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int currBeans = values.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int neededCups = values.nextInt();
        int cupsAvailable = Math.min(Math.min(currWater / 200, currMilk / 50), currBeans / 15);
        if(neededCups == cupsAvailable){
            System.out.println("Yes, I can make that amount of coffee");
        }
        else if(cupsAvailable > neededCups){
            System.out.println("Yes, I can make that amount of coffee (and even " + (cupsAvailable - neededCups) + " more than that)");
        }
        else{
            System.out.println("No, I can make only " + cupsAvailable + " cup(s) of coffee");
        }
    }

    public static void ingredientsNeeded(){
        Scanner input = new Scanner(System.in);
        int cups = input.nextInt();
        int water = 200 * cups;
        int milk = 50 * cups;
        int coffeeBeans = 15 * cups;
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }
}
