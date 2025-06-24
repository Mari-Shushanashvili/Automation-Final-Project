import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;

public class PutPostsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    /**
     * Test Case 4: Update an existing post
     * Requirement: Send a PUT request to /posts/1 and confirm the title is updated.
     */
    @Test
    public void testUpdatePost() {
        String updatedTitle = "This Title Has Been Updated";
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 1);
        requestBody.put("title", updatedTitle);
        requestBody.put("body", "The body of this post has also been updated.");
        requestBody.put("userId", 1);


        RestAssured.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo(updatedTitle));
    }
}