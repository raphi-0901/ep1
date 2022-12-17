import java.util.Arrays;

public class Question4 {
    public static void main(String[] args) {
        System.out.println(isRepetition(""));
        System.out.println(isRepetition("a"));
        System.out.println(isRepetition("ohoh"));
        System.out.println(isRepetition("ohohoh"));
        System.out.println(isRepetition("hallohallohallohallo"));
        System.out.println(move("Halslo12y342s"));
    }


    private static String generate(String input) {
        if (input.isEmpty()) {
            return "|";
        } else {
            String help = input.substring(0, input.length() - 1);
            return generate(help) + input.charAt(input.length() - 1) + generate(help);
        }
    }

    private static void insertionSort(int[] data) {
        for (int i = 0; i < data.length;
             i++) {
            for (int j = i; j > 0 && data[j] < data[j - 1]; j--)
                exchange(data, j, j - 1);
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isRepetition(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        if (s.charAt(s.length() / 2 - 1) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isRepetition(s.substring(0, s.length() / 2 - 1) + s.substring(s.length() / 2));
    }

    private static String move(String s) {
        if (s.length() <= 1) {
            return s;
        }
        if (s.charAt(0) < '0' || s.charAt(0) > '9') {
            return s.charAt(0) + move(s.substring(1));
        }
        if (s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') {
            return move(s.substring(0, s.length() - 1)) + s.charAt(s.length() - 1);
        }
        return s.charAt(s.length() - 1) + move(s.substring(1, s.length() - 1)) + s.charAt(0);

    }

}
