package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SaleItem {
  protected String name;
  protected Number price;
  protected Object category;

  public void setNewPrice(final Number newPrice) {

    price = newPrice;
  }

  public void setCategory(final Object newCategory) {

    category = newCategory;
  }

  public Number getPrice() {

    return price;
  }

  public String getName() {

    return name;
  }

  public Object getCategory() {

    return category;
  }

  public SaleItem() {}

  public String toString() {

    return "SaleItem{"
        + "name := "
        + Utils.toString(name)
        + ", price := "
        + Utils.toString(price)
        + ", category := "
        + Utils.toString(category)
        + "}";
  }
}
