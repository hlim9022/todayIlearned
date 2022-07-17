import java.util.*;

public class Day3_Q2 {

    // 내 답안
    public static ArrayList<Integer> solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        //key-value값으로 저장하기 위한 해시맵 선언
        HashMap<Integer, Integer> list = new HashMap<>();
        //해시맵 초기화 { {1, 0}, {2, 0}, {3, 0} }
        for (int i = 1; i <= 3; i++) {
            list.put(i, 0);
        }

        for (int i = 0; i < answers.length; i++) {
            if(p1[i % p1.length] == answers[i]) list.put(1,list.getOrDefault(1,0)+1);
            if(p2[i % p2.length] == answers[i]) list.put(2,list.getOrDefault(2,0)+1);
            if(p3[i % p3.length] == answers[i]) list.put(3,list.getOrDefault(3,0)+1);
        }

        //value 최대값 구하기
        int val = Math.max(list.get(1), (Math.max(list.get(2), list.get(3))));

        //최대값과 같은 값이 있으면 리스트에 추가
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= list.size(); i++) {
            if (list.get(i) == val) answer.add(i);
        }

        return answer;
    }


    // 개념은 비슷하나 해시맵이 아닌 배열로 푼 문제, 참고할 것!
    public static int[] solution2(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        //3명의 사람은 고정이기 때문에 배열크기 초기화가능
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if(p1[i % p1.length] == answers[i]) score[0]++;
            if(p2[i % p2.length] == answers[i]) score[1]++;
            if(p3[i % p3.length] == answers[i]) score[2]++;
        }

        int val = Math.max(score[0], (Math.max(score[1], score[2])));

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == val) answer.add(i+1);
        }

        //stream을 통해 리스트를 배열로 전환하여 반환
        return answer.stream().mapToInt(x->x.intValue()).toArray();
    }
}
