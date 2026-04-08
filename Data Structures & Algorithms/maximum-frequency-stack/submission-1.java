class FreqStack {

    Map<Integer, Integer> map;
    List<Integer> stack;

    public FreqStack() {
        map = new HashMap<>();
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        map.put(val, map.getOrDefault(val, 0) + 1);
    }
    
    public int pop() {
        int maxCnt = Collections.max(map.values());
        int i = stack.size() - 1;
        while(map.get(stack.get(i)) != maxCnt){
            i--;
        }
        int val = stack.remove(i);
        map.put(val, map.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */