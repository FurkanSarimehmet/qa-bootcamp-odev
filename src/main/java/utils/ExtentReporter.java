package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/extent-reports/index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("QA Bootcamp Test Raporu");
            reporter.config().setDocumentTitle("Parabank Test Raporu");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Furkan Sarımehmet");
        }
        return extent;
    }
}
