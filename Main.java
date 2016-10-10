
public class Main {
	

	public static void main(String[] args) {
		String str = "qwertydqwedsdswyqwertyuiopuiosd";
		System.out.println(getSubLength(str));
	}
	
	/*声明两个指针front和last,last初始指向位置0，front初始指向位置1。
	 * front向前移动，每移动一次就和front和last之间的字符遍历比较，
	 * 如果发现重复，front-last-1的长度就是当前最大子字符串的长度，last位置变为front-1，front继续向前移动
	 * 如果没有发现重复，则继续向前移动，
	 * 当再次发现重复的时候，和上一次记录的长度比较，舍弃长度小的，保留长度大的。
	 * 如此循环，直至front移动到字符尾部，再用front-last-1和最大长度比较，最终确定最大子字符串长度。
	 */
	public static int getSubLength(String str) {
		int front = 1; //头部指针
        int last = 0;  //尾部指针
        int length = str.length();
        int max = 1;
        for (; front < length; front++) {
            char cache = str.charAt(front);			//得到当前的字母准备遍历
            for (int j = front; j > last; j--) {
                if (cache == str.charAt(j-1)) {
                	if(max<=front-last){	//	和上一次记录的长度比较，舍弃长度小的，保留长度大的
                		max = front-last;
                	}
                    last = j;
                }
            }
        }
        //特殊情况：front移动到最后，还要再比较一下
        if(max<=length-last){
        	max = length-last;
        }
        return max;
    }
}

