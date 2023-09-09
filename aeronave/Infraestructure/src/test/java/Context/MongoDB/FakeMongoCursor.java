package Context.MongoDB;

import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.client.MongoCursor;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import org.bson.Document;

public class FakeMongoCursor implements MongoCursor<Document> {

  private final Iterator<Document> iterator;

  public FakeMongoCursor(List<Document> documents) {
    this.iterator = documents.iterator();
  }

  @Override
  public void close() {
    // Aquí puedes simular el cierre del cursor si es necesario.
  }

  @Override
  public boolean hasNext() {
    return iterator.hasNext();
  }

  @Override
  public Document next() {
    return iterator.next();
  }

  @Override
  public Document tryNext() {
    return iterator.hasNext() ? iterator.next() : null;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("No soportado en este stub.");
  }

  @Override
  public void forEachRemaining(Consumer<? super Document> action) {
    while (hasNext()) {
      action.accept(next());
    }
  }

  @Override
  public ServerCursor getServerCursor() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getServerCursor'");
  }

  @Override
  public ServerAddress getServerAddress() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getServerAddress'");
  }
  // ... Puedes agregar otras implementaciones de métodos si es necesario.
}
