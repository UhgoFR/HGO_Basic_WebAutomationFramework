package reusableComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import testBase.ObjectRepo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentSetUp extends ObjectRepo {

    public static ExtentReports setupExtentReport(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportPath = System.getProperty("user.dir")+"/reports/ExecutionReport_"+actualDate+".html";
        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(sparkReport);
        sparkReport.config().setDocumentTitle("DocumentTitle");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("ReportName");
        return extent;
    }
}
