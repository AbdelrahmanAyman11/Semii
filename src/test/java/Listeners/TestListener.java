package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ PASSED: " +
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ FAILED: " +
                result.getMethod().getMethodName());

        if (result.getThrowable() != null) {
            result.getThrowable().printStackTrace(System.out);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ SKIPPED: " +
                result.getMethod().getMethodName());
    }
}