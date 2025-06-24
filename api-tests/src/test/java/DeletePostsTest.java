import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    /**
     * Test Case 5: Delete an existing post
     * Requirement: Send a DELETE request to /posts/1 and ensure the status code is 200 or 204.
     */
    @Test
    public void testDeletePost() {
        RestAssured.given()
                .when()
                .delete("/posts/1")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(200);
    }
}