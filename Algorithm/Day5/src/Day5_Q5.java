public class Day5_Q5 {
    public int solution(String dartResult) {
        char[] cList = dartResult.toCharArray();
        int[] answer = new int[3]; // 3번의 점수 기회
        int idx = 0;
        String temp = "";

        for (int i = 0; i < cList.length; i++) {
            switch (cList[i]) {
                case 'S':
                    answer[idx++] = Integer.parseInt(temp);
                    temp = "";
                    break;
                case 'D':
                    answer[idx++] = (int)Math.pow(Integer.parseInt(temp),2);
                    temp = "";
                    break;
                case 'T':
                    answer[idx++] = (int)Math.pow(Integer.parseInt(temp),3);
                    temp = "";
                    break;
                case '*':
                    answer[idx - 1] *= 2;
                    if(idx > 1) answer[idx - 2] *=2;
                    break;
                case '#':
                    answer[idx - 1] *= -1;
                    break;
                default:
                    temp += String.valueOf(cList[i]);
                    break;
            }
        }

        int aNum = 0;
        for (int i = 0; i < answer.length; i++) {
            aNum += answer[i];
        }
        return aNum;
    }
}
