package com.elevate.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


/**
 * Created by filip.fursau on 19.12.2017.
 */
public class DemoTest extends BaseApiGatewayTest {

    @Test
    public void testGetToken() {
        given()

                .when()
                .post("/v1/")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
