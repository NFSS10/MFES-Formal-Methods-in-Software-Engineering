package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Service extends SaleItem {
  public void cg_init_Service_1(final String pName, final Number pPrice, final Object pCategory) {

    name = pName;
    price = pPrice;
    category = pCategory;
    return;
  }

  public Service(final String pName, final Number pPrice, final Object pCategory) {

    cg_init_Service_1(pName, pPrice, pCategory);
  }

  public Service() {}

  public String toString() {

    return "Service{}";
  }
}
