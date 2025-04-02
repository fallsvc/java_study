package recursivesearchbacktrackin.synthesisproblem;

import java.util.ArrayList;
import java.util.List;


public class Solution4 {
    //https://leetcode.cn/problems/generate-parentheses/
    int left,right,count;
    StringBuilder path;
    List<String> list;
    public List<String> generateParenthesis(int n) {
        path=new StringBuilder();
        list=new ArrayList<String>();
        count=n;
        dfs();
        return list;
    }
    public void dfs(){
        if(left>count||right>left) return;
        if(right==count) list.add(path.toString());
        

       //选左括号
        path.append("(");
        left++;
        dfs();
        // 回溯
        left--;
        path.deleteCharAt(path.length()-1);
        // 选右括号
        path.append(")");
        right++;
        dfs();
        // 回溯
        right--;
        path.deleteCharAt(path.length()-1);

    }
    // 另外一种写法
//        int left,right,count;
//    StringBuilder path;
//    List<String> list;
//    public List<String> generateParenthesis(int n) {
//        path=new StringBuilder();
//        list=new ArrayList<String>();
//        count=n;
//        dfs();
//        return list;
//    }
//    public void dfs(){
//        if(right==count) list.add(path.toString());
//
//        if(left<count){
//             //选左括号
//            path.append("(");
//            left++;
//            dfs();
//            // 回溯
//            left--;
//            path.deleteCharAt(path.length()-1);
//        }
//
//        if(left>right){
//            // 选右括号
//            path.append(")");
//            right++;
//            dfs();
//            // 回溯
//            right--;
//            path.deleteCharAt(path.length()-1);
//
//        }
}