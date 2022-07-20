public class Day5_Q7 {
    public int solution(int n) {
        int count = 0;

        for(int i=1; i<=n; i++) {
            int j = i;
            int sum = n;
            while(sum >= 0) {
                sum -= j;
                j++;

                if(sum == 0) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
