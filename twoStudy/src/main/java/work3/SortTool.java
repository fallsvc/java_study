package work3;

public class SortTool {
	public static void sort(String[] strList) {
		// 完成倒序排序代码；提示：strList[i].compareTo()
        // 冒泡排序
		for (int i = 0; i < strList.length-1; i++) {
			for (int j = 0; j < strList.length-1-i; j++) {
				if(strList[j].compareTo(strList[j+1])<0){
					swap(strList,j,j+1);
				}
			}
		}
	}

	private static void swap(String[] strList, int i, int j) {
		String tmp=strList[i];
		strList[i]=strList[j];
		strList[j]=tmp;
	}
}