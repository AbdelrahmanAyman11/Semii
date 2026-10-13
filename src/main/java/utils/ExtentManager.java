package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentManager{

    private static ExtentReports extent;
    private static ExtentTest test;
    private static ExtentSparkReporter spark;
    public static ExtentReports getInstance() {

        if (extent == null) {

            spark = new ExtentSparkReporter("Reports/myreport.html");

            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Demo Web Shop Tests");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
    public static ExtentTest createTest(String testName) {

        test = getInstance().createTest(testName);

        return test;
    }
    public static void flushReport() throws IOException {
        if (extent != null) {
            extent.flush();
            Desktop.getDesktop().open(new File("C:\\Users\\Dell\\IdeaProjects\\Semii\\reports\\myreport.html"));
        }
    }

}