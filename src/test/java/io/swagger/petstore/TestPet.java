package io.swagger.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestPet {

    private final String BASE_URL = "http://petstore.swagger.io" ;
    private final String apiKeyValue = "qwe123r4t5";
    private static final String ID_TEST_VALUE = RandomStringUtils.randomNumeric(5);


    @Test
    public void createPetTest(){

        System.out.println("Id = " + ID_TEST_VALUE);

        RestAssured
                .given().baseUri(BASE_URL).basePath("/v2/pet")
                .contentType(ContentType.JSON)
                .header("api_key",apiKeyValue)
                .body(("{\n" +
                    "  \"id\": " + ID_TEST_VALUE + ",\n" +
                    "  \"name\": \"" + "testPetName" + ID_TEST_VALUE + "\",\n" +
                    "  \"photoUrls\": [],\n" +
                    "  \"tags\": [],\n" +
                    "  \"status\": \"pending\"\n" +
                    "}"))
                .when().post()
                .then()
                .body("id", Matchers.equalTo(Integer.valueOf(ID_TEST_VALUE)));
    }

    @Test()
    public void petGetIdTest(){

        System.out.println("Id = " + ID_TEST_VALUE);
        RestAssured
                .given().baseUri(BASE_URL).basePath("/v2/pet")
                .contentType(ContentType.JSON)
                .header("api_key",apiKeyValue)
                .when().get(ID_TEST_VALUE).then().extract().response().prettyPrint();
    }

    @Test
    public void Test() {
        Map<String,Object> user = new HashMap<>();
        user.put("id","12121212");
        user.put("username","userWithMap");
        user.put("firstName","TarasU");
        user.put("lastName","TarasU");
        user.put("email","asd@asd");
        user.put("password","password@asd");
        user.put("phone","093 55 55 55");

        RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath("/v2/user")
                .contentType(ContentType.JSON)
                .header("api_key", apiKeyValue)
                .body(user)
                .when().post()
                .then().statusCode(200);
    }

    @Test
    public void userCreateTest(){

        RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath("/v2/user")
                .contentType(ContentType.JSON)
                .header("api_key", apiKeyValue)
                .body("{\n" +
                        "  \"id\": 1212,\n" +
                        "  \"username\": \"TarasF\",\n" +
                        "  \"firstName\": \"Taras\",\n" +
                        "  \"lastName\": \"F\",\n" +
                        "  \"email\": \"qwe@qwe.com\",\n" +
                        "  \"password\": \"123\",\n" +
                        "  \"phone\": \"123++123\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when().post()
                .then().extract().response()
                .prettyPrint();
        System.out.println("test 2 done");
    }

    @Test
    public void userCanLoginTest() {
        RestAssured
                .given()
                .baseUri(BASE_URL)
                .basePath("/v2/user/")
                .contentType(ContentType.JSON)
                .header("api_key", apiKeyValue)
                .get("tarasF")
                .then()
                .body("email", Matchers.equalTo("qwe@qwe"))
                .body("firstName",Matchers.equalTo("F"))
                .statusCode(200);
        System.out.println("Test 3 done");
    }

    @Test
    public void makeSureThatGoogleIsUp() {
        RestAssured.
        given().when().get("http://www.google.com").then().statusCode(200);
    }

}
