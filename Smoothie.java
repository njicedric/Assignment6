
public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private final double PROTEIN_PRICE = 1.5;
    private final double FRUIT_PRICE = 0.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (addProtein) price += PROTEIN_PRICE;
        price += numOfFruits * FRUIT_PRICE;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + 
               numOfFruits + " fruits, " +
               (addProtein ? "Protein added" : "No protein") + 
               ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Smoothie other = (Smoothie) obj;
        return numOfFruits == other.numOfFruits && 
               addProtein == other.addProtein;
    }

    // Getters and setters
    public int getNumOfFruits() { return numOfFruits; }
    public boolean getAddProtein() { return addProtein; }
    public void setNumOfFruits(int numOfFruits) { this.numOfFruits = numOfFruits; }
    public void setAddProtein(boolean addProtein) { this.addProtein = addProtein; }
}