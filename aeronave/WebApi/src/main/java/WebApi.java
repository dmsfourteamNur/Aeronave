import Controllers.AeronaveController;
import Controllers.MarcaController;
import fourteam.config.Config;
import fourteam.http.Rest;

public class WebApi {

  public static void AddControllers() {
    Rest.addController(AeronaveController.class);
    Rest.addController(MarcaController.class);
    Rest.start(Integer.parseInt(Config.getProperty("http.port")));
    Rest.createSwagger();
  }
}
