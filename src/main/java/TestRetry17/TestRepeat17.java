package TestRetry17;

import org.testng.Assert;
import org.testng.annotations.Test;


/* Для повторения тестов нужно:
* 1) Повторить несколько раз упавшие тесты
* IRetryAnalyzer, ITestResult
* */

public class TestRepeat17 {

    @Test (retryAnalyzer = Retry.class)
    public void test1() {
        System.out.println("MyTest 1");
        Assert.fail();
    }
}

