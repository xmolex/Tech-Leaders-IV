import java.util.Scanner;

public class Interface {

    private final String COMMAND_EXIT = "Exit";

    // инициализация запроса данных с консоли
    public void scan(Phones phones) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name or Exit");
        String cmdText = scanner.nextLine();
        while (cmdText != COMMAND_EXIT) {
            long phoneNumber = phones.get(cmdText);
            System.out.println("Phone number for " + cmdText + " is '" + phoneNumber + "'");
            System.out.println("Enter name or Exit");
            cmdText = scanner.nextLine();
        }

        System.out.println("Exit...");
    }

}
