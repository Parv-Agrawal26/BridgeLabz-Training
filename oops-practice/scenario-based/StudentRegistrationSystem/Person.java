public class Person {
    private String name;
    private int age;
    private String gender;
    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    String getName() {
        return name;
    }
    int getAge() {
        return age;
    }
    String getGender() {
        return gender;
    }
}