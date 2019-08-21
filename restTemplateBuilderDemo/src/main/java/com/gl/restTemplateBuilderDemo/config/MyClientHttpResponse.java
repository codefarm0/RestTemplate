package com.gl.restTemplateBuilderDemo.config;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.*;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */
public class MyClientHttpResponse implements ClientHttpResponse {

    private ClientHttpResponse clientHttpResponse;
    private byte[] body = null;

    public MyClientHttpResponse(ClientHttpResponse clientHttpResponse) {
        this.clientHttpResponse = clientHttpResponse;
    }

    @Override
    public HttpStatus getStatusCode() throws IOException {
        return clientHttpResponse.getStatusCode();
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return clientHttpResponse.getRawStatusCode();
    }


    @Override
    public String getStatusText() throws IOException {
        return clientHttpResponse.getStatusText();
    }


    @Override
    public void close() {
        clientHttpResponse.close();
    }

    @Override
    public InputStream getBody() throws IOException {
        if (body != null) {
            return new ByteArrayInputStream(body);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copyLarge(clientHttpResponse.getBody(), outputStream);
        body = outputStream.toByteArray();
        return new ByteArrayInputStream(body);
    }

    @Override
    public HttpHeaders getHeaders() {
        return clientHttpResponse.getHeaders();
    }
}
