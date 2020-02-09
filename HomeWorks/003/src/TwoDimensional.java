import java.util.Arrays;
import java.util.Random;

public class TwoDimensional {

    private static final int arrayLength = 7;
    private static int[][] TwoDimensionalArray = new int[arrayLength][arrayLength];

    // fill an two-dimensional array
    public static void createArray() {
        Random random = new Random();
        for (int pos1 = 0; pos1 < arrayLength; pos1++) {
            for (int pos2 = 0; pos2 < arrayLength; pos2++) {
                TwoDimensionalArray[pos1][pos2] = random.nextInt(100);
            }
        }
    }

    // change string
    public static String changeString(int firstPos, int secondPos) {

        // check by length array
        if (ParamMoreThanArrayLength(firstPos) || ParamMoreThanArrayLength(secondPos)) {
            return ("length array less param, skip operation...");
        }

        int[] tempArrayForMove = TwoDimensionalArray[firstPos];
        TwoDimensionalArray[firstPos] = TwoDimensionalArray[secondPos];
        TwoDimensionalArray[secondPos] = tempArrayForMove;
        return ("OK");
    }

    // change column
    public static String changeColumn(int firstPos, int secondPos) {

        // check by length array
        if (ParamMoreThanArrayLength(firstPos) || ParamMoreThanArrayLength(secondPos)) {
            return ("length array less param, skip operation...");
        }

        // move with temp variable
        int tempIntVarForMove;
        for (int pos = 0; pos < arrayLength; pos++) {
            tempIntVarForMove = TwoDimensionalArray[pos][firstPos];
            TwoDimensionalArray[pos][firstPos] = TwoDimensionalArray[pos][secondPos];
            TwoDimensionalArray[pos][secondPos] = tempIntVarForMove;
        }

        return ("OK");
    }

    // calc sum
    public static int calcSumBelowMainDiagonal() {
        int resultSum = 0;

        for (int pos1 = 1; pos1 < arrayLength; pos1++) {
            for (int pos2 = 0; pos2 < pos1; pos2++) {
                resultSum += TwoDimensionalArray[pos1][pos2];
            }
        }

        return resultSum;
    }

    public static String toStringStatic() {
        String toStringMess = "";

        for (int pos = 0; pos < arrayLength; pos++) {
            toStringMess += Arrays.toString(TwoDimensionalArray[pos]) + "\n";
        }

        return toStringMess;
    }

    private static boolean ParamMoreThanArrayLength(int posElem) {
        return posElem >= arrayLength;
    }
}
