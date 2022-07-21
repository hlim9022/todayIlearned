import java.util.Arrays;

public class Day5_Q4 {
    public static String solution(int[] numbers, String hand) {
        int[][] location = {{1,2,3}, {4,5,6}, {7,8,9}, {10,0,11}};

        String answer = "";

        int[] rStart = {3,2};
        int[] lStart = {3,0};

        int tempX = 0, tempY = 0;
        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < location.length; j++) {
                for (int k = 0; k < location[0].length; k++) {
                    if (numbers[i] == location[j][k]) {
                        tempX = j;
                        tempY = k;
                    }
                }
            }

            // 1,4,7인 경우는 무조건 '왼손(L)'이 누른다
            if (tempY == 0) {
                answer += "L";
                lStart[0] = tempX;
                lStart[1] = tempY;
            // 3,6,9인 경우는 무조건 '오른손(R)'이 누른다
            } else if (tempY == 2) {
                answer += "R";
                rStart[0] = tempX;
                rStart[1] = tempY;

            //그 외의 숫자는 현재 각 손가락의 위치에서 거리가 가까운 손가락이 누른다
            } else {
                int disL = Math.abs(tempX - lStart[0]) + Math.abs(tempY - lStart[1]);
                int disR = Math.abs(tempX - rStart[0]) + Math.abs(tempY - rStart[1]);

                if(disL > disR) {
                    answer += "R";
                    rStart[0] = tempX;
                    rStart[1] = tempY;
                } else if (disL < disR) {
                    answer += "L";
                    lStart[0] = tempX;
                    lStart[1] = tempY;
                //거리값이 같은 경우, 주 손이 누른다
                } else {
                    if(hand.equals("right")){
                        answer += "R";
                        rStart[0] = tempX;
                        rStart[1] = tempY;
                    } else if(hand.equals("left")){
                        answer += "L";
                        lStart[0] = tempX;
                        lStart[1] = tempY;
                    }
                }
            }
        }
        return answer;
    }
}
