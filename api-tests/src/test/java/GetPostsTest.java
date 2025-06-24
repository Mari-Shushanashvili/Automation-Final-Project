import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// We need Hamcrest matchers for our assertions
import static org.hamcrest.Matchers.*;

public class GetPostsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    /**
     * Test Case 1: Get all posts
     * Requirement: Verify status code is 200 and the response contains at least 100 posts.
     */
    @Test
    public void testGetAllPosts() {
        RestAssured.given()
                .when()
                .get("/posts")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(200)
                .body("size()", greaterThanOrEqualTo(100));
    }

    /**
     * Test Case 2: Get a single post
     * Requirement: Verify that for post with id 1, the userId equals 1.
     */
    @Test
    public void testGetSinglePost() {
        RestAssured.given()
                .when()
                .get("/posts/1")
                .then()
                .log().ifValidationFails()
                .assertThat()
                .statusCode(200)
                .body("userId", equalTo(1));
    }
}