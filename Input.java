import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Input {
    public static int inputNumber(int len) {
        Scanner scanner = new Scanner(System.in);

        int N;
        while (true) {
            System.out.print("입력: ");
            N = scanner.nextInt();
            scanner.nextLine();
            if ((len == -1 && N > 0) || (1 <= N && N <= len))
                return N;

            System.out.println("잘못 입력하였습니다.");
            System.out.println("다시 입력하세요.");
        }
    }

    public static String inputString(String ...strs) {
        List<String> list = Arrays.asList(strs);

        Scanner scanner = new Scanner(System.in);
        String str;
        while (true) {
            System.out.print("입력: ");
            str = scanner.nextLine();
            if (list.contains(str)) return str;

            System.out.println("잘못 입력하였습니다.");
            System.out.println("다시 입력하세요.");
        }
    }
}