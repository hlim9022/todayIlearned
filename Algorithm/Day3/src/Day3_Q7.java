public class Day3_Q7 {
    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            int sum = (int)s.charAt(i) + n;

            // 제한: 공백은 아무리 밀어도 공백을 둬야한다.
            if((int)s.charAt(i) == 32) {
                answer += ' ';
                continue;
            }

            //문자가 대문자인 경우
            if ((int)s.charAt(i) >= 65 && (int)s.charAt(i) <= 90) {
                //문자를 n만큼 밀었을ㄷ 때, 'Z'를 넘어서는 경우 다시 'A'로 넘어오도록
                if (sum > 90) sum -= 26;
            //문자가 소문자인 경우
            } else {
                //문자를 n만큼 밀었을ㄷ 때, 'z'를 넘어서는 경우 다시 'a'로 넘어오도록
                if (sum > 122) sum -= 26;
            }

            answer += (char)sum;
        }
        return answer;
    }
}
