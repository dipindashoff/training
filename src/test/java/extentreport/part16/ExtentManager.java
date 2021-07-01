package extentreport.part16;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import net.bytebuddy.asm.Advice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance() {

        try {
            System.out.println("Building extent report...");
//        String dateTime = LocalDateTime.now().toString().replaceAll("\\W", "_");
//        String fileName = "extent_"+dateTime+".html";

            Path path = Paths.get("./reports/Extent Reports/" + getDate());
            Files.createDirectories(path);
            String fileName = path + "/ExtentReport_" + getDateTime() + ".html";

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//        htmlReporter.config().setChartVisibilityOnOpen(true);
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle(fileName);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(fileName);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return extent;
    }

    /*
    Gte date time
     */
    public static String getDate(){
        System.out.println("Local Date: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd_MMM_yy")));
        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd_MMM_yy"));
    }

    public static String getDateTime(){
        System.out.println("Local Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(
                "dd_MMM_yy_hh_mm_ss")));
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MMM_yy_hh_mm_ss"));
    }
}
