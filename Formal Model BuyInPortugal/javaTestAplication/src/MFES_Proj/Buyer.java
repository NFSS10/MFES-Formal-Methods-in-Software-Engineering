package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Buyer extends User {
  public static final Number avgDaysYear = 365.25;
  public static final Number avgDaysMonth = 30.44;
  private VDMSeq orderHistory = SeqUtil.seq();
  private VDMSeq cart = SeqUtil.seq();

  public void cg_init_Buyer_1(final String bName, final Company bCompany) {

    name = bName;
    company = bCompany;
    cash = 0.0;
    return;
  }

  public Buyer(final String bName, final Company bCompany) {

    cg_init_Buyer_1(bName, bCompany);
  }

  public VDMSeq getOrderHistory() {

    return Utils.copy(orderHistory);
  }

  public VDMSeq getCartItems() {

    return Utils.copy(cart);
  }

  public void addToCart(final SaleItem sItem, final String sName) {

    cart = SeqUtil.conc(Utils.copy(cart), SeqUtil.seq(new cartItem(sItem, sName)));
  }

  public VDMSeq makeOrder(final Number year, final Number month, final Number day) {

    VDMSeq productsBought = SeqUtil.seq();
    Number size = cart.size();
    VDMSeq oldcart = Utils.copy(cart);
    long toVar_2 = size.longValue();

    for (Long i = 1L; i <= toVar_2; i++) {
      productsBought =
          SeqUtil.conc(
              Utils.copy(productsBought), SeqUtil.seq(((cartItem) Utils.get(cart, i)).product));
      reduceFunds(((cartItem) Utils.get(cart, i)).product.getPrice());
    }
    orderHistory =
        SeqUtil.conc(
            Utils.copy(orderHistory),
            SeqUtil.seq(new Order(Utils.copy(productsBought), year, month, day)));
    resetCart();
    return Utils.copy(oldcart);
  }

  public void resetCart() {

    cart = SeqUtil.seq();
  }

  public Buyer() {}

  public static Boolean checkStock(final VDMSeq cart_1) {

    if (Utils.empty(cart_1)) {
      return true;

    } else {
      final cartItem c = Utils.copy(((cartItem) cart_1.get(0)));

      Boolean ternaryIfExp_3 = null;

      if (c.product instanceof Product) {
        final Product p = (Product)c.product;

        Boolean ternaryIfExp_4 = null;

        if (p.getStockQt().longValue() < 1L) {
          ternaryIfExp_4 = false;
        } else {
          ternaryIfExp_4 = checkStock(SeqUtil.tail(Utils.copy(cart_1)));
        }

        ternaryIfExp_3 = ternaryIfExp_4;

      } else {
        ternaryIfExp_3 = checkStock(SeqUtil.tail(Utils.copy(cart_1)));
      }

      return ternaryIfExp_3;
    }
  }

  public static Number getTotal(final VDMSeq cart) {

    if (Utils.empty(cart)) {
      return 0.0;

    } else {
      final cartItem c = Utils.copy(((cartItem) cart.get(0)));

      return c.product.getPrice().doubleValue()
          + getTotal(SeqUtil.tail(Utils.copy(cart))).doubleValue();
    }
  }

  public static Boolean checkDates(final VDMSeq orders) {

    if (orders.size() < 2L) {
      return true;

    } else {
      if (((Order) Utils.get(orders, 1L)).getDate().year.longValue()
                  * Buyer.avgDaysYear.doubleValue()
              + ((Order) Utils.get(orders, 1L)).getDate().month.longValue()
                  * Buyer.avgDaysMonth.doubleValue()
              + ((Order) Utils.get(orders, 1L)).getDate().day.longValue()
          <= ((Order) Utils.get(orders, 2L)).getDate().year.longValue()
                  * Buyer.avgDaysYear.doubleValue()
              + ((Order) Utils.get(orders, 2L)).getDate().month.longValue()
                  * Buyer.avgDaysMonth.doubleValue()
              + ((Order) Utils.get(orders, 2L)).getDate().day.longValue()) {
        return checkDates(SeqUtil.tail(Utils.copy(orders)));

      } else {
        return false;
      }
    }
  }

  public String toString() {

    return "Buyer{"
        + "avgDaysYear = "
        + Utils.toString(avgDaysYear)
        + ", avgDaysMonth = "
        + Utils.toString(avgDaysMonth)
        + ", orderHistory := "
        + Utils.toString(orderHistory)
        + ", cart := "
        + Utils.toString(cart)
        + "}";
  }

  public static class cartItem implements Record {
    public SaleItem product;
    public String sName;

    public cartItem(final SaleItem _product, final String _sName) {

      product = _product != null ? _product : null;
      sName = _sName != null ? _sName : null;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof cartItem)) {
        return false;
      }

      cartItem other = ((cartItem) obj);

      return (Utils.equals(product, other.product)) && (Utils.equals(sName, other.sName));
    }

    public int hashCode() {

      return Utils.hashCode(product, sName);
    }

    public cartItem copy() {

      return new cartItem(product, sName);
    }

    /*public String toString() {

      return "mk_Buyer`cartItem" + Utils.formatFields(product, sName);
    }*/

    public String toString()
    {
      return "("+product.getName()+" - "+product.getPrice()+"€ - vendedor: " + sName + ") ";
    }
  }
}
