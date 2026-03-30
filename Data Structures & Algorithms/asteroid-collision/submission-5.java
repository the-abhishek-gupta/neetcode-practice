class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int each : asteroids){  
            boolean  flag = true;
            while (!stack.isEmpty() && stack.peek() > 0 && each < 0){
                if (Math.abs(stack.peek()) < Math.abs(each)){
                    stack.pop();
                    continue;
                }
                else if (stack.peek() + each == 0)
                    stack.pop();
                flag = false;
                break;
            }
            if (flag)
                stack.push(each);
        }
        int n = stack.size();
        int[] ans = new int[n];
        for (int i = n-1; i >=0; i--)
            ans[i] = stack.pop();
        return ans;
    }
}