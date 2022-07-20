import java.util.Arrays;

public class Day5_Q3 {

//-------------------------------------------------------------내 답안
    // 2진법으로 변환해주는 Method
    public String[] toBinary(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];

        for (int i = 0; i < arr.length; i++) {
            sb.delete(0,n);
            while (arr[i] != 0) {
                int x = arr[i] % 2;
                arr[i] /= 2;
                sb.append(x);
            }

            while(sb.length() != n) {
                sb.append(0);
            }
            answer[i] = sb.reverse().toString();
        }
        return answer;
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] temp1 = toBinary(n, arr1);
        String[] temp2 = toBinary(n, arr2);
        String[] answer = new String[n];


        for (int i = 0; i < temp1.length; i++) {
            String num = "";
            for (int j = 0; j < temp1[i].length(); j++) {
                if(temp1[i].charAt(j) == '0' && temp2[i].charAt(j) == '0') {
                    num += ' ';
                } else num += '#';
            }
            answer[i] = num;
        }

        return answer;
    }
//-------------------------------------------------------------내 답안




/*-------------------------------------------------------------참고답안
    비트연산자(|)를 사용하여 간단하게 연산
 */


    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            System.out.println(answer[i]);
        }

        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%"+n+"s", answer[i]);
            System.out.println(answer[i]);
            answer[i] = answer[i].replaceAll("1", "#");
            answer[i] = answer[i].replaceAll("0", " ");
        }

        return answer;
    }
//-------------------------------------------------------------참고답안
}
