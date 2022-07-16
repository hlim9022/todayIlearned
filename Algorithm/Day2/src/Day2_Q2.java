public class Day2_Q2 {
    public int[] removeMin(int[] arr) {
        int min = arr[0];

        // 요소 중에 최소값 찾기
        for(int i=0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        // 최소값을 제외하여 리턴할 배열 생성
        int[] rList = new int[arr.length - 1];
        int idx = 0;
        for(int i=0; i < arr.length; i++) {
            if (arr[i] == min) continue; //찾은 최소값은 제외하고 배열에 넣기
            else rList[idx++] = arr[i];
        }
        return rList;
    }

    public int[] solution(int[] arr) {
        int[] answer;
        if (arr.length <= 1) {
            answer = new int[]{-1};
        } else {
            answer = removeMin(arr);
        }
        return answer;
    }
}
