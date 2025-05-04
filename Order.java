
import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer);
        this.beverages = new ArrayList<>();
        this.orderNo = generateOrder();
    }

    private int generateOrder() {
        return (int)(Math.random() * 80000) + 10000;
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

    public int getTotalItems() {
        return beverages.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderNo)
          .append(", Time: ").append(orderTime)
          .append(", Day: ").append(orderDay)
          .append(", Customer: ").append(customer)
          .append("\nBeverages:\n");
        
        for (Beverage beverage : beverages) {
            sb.append("- ").append(beverage).append("\n");
        }
        
        sb.append("Total: $").append(String.format("%.2f", calcOrderTotal()));
        return sb.toString();
    }

    // Getters
    public int getOrderNo() { return orderNo; }
    public int getOrderTime() { return orderTime; }
    public Day getOrderDay() { return orderDay; }
    public Customer getCustomer() { return new Customer(customer); }
    public ArrayList<Beverage> getBeverages() { return new ArrayList<>(beverages); }
}