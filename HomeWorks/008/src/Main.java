public class Main {

    // путь к файлу с данными
    private static String pathFileWithData = "c:\\data.txt";

    public static void main(String[] args) {

        Phones phones = new Phones();
        Parser parser = new Parser(pathFileWithData);
        Interface interFace = new Interface();

        // разбираем файл и заполняем телефонную книгу
        boolean isFileParse = true;
        try {
            parser.parse(phones);

        } catch (Exception e) {
            isFileParse = false;
            interFace.printException(e);
        }

        if (isFileParse) {
            // производим поиск по телефонной книге
            interFace.scan(phones);
        }

    }
}
