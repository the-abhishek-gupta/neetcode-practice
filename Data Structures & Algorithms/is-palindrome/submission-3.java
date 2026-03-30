class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (Character.isLetterOrDigit(c))
                sb.append(c);
        }
        int left = 0;
        int right = sb.length()-1;

        while (left < right && sb.charAt(left) == sb.charAt(right)){
            left++;
            right--;
        }
        return left >= right;
    }
}
