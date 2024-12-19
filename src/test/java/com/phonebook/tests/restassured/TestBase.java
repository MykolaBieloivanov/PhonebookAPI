package com.phonebook.tests.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoic3RldmVAZ21haWwuY29" +
            "tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE3MzUxMTc5OTcsImlhdCI6MTczNDUxNzk5N30.SkNfGtf8K8tjKNuMOpiSShNzLGLYf2BMjo" +
            "QRMOdG4Wk";

    public static final String AUTHORIZATION = "Authorization";

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }
}
