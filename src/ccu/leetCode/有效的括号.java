package ccu.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author huang_2
 * @Date 2020/4/1 11:44 上午
 * @Description TODO
 */
public class 有效的括号 {

    private Map<Character,Character> map = new HashMap<>();

    public 有效的括号(){
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                char cur = stack.isEmpty()? '*' : stack.pop();
                if(cur != map.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return true;

    }

}
