public class Main {

    // путь к файлу с данными
    private static String pathFileWithData = "c:\\data.txt";

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        ParserFromFile parser = new ParserFromFile(pathFileWithData);
        ConsoleUserInterface interFace = new ConsoleUserInterface();

        // парсим файл
        try {
            parser.parse(phoneBook);

        } catch (Exception e) {
            interFace.printException(e);
            return;
        }

        // производим поиск по телефонной книге
        interFace.run(phoneBook);

    }
}
