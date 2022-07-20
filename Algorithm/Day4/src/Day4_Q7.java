import java.util.ArrayList;

public class Day4_Q7 {
    public static int solution(int n) {

        if(n == 2) return 1;

        ArrayList<Integer> pList = new ArrayList<>();
        pList.add(2);
        pList.add(3);

        for (int i = 5; i <= n; i+=2) {
            boolean isPrime = true;
            for (int j = 1; pList.get(j) * pList.get(j) <= i; j++) {
                if(i % pList.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                pList.add(i);
            }

        }
        return pList.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }
}
