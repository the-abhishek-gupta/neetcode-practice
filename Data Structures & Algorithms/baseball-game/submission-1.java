class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String each : operations){
            if (each.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                int n = a+b;
                stack.push(b);
                stack.push(a);
                stack.push(n);
            }
            else if (each.equals("D")){
                int a = stack.pop();
                int n = a*2;
                stack.push(a);
                stack.push(n);
            }
            else if (each.equals("C")){
                stack.pop();
            }
            else{
                int n = Integer.parseInt(each);
                stack.push(n);
            }
        }
        for (int each : stack)
            sum+= each;
        return sum;
    }
}