package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private static final int MAX_RETRY_COUNT = 3;
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()) {
            if(retryCount < MAX_RETRY_COUNT) {
                LoggingUtil.info("Retrying test " + iTestResult.getName() + " with status " + getResultStatusName(iTestResult.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
                retryCount++;
                return true;
            }
        }
        return false;
    }

    private String getResultStatusName(final int status) {
        String resultName = null;
        if(status == 1) {
            resultName = "SUCCESS";
        }
        if(status == 2) {
            resultName = "FAILURE";
        }
        if(status == 3) {
            resultName = "SKIP";
        }
        return resultName;
    }
}
