package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
    for (Ceo ceo : ceos){
      if (ceo.id.equals(ceo_id)){
        Option<Ceo> res = new Option.Some<Ceo>.of(ceo);
        return new CompletableFuture().complete(res);
      }
    }
    Option<Ceo> res = new Option.None<Ceo>();
    return new CompletableFuture().complete(res);
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
    for (Entreprise entreprise : entreprises){
      if (entreprise.ceo_id.equals(ceo_id)){
        Option<Entreprise> res = new Option.Some<Entreprise>.of(entreprise);
        return new CompletableFuture().complete(res);
      }
    }
    Option<Ceo> res = new Option.None<Entreprise>();
    return new CompletableFuture().complete(res);
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
    Option<Ceo> ceo = getCeoById(ceo_id).get();
    Option<Entreprise entreprise = getEnterpriseByCeoId(ceo_id).get();
    Tuple2<Option<Ceo>, Option<Enterprise>> tuple = new Tuple2<Option<Ceo>, Option<Enterprise>>(ceo, entreprise);
    return new CompletableFuture().complete(tuple);
  }

}
