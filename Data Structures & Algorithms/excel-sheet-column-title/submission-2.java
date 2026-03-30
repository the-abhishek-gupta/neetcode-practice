class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber-- > 0){
            int val = columnNumber % 26;
            columnNumber = columnNumber / 26;
            sb.append((char)('A'+val));
        }
        return sb.reverse().toString();
    }
}