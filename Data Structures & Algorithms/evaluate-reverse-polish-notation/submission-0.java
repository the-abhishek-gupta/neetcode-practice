class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("*");
        set.add("+");
        set.add("-");
        set.add("/");
        Stack<Integer> stack = new Stack<>();
        for (String each : tokens){
            if (set.contains(each))
                eval(stack, each);
            else
                stack.push(Integer.parseInt(each));
        }
        return stack.pop();
    }
    void eval(Stack<Integer> stack, String op){
        System.out.println(op+" "+stack);
        int b = stack.pop();
        int a = stack.pop();
        int c = -1;
        if (op.equals("+"))
            c = a+b;
        else if (op.equals("-"))
            c = a-b;
        else if (op.equals("*"))
            c = a*b;
        else if (op.equals("/"))
            c = a/b;
        stack.push(c);

        System.out.println(stack);
    }
}
