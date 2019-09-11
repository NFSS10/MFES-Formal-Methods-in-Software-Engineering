package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Product extends SaleItem {
  private Number quantity;

  public void cg_init_Product_1(
      final String pName, final Number pPrice, final Object pCategory, final Number qty) {

    name = pName;
    price = pPrice;
    category = pCategory;
    quantity = qty;
    return;
  }

  public Product(
      final String pName, final Number pPrice, final Object pCategory, final Number qty) {

    cg_init_Product_1(pName, pPrice, pCategory, qty);
  }

  public void addQuantityByTheSeller(final Number qty) {

    quantity = quantity.longValue() + qty.longValue();
  }

  public void removeQuantityByTheSeller(final Number qty) {

    quantity = quantity.longValue() - qty.longValue();
  }

  public Number getStockQt() {

    return quantity;
  }

  public Product() {}

  public String toString() {

    return "Product{" + "quantity := " + Utils.toString(quantity) + "}";
  }
}
