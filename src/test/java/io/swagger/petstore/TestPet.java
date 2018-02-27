package io.swagger.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.Random;

public class TestPet {

    @Test
    public void petTest(){
        //String idTestValue = RandomStringUtils.randomNumeric(5);

        RestAssured.given()
                .baseUri("http://petstore.swagger.io")
                .basePath("/v2/pet/121")
                .accept(ContentType.JSON)
                .header("api_key","123qwe")
                .get()
                .then().statusCode(200)
        ;
    }

}
