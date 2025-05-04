
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_COST = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) price += EXTRA_COST;
        if (extraSyrup) price += EXTRA_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + 
               (extraShot ? "Extra shot" : "No extra shot") + ", " +
               (extraSyrup ? "Extra syrup" : "No extra syrup") + 
               ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Coffee other = (Coffee) obj;
        return extraShot == other.extraShot && 
               extraSyrup == other.extraSyrup;
    }

    // Getters and setters
    public boolean getExtraShot() { return extraShot; }
    public boolean getExtraSyrup() { return extraSyrup; }
    public void setExtraShot(boolean extraShot) { this.extraShot = extraShot; }
    public void setExtraSyrup(boolean extraSyrup) { this.extraSyrup = extraSyrup; }
}