import java.util.*;

public class Day4_Q5 {
    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            for(int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                list.add(array[j]);
            }
            Collections.sort(list);

            answer[i] = list.get(commands[i][2] - 1);
            list.clear();
        }

        return answer;
    }
}

