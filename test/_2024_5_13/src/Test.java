/**
 * @auther falls_vc
 * description:
 * @date 2024/5/13  18:14
 */


public class Test {
    //bf
     public static void getNext(String sub,int[] next){
            next[0]=-1;
            next[1]=0;
            int i=2;//多走一步
            int j=0;
            while(i<sub.length()){
                if(j==-1||sub.charAt(j)==sub.charAt(i-1)){
                    next[i]=j+1;
                    i++;
                    j++;
                }else{
                    j=next[j];
                }
            }
        }
    public static int KMP(String str,String sub,int pos){
        if(str==null||sub==null) return -1;
        int lenStr=str.length();
        int lenSub=sub.length();
        if(lenStr==0||lenSub==0) return -1;
        if(pos<0||pos>=lenStr) return -1;

        int[] next=new int[lenSub];
        int[] nextVal=new int[lenSub];

        getNext(sub,next);
//        getNextVal(sub,next,nextVal);

        int i=pos;//str
        int j=0;//sub
        while(i<lenStr&&j<lenSub){
            if(j==-1||str.charAt(i)==sub.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
        }

        if(j>=lenSub){
            return i-j;
        }
        return -1;
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
        System.out.println(KMP("aaagaghaaad","aad",0));
    }

    public static void main(String[] args) {
        TestDemo t=new TestDemo();
        System.out.println(t.x);

         TestDemo.m_z=20;
         TestDemo.setZ(30);
        System.out.println(TestDemo.m_z);


    }

    public static void main1(String[] args) {
        System.out.println(TestDemo.m_z);
        TestDemo t=new TestDemo(10,20);
        System.out.println(t.x);
        t.setX(100);
        t.setY(200);
        System.out.println(t);
        System.out.println(t.getX() + t.getY());
    }
}
