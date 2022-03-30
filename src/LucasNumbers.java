public class LucasNumbers {
    public static void main(String[] args) {
        System.out.println("\n----------------[1-40 Lucas Numbers]----------------");
        for (int i = 1; i <= 40; i++) {
            System.out.println(i + " => " + calculateLucasNumbers(i));
        }
        System.out.println("\n-------------------[Lucas Ratios]-------------------");
        for (int i = 35; i < 45; i++) {
            long[] firstCalc = timeCalculateLucasNumbers(i + 1);
            long[] secondCalc = timeCalculateLucasNumbers(i);
            System.out.println("The Ratio of lucas numbers " + (i + 1) + "/" + i + " is " +
                    (double) firstCalc[0] / secondCalc[0] + " (" + firstCalc[0] + "/" + secondCalc[0] + ")");
            System.out.println("The Ratio of the time of lucas numbers " + (i + 1) + "/" + i + " is " +
                    (double) firstCalc[1] / secondCalc[1] + " (" + firstCalc[1] + "/" + secondCalc[1] + ")");
            System.out.println();
        }
        System.out.println("\n---------------------[My Ratios]---------------------");
        for (int i = 35; i < 45; i++) {
            long[] firstCalc = timeCalculateMyNumbers(i + 1);
            long[] secondCalc = timeCalculateMyNumbers(i);
            System.out.println("The Ratio of my numbers " + (i + 1) + "/" + i + " is " +
                    (double) firstCalc[0] / secondCalc[0] + " (" + firstCalc[0] + "/" + secondCalc[0] + ")");
            System.out.println("The Ratio of the time of my numbers " + (i + 1) + "/" + i + " is " +
                    (double) firstCalc[1] / secondCalc[1] + " (" + firstCalc[1] + "/" + secondCalc[1] + ")");
            System.out.println();
        }
    }

    private static long calculateLucasNumbers(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        return calculateLucasNumbers(n - 1) + calculateLucasNumbers(n - 2);
    }

    private static long[] timeCalculateLucasNumbers(int n) {
        long start = System.currentTimeMillis();
        long result = calculateLucasNumbers(n);
        long executionTime = System.currentTimeMillis() - start;
        return new long[]{result, executionTime};
    }

    private static long myNumberSequence(int n) {
        if (n == 0) return 3;
        if (n == 1) return 14;
        return calculateLucasNumbers(n - 1) + calculateLucasNumbers(n - 2);
    }

    private static long[] timeCalculateMyNumbers(int n) {
        long start = System.currentTimeMillis();
        long result = myNumberSequence(n);
        long executionTime = System.currentTimeMillis() - start;
        return new long[]{result, executionTime};
    }
}
