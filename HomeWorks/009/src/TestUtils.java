import com.sun.javaws.IconUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class TestUtils {

    private static int ITERATIONS_COUNT = 50000;

    public static long testAddToCollection(Collection<Integer> collection) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < ITERATIONS_COUNT; i++){
            collection.add(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    public static long testAddToDefinePosition(List<Integer> list, int position) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < ITERATIONS_COUNT; i++){
            if (position == -1) {
                list.add(list.size(), i);
            }
            else {
                list.add(position, i);
            }
        }
        return System.currentTimeMillis() - startTime;
    }

    public static long testFillAndContains(Set<Integer> setList) {
        for(int i = 0; i < ITERATIONS_COUNT; i++){
            setList.add(i);
        }

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < ITERATIONS_COUNT; i++){
            setList.contains(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    public static long testFillAndContainsInCollections(Collection<Integer> collection) {
        for(int i = 0; i < ITERATIONS_COUNT; i++){
            collection.add(i);
        }

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < ITERATIONS_COUNT; i++){
            collection.contains(i);
        }
        return System.currentTimeMillis() - startTime;
    }

    public static void setIterationsCount(int iterationsCount) {
        ITERATIONS_COUNT = iterationsCount;
    }
}
