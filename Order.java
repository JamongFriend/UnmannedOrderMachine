import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Order {
    private final List<Food> foods;

    public Order() {
        foods = new ArrayList<>();
    }

    public void buy(Food food, int size) {
        for (int i = 0; i < size; ++i)
            foods.add(food);
    }

    private int payment() {
        int sum = 0;
        for (Food food : foods) sum += food.getPrice();
        return sum;
    }

    public void printBills() {
        System.out.println("\n===================================================================");
        printMenus();

        System.out.printf("총 금액은 %d원 입니다.", payment());
        System.out.println("\n===================================================================\n");
    }

    public void printMenus() {
        List<Food> rices = foods.stream().filter(v -> v instanceof RiceFood).collect(Collectors.toList());
        List<Food> noodles = foods.stream().filter(v -> v instanceof NoodleFood).collect(Collectors.toList());
        List<Food> drinks = foods.stream().filter(v -> v instanceof DrinkFood).collect(Collectors.toList());

        Consumer<List<Food>> print = (flist) -> {
            HashMap<Integer , Food> map = new HashMap<>();
            for(int i = 0; i < flist.size(); i++){
                map.put(i, flist.get(i));
            }
            for(Map.Entry<Integer, Food> entry : map.entrySet()){
                System.out.println(entry.getValue());
            }
        };
        print.accept(rices);
        print.accept(noodles);
        print.accept(drinks);
    }
}
