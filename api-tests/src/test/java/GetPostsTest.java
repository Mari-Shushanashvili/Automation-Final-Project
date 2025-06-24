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
     * Prerequisite: Verify status code is 200 and the response contains at least 100 posts.
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
     * Prerequisite: Verify that for post with id 1, the userId equals 1.
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

    /**
     * Test Case 6: Get a non-existent post (Negative Test)
     * Prerequisite: Verify that the API returns a 404 Not Found status code
     * when requesting a resource that does not exist.
     */
    @Test
    public void testGetNonExistentPost() {
        RestAssured.given()
                .when()
                .get("/posts/9999")
                .then()
                .assertThat()
                .statusCode(404);
    }
}