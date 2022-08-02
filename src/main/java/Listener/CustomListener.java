package Listener;

import Util.Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomListener extends Utils implements ITestListener {


    public CustomListener() throws IOException {
    }


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failed");
        try {
            takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
