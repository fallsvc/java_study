package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/4  16:33
 */
public class MyArrayList {
    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        StringBuilder stringBuilder=new StringBuilder("[ ");
        for (int i = 0; i < elem.length; i++) {
            stringBuilder.append(i);
            if(i!=elem.length-1)
                stringBuilder.append(" ,");
        }
        stringBuilder.append(" ]");

        System.out.println(stringBuilder.toString());
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        if(isFull()){
            elem=new int[usedSize*2];
        }
        elem[usedSize]=data;
        usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        if(usedSize==elem.length){
            return true;
        }
        return false;
    }


    private boolean checkPosInAdd(int pos) {
        if(pos>=0&&pos<=usedSize){
            return true;//合法
        }
        throw new CheckPos1Exception("checkPosInAddException ");
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if(isFull()){
            elem=new int[usedSize*2];
        }
        checkPosInAdd(pos);

        //pos 后面后挪一位
        for (int i = usedSize; i > pos ; i--) {
            elem[i]=elem[i-1];
        }
        elem[pos]=data;
        usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elem[i]==toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < usedSize; i++) {
            if (elem[i]==toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos) {
        if(pos<0||pos>=usedSize){
            throw new CheckPos1Exception("pos  不合法");
        }
        return elem[pos];
    }

    private boolean isEmpty() {
        if(usedSize==0){
            return true;
        }

        return false;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        if(pos<0||pos>=usedSize){
            throw new CheckPos1Exception("pos 不合法！ ");
        }
        elem[pos]=value;
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
        for (int i = 0; i < usedSize; i++) {
            if(elem[i]==key){
                for (int j = i; j <usedSize-1; j++) {
                    elem[j]=elem[j+1];
                }
                break;
            }
        }
        usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return usedSize;
    }

    // 清空顺序表
    public void clear() {
        elem=new int[DEFAULT_SIZE];
        usedSize=0;
    }
}
