/**
 * @auther falls_vc
 * description:
 * @date 2024/5/12  10:32
 */
public class Test {
    //KMP next[]

    public static int KMP(String str,String sub,int pos){
        if(str==null||sub==null){
            return -1;
        }
        int lenStr=str.length();
        int lenSub=sub.length();
        if(lenStr==0||lenSub==0){
            return -1;
        }
        if(pos<0||pos>lenStr){
            return -1;
        }
        int[] next=new int[lenSub];
        int[] nextVal=new int[lenSub];

        getNext(sub,next);
        getNextVal(sub,next,nextVal);
//           int[] next=new int[]{-1,-1,-1,-1,-1,-1,5} ;

        int i=pos;//遍历主串
        int j=0;//遍历字串
        while(i<lenStr&&j<lenSub){
            if(j==-1||str.charAt(i)==sub.charAt(j)){
                i++;
                j++;
            }else{
                j=nextVal[j];
            }
        }
        if(j>=lenSub){
            return i-j;
        }
        return -1;
    }

    public static void getNext(String sub,int[] next){
        int len=sub.length();
        next[0]=-1;
        next[1]=0;
        int i=2;//提前一步
        int j=0;
        while(i<len){
            if(j==-1||sub.charAt(j)==sub.charAt(i-1)){
                next[i]=j+1;
                i++;
                j++;
            }else{
                j=next[j];
            }
        }
    }
    public static void getNextVal(String sub,int[] next,int[] nextVal){
        nextVal[0]=-1;
        int i=1;
        while(i<sub.length()){
            if(sub.charAt(i)==sub.charAt(next[i])){
                nextVal[i]=nextVal[next[i]];
            }else{
                nextVal[i]=next[i];
            }
            i++;
        }
    }

    public static void main2(String[] args) {
//        System.out.println(KMP("ahdkshej","ksh",0));
//        System.out.println(KMP("ahdkshej","ahdk",0));
//
//        System.out.println(KMP("ahdkshej","zdhr",0));

        System.out.println(KMP("aabbaaaaaaaah","aaaaaah",0));
    }
    //BF
    public static int BF(String str,String sub){
        if(str==null&&sub==null){
            return -1;
        }
        int strLength=str.length();
        int subLength=sub.length();
        if(strLength==0&&subLength==0){//防止字符串为""无元素
            return -1;
        }
        int i=0;//遍历主串
        int j=0;//遍历子串
        while(i<strLength&&j<subLength){
            if(str.charAt(i)==sub.charAt(j)){
                i++;
                j++;
            }else{
                i=i-j+1;
                j=0;
            }
        }
        if(j>=subLength){
            return i-j;
        }

        return -1;
    }
    public static void main1(String[] args) {

        String a="rf";

        System.out.println(BF("abdsfsfhjs","safs"));
    }
}
