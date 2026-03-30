class MyQueue {

    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        return reversedStack(true);
    }
    
    public int peek() {
        return reversedStack(false);
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }

    private int reversedStack(boolean flag){
        Stack<Integer> rev = new Stack<>();
        while (!stack.isEmpty())
            rev.push(stack.pop());
        int ans = rev.peek();
        if (flag)
            rev.pop();
        while (!rev.isEmpty())
            stack.push(rev.pop());
        return ans;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */