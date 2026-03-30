class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String op : tokens){
            if (op.equals("+"))
                stack.push(stack.pop()+ stack.pop());
            else if (op.equals("-"))
                stack.push(-1 * stack.pop() + stack.pop());
            else if (op.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (op.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }
            else
                stack.push(Integer.parseInt(op));
        }
        return stack.pop();
    }
}
