class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        char[] arr = path.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= arr.length; i++){
            if(i == arr.length || arr[i] == '/'){
                String dir = sb.toString();
                sb.setLength(0);

                if(dir.equals("") || dir.equals(".")){
                    continue;
                } else if(dir.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else {
                    stack.push(dir);
                }
            } else {
                sb.append(arr[i]);
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder result = new StringBuilder();
        for(String s : stack){
            result.append("/").append(s);
        }
        return result.toString();
    }
}