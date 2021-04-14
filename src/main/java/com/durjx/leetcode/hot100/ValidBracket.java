package com.durjx.leetcode.hot100;

import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author durjx
 * @date 2021/4/13
 * @description 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 **/
@Slf4j
public class ValidBracket {
    public static void main(String[] args) {
        String s = "{[]}";

        ValidBracket validBracket = new ValidBracket();
        log.info("结果：" + validBracket.isValid(s));
    }

    public boolean isValid(String s) {
        int length = s.length();
        Deque<Character> deque = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        //字符串长度是奇数，则不可能匹配成功
        if (length % 2 == 1) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                //deque.peek(); 队列的第一个元素
                if (deque.isEmpty() || !deque.peek().equals(map.get(c))) {
                    return false;
                }
                //删除链表的第一个元素
                deque.pop();
            } else {
                //双向队列里插入数据
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }
}
