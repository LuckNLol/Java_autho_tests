package TestNG15;


import org.testng.annotations.Test;

public class Test2 {

    @Test (groups = {"smokeTest", "regress"}) // Собраны Смоук тесты и Регресс
    public void test2(){
        System.out.println("MyTest 2");
    }
}
