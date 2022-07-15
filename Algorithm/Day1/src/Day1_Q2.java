import java.util.*;

public class Day1_Q2 {
    public static int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        // arr 요소들 중 divisor로 나누어 떨어지는 값만 골라 list에 추가
        for (int ele : arr) {
            if (ele % divisor == 0) {
                list.add(ele);
            }
        }

        int[] answer; // 빈 배열 선언
        if (list.size() == 0) { // 나누어 떨어지는 값이 하나도 없을 경우, -1을 배열에 넣어줌
            answer = new int[]{-1};
        } else {
            answer = new int[list.size()]; // list 사이즈 크기로 배열을 생성 한 후, 값을 넣어줌

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        // 배열을 오름차순으로 sort
        Arrays.sort(answer);

        return answer;
    }


    public static void main(String[] args) {
        int[] arr = {5,9,7,10};

        System.out.println(solution(arr, 5));




    }
}
