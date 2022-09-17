package Model.Aeronaves.ValueObjects;

import core.BussinessRuleValidateExeption;
import core.ValueObject;
import rule.StringNotNullOrEmptyRule;

public class ModeloAeronave extends ValueObject {

  private String value;

  public ModeloAeronave(String Value) throws BussinessRuleValidateExeption {
    CheckRule(new StringNotNullOrEmptyRule(Value));
    this.value = Value;
  }

  @Override
  public String toString() {
    return value;
  }
}
