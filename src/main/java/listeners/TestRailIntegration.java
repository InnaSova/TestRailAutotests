package listeners;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;
import java.util.Base64;

public class TestRailIntegration {
    private static final String TESTRAIL_URL = "https://innasova.testrail.io";
    private static final String USERNAME = "sovulai@gmail.com";
    private static final String API_KEY = "!123Artyuse";

    public static int createTestRun(int projectId, String runName) throws Exception {
        URL url = new URL(TESTRAIL_URL + "/index.php?/api/v2/add_run/" + projectId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((USERNAME + ":" + API_KEY).getBytes()));

        JSONObject payload = new JSONObject();
        payload.put("name", runName);
        payload.put("include_all", true);

        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(payload.toString().getBytes());
        os.flush();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed to create test run. HTTP error code: " + conn.getResponseCode());
        }

        JSONObject response = new JSONObject(new String(conn.getInputStream().readAllBytes()));
        return response.getInt("id"); // Возвращает ID созданного Test Run
    }

    public static void addResultForCase(int runId, int testCaseId, int status, String comment) throws Exception {
        URL url = new URL(TESTRAIL_URL + "/index.php?/api/v2/add_result_for_case/" + runId + "/" + testCaseId);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((USERNAME + ":" + API_KEY).getBytes()));

        JSONObject payload = new JSONObject();
        payload.put("status_id", status);
        payload.put("comment", comment);

        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(payload.toString().getBytes());
        os.flush();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed to add result. HTTP error code: " + conn.getResponseCode());
        }

        System.out.println("Result added successfully to Test Run " + runId + ", Test Case " + testCaseId);
    }

}
