import java.util.Arrays;

public class OneDimensional {

    private static int[] OneDimensionalArray = {5, 4, 1, 8, 100, 74, 11};
    private static int maxValue;

    public static int findMAxFromArray() {

        maxValue = OneDimensionalArray[0];
        for (int pos = 1; pos < OneDimensionalArray.length; pos++) {
            if (OneDimensionalArray[pos] > maxValue) {
                maxValue = OneDimensionalArray[pos];
            }
        }

        return maxValue;

    }

    public static String toStringStatic() {
        return Arrays.toString(OneDimensionalArray);
    }

}
