package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestRailListener implements ITestListener {
    private static int runId; // ID Test Run, созданного для текущего тестового набора

    @Override
    public void onStart(ITestContext context) {
        try {
            int projectId = 2; // Замените на ваш Project ID
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            String runName = "Automated Test Run: " + formattedDateTime;
            runId = TestRailIntegration.createTestRun(projectId, runName);
            System.out.println("Created Test Run with ID: " + runId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create Test Run in TestRail");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            int testCaseId = extractTestCaseId(result.getMethod().getMethodName());
            TestRailIntegration.addResultForCase(runId, testCaseId, 1, "Test passed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            int testCaseId = extractTestCaseId(result.getMethod().getMethodName());
            String comment = "Test failed: " + result.getThrowable().getMessage();
            TestRailIntegration.addResultForCase(runId, testCaseId, 5, comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int extractTestCaseId(String methodName) {
        // Логика извлечения ID теста из имени метода, например "TC1234"
        return Integer.parseInt(methodName.replaceAll("\\D+", ""));
    }
}