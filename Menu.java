import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

    protected abstract List<Food> getFoods();

    public Food selectFood() {
        showMenu();

        int i = Input.inputNumber(getFoods().size());
        return getFoods().get(i-1);
    }

    public int countFood() {
        System.out.println("몇개를 주문하시겠습니까?");
        return Input.inputNumber(-1);
    }

    private void showMenu() {
        for (int i = 0; i < getFoods().size(); ++i)
            System.out.printf("%d: %s\n", i+1, getFoods().get(i));
    }

}

class RiceMenu extends Menu {
    public static List<Food> list = new ArrayList<>();
    static {
        list.add(new RiceFood("볶음밥", 7000));
        list.add(new RiceFood("덮밥", 7000));
        list.add(new RiceFood("국밥", 6000));
        list.add(new RiceFood("공기밥", 1000));
    }

    protected List<Food> getFoods() {
        return list;
    }
}

class NoodleMenu extends Menu {
    public static List<Food> list = new ArrayList<>();
    static {
        list.add(new NoodleFood("국수" , 6000));
        list.add(new NoodleFood("라면" , 3000));
        list.add(new NoodleFood("냉면" , 5000));
        list.add(new NoodleFood("모밀" , 6000));
    }

    protected List<Food> getFoods() {
        return list;
    }
}

class DrinkMenu extends Menu {
    public static List<Food> list = new ArrayList<>();
    static {
        list.add(new DrinkFood("사이다", 2000));
        list.add(new DrinkFood("콜라", 2000));
        list.add(new DrinkFood("환타", 2000));
    }

    protected List<Food> getFoods() {
        return list;
    }
}