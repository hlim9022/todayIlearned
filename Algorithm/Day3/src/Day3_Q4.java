import java.util.Arrays;

public class Day3_Q4 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] str = s.split("");

        //compareTo로 문자열 역순으로 배치 후, StringBuilder에 하나씩 넣어서 문자열 완성
        Arrays.stream(str).sorted((a,b)->b.compareTo(a)).forEach(x->sb.append(x));
        return sb.toString();
    }
}
