import java.util.ArrayList;

public class Day3_Q5 {
    public int solution(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        // 숫자 3개를 뽑아 나올 수 있는 합 리스트 생성
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        int answer = 0;

        /* 소수는 1을 제외하고 자기자신으로 밖에 나누어 떨어지지 않기 때문에,
        2부터 나눠봤을 때 자기자신을 제외한 나머지가 0인 값이 없다면 소수!
        => 하나라도 나누어 떨어지는 값이 있다면 isPrime = false
         */
        for (int i = 0; i < list.size(); i++) {
            boolean isPrime = true;
            for (int j = 2; j < list.get(i); j++) {
                if (list.get(i) % j == 0) {
                    isPrime = false;
                }
            }

            //isPrime = true일 때 값이 증가 => 소수개수 증가
            if(isPrime) answer++;
        }

        return answer;
    }
}
