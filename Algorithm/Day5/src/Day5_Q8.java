import java.util.Stack;

public class Day5_Q8 {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][moves[i] - 1] != 0) {
                    if(!stack.isEmpty() && stack.peek() == (board[j][moves[i] - 1])) {
                        stack.pop();
                        count += 2;
                        (board[j][moves[i] - 1]) = 0;
                        break;
                    } else {
                        stack.push(board[j][moves[i] - 1]);
                        board[j][moves[i] - 1] = 0;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
