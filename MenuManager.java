import java.util.List;
import java.util.function.BiConsumer;

public class MenuManager {
    private MenuManager() {}
    private static class InstanceMenuManager {
        private static final MenuManager instance = new MenuManager();
    }

    public static MenuManager getInstance(){
        return InstanceMenuManager.instance;
    }

    public Menu start() {
        System.out.println("어떤 음식을 주문하시겠습니까?");
        System.out.println("1. 밥류    2. 면류    3. 음료");
        String food = Input.inputString("1", "2", "3");
        return createMenu(food);
    }

    public Menu createMenu(String food) {
        return switch (food) {
            case "1" -> new RiceMenu();
            case "2" -> new NoodleMenu();
            case "3" -> new DrinkMenu();
            default -> throw new IllegalStateException("Unexpected value: " + food);
        };
    }

    public boolean plusFood() {
        System.out.println("추가 주문을 하시겠습니까?(y/n)");
        String ans = Input.inputString("y", "n");
        System.out.println();
        return ans.equals("y");
    }

    public void showBoard() {
        System.out.printf("%30s\n", "Menu");

        String format = "%-15s%-15s";

        BiConsumer<String, List<Food>> print = (title, foods) -> {
            StringBuilder line = new StringBuilder();
            int len = 65 - title.length();
            for (int i = 0; i < len; ++i)
                line.append("-");

            System.out.printf("--%s%s\n", title, line.toString());
            for (int i = 0; i < foods.size(); ++i) {
                Food food = foods.get(i);
                System.out.printf(format, food.getName(), food.getPrice());
                if (i % 2 == 1) System.out.println();
            }
        };

        print.accept("Rice", RiceMenu.list);
        print.accept("Noodle", NoodleMenu.list);
        print.accept("Drink", DrinkMenu.list);

        System.out.println("\n===================================================================");
        System.out.println();
    }
}
