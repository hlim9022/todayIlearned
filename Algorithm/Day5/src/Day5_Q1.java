import java.util.Arrays;

public class Day5_Q1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];

        // 체육복을 lost한 학생은 0, 체육복이 있는 학생은 1로 학생리스트 initialize
        for (int i = 0; i < n; i++) {
            students[i] = 1;
            for (int j = 0; j < lost.length; j++) {
                if (i == lost[j] - 1) students[i] = 0;
            }
        }

        // reserve 즉, 여분의 체육복이 있는 학생은 +1
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (i == reserve[j] - 1) students[i] += 1;
            }
        }

        for (int i = 0; i < students.length; i++) {
            boolean flag = false; // 체육복을 빌려줬다면 true로 바꿔서 표시

            // 여분까지 총 2벌의 체육복이 있는 학생들 확인
            if (students[i] == 2) {

                //첫번째 학생은 그 다음 학생에게 밖에 체육복을 줄 수 없다! => 2번학생이 체육복이 없을시에만
                if(i==0) {
                    if(students[i+1] == 0) {
                        students[i+1] += 1;
                        flag = true;
                    }
                //마지막 학생은 앞에 학생에게 밖에 체육복을 줄 수 없다! => 바로 앞 학생이 체육복이 없을시에만
                } else if (i==students.length-1) {
                    if(students[i-1] == 0) {
                        students[i-1] += 1;
                        flag = true;
                    }

                // 그 외 중간 학생은 양 옆에 학생을 확인해보고 없을시에만 준다.
                } else {
                    if(students[i-1] == 0) {
                        students[i-1] += 1;
                        flag = true;
                    } else if(students[i+1] == 0) {
                        students[i+1] += 1;
                        flag = true;
                    }
                }
            }
            if(flag) students[i] -= 1;
        }

        System.out.println(Arrays.toString(students));
        int answer = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] > 0) answer++;
        }
        return answer;
    }
}
