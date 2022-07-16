public class Day2_Q4 {
    public boolean solution(int x) {
        int sum = 0;
        int a = x;

        while(x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return (a % sum == 0);
    }
}
