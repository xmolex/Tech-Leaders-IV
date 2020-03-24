import java.util.Scanner;

public class Interface {

    private final String COMMAND_EXIT = "Exit";

    // инициализация запроса данных с консоли
    public void scan(Phones phones) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name or Exit");
        String cmdText = scanner.nextLine();
        while (!COMMAND_EXIT.equals(cmdText)) {
            long phoneNumber;

            try {
                phoneNumber = phones.get(cmdText);
                System.out.println("Phone number for " + cmdText + " is '" + phoneNumber + "'");
            } catch (Exception e) {
                System.out.println(cmdText + " not found");
            }

            System.out.println("Enter name or Exit");
            cmdText = scanner.nextLine();
        }

        System.out.println("Exit...");
    }

    // вывод исключений в консоль
    public void printException(Exception e) {
        System.out.println(e);
    }

}
