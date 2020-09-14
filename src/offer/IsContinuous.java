package offer;

/**
 * @author Major Tom
 * @date 2020/8/21 21:40
 * @description LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测
 *              测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是
 *              顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,
 *              4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气
 *              如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *              思路：先对数组进行排序，然后看数组中0的个数，判断是否有对子，若没有就计算相邻数之间的间隔
 */
public class IsContinuous {
    public static boolean isContinuous(int[] numbers){
        int len=numbers.length;
        if(len<4)return false;
        int[] cups=new int[14];//使用容器来统计个数
        for(int i=0;i<len;i++){
            cups[numbers[i]]++;//将数字装进容器
        }
        int kingsLeft=cups[0];//万能数字的个数
        int blankNum=0;
        for(int i=1;i<=9;i++){
            blankNum=0;
            for(int j=0;j<5;j++){
                if(cups[i+j]==0)blankNum++;
            }
            if(kingsLeft>=blankNum||blankNum==0)return true;//只要万能数字个数多于空缺，或者没有空缺，直接返回true即可
        }
        return false;
    }
    /**
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     * 凑字数哇凑字数，凑字数哇凑字数
     */
}
