import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    // путь к файлу с данными
    private static String pathFileWithData = "c:\\data.txt";

    public static void main(String[] args) {

        Phones phones = new Phones();
        Parser parser = new Parser(pathFileWithData);
        Interface interFace = new Interface();

        // разбираем файл и заполняем телефонную книгу
        try (parser.parse(phones)) {
            // производим поиск по телефонной книге
            interFace.scan(phones);

        } catch (Exception e) {
            System.out.println("Don't parce text file");
            //System.out.println(e);

        }

    }
}
