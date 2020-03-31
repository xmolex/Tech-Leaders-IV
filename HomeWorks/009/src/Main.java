import java.util.*;

public class Main {

    public static void main(String[] args) {
        // добавление элементов в ArrayList, LinkedList, HashSet, TreeSet
        //testAddToCollections(1000000);

        // добавление по фиксированному индексу (2 теста, в начало и конец) в ArrayList, LinkedList
        //testAddToBeginAndEnd(50000, 1000000);
    }

    // добавление элементов в ArrayList, LinkedList, HashSet, TreeSet
    public static void testAddToCollections(int iterationsCount) {
        TestUtils.setIterationsCount(iterationsCount);
        System.out.println("=========== iterations count: " + iterationsCount + " ================" );

        System.out.println("test add to ArrayList: " + TestUtils.testAddToCollection(new ArrayList<>()) + " ms");
        System.out.println("test add to LinkedList: " + TestUtils.testAddToCollection(new LinkedList<>()) + " ms");
        System.out.println("test add to HashSet: " + TestUtils.testAddToCollection(new HashSet<>()) + " ms");
        System.out.println("test add to TreeSet: " + TestUtils.testAddToCollection(new TreeSet<>()) + " ms");
        System.out.println("Быстрее всего должно работать в ArrayList, т.к. просто добавляет в конец массива без смещения, иногда правда расширяя массив");
    }

    // добавление по фиксированному индексу (2 теста, в начало и конец) в ArrayList, LinkedList
    public static void testAddToBeginAndEnd(int iterationsCountForBegin, int iterationsCountForEnd) {
        TestUtils.setIterationsCount(iterationsCountForEnd);
        System.out.println("=========== iterations count: " + iterationsCountForEnd + " ================" );
        System.out.println("test add to end ArrayList: " + TestUtils.testAddToDefinePosition(new ArrayList<>(), -1) + " ms");
        System.out.println("test add to end LinkedList: " + TestUtils.testAddToDefinePosition(new LinkedList<>(), -1) + " ms");
        System.out.println("Быстрее всего должно работать в ArrayList, т.к. просто добавляет в конец массива без смещения, иногда правда расширяя массив. Да и размер высчитывает быстрее.");

        TestUtils.setIterationsCount(iterationsCountForBegin);
        System.out.println("=========== iterations count: " + iterationsCountForBegin + " ================" );
        System.out.println("test add to end ArrayList: " + TestUtils.testAddToDefinePosition(new ArrayList<>(), 0) + " ms");
        System.out.println("test add to end LinkedList: " + TestUtils.testAddToDefinePosition(new LinkedList<>(), 0) + " ms");
        System.out.println("Быстрее всего должно работать в LinkedList, т.к. просто добавляет новый объект (node) и устанавливает на него ссылки у соседа, а вот ArrayList постоянно смещает все элементы");
    }
}
