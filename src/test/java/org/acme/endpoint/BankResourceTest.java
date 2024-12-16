package org.acme.endpoint;

import com.fasterxml.jackson.core.type.TypeReference;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.openapi.quarkus.api_yaml.model.BankDTO;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@QuarkusTest
public class BankResourceTest{

    @Test
    void createBank(){
        given()
                .when().get("/banks")
                .then()
                    .statusCode(200);
        Response responseBody = when().get("/banks");
        List<BankDTO> bankDataList = mapper.readValue(responseBody, new TypeReference<List<BankDTO>>(){});

        assertThat(bankDataList)
                .isInstanceOf(List.class)
                .hasOnlyElementsOfType(BankDTO.class)
                .hasSize(1);
    }

}