import Controllers.AeronaveController;
import Controllers.MarcaController;
import Fourteam.config.Config;
import Fourteam.http.Rest;

public class WebApi {

  public static void AddControllers() {
    Rest.addController(AeronaveController.class);
    Rest.addController(MarcaController.class);
    Rest.start(Integer.parseInt(Config.getProperty("http.port")));
    Rest.createSwagger();
  }
}
