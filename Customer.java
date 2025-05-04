
public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }

    // Getters and setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}