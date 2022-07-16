import java.util.*;

public class Day2_Q7 {
    public static int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        // 다음 값과 비교해서 같지않을 때 현재 값을 리스트에 저장
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i+1]) {
                list.add(arr[i]);
            }
        }

        // 마지막요소는 다음 값이 없이 비교대상이 없지만,
        // null값이라고 할 수 있는 다음값과 마지막요소는 값이 다르기 때문에 리스트에 더해줌
        list.add(arr[arr.length - 1]);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
