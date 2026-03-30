class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        int i = 0;
        for (char c: s.toCharArray()){
            if (c == '(')
                open.push(i);
            else if (c == '*')
                star.push(i);
            else{
                if (open.size() > 0)
                    open.pop();
                else if (star.size() > 0)
                    star.pop();
                else 
                    return false;
            }
            i++;
        }
        while (open.size() > 0 && star.size()> 0){
            if (star.pop() < open.pop()){
                return false;
            }
        }
        return open.isEmpty();
    }
}
