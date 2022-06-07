public class UnmannedOrderMachine {
    public static void main(String[] args) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.showBoard();

        Order order = new Order();
        do {
            Menu menu = menuManager.start();

            Food food = menu.selectFood();
            int num = menu.countFood();
            order.buy(food, num);
        } while (menuManager.plusFood());

        order.printBills();
    }
}