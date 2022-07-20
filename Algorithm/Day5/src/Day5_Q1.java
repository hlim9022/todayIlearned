public class Day5_Q1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];

        //체육복을 잃어버린(lost) 학생은 0, 잃어버리지 않은 학생은 1로 배열 생성
        for (int i = 0; i < n; i++) {
            students[i] = 1;
            for (int j = 0; j < lost.length; j++) {
                if (i == lost[j] - 1) students[i] = 0;
            }
        }

        // 여분이 있는 학생에게는 +1씩 해줌
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (i == reserve[j] - 1) students[i] += 1;
            }
        }


        for (int i = 0; i < students.length; i++) {

            // 체육복이 2벌인 경우의 상황
            if (students[i] == 2) {

                if (i == 0) {
                //CASE1: 첫번째 학생이 2벌인 경우에는 다음학생이 체육복이 없을시에만 1벌을 줄 수 있다.
                    if (students[i + 1] == 0) {
                        students[i + 1] += 1;
                        students[i] -= 1;
                    }
                } else if (i == students.length - 1) {
                //CASE2: 마지막 학생이 2벌인 경우에는 앞 학생이 체육복이 없을시에만 1벌을 줄 수 있다.
                    if (students[i - 1] == 0) {
                        students[i - 1] += 1;
                        students[i] -= 1;
                    }
                /* CASE3: 중간의 학생이 2벌인 경우, 양옆을 확인하여 체육복이 없는 학생에게 여벌을 준다.
                만약, 양 옆 학생이 모두 체육복이 있는 상황이면 주지 않아도 된다.
                 */
                } else {
                    if (students[i - 1] == 0) {
                        students[i - 1] += 1;
                        students[i] -= 1;
                    } else if (students[i + 1] == 0) {
                        students[i + 1] += 1;
                        students[i] -= 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] > 0) answer++;
        }
        return answer;
    }
}
