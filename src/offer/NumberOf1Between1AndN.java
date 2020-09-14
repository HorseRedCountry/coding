package offer;

/**题目描述：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字
 *         有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 *         可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *    思路：如果要计算百位上1出现的次数，它要受到3方面的影响：百位上的数字，百位以下（低位）的数字，百位以上（高位）
 *         的数字。依次计算即可
 * @author Major Tom
 * @date 2020/7/24 22:39
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0,after = 0,before = 0;
        while((n/i)!= 0){
            current = (n/i)%10; //高位数字
            before = n/(i*10); //当前位数字
            after = n-(n/i)*i; //低位数字
            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0)
                count += before*i;
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
            else if(current == 1)
                count += before * i + after + 1;
                //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
            else{
                count += (before + 1) * i;
            }
            //前移一位
            i = i*10;
        }
        return count;
    }
    /**
     * 凑字数哇凑字数，凑字数哇凑字数。
     * 凑字数哇凑字数，凑字数哇凑字数。
     * 凑字数哇凑字数，凑字数哇凑字数。
     * 凑字数哇凑字数，凑字数哇凑字数。
     * 凑字数哇凑字数，凑字数哇凑字数。
     * 凑字数哇凑字数，凑字数哇凑字数。
     */
}
