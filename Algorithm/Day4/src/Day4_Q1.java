public class Day4_Q1 {
    public int solution(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++)
            sum += (i % Math.sqrt(i) == 0)? -i : i;
        return sum;
    }
}
