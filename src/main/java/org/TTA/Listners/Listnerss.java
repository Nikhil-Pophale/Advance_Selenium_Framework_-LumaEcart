package org.TTA.Listners;

import org.TTA.Base.Common;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listnerss extends Common implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            takeScreenShot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
