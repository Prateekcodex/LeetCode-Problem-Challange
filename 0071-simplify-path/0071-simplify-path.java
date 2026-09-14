class Solution {
    public String simplifyPath(String path) {

        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            }

            else {
                stack.offerLast(part);
            }
        }

        return "/" + String.join("/", stack);
    }
}