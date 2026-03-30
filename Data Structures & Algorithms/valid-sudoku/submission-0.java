class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length;i++){
            for (int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if (c != '.'){
                    String c_in_i = c +"i"+i;
                    String c_in_j = c +"j"+j;
                    String c_in_i_j = c +"i_j"+(i/3)+"_"+(j/3);
                    if (set.contains(c_in_i) || set.contains(c_in_j) || set.contains(c_in_i_j))
                        return false;
                    set.add(c_in_i);
                    set.add(c_in_j);
                    set.add(c_in_i_j);
                }
            }
        }
        return true;
    }
}
