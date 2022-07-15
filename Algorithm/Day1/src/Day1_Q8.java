import java.util.*;

public class Day1_Q8 {
    public long solution(long n) {
        List<Integer> num = new ArrayList<>();

        while (n != 0) {
            int x = (int)(n % 10);
            n /= 10;

            // n의 각 자리수를 역순으로 리스트에 저장
            num.add(x);
        }

        //자리수만큼의 크기로 배열 생성
        int[] aList = new int[num.size()];

        //배열에 값을 넣은 후
        for (int i = 0; i < aList.length; i++) {
            aList[i] = num.get(i);
        }

        //오름차순으로 sort
        Arrays.sort(aList);
        String answer = "";

        //내림차순으로 String에 넣음
        for (int i = aList.length - 1; i >= 0; i--) {
            answer += aList[i];
        }

        //String을 Long타입으로 형번환 후 반환
        return Long.parseLong(answer);
    }
}
