import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    Scanner sc = new Scanner(System.in);
    public UserInput() {
    }

    public int getNum(String str) {
        int num = 0;
        int minNum = 1;
        int maxNum = 9;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(str);
            try {
                num = sc.nextInt();
                if (num >= minNum && num <= maxNum) {
                    validInput = true;
                } else {
                    System.out.print("Wähle eine Zahl von 1-9: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Wähle eine ZAHL!: ");
                sc.next();
            }
        }
        return num;
    }
}
