import java.util.HashMap;

public class Day1_Q4 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();

        /* HashMap안에 각 참가자에 대해 {"이름", 1}으로 값을 저장,
        getOrDefault -> key에 대한 value값이 있다면 그 값을 가져오고, 없다면 defualt값(0)으로 세팅
        * */
        for (String ppl : participant) {
            hm.put(ppl, hm.getOrDefault(ppl, 0) + 1);
        }

        /* 완주자 명단에 이름(key)가 있으면, value에서 1을 빼줌
        * */
        for (String com : completion) {
            hm.put(com, hm.get(com) - 1);
        }

        /* 이름(key)값을 순회하면서 value값이 0이 아닌 값을 찾음
        => 0이 아닌 사람은 완주자 명단에 없는 사람
        * */
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
            }
        }
        return answer;
    }
}
