package Event;

import core.DomainEvent;
import java.time.LocalDateTime;
import java.util.UUID;

public class AeronaveChange extends DomainEvent {

  public UUID keyAeronave;

  public AeronaveChange() {
    super();
  }

  public AeronaveChange(UUID keyAeronave) {
    super(LocalDateTime.now());
    this.keyAeronave = keyAeronave;
  }

}
