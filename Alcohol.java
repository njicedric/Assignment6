
public class Alcohol extends Beverage {
    private boolean weekend;
    private final double WEEKEND_PRICE = 0.6;

    public Alcohol(String name, Size size, boolean weekend) {
        super(name, Type.ALCOHOL, size);
        this.weekend = weekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (weekend) price += WEEKEND_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + 
               (weekend ? "Weekend" : "Weekday") + 
               ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Alcohol other = (Alcohol) obj;
        return weekend == other.weekend;
    }

    // Getters and setters
    public boolean isWeekend() { return weekend; }
    public void setWeekend(boolean weekend) { this.weekend = weekend; }
}