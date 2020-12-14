package dailyex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 *  lamda表达式练习
 * </P>
 *
 * @author Major Tom
 * @since 2020/12/14 15:57
 */
public class LamdaDemo {
    public static void main(String[] args) {
        List<Student> students=new ArrayList<Student>(){
            {
                add(new Student("stu1",100.0));
                add(new Student("stu2",97.0));
                add(new Student("stu3",96.0));
                add(new Student("stu4",95.0));
            }
        };
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return Double.compare(o1.getScore(),o2.getScore());
//            }
//        });
        Collections.sort(students,(s1,s2)->Double.compare(s1.getScore(),s2.getScore()));
        System.out.println(students);
    }
}
