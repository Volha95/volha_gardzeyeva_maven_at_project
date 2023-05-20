package homework.api.steps;

import classwork.day20.Search;
import homework.api.testdata.RequestSpec;
import homework.api.testobjects.Data;
import homework.api.testobjects.User;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class SearchUserWSTests {
    SearchMethods searchMethods = new SearchMethods();

    @Test
    public void searchFullLongName() throws FileNotFoundException {
        String name = "simon";
        User user = RestAssured
                .given()
                .spec(RequestSpec.requestSpec)
                .body(new Search(name, true))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class).getData().get(0);
        Assert.assertEquals("No such user", searchMethods.searchByExactMatch(name), user);
    }

    @Test
    public void searchFullShortName() throws FileNotFoundException {
        String name = "sim";
        User user = RestAssured
                .given()
                .spec(RequestSpec.requestSpec)
                .body(new Search(name, true))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class).getData().get(0);
        Assert.assertEquals("No such user", searchMethods.searchByPartialMatch(name), user);
    }

    @Test
    public void searchPartialLongName() throws FileNotFoundException {
        String name = "simon";
        User user = RestAssured
                .given()
                .spec(RequestSpec.requestSpec)
                .body(new Search(name, false))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class).getData().get(0);
        Assert.assertEquals("No such user", searchMethods.searchByPartialMatch(name), user);
    }

    @Test
    public void searchPartialShortName() throws FileNotFoundException {
        String name = "sim";
        User user = RestAssured
                .given()
                .spec(RequestSpec.requestSpec)
                .body(new Search(name, false))
                .when()
                .post()
                .then()
                .extract().body().as(Data.class).getData().get(0);
        Assert.assertEquals("No such user", searchMethods.searchByPartialMatch(name), user);
    }

    @Test
    public void searchAllUsers() throws FileNotFoundException {
        String name = "";
        List<User> users = RestAssured
                .given()
                .spec(RequestSpec.requestSpec)
                .body(new Search(name, false))
                .when()
                .post()
                .then()
                .statusCode(300)
                .extract().body().as(Data.class).getData();
        Assert.assertEquals("No users", searchMethods.searchUsers(), users);
    }
}
