package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class Pet {
    String uri = "https://petstore.swagger.io/v2/user";
    int petId = 1101;

    public String lerJson(String caminhoJson) throws IOException {

        return new String (Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test(priority = 0)
    public void incluir() throws IOException {
       String jsonBody = lerJson("src/test/resources/data/pet.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
                //.body("code",is(200))
                .body("id",is(petId))
                .body("name",is("Jay"))
                .body("category.name",is("dog"))
                .body("tags.name[0]",stringContainsInOrder("vermifugado "))
        ;
    }

    @Test(priority = 1, dependsOnMethods = {"incluir"})
    public void consultarPet(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("name",is("Jay"))
                .body("status", is("available"))
        ;
    }

    @Test(priority = 2,dependsOnMethods = {"consultarPet"})
        public void alterarPet() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/newpet.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                        .put(uri)
                .then()
                .log().all()
                .statusCode(200)
                .body("status",is("vendido"))
        ;
    }

    @Test (priority = 3, dependsOnMethods = {"alterarPet"})
   public void excluirPet(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" +petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code",is(200))
                .body("type", is("unknown"))
                .body("message",is(Integer.toString(petId)))
        ;
    }




}
