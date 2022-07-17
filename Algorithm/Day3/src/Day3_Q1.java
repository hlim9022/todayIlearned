public class Day3_Q1 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int mCount = 0; // missing 숫자 카운트 변수
        int wCount = 0; // winning 숫자 카운트 변수

        for(int i=0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                for(int j=0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        wCount++;
                        break; // 중복이 없는 숫자 배열이기 때문에, 동일한 값을 찾으면 반복문 중지
                    }
                }
            } else mCount++; // missing 갯수 세기
        }
        answer[0] = (7-(wCount+mCount) > 5)? 6 : 7-(wCount+mCount);
        answer[1] = (7-wCount > 4)? 6 : 7-wCount;

        return answer;
    }
}
