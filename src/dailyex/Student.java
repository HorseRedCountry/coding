package dailyex;

/**
 * <p>
 *  学生定义--练习lamda表达式用
 * </P>
 *
 * @author Major Tom
 * @since 2020/12/14 15:59
 */
public class Student {
    /**姓名*/
    private String name;
    /**成绩*/
    private Double score;

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
