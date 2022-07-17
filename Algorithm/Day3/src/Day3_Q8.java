public class Day3_Q8 {
    public String solution(String new_id) {
        //1단계: 모든 대문자를 소문자로 치환
        String temp1 = new_id.toLowerCase();

        //2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String check = "abcdefghijklmnopqrstuvwxyz0123456789-_.";
        String temp2 = "";
        for (int i = 0; i < temp1.length(); i++) {
            for (int j = 0; j < check.length(); j++) {
                if(temp1.charAt(i) == check.charAt(j)) temp2 += temp1.charAt(i);
            }
        }

        //3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while (temp2.contains("..")) {
            temp2 = temp2.replace("..", ".");
        }

        //4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (temp2.startsWith(".")) temp2 = temp2.substring(1);

        //5단계: 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(temp2.isEmpty()) temp2 += "a";

        //6단계: 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        if(temp2.length() >= 16) temp2 = temp2.substring(0, 15);
        if (temp2.endsWith(".")) temp2 = temp2.substring(0, temp2.length()-1);

        //7단계: 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(temp2.length() <= 2) {
            while (temp2.length() != 3){
                temp2 += temp2.charAt(temp2.length()-1);
            }
        }
        return temp2;
    }
}
