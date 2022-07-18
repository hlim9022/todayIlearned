import java.util.*;

public class Day4_Q8 {
    public int[] solution(int N, int[] stages) {
        double[][] pList = new double[N][2];

        int len = stages.length;
        int[] temp = new int[N];

        //각 스테이지에 도전중인 사용자 수의 배열을 만듬
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) count++;
            }
            temp[i-1] = count;
        }

        //{(스테이지번호),(실패율)} 이중배열로 만듬
        for (int i = 0; i < temp.length; i++) {
            pList[i][0] = i+1;
            if (len != 0) {
                pList[i][1] = ((double)temp[i]) / len;
                len -= temp[i];
            } else pList[i][1] = 0;
        }

        // 실패율을 기준으로 내림차순으로 정렬
        Arrays.sort(pList, (x,y) -> {
            return Double.compare(y[1], x[1]);
        });

        int[] answer = new int[N];
        for (int i = 0; i < pList.length; i++) {
            answer[i] = (int)pList[i][0];
        }
        return answer;
    }
}
