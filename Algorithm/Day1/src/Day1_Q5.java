public class Day1_Q5 {
    public static String solution(String s) {

/* 첫 답안 => 답은 나오나 제출시에 실패로 뜸
    String이 아닌 char값으로 시도 => 형변환 오류로 인한 실패인 듯

        String[] sList = s.split(" ");
        StringBuilder answer = new StringBuilder();

        for (int j = 0; j < sList.length; j++) {
            for (int i = 0; i < sList[j].length(); i++) {
                if (i % 2 == 0) {
                    answer.append((char) ((sList[j].charAt(i)) - 32));
                    continue;
                }
                answer.append(sList[j].charAt(i));
            }

            if (j == sList.length - 1) {
                answer.append("");
            } else answer.append(" ");
        }
        return answer.toString();

 */

        String answer = "";
        String[] str = s.split(""); // 각 문자를 String으로 저장하여 배열을 만듬
        int idx = 0;

        for (int i = 0; i < str.length; i++) {
            // blank값인 경우에 idx값을 다시 0으로 세팅 => 각 단어에서 짝수인덱스의 문자가 대문자로 변환되어야하기 때문
            if (str[i].equals(" ")){
                answer += " ";
                idx = 0;
            } else if (idx % 2 == 0){
                answer += str[i].toUpperCase();
                idx++;
            } else {
                answer += str[i].toLowerCase();
                idx++;
            }
        }
        return answer;
    }
}
