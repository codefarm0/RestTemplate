package com.gl.restTemplateBuilderDemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */
public class MyRequestInterceptor implements ClientHttpRequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(MyRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        logger.info("Request details");
        logger.info(" URI - {}", request.getURI());
        logger.info("Headers - {}", request.getHeaders());
        logger.info("Method - {}", request.getMethod());
        //request.

        ClientHttpResponse response = execution.execute(request, body);

        MyClientHttpResponse myClientHttpResponse = new MyClientHttpResponse(response);

        logger.info("Response details");
        logger.info("status -{}", myClientHttpResponse.getStatusCode());
        logger.info("Body -{}", getResponseBody(myClientHttpResponse.getBody()));

        return myClientHttpResponse;
    }

    private String getResponseBody(InputStream responseBody) {

            StringBuilder inputStringBuilder = new StringBuilder();

        try  (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseBody, StandardCharsets.UTF_8)))
        {
            String line = bufferedReader.readLine();
            while (line != null) {
                inputStringBuilder.append(line);
                inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
            return inputStringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //IOUtils.
    }
}
