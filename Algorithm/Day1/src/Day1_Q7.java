import java.util.*;

public class Day1_Q7 {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();

        while (n != 0) {
            int x = (int)(n % 10);
            n /= 10;

            list.add(x);
        }
        int[] answer = new int[list.size()];

        for (int i=0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
