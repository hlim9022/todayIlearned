import java.util.*;

public class Day2_Q5 {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        int answer = 0;

        while(n != 0) {
            int x = n % 3;
            n /= 3;

            list.add(x); // n을 3진법으로 변환한 각 자리값을 역으로 list에 넣음
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            answer += list.get(list.size() - 1 - i) * Math.pow(3, i);
        }

        return answer;
    }
}
