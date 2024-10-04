package unionfindset;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/30  19:32
 */
public class Demo1 {
    public static boolean equationsPossible(String[] equations) {
        UnionFindSet unionFindSet=new UnionFindSet(26);

        for(String str: equations){
            if(str.charAt(1)=='='){
                unionFindSet.union(str.charAt(0)-97,str.charAt(3)-97);
            }
        }

        for(String str:equations){
            if(str.charAt(1)=='!'&&unionFindSet.isSameUnionFindSet(str.charAt(0)-97,str.charAt(3)-97)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] str={"a==b","b!=a"};
        System.out.println(equationsPossible(str));
    }

    public static void main1(String[] args) {
        UnionFindSet unionFindSet = new UnionFindSet(10);

        unionFindSet.union(0,7);
        unionFindSet.union(0,8);
        unionFindSet.union(0,9);
        unionFindSet.union(2,6);
        unionFindSet.union(2,5);
        unionFindSet.union(3,4);

        unionFindSet.union(0,1);

        unionFindSet.union(0,2);

        for (int i = 0; i < unionFindSet.elem.length; i++) {
            System.out.print(unionFindSet.elem[i]+" ");
        }
        System.out.println();

    }
}