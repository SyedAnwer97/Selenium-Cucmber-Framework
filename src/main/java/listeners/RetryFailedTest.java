package listeners;

import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.PropertyUtils;

import static property.Properties.retry;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count;
    private final static int RETRYCOUNT = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
            if (retry.equalsIgnoreCase("yes")) {
                value = count < RETRYCOUNT;
                count++;
            }
        return value;
    }

}
