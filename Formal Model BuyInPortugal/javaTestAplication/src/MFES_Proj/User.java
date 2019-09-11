package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class User {
  protected String name;
  protected Company company;
  protected Number cash;

  public String getName() {

    return name;
  }

  public Company getCompany() {

    return company;
  }

  public void setCompany(final Company newCompany) {

    company = newCompany;
  }

  public Number getCurrentCash() {

    return cash;
  }

  public void addFunds(final Number value) {

    cash = cash.doubleValue() + value.doubleValue();
  }

  public void reduceFunds(final Number value) {

    cash = cash.doubleValue() - value.doubleValue();
  }

  public User() {}

  public String toString() {

    return "User{"
        + "name := "
        + Utils.toString(name)
        + ", company := "
        + Utils.toString(company)
        + ", cash := "
        + Utils.toString(cash)
        + "}";
  }
}
