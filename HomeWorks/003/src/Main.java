public class Main {

    public static void main(String[] args) {
        oneDimensionalArray(args);

        twoDimensionalArray(args);
    }

    public static void oneDimensionalArray(String[] args) {
        // One-dimensional array operations
        System.out.println("One-dimensional array:");
        System.out.println(OneDimensional.toStringStatic());

        System.out.println("Max value from one-dimensional array:");
        System.out.println(OneDimensional.findMAxFromArray());
    }

    public static void twoDimensionalArray(String[] args) {
        // get console params
        System.out.println("Console params:");
        if (args.length == 0) {
            System.out.println("Params is empty, enter two int numeric");
            return;
        }
        System.out.println(args[0] + ", " + args[1]);

        // attemp string to int
        int firstArg = 1;
        int secondArg = 1;
        try {
            firstArg = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("First param is wrong, i will use 1");
        }
        try {
            secondArg = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Second param is wrong, i will use 1");
        }

        // Two-dimensional array operations
        TwoDimensional.createArray();

        System.out.println("Two-dimensional array:");
        System.out.println(TwoDimensional.toStringStatic());

        System.out.println("Change string " + Integer.toString(firstArg) + " and " + Integer.toString(secondArg) + ":");
        System.out.println(TwoDimensional.changeString(firstArg, secondArg));
        System.out.println(TwoDimensional.toStringStatic());

        System.out.println("Change column " + Integer.toString(firstArg) + " and " + Integer.toString(secondArg) + ":");
        System.out.println(TwoDimensional.changeColumn(firstArg, secondArg));
        System.out.println(TwoDimensional.toStringStatic());

        System.out.println("Sum below main diagonal: " + Integer.toString(TwoDimensional.calcSumBelowMainDiagonal()));
    }
}
