package aaa;

/**
 * @author wwl
 * @create 2023-04-27 13:08
 */
public class User {
    private String name;
    private int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void processData() {
        // 在这里处理表单数据
        System.out.println("hello");
        System.out.println(name+"  "+ age);
    }
}