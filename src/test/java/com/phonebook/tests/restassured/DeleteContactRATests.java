package com.phonebook.tests.restassured;

import com.phonebook.dto.ContactDto;
import com.phonebook.dto.ErrorDto;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class DeleteContactRATests extends TestBase {

    String id;

    @BeforeMethod
    public void precondition() {

        ContactDto contactDto = ContactDto.builder()
                .name("Bob")
                .lastName("Dylan")
                .email("dylan@gmail.com")
                .phone("1234567890")
                .address("Berlin")
                .description("Knock knock on the heavens door")
                .build();

        String message = given()
                .header(AUTHORIZATION, TOKEN)
                .body(contactDto)
                .contentType(ContentType.JSON)
                .post("contacts")
                .then()
                .extract().path("message");
        System.out.println(message);


        //Contact was added! ID: 028c927b-d6fb-477d-af25-075e9e9f1dfe

        String[] split = message.split(": ");
        id = split[1];
    }


    @Test
    public void deleteContactSuccessTest() {
        // String message
        given()
                .header(AUTHORIZATION, TOKEN)
                .when()
                .delete("contacts/" + id)
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("message", equalTo("Contact was deleted!"));


        // .extract().path("message");
        //System.out.println(message);
        //Contact was deleted!

    }

    @Test
    public void DeleteContactByWrongId() {
        //ErrorDto errorDto =
        given()
                .header(AUTHORIZATION, TOKEN)
                .when()
                .delete("contacts/028c927b-d6fb-477d-af25-075e9e9f1dfe")
                .then()
                .assertThat().statusCode(400)
                .assertThat().body("message", containsString("not found in your contacts"));
                //.extract().body().as(ErrorDto.class);
        //  System.out.println(errorDto.getMessage());
    }
}

















