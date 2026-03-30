class Solution {
    public int reverse(int x) {
        boolean flag = x < 0;
        if (x < 0)
            x *= -1;

        int sum = 0;
        while (x > 0) {
            int digit = x % 10;

            if (sum > (Integer.MAX_VALUE - digit) / 10) {
                return 0;
            }

            sum = sum * 10 + digit;
            x /= 10;
        }

        return flag ? -sum : sum;
    }

}
