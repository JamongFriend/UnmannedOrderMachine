public abstract class Food {
    private final String name;
    private final int price;

    protected Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("[%s]", name);
    }
}

class RiceFood extends Food {
    public RiceFood(String name, int price) {
        super(name, price);
    }
}

class NoodleFood extends Food {
    public NoodleFood(String name, int price) {
        super(name, price);
    }
}

class DrinkFood extends Food {
    public DrinkFood(String name, int price) {
        super(name, price);
    }
}