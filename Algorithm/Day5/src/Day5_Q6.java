import java.util.Arrays;

public class Day5_Q6 {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] num = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(num);

        return num[0] + " " + num[str.length-1];
    }
}
