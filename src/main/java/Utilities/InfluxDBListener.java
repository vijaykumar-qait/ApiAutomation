package Utilities;

import org.influxdb.dto.Point;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class InfluxDBListener implements ITestListener {
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        this.postTestMethodStatus(result, "PASS");
    }

    public void onTestFailure(ITestResult result) {
        this.postTestMethodStatus(result, "FAIL");
    }

    public void onTestSkipped(ITestResult result) {
        this.postTestMethodStatus(result, "SKIPPED");
    }

    public void onFinish(ITestContext context) {
        this.postTestMethodStatus(context);
    }

    private void postTestMethodStatus(ITestContext context) {
        Point point = Point.measurement("testclass").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("name", context.getAllTestMethods()[0].getTestClass().getName())
                .addField("duration", context.getEndDate().getTime() - context.getStartDate().getTime())
                .build();
        UpdateResults.updateResult(point);
    }

    private void postTestMethodStatus(ITestResult result, String status) {
        Point point = Point.measurement("testmethod").time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("testclass", result.getTestClass().getName())
                .tag("name", result.getName())
                .tag("description", result.getMethod().getDescription())
                .tag("status", status)
                .addField("duration", result.getEndMillis() - result.getStartMillis())
                .build();
        UpdateResults.updateResult(point);
    }
}
