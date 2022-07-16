public class Day2_Q6 {
    public static int solution(int[][] sizes) {

        // 항상 sizes[i][0]이 sizes[i][1]보다 큰값이 되도록 만들어줌
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        int maxW = sizes[0][0];
        int maxH = sizes[0][1];

        // 가로와 세로 중 최대 값 찾기
        for (int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] > maxW) maxW = sizes[i][0];
            if(sizes[i][1] > maxH) maxH = sizes[i][1];
        }
        return maxH * maxW;
    }
}
