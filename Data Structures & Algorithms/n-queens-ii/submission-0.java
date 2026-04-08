class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        backtrack(0, n, col, diag1, diag2);
        return count;
    }
    private void backtrack(int row, int n, boolean[] col, boolean[] diag1, boolean[] diag2){
        if(row == n){
            count++;
            return;
        }
        for(int c = 0; c < n; c++){
            if(col[c] || diag1[row + c] || diag2[row - c + (n - 1)]){
                continue;
            }
            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + (n - 1)] = true;

            backtrack(row + 1, n, col, diag1, diag2);

            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + (n - 1)] = false;
        }
    }
}