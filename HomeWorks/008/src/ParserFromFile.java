import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ParserFromFile {

    private String pathFile = "";

    public ParserFromFile(String pathFile) {
        this.pathFile = pathFile;
    }

    // парсим файл и собираем ассоциативный массив
    public void parse(PhoneBook phoneBook) throws Exception {

        // счетчик строк
        int positionString = 0;

        // читаем данные из файла
        try (Scanner scanner = new Scanner(new FileInputStream(new File(getPathFile())))) {

            // количество записей
            String countString = scanner.nextLine();
            positionString++;
            int count;
            try {
                count = Integer.parseInt(countString);
            } catch (Exception e) {
                throw new InputMismatchException("COUNT_IS_NOT_INTEGER: '" + countString + "', line: " + positionString);
            }

            if (scanner.hasNext()) {
                // разделитель в виде пустой строки
                scanner.nextLine();
                positionString++;
            }

            // далее у нас должны быть повторяющиеся строки с данными: имя, телефонный номер, разделитель в виде пустой строки
            for (int i = 0; i < count; i++) {
                String name = scanner.nextLine();
                positionString++;

                String phoneNumberString = scanner.nextLine();
                positionString++;

                long phoneNumber;
                try {
                    phoneNumber = Long.parseLong(phoneNumberString);
                } catch (Exception e) {
                    throw new InputMismatchException("PHONENUMBER_IS_NOT_LONG: '" + phoneNumberString + "', line: " + positionString);
                }

                if (scanner.hasNext()) {
                    // разделитель в виде пустой строки
                    scanner.nextLine();
                    positionString++;
                }

                // заносим запись в адресную книгу
                phoneBook.add(name, phoneNumber);
            }

        } catch (IOException e) {
            throw new IOException("FILE_NOT_OPENED: '" + pathFile + "'");
        }

    }

    public String getPathFile() {
        return pathFile;
    }

}
