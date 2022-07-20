import java.util.ArrayList;

public class Day4_Q4 {
    public int[] solution(int n, int m) {
        ArrayList<Integer> nList = new ArrayList<>();
        ArrayList<Integer> mList = new ArrayList<>();

        //n의 약수 구하기
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) nList.add(i);
        }

        //m의 약수 구하기
        for (int i = 1; i <= m; i++) {
            if (m % i == 0) mList.add(i);
        }

        // n과 m의 약수 중 공통된 부분만 추출
        nList.retainAll(mList);

        //추출된 리스트에서 마지막 인덱스값 => 최대공약수
        int temp = nList.get(nList.size()-1);

        // 최소공배수 = 최대공약수 * (n을 최대공약수로 나눈값) * (m을 최대공약수로 나눈값)
        int lcm = temp * (n / temp) * (m / temp);

        int[] answer = {temp, lcm};
        return answer;
    }
}
