import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class TestPotato {
    @Test
    public void testPotato() throws IOException{
        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/json/potato.json"))));
        body.put("name", "Tomato");
        body.put("job", "Eat maket");

        String renamePotato = given()
                .header("Content-type", "application/json")
                .header("charset", "UTF-8")
                .baseUri("https://reqres.in/")
                .body(body.toString())
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract().response()
                .prettyPrint();


    }
}
