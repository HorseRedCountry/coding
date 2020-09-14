package offer;

/**
 * @author Major Tom
 * @date 2020/8/20 18:30
 * @description 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 *              有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的
 *              顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *              思路：可以把字符串按照空格切割，分成一个字符串数组，然后把生成的字符串数组的元素反向输出，合并为一个新串
 */
public class ReverseSentence {
    public static String reverse(String str){
        //判断极端情况：字符串全为空
        if(str.trim().isEmpty()){
            return str;
        }
        //分割为字符数组
        String[] strArr=str.split(" ");
        String result="";
        for (int i = strArr.length-1; i >= 0; i--) {
            if (i !=0) {
                result=result+strArr[i]+" ";
            }else{
                //最后一个不要加空格
                result=result+strArr[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse("Student. a am I"));//I am a Student.
        /**
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         * 凑字数哇凑字数，凑字数哇凑字数。
         */
    }
}
