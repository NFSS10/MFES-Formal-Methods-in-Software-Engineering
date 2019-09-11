package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Company {
  private Object dimension;
  private String name;

  public void cg_init_Company_1(final String cName, final Object cDimension) {

    name = cName;
    dimension = cDimension;
    return;
  }

  public Company(final String cName, final Object cDimension) {

    cg_init_Company_1(cName, cDimension);
  }

  public String getName() {

    return name;
  }

  public Object getDimension() {

    return dimension;
  }

  public void setName(final String newName) {

    name = newName;
  }

  public void setDimension(final Object newDimension) {

    dimension = newDimension;
  }

  public Company() {}

  public String toString() {

    return "Company{"
        + "dimension := "
        + Utils.toString(dimension)
        + ", name := "
        + Utils.toString(name)
        + "}";
  }
}
