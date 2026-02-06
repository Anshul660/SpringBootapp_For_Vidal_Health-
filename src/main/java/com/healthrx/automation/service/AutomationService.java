package com.healthrx.automation.service;

import com.healthrx.automation.model.SubmitSolutionRequest;
import com.healthrx.automation.model.WebhookRequest;
import com.healthrx.automation.model.WebhookResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AutomationService implements CommandLineRunner {

    private static final String GENERATE_WEBHOOK_URL = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
    private static final String SUBMIT_SOLUTION_URL = "https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA";

    // User Details
    // User Details
    private static final String NAME = "John Doe";
    private static final String REG_NO = "250850120032"; // Updated to Even RegNo (Question 2)
    private static final String EMAIL = "john@example.com";

    // Question 2 (Even) Solution
    // Problem: Average age of individuals with salaries > 70k, per department. List
    // top 10 names.
    private static final String SQL_SOLUTION = """
            SELECT
                d.DEPARTMENT_NAME,
                AVG(TIMESTAMPDIFF(YEAR, e.DOB, CURDATE())) AS AVERAGE_AGE,
                SUBSTRING_INDEX(GROUP_CONCAT(CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) SEPARATOR ', '), ', ', 10) AS EMPLOYEE_LIST
            FROM DEPARTMENT d
            JOIN EMPLOYEE e ON d.DEPARTMENT_ID = e.DEPARTMENT
            WHERE EXISTS (
                SELECT 1
                FROM PAYMENTS p
                WHERE p.EMP_ID = e.EMP_ID
                AND p.AMOUNT > 70000
            )
            GROUP BY d.DEPARTMENT_ID, d.DEPARTMENT_NAME
            ORDER BY d.DEPARTMENT_ID DESC
            """;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting Automation Service...");
        System.out.println("User: " + NAME + " | RegNo: " + REG_NO);

        RestTemplate restTemplate = new RestTemplate();

        // Step 1: Generate Webhook
        System.out.println("Step 1: Requesting Webhook...");
        WebhookRequest request = new WebhookRequest(NAME, REG_NO, EMAIL);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<WebhookRequest> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<WebhookResponse> response = restTemplate.postForEntity(GENERATE_WEBHOOK_URL, entity,
                    WebhookResponse.class);
            WebhookResponse body = response.getBody();

            if (body != null) {
                String accessToken = body.getAccessToken();
                System.out.println("Received Access Token: " + accessToken);

                // Step 2: Submit Solution (Directly for Question 2)
                System.out.println("Step 2: Submitting Solution to " + SUBMIT_SOLUTION_URL);

                // Construct Body
                SubmitSolutionRequest submitRequest = new SubmitSolutionRequest(SQL_SOLUTION);

                HttpHeaders submitHeaders = new HttpHeaders();
                submitHeaders.setContentType(MediaType.APPLICATION_JSON);
                submitHeaders.set("Authorization", accessToken);

                HttpEntity<SubmitSolutionRequest> submitEntity = new HttpEntity<>(submitRequest, submitHeaders);

                try {
                    ResponseEntity<String> submitResponse = restTemplate.postForEntity(SUBMIT_SOLUTION_URL,
                            submitEntity, String.class);
                    System.out.println("Submission Response Code: " + submitResponse.getStatusCode());
                    System.out.println("Submission Response Body: " + submitResponse.getBody());
                } catch (Exception e) {
                    System.err.println("Submission Failed: " + e.getMessage());
                }

            } else {
                System.err.println("Failed to get response body from Generate Webhook");
            }

        } catch (Exception e) {
            System.err.println("Error during automation: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Automation Task Completed.");
    }
}
