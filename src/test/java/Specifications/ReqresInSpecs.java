package Specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;

public class ReqresInSpecs {
    public static RequestSpecification reqresRequestSpec = with()
            .log().all()
            .filter(customLogFilter().withCustomTemplates())
            .baseUri("https://reqres.in/")
            .basePath("/api/users")
            .when()
            .log().uri()
            .log().body();

    public static ResponseSpecification reqresResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
