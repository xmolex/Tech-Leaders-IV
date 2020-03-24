import java.util.ArrayList;
import java.util.Scanner;

public class Interface {

    private final String COMMAND_EXIT = "Exit";
    private final String COMMAND_LIST = "List";

    // инициализация запроса данных с консоли
    public void scan(Phones phones) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name or Exit");
        String cmdText = scanner.nextLine();
        while (!COMMAND_EXIT.equals(cmdText)) {

            if (COMMAND_LIST.equals(cmdText)) {
                // выводим список из всех элементов в адресной книге
                String[] names = phones.list();
                System.out.println("Found elems: " + names.length);
                for (int i = 0; i < names.length; i++) {
                    System.out.println("name: " + names[i] + ", phone: " + phones.get(names[i]));
                }
            } else {
                // поиск номера по имени
                long phoneNumber;

                try {
                    phoneNumber = phones.get(cmdText);
                    System.out.println("Phone number for " + cmdText + " is '" + phoneNumber + "'");
                } catch (Exception e) {
                    System.out.println(cmdText + " not found");
                }
            }

            // запрос новой порции данных
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
