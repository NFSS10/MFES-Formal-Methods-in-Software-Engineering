package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Seller extends User {
  public Object status = MFES_Proj.quotes.PendingVerificationQuote.getInstance();
  private VDMMap saleItems = MapUtil.map();

  public void cg_init_Seller_1(final String sName, final Company sCompany) {

    name = sName;
    company = sCompany;
    cash = 0.0;
    return;
  }

  public Seller(final String sName, final Company sCompany) {

    cg_init_Seller_1(sName, sCompany);
  }

  public void setVerified() {

    status = MFES_Proj.quotes.VerifiedQuote.getInstance();
  }

  public void setBlocked() {

    VDMMap atomicTmp_1 = MapUtil.map();
    Object atomicTmp_2 = MFES_Proj.quotes.BlockedQuote.getInstance();
    {
        /* Start of atomic statement */
      saleItems = Utils.copy(atomicTmp_1);
      status = atomicTmp_2;
    } /* End of atomic statement */
  }

  public void addProductToSale(final SaleItem saleItem) {

    Boolean andResult_15 = false;

    if (saleItem instanceof Service) {
      if (!(SetUtil.inSet(saleItem.getName(), MapUtil.dom(Utils.copy(saleItems))))) {
        andResult_15 = true;
      }
    }

    if (andResult_15) {
      saleItems =
          MapUtil.munion(
              Utils.copy(saleItems), MapUtil.map(new Maplet(saleItem.getName(), saleItem)));
    } else {
      Boolean andResult_16 = false;

      if (saleItem instanceof Product) {
        if (!(SetUtil.inSet(saleItem.getName(), MapUtil.dom(Utils.copy(saleItems))))) {
          andResult_16 = true;
        }
      }

      if (andResult_16) {
        saleItems =
            MapUtil.munion(
                Utils.copy(saleItems), MapUtil.map(new Maplet(saleItem.getName(), saleItem)));
      } else {
        final Product p = ((Product) Utils.get(saleItems, saleItem.getName()));
        {
          Product sItem = (Product)saleItem;
          p.addQuantityByTheSeller(sItem.getStockQt());
        }
      }
    }
  }

  public void sellProduct(final String sItemName) {

    SaleItem saleItem = ((SaleItem) Utils.get(saleItems, sItemName));
    if (saleItem instanceof Product) {
      final Product p = ((Product) Utils.get(saleItems, saleItem.getName()));
      {
        p.removeQuantityByTheSeller(1L);
      }
    }

    addFunds(saleItem.getPrice());
  }

  public void setNewSalePrice(final String saleName, final Number price) {

    final SaleItem p = ((SaleItem) Utils.get(saleItems, saleName));
    {
      p.setNewPrice(price);
    }
  }

  public VDMMap getSaleItemsBeingSoldByMe() {

    return Utils.copy(saleItems);
  }

  public VDMSet getSalesByName(final String sName) {

    if (SetUtil.inSet(sName, MapUtil.dom(Utils.copy(saleItems)))) {
      return SetUtil.set(((SaleItem) Utils.get(saleItems, sName)));

    } else {
      return SetUtil.set();
    }
  }

  public VDMSet getSalesByCategory(final Object category) {

    return getCategoriesAux(MapUtil.rng(Utils.copy(saleItems)), ((Object) category));
  }

  public SaleItem getSaleItem(final String sName) {

    return ((SaleItem) Utils.get(saleItems, sName));
  }

  public void changeItemSaleCategory(final String itemSaleName, final Object newCategory) {

    ((SaleItem) Utils.get(saleItems, itemSaleName)).setCategory(newCategory);
  }

  public Seller() {}

  public static VDMSet getCategoriesAux(final VDMSet saleItems_1, final Object category) {

    VDMSet setCompResult_1 = SetUtil.set();
    VDMSet set_1 = Utils.copy(saleItems_1);
    for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext(); ) {
      SaleItem sale = ((SaleItem) iterator_1.next());
      if (Utils.equals(sale.getCategory(), category)) {
        setCompResult_1.add(sale);
      }
    }
    return Utils.copy(setCompResult_1);
  }

  public static Boolean restrictNumberOfSales(final VDMSet saleItens, final Company company_1) {

    Boolean casesExpResult_1 = null;

    Object casesExp_1 = company_1.getDimension();
    Object quotePattern_1 = casesExp_1;
    Boolean success_3 = Utils.equals(quotePattern_1, MFES_Proj.quotes.MicroQuote.getInstance());

    if (!(success_3)) {
      Object quotePattern_2 = casesExp_1;
      success_3 = Utils.equals(quotePattern_2, MFES_Proj.quotes.SmallQuote.getInstance());

      if (!(success_3)) {
        Object quotePattern_3 = casesExp_1;
        success_3 = Utils.equals(quotePattern_3, MFES_Proj.quotes.MediumQuote.getInstance());

        if (!(success_3)) {
          Object quotePattern_4 = casesExp_1;
          success_3 = Utils.equals(quotePattern_4, MFES_Proj.quotes.BigQuote.getInstance());

          if (success_3) {
            Boolean ternaryIfExp_10 = null;

            if (saleItens.size() > 300L) {
              ternaryIfExp_10 = false;
            } else {
              ternaryIfExp_10 = true;
            }

            casesExpResult_1 = ternaryIfExp_10;
          }

        } else {
          Boolean ternaryIfExp_9 = null;

          if (saleItens.size() > 200L) {
            ternaryIfExp_9 = false;
          } else {
            ternaryIfExp_9 = true;
          }

          casesExpResult_1 = ternaryIfExp_9;
        }

      } else {
        Boolean ternaryIfExp_8 = null;

        if (saleItens.size() > 100L) {
          ternaryIfExp_8 = false;
        } else {
          ternaryIfExp_8 = true;
        }

        casesExpResult_1 = ternaryIfExp_8;
      }

    } else {
      Boolean ternaryIfExp_7 = null;

      if (saleItens.size() > 50L) {
        ternaryIfExp_7 = false;
      } else {
        ternaryIfExp_7 = true;
      }

      casesExpResult_1 = ternaryIfExp_7;
    }

    return casesExpResult_1;
  }

  public String toString() {

    return "Seller{"
        + "status := "
        + Utils.toString(status)
        + ", saleItems := "
        + Utils.toString(saleItems)
        + "}";
  }
}
