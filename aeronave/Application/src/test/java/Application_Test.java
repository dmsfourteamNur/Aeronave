import org.junit.Test;

public class Application_Test {

  @Test
  public void AddApplicationAccept() {
    // INFO:Usamos el IMediator del kernel en cambio del MediatR de Spring
    new Application();
    Application.AddApplication();
  }
}
