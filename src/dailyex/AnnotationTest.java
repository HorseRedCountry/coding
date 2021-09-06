package dailyex;

/**
 * <p>
 *  注解练习
 * </P>
 *
 * @author Major Tom
 * @since 2021/5/4 16:09
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person person=new Student();
        person.eat();
        person.walk();
    }
}

@MyAnnotationDemo("张三")
class Person{

    private String name;
    private int age;

    public Person(){}

    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public void walk(){
        System.out.println("人要走路");
    }

    public void eat(){
        System.out.println("人要恰饭");
    }
}
@SuppressWarnings("")
interface info{
    void show();
}

class Student extends Person implements info{


    @Override
    public void walk(){
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}
