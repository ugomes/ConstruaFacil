package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class User {
    String uri = "https://petstore.swagger.io/v2/user";
    int userId = 2101;
    String username = "Joao";
    String password = "12345@mudar";
    String token = "";
    public String lerJson(String caminhoJson) throws IOException {

        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test
    public void incluirUsuario() throws IOException {

        String jsonBody = lerJson("src/test/resources/data/user.json");

            given()
                    .contentType("application/json")
                    .log().all()
                    .body(jsonBody)
            .when()
                    .post(uri)
            .then()
                    .log().all()
                    .statusCode(200)
                    .body("code",is(200))
                    .body("type", is("unknown"))
                    .body("message", is(Integer.toString(userId)))

       ;
    }
    @Test
    public void consultarUsuario(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + username)
        .then()
                .statusCode(200)
                .body("username",is("Joao"))
                .body("email", is("joao.jr@teste.com.br"))
                .body("id",is(userId))

        ;
    }
@Test
    public void login(){

        String mensagem =

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/login?username=" + username + "&password=" + password )
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
               .body("type", is("unknown"))
        .extract()
                .path("message")
       ;
    System.out.println("A mensagem e : " + mensagem);
    token = mensagem.substring(23);
    System.out.println("O token e :" + token);
    }

}
