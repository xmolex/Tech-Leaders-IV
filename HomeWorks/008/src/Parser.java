import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Parser {

    private String pathFile = "";

    public Parser(String pathFile) {
        this.pathFile = pathFile;
    }

    // парсим файл и собираем ассоциативный массив
    public void parse(Phones phones) throws Exception {

        // читаем данные из файла
        try (Scanner scanner = new Scanner( new FileInputStream( new File(getPathFile())))) {

            // количество записей
            String countString = scanner.nextLine();
            int count;

            try {
                count = Integer.parseInt(countString);
            } catch (Exception e) {
                throw new Exception("COUNT_IS_NOT_INTEGER: '" + countString + "'");
            }

            if (scanner.hasNext()) {
                scanner.nextLine(); // разделитель
            }

            for(int i = 0; i < count; i++) {
                String name = scanner.nextLine();
                String phoneNumberString = scanner.nextLine();
                long phoneNumber;

                try {
                    phoneNumber = Long.parseLong(phoneNumberString);
                } catch (Exception e) {
                    throw new Exception("PHONENUMBER_IS_NOT_LONG: '" + phoneNumberString + "'");
                }

                if (scanner.hasNext()) {
                    scanner.nextLine(); // разделитель
                }

                // заносим запись в адресную книгу
                phones.add(name, phoneNumber);
            }

        } catch (IOException e) {
            throw new Exception("FILE_NOT_OPENED");
        }

    }

    public String getPathFile() {
        return pathFile;
    }

}
