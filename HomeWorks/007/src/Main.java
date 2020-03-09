import java.util.Random;

public class Main {

    private static final String[] STRINGS_RAND = {"Mark","John","Tony","Andrew","Devid","EDWARD","JAKE","MAX","FREDDIE","HARRISON","TYLER","SEBASTIAN"};
    private static final int ARRAY_SIZE_FOR_EXAMPLE = 5;

    public static void main(String[] args) {
	    LinkedList myList = new LinkedList();

	    // заполняем список
        System.out.println("Заполняем список случайными строками...");
        for (int i = 0; i < ARRAY_SIZE_FOR_EXAMPLE; i++) {
            fillList(myList);
        }

        // выводим размер списка
        System.out.println("Размер списка: " + myList.size());

        // выводим список через while
        System.out.println("Выводим список через next()...");
        printList(myList);

        // выводим список через for
        System.out.println("Выводим список через size()...");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Элемент " + i + ": " + myList.get(i) );
        }

    }

    // добавляем элемент в список случайным значением
    public static void fillList(LinkedList myList) {
        Random random = new Random();
        String randomStr = STRINGS_RAND[random.nextInt(STRINGS_RAND.length)];
        myList.add(randomStr);
        System.out.println("add random value: '" + randomStr + "'" + " in inkedList");
    }

    // выводим все элементы из списка
    public static void printList(LinkedList myList) {
        int currentPosition = 0;
        Iterator listIterator = new Iterator(myList);
        while (listIterator.hasNext()) {
            System.out.println("Элемент: " + currentPosition );
            System.out.println(listIterator.next());
            currentPosition++;
        }
    }
}

