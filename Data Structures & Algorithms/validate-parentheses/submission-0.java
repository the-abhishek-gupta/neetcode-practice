class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '[' || c == '{' || c== '('){
                stack.push(c);
            }
            else{
                if (!stack.isEmpty()){
                    if (c == ']' && stack.peek() == '['){
                        stack.pop();
                    }
                    else if (c == '}' && stack.peek() == '{'){
                        stack.pop();
                    }
                    else if (c == ')' && stack.peek() == '('){
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }
                }
                else
                    return false;
            }
            System.out.println("stack :"+stack);
        }
        return stack.isEmpty();
    }
}
