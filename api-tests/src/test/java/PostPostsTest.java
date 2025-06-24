import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;

public class PostPostsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    /**
     * Test Case 3: Create a new post
     * Prerequisite: Send a POST request, verify status code 201, and check the response body.
     */
    @Test
    public void testCreatePost() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "My Automation Post");
        requestBody.put("body", "This is a test post created by REST-assured.");
        requestBody.put("userId", 50);

        RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(201)
                .body("title", equalTo("My Automation Post"))
                .body("body", equalTo("This is a test post created by REST-assured."))
                .body("userId", equalTo(50))
                .body("id", notNullValue());
    }
}