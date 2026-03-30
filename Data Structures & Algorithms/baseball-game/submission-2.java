class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String each : operations){
            if (each.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a+b);
            }
            else if (each.equals("D")){
                stack.push(2 * stack.peek());
            }
            else if (each.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(each));
            }
        }
        for (int each : stack)
            sum+= each;
        return sum;
    }
}