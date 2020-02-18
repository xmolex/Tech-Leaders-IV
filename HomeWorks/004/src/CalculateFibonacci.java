public class CalculateFibonacci {

    private static final int sizeArray = 1000;

    // init array (size elems) for fast
    private static long[] tempHash = new long[sizeArray];

    public static long calculate(int n) {

        // maybe already calculate
        if (n < sizeArray) {
            if (tempHash[n] != 0) {
                return tempHash[n];
            }
        }

        // calculate
        long result = n <= 1 ? n : calculate(n - 1) + calculate(n - 2);
        tempHash[n] = result;

        return result;
    }

}
