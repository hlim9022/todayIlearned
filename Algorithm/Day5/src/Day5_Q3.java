public class Day5_Q3 {


    //------------------------------------------------내 답안
    public static String[] toBinary(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];

        //arr안에 있는 10진법 수를 2진법으로 변환
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
    //------------------------------------------------내 답안


    //----------------------------------------------다른 풀이
    public String[] solution2(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];

        //비트연산자와 Integer의 method를 사용
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = String.format("%" + n + "s", result[i]);
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }

        return result;
    }
}
