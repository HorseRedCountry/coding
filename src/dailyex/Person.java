package dailyex;

public class Person {
    private String name;
    private int age;
    public static String hobby="恶心心";

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    } public Person() {

    }
    public static void main(String[] args) {
        System.out.println(Person.hobby);
        Person person=new Person("方大醒",24);
        System.out.println(Person.hobby);
        Person.hobby="吃饭饭，恶心心";
        System.out.println(Person.hobby);
    }
    /*
        运行结果:恶心心
                恶心心
                吃饭饭，恶心心
     */
}
