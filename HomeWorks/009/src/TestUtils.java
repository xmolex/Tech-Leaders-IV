import com.sun.javaws.IconUtil;

import java.util.Collection;
import java.util.List;

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


    public static void setIterationsCount(int iterationsCount) {
        ITERATIONS_COUNT = iterationsCount;
    }
}
