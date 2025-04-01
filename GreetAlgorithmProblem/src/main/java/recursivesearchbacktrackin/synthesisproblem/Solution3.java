package recursivesearchbacktrackin.synthesisproblem;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
class Solution3 {
    String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ret;
    StringBuilder path;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<String>();
        path=new StringBuilder();
        ret=new ArrayList<>();
        dfs(digits,0);
        return ret;
    }
    public void dfs(String digits,int pos){
        if(pos==digits.length()){
            ret.add(path.toString());
            return;
        }
        String s=arr[digits.charAt(pos)-'0'];
        for(int i=0;i<s.length();i++){
            path.append(s.charAt(i));
            dfs(digits,pos+1);
            // 回溯
            path.deleteCharAt(pos);
        }
    }
}