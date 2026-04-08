class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        String currStr = "";
        int k = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            } else if(c == '['){
                countStack.push(k);
                stringStack.push(currStr);

                currStr = "";
                k = 0;
            } else if(c == ']'){
                int repeat = countStack.pop();
                String prevStr = stringStack.pop();

                StringBuilder sb = new StringBuilder(prevStr);
                for(int i = 0; i < repeat; i++){
                    sb.append(currStr);
                }
                currStr = sb.toString();
            } else {
                currStr += c;
            }
        }
        return currStr;
    }
}