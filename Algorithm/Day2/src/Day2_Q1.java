public class Day2_Q1 {
    public static long solution(long n) {

        return ((int)Math.sqrt(n) == Math.sqrt(n))?
                (long)Math.pow((int)Math.sqrt(n)+1, 2) : -1;
    }
}
