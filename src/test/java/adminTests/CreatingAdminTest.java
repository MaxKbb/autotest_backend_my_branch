package adminTests;

import admin.Admin;
        import admin.AdminClient;
        import org.junit.Before;
        import org.junit.After;
        import org.junit.Test;
        import io.qameta.allure.junit4.DisplayName;
        import io.restassured.response.ValidatableResponse;

        import static org.hamcrest.CoreMatchers.*;

public class CreatingAdminTest {

    AdminClient adminClient;
    Admin admin;
    private int adminId;

    @Before
    public void setUp() {
        adminClient = new AdminClient();
        admin = Admin.getRandomCourier();
    }

    @After
    public void tearDown() {
        if (adminId != 0) {
            adminClient.deleteAdmin(adminId);
        }
    }

    @Test
    @DisplayName("Создаем нового курьера")
    public void successCreatingCourierTest() {
        ValidatableResponse createResponse = adminClient.createCourier(admin).statusCode(201);
        createResponse.assertThat().body("ok", equalTo(true));
    }
}