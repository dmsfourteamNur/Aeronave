package aeronave.steps;

import context.World;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Assert;
import util.RequestSpecificationFactory;

public class crearAeronaveSteps {

  private final World world;
  private RequestSpecification request;
  private JSONObject requestData;
  private Response response;

  public crearAeronaveSteps(World world) {
    this.world = world;
  }

  @Before
  public void setUp() {
    request = RequestSpecificationFactory.getInstance();
  }

  @Given("crear aeronave valida")
  public void given(@Transpose DataTable dataTable) {
    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
    requestData = new JSONObject();
    requestData.put("matricula", data.get(0).get("matricula"));
    requestData.put("keyModelo", data.get(0).get("keyModelo"));
  }

  @Given("crear aeronave invalida")
  public void given2(@Transpose DataTable dataTable) {
    List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
    String matricula = data.get(0).get("matricula");
    requestData = new JSONObject();
    requestData.put("matricula", matricula);
  }

  @When("se envia una solicitud para la creacion de una aeronave")
  public void when1() {
    response =
      request
        .accept(ContentType.JSON)
        .body(requestData.toString())
        .contentType(ContentType.JSON)
        .when()
        .post(this.world.envConfig.getProperty("service_url") + "/aeronave/registro");
  }

  @Then("luego verifique que la respuesta HTTP sea {int}")
  public void then1(Integer status) {
    Integer actualStatusCode = response.then().extract().statusCode();
    Assert.assertEquals(status, actualStatusCode);
  }

  @Then("se devuelve una identificacion de la aeronave")
  public void then2() {
    String responseString = response.then().extract().asString();
    Assert.assertNotNull(responseString);
    Assert.assertNotEquals("", responseString);
  }
}
