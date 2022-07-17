public class Day3_Q6 {

    // 내 답안
    public int solution(String s) {
        String[] nStr = { "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};

        String temp = "";
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            //문자가 숫자가 아닌 경우
            if(!(s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                //문자를 하나씩 더해서 String을 생성
                temp += s.charAt(i);

                // nStr 배열에 글자와 동일하다면, 숫자값을 답 String에 더한 후 temp를 다시 빈 String으로 초기화
                for (int j = 0; j < nStr.length; j++) {
                    if(temp.equals(nStr[j])) {
                        answer += j;
                        temp = "";
                    }
                }

            //문자가 숫자인 경우에는 그대로 답 String에 더해줌
            } else {
                answer += s.charAt(i);
            }
        }
        return Integer.parseInt(answer);
    }


    /* 참고하면 좋을 심플 답안
        => nStr 배열에 문자열을 담아두고 입력된 s에 이 배열 안에 문자와 동일한 string이 있다면
        인덱스 번호가 곧 그 문자열 숫자이니 이 값으로 교체!
        (단, 숫자가 아닌 String형태로 추가해야하니 i + "" 으로 입력하여 String으로 형변환)
     */
    public int solution2(String s) {
        String[] nStr = { "zero", "one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine"};

        for (int i = 0; i < nStr.length; i++) {
            s = s.replaceAll(nStr[i], i + "");
        }
        return Integer.parseInt(s);
    }
}
