class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];
        backtrack(0, n, board, result, col, diag1, diag2);
        return result;
    }
    private void backtrack(int row, int n, char[][] board, List<List<String>> result, boolean[] col, boolean[] diag1, boolean[] diag2){
        if(row == n) {
            result.add(construct(board));
            return;
        }
        for(int c = 0; c < n; c++){
            if(col[c] || diag1[row + c] || diag2[row - c + (n - 1)]) continue;
            board[row][c] = 'Q';
            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + (n - 1)] = true;

            backtrack(row + 1, n, board, result, col, diag1, diag2);

            board[row][c] = '.';
            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + (n - 1)] = false;

        }
    }
    private List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}
