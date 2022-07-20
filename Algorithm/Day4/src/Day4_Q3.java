import java.util.Arrays;

public class Day4_Q3 {
    public static int solution(int[] d, int budget) {
        //오름차순으로 정렬된 부서별 예산요청 배열
        Arrays.sort(d);

        int count = 0;

        //부서의 요청예산 금액이 현재 budget보다 작거나 같으면 예산을 할당
        for (int i = 0; i < d.length; i++) {
            if(budget < d[i]) break;
            else {
                budget -= d[i];
                count++;
            }
        }
        return count;
    }
}
