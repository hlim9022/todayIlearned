import java.util.Arrays;

public class Day3_Q3 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        // 각 문자열 맨앞에 n번째 인덱스의 문자값을 넣어줌
        for (int i = 0; i < strings.length; i++) {
            answer[i] = strings[i].charAt(n) + strings[i];
        }

        //sort => n번 인덱스문자를 기준으로 정렬(맨 앞에 문자를 추가해줬으니)
        Arrays.sort(answer);

        //결과를 반환할 때는 임의로 추가했던 n번째 인덱스 문자를 삭제 후 반환!
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer[i].substring(1);
        }

        return answer;
    }
}
