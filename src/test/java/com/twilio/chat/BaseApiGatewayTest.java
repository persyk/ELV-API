package com.twilio.chat;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.testng.annotations.BeforeTest;
import service.GatewaySslSocketFactory;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

public class BaseApiGatewayTest {

    private static final String API_GATEWAY_HOST_URL = "https://testing.api.elevateapp.cc";
    private static final int API_GATEWAY_HOST_PORT = 443;

    @BeforeTest
    public void setUpBaseApiGateway() throws NoSuchAlgorithmException {
        // Set the host, port, and base path
        RestAssured.baseURI = API_GATEWAY_HOST_URL;
        RestAssured.port = API_GATEWAY_HOST_PORT;
        RestAssured.basePath = "dev";

        // Use our custom socket factory
        SSLSocketFactory customSslFactory = new GatewaySslSocketFactory(
                SSLContext.getDefault(), SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        RestAssured.config = RestAssured.config().sslConfig(
                SSLConfig.sslConfig().sslSocketFactory(customSslFactory));
        RestAssured.config.getHttpClientConfig().reuseHttpClientInstance();
    }
}