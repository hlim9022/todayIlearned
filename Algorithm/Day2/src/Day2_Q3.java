public class Day2_Q3 {
    public static int solution(int num) {
        int count = 0;
        long n = (long) num;

        while (!(n == 1 || count == 500)) {
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;

            System.out.println(n);
            count++;
        }
        return (count == 500) ? -1 : count;
    }
}
