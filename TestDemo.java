import java.util.Scanner;

public class TestDemo {
    /**
     * 题目：
     * 从C/C+ +转到Java的程序员，一开始最不习惯的就是变 量命名方式的改变。C语言风格使用下划线分隔多个单词，例如"hello_ world";而Java则采用一种叫骆驼命名法的规则:除首个单词以外，所有单词的首字母大写，例如"helloWorld"。请你帮可怜的程序员们自动转换变量名。
     *
     * 输入：
     * hello_worldnice_to_meet_you
     * 输出：
     * helloWorldniceToMeetYou
     *
     * 分析：
     * 如果要将C语言的变量名转为Java变量名，首先要以下划线为分割点，将这个多单词变量名分为多个单词。然后将这些单词出国第一个之外，其余的单词的首字母大写再将其拼接，这里用到了substring()函数和toUpperCase()函数
     *
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String str2 = scanner.nextLine();
            if (str.length()<=100){
                printStr(str);
            }
            if (str2.length()<=100){
                printStr(str2);
            }
        }
    }
    public static void printStr(String string){
        String[] segments=string.split("_");
        String str=segments[0];
        for (int i = 1; i < segments.length; i++) {
            str+=segments[i].toUpperCase().substring(0,1)+segments[i].substring(1);
        }
        System.out.println(str);
    }

    /**
     * 给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K]，右部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。求这么多划分方案中，
     * 左部分中的最大值减去右部分最大值的绝对值，最大是多少？
     *
     * 给定整数数组A和数组的大小n，请返回题目所求的答案。
     *
     * 测试样例：
     *
     * [2,7,3,1,1],5
     *
     * 返回：6
     *
     * 思路分析：这两个数中有一个肯定是数组的最大值。要使得差值最大，那么另一边的最大值应尽可能的小。
     * 假设最大值在左边，那么对于最大值右边的数组有很多种分法，每一种分法肯定都包含数组最后一个数字即A[n-1]。如果不取A[n-1]，取最后一个数字和最大值中间的任一数字A[i]。
     * 若A[i]大于A[n-1]，那还不如取最后一个数字；若最A[i] 小于A[n-1]，那右半边的最大值肯定不是A[i]，所以无论如何右半边取最右端数字。
     * 假设最大值在右边，同理左半边取最左端数字。
     * 只需用数组最大值减去数组两端较小的那个值即可
     *
     */

    public int findMaxGap(int[] A, int n) {
        int max=0;
        for(int i=0;i<A.length;i++) {          //找出数组中的最大值
            if(A[i]>max)
                max=A[i];
        }
        int ans1=max-A[0];
        int ans2=max-A[n-1];
        if(ans1>ans2)
            return ans1;
        else
            return ans2;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/97e7a475d2a84eacb60ee545597a8407
     * 来源：牛客网
     *
     * 对于一个矩阵，请设计一个算法从左上角(mat[0][0])开始，顺时针打印矩阵元素。
     *
     * 给定int矩阵mat,以及它的维数nxm，请返回一个数组，数组中的元素为矩阵元素的顺时针输出。
     *
     * 测试样例：
     * [[1,2],[3,4]],2,2
     * 返回：[1,2,4,3]
     */
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] a = new int[m*n];
        int i = 0;
        int j = 0;
        int k = 0;
        int startX = 0;
        int startY = 0;
        int endX = n-1;
        int endY = m-1;
        while(startX <= endX && startY <= endY){
            //如果只剩下一行
            if(startX == endX){
                for(;j <= endY; j++,k++){
                    a[k] = mat[startX][j];
                }
                return a;
            }

            //如果只剩下一列
            if(startY == endY){
                for(;i <= endX; i++,k++){
                    a[k] = mat[i][startY];
                }
                return a;
            }
            //将矩阵上边除右顶点添加到返回的数组中
            for(;j < endY; j++,k++){
                a[k] = mat[i][j];
            }

            //将矩阵右边除边下顶点添加到返回的数组中
            for(;i < endX; i++,k++){
                a[k] = mat[i][j];
            }

            //将矩阵下边除边左顶点添加到返回的数组中
            for(;j > startX; j--,k++){
                a[k] = mat[i][j];
            }
            //将矩阵左边除边上顶点添加到返回的数组中
            for(;i > startY; i--,k++){
                a[k] = mat[i][j];
            }
            i++;
            j++;
            startX++;
            startY++;
            endX--;
            endY--;

        }
        return a;
    }


}
