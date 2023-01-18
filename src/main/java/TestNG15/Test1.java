package TestNG15;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/* Подключил plugin "CreateTestXML": File-Settings-Plugins. ПКМ на названии проекта: CreateTestXML
* Можно настраивать XML, добавлять/убирать тесты, настоить из какой папки брать тесты
*
* Находять в классе: ЛКМ-Current File-Edit Configuration: задать "Name", выбрать из списка "Test Kind"
* Можно делать выборку по всем тестам, по методам внутри тестов, но наборам, по группам тестов
*
* @Parametres передача параметров в тесты
*/

public class Test1 {

    @DataProvider(name = "db")
    public static Object[][] dbData() {
        return new Object[][]{
                {"SQL", 2},
                {"noSQL", 3}
        };
    }

    @Parameters({"db"})
    @Test(dataProvider = "db")
    public void test1(String element1, int element2) {
        System.out.println("MyTest 1 " + " " + element1 + " " + element2);
    }
}



//    @Test (groups = {"Sanity"}) // Собраны регресс тесты
//    public void test12(){
//        System.out.println("MyTest 1.2");
//    }
//
//    @Test (groups = {"regress"}) // Собраны регресс тесты
//    public void test13(){
//        System.out.println("MyTest 1.3");
//    }



