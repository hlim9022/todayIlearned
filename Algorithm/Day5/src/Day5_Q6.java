import java.util.*;

public class Day5_Q6 {

    public static String solution(String s) {
        String[] str = s.split(" ");
        int[] num = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(num);

        return num[0] + " " + num[str.length-1];
    }

    public static void main(String[] args) {
        System.out.println(solution("-1 -2 -3 -4"));
    }
}
