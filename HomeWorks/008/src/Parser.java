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
            int count = scanner.nextInt();
            scanner.nextLine(); // разделитель

            for(int i = 0; i < count; i++) {
                String name = scanner.nextLine();
                Long phoneNumber = scanner.nextLong();
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
