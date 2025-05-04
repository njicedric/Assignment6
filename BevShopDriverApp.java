
public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        
        System.out.println("The current order can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());
        
        // First order
        System.out.println("\nStarting a new order:");
        bevShop.startNewOrder(10, Day.MONDAY, "John", 23);
        System.out.println("Total for current order: $" + bevShop.getCurrentOrder().calcOrderTotal());
        
        System.out.println("\nAdding alcohol drink:");
        bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
        System.out.println("Total drinks in order: " + bevShop.getCurrentOrder().getTotalItems());
        System.out.println("Total price: $" + bevShop.getCurrentOrder().calcOrderTotal());
        
        // Second order
        System.out.println("\nStarting a new order:");
        bevShop.startNewOrder(15, Day.SATURDAY, "Mary", 18);
        System.out.println("Total for current order: $" + bevShop.getCurrentOrder().calcOrderTotal());
        
        System.out.println("\nAdding smoothie:");
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);
        System.out.println("Total price: $" + bevShop.getCurrentOrder().calcOrderTotal());
        
        // Display monthly report
        System.out.println("\nMonthly Report:");
        System.out.println("Total orders: " + bevShop.totalNumOfMonthlyOrders());
        System.out.println("Total sales: $" + bevShop.totalMonthlySale());
    }
}