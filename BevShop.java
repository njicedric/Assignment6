
import java.util.ArrayList;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;
    private int currentAlcoholDrinks;

    public BevShop() {
        orders = new ArrayList<>();
        currentAlcoholDrinks = 0;
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return currentAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return currentAlcoholDrinks;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (isValidTime(time)) {
            orders.add(new Order(time, day, new Customer(customerName, customerAge)));
            currentAlcoholDrinks = 0;
        }
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            getCurrentOrder().addNewBeverage(bevName, size);
            currentAlcoholDrinks++;
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        }
        return null;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(i));
            orders.set(i, temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monthly Orders:\n");
        for (Order order : orders) {
            sb.append(order).append("\n\n");
        }
        sb.append("Total Monthly Sale: $").append(String.format("%.2f", totalMonthlySale()));
        return sb.toString();
    }
}