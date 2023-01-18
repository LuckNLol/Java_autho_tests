package DependentTests16;
import org.testng.annotations.Test;

/* Хотим чтобы test4 выполнялся после test3 и зависил от выполнения test3 */

public class Test3 {

    @Test
    public void thisTest3(){
        System.out.println("MyTest 3");
    }

    /* Жесткая зависимость */
    @Test(dependsOnMethods = {"thisTest3"})
    public void test4(){
        System.out.println("MyTest 4");
    }

    /* не жесткая зависимость, alwaysRun = true запускать даже если есть зависимость от другого метода */
    @Test(dependsOnMethods = {"thisTest3"}, alwaysRun = true) //
    public void test5(){
        System.out.println("MyTest 5");
    }

    /* Зависимость от группы */
    @Test(dependsOnGroups = {"SomeGr.*"}, alwaysRun = true) // * сначала выполнить тесты в Группе, потом это тест
    public void test6(){
        System.out.println("MyTest 6");
    }
}
