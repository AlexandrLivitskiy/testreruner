package main;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Ali on 21.09.2017.
 */
public class JiraApi {
    private static String USER_LIST = "(alexandr.livitskiy%2C%20ali.naffaa)";
    private static String NAME_PASS = "Basic ";
    private static String CDR_TODAY = "https://jira.ringcentral.com/rest/api/2/search?jql=project%20%3D%20CDR%20AND%20resolved%20%3E%3D%20-1d%20AND%20assignee%20in%20"+USER_LIST;

    public String getCDR() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(CDR_TODAY);

        request.addHeader("Authorization", NAME_PASS);
        HttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}
