package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.lang.annotation.Annotation;

public class listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("success");
    }


}
