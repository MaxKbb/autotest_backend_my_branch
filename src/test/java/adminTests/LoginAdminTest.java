package adminTests;

        import admin.Admin;
        import admin.AdminClient;
        import admin.AdminCredential;
        import org.junit.Before;
        import org.junit.After;
        import org.junit.Test;
        import io.qameta.allure.junit4.DisplayName;
        import io.restassured.response.ValidatableResponse;


        import static org.hamcrest.CoreMatchers.*;

public class LoginAdminTest {

    AdminClient adminClient;
    Admin admin;
    int adminId;
    AdminCredential adminCredentials;

    @Before
    public void setUp() {
        adminClient = new AdminClient();
        admin = Admin.getRandomCourier();
        adminClient.createAdmin(admin);
        adminCredentials = new AdminCredential(admin.getLogin(), admin.getPassword());
    }

    @After
    public void tearDown() {
        adminClient.deleteAdmin(adminId);
    }

    @Test
    @DisplayName("Успешный логин, переданы все обязательные поля")
    public void successLoginAdminTest() {
        ValidatableResponse loginResponse = adminClient.loginAdmin(adminCredentials).statusCode(200);
        adminId = loginResponse.extract().path("id");
        loginResponse.assertThat().body("id", notNullValue());
        System.out.println(adminId);
    }
}