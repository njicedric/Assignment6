
public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public abstract double calcPrice();

    public String getName() { return name; }
    public Type getType() { return type; }
    public Size getSize() { return size; }
    public double getBasePrice() { return BASE_PRICE; }
    public double getSizePrice() { return SIZE_PRICE; }

    public double addSizePrice() {
        switch(size) {
            case SMALL: return BASE_PRICE;
            case MEDIUM: return BASE_PRICE + SIZE_PRICE;
            case LARGE: return BASE_PRICE + 2 * SIZE_PRICE;
            default: return BASE_PRICE;
        }
    }

    @Override
    public String toString() {
        return name + ", " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Beverage)) return false;
        Beverage other = (Beverage) obj;
        return name.equals(other.name) && 
               type == other.type && 
               size == other.size;
    }
}