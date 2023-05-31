package admin;

import client.Client;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class AdminClient extends Client {

    private static final String COURIER_PATH = "api/v1/courier/";
    private static final String COURIER_LOGIN = "api/v1/courier/login";

    @Step("Создание нового администратора")
    public ValidatableResponse createAdmin(Admin admin) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .spec(getSpec())
                .log().all()
                .body(admin)
                .when()
                .post(COURIER_PATH)
                .then()
                .log().all();
    }

    @Step("Авторизация администратора в системе")
    public ValidatableResponse loginAdmin(AdminCredential adminCredential) {
        return given()
                .header("Content-type", "application/json")
                .spec(getSpec())
                .log().all()
                .body(adminCredential)
                .when()
                .post(COURIER_LOGIN)
                .then()
                .log().all();
    }


    @Step("Удаление администратора")
    public ValidatableResponse deleteAdmin(int adminId) {
        return given()
                .spec(getSpec())
                .when()
                .delete(COURIER_PATH + adminId)
                .then()
                .log().all();
    }
}
