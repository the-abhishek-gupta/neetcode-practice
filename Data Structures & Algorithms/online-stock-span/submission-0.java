class StockSpanner {

    Stack<Item> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int ct = 1;
        while (!stack.isEmpty() && price >= stack.peek().val){
            ct+=stack.pop().i;
        }
        stack.push(new Item(price, ct));
        return ct;
    }
}
class Item{
    int val, i;
    Item(int v, int i){
        this.val = v;
        this.i = i;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */