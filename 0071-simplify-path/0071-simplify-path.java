class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directory = path.split("/");

        for(String dir : directory){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            }
            else if(dir.equals("..")){
                if(!stack.isEmpty())stack.pop();
            }
            else{
                stack.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.insert(0, "/"+stack.pop());
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}