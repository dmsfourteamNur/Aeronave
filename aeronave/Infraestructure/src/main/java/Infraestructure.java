import Context.IWriteDbContext;
import Fourteam.config.Config;
import Fourteam.extensions.IServiceCollection;
import Repositories.*;
import Repository.*;
import UseCases.Consumers.AeronaveCreadoConsumer;
import UseCases.Consumers.TripulacionCreadoConsumer;

public class Infraestructure {

  public static void AddInfraestructure() {
    IServiceCollection.AddMediator();
    IServiceCollection.AddScoped(IWriteDbContext.class, Context.MongoDB.WriteDbContext.class);
    IServiceCollection.AddScoped(IUnitOfWork.class, UnitOfWork.class);
    IServiceCollection.AddScoped(IAeronaveRepository.class, AeronaveRepository.class);
    IServiceCollection.AddScoped(IAsientoRepository.class, AsientoRepository.class);
    IServiceCollection.AddScoped(IMarcaRepository.class, MarcaRepository.class);
    Application.AddApplication();
    // AddRabbitMq();
  }

  private static void AddRabbitMq() {
    IServiceCollection.AddMassTransit(config -> {
      config.AddConsumer(TripulacionCreadoConsumer.class);
      config.AddConsumer(AeronaveCreadoConsumer.class);

      config.UsingRabbitMq((context, cfg) -> {
        cfg.Host = Config.getProperty("rabit.host");
        cfg.User = Config.getProperty("rabit.user");
        cfg.Password = Config.getProperty("rabit.pass");
      });
    });
  }
}
