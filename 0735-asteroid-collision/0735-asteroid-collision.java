import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() &&
                   asteroid < 0 &&
                   stack.peek() > 0) {

                if (stack.peek() < -asteroid) {
                    // Stack asteroid explodes
                    stack.pop();
                }
                else if (stack.peek() == -asteroid) {
                    // Both explode
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else {
                    // Current asteroid explodes
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}