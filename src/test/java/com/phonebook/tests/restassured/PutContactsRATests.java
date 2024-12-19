package com.phonebook.tests.restassured;

import com.phonebook.dto.AllContactsDto;
import com.phonebook.dto.ContactDto;
import com.phonebook.dto.ResponseMessageDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutContactsRATests extends TestBase {


    @Test
    public void updateContactSuccessTest() {

        ContactDto updatedContact = ContactDto.builder()
                .id("69ee2d6f-5b94-429a-8d5d-b2f3dddbfe24")
                .name("Joe")
                .lastName("Biden")
                .email("idontrememberanything@gmail.com")
                .phone("1234567890")
                .address("Old house")
                .description("I LOVE MY SON")
                .build();


        ResponseMessageDto responseMessageDto = given()
                .header(AUTHORIZATION, TOKEN)
                .contentType(ContentType.JSON)
                .body(updatedContact)
                .when()
                .put("contacts")
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(ResponseMessageDto.class);


        System.out.println("ОТВЕТОЧКА - " + responseMessageDto.getMessage());

    }


}
