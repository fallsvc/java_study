package recursivesearchbacktrackin.synthesisproblem;

import java.util.ArrayList;
import java.util.List;

class Solution7 {
	//https://leetcode.cn/problems/letter-case-permutation/
    StringBuilder path;
    List<String> ret;
    public List<String> letterCasePermutation(String s) {

        path=new StringBuilder();
        ret=new ArrayList<>();

        dfs(s,0);
        return ret;
    }

    public void dfs(String s,int pos){
        if(s.length()==pos){
            ret.add(path.toString());
            return;
        }
        char ch=s.charAt(pos);

        // 不改变
        path.append(ch);
        dfs(s,pos+1);
        // 回溯
        path.deleteCharAt(path.length()-1);

        if(ch<'0'||ch>'9'){
            path.append(change(ch));
            dfs(s,pos+1);
            // 回溯
            path.deleteCharAt(path.length()-1);
        }

     
    }
    public char change(char ch){
        if(ch>='a'&&ch<='z'){
            //
            ch-=32;

        }else{
            ch+=32;
        }
        return ch;
    }
}
