import Context.IWriteDbContext;
import Repositories.IUnitOfWork;
import core.ConfirmedDomainEvent;
import core.DomainEvent;
import fourteam.db.Exception.DataBaseException;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.Mediator;
import java.util.List;

public class UnitOfWork implements IUnitOfWork {

  private IWriteDbContext _context;
  private Mediator _mediator;

  public UnitOfWork(IWriteDbContext context, Mediator mediator) {
    _context = context;
    _mediator = mediator;
  }

  @Override
  public void commit() throws Exception {
    List<Object> events = _context.getDomainEvents();
    for (Object domainEvent : events) {
      DomainEvent event = (DomainEvent) domainEvent;
      _mediator.notify(event);
    }
    try {
      _context.Commit();
    } catch (DataBaseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    for (Object domainEvent : events) {
      DomainEvent event = (DomainEvent) domainEvent;
      _mediator.notify(MakeGeneryc(event));
    }
  }

  public <T> ConfirmedDomainEvent<T> MakeGeneryc(T o) {
    return new ConfirmedDomainEvent<T>(o);
  }
}
