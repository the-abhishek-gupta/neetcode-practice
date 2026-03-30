class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if (c == '.')
                    continue;
                String c_row = c+"_row_"+i;
                String c_col = c+"_col_"+j;
                String c_box = c+"_box_"+(i/3)+"_"+(j/3);
                if (set.contains(c_row) || set.contains(c_col) || set.contains(c_box))
                    return false;
                set.add(c_row);
                set.add(c_col);
                set.add(c_box);
            }
        }
        return true;
    }
}
