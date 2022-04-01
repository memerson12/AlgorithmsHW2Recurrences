import java.util.Arrays;

public class Subirach {
    private static final int[] test = {1, 14, 14, 4, 11, 7, 6, 9, 8, 10, 10, 5, 13, 2, 3, 15};
    private static int count = 0;
    private static int desiredSum = 33;

    public static void main(String[] args) {
        int numCombos4 = combinations(test, 4, 4, true);
        int numCombosAll = combinations(test, 1, test.length, true);
        int maxCombo = 0;
        int maxIndex = 0;
        for (int i = 0; i < Arrays.stream(test).sum(); i++) {
            desiredSum = i;
            int combos = combinations(test, 1, test.length, true);
            if (combos > maxCombo) {
                maxIndex = i;
                maxCombo = combos;
            }
            System.out.println("The sum of " + i + " can be made " + combos + " way(s)");
        }
        System.out.println("There were " + numCombos4 + " combinations with 4 elements that added up to 33");
        System.out.println("There were " + numCombosAll + " combinations that added up to 33");
        System.out.println("The number with the max number of combos was " + maxIndex + " with " + maxCombo + " combos");

    }


    static int combinations(int[] arr, int minSize, int maxSize, boolean checkSum) {
        count = 0;
        for (int i = minSize; i <= maxSize; i++) {
            int[] data = new int[i];
            combinationHelper(arr, data, 0, arr.length - 1, 0, i, checkSum);
        }
        return count;
    }

    static void combinationHelper(int[] arr, int[] data, int start, int end, int index, int comboSize, boolean checkSum) {
        if (index == comboSize) {
            if (checkSum(data) || !checkSum) {
//                System.out.println(Arrays.toString(data));
                count++;
            }
            return;
        }

        for (int i = start; i <= end && end - i + 1 >= comboSize - index; i++) {
            data[index] = arr[i];
            combinationHelper(arr, data, i + 1, end, index + 1, comboSize, checkSum);
        }
    }

    private static boolean checkSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum == desiredSum;
    }
}
