package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BuyInPortugal {
  private VDMMap sellers;
  private VDMMap buyers;
  private VDMMap companies;

  public void cg_init_BuyInPortugal_1() {

    sellers = MapUtil.map();
    buyers = MapUtil.map();
    companies = MapUtil.map();
    return;
  }

  public BuyInPortugal() {

    cg_init_BuyInPortugal_1();
  }

  public VDMMap getBuyers() {

    return Utils.copy(buyers);
  }

  public VDMMap getSellers() {

    return Utils.copy(sellers);
  }

  public VDMMap getCompanies() {

    return Utils.copy(companies);
  }

  public void register(
      final String username, final String companyName, final Object companyDimension) {

    if (SetUtil.inSet(companyName, MapUtil.dom(Utils.copy(companies)))) {
      final Company company = ((Company) Utils.get(companies, companyName));
      buyers =
          MapUtil.munion(
              Utils.copy(buyers), MapUtil.map(new Maplet(username, new Buyer(username, company))));

    } else {
      final Company company = new Company(companyName, ((Object) companyDimension));
      {
        companies =
            MapUtil.munion(Utils.copy(companies), MapUtil.map(new Maplet(companyName, company)));
        buyers =
            MapUtil.munion(
                Utils.copy(buyers),
                MapUtil.map(new Maplet(username, new Buyer(username, company))));
      }
    }
  }

  public void becomeSeller(final String username) {

    {
      final Buyer buyer = ((Buyer) Utils.get(buyers, username));
      sellers =
          MapUtil.munion(
              Utils.copy(sellers),
              MapUtil.map(new Maplet(username, new Seller(username, buyer.getCompany()))));
    }
  }

  public void transferFunds(final String username, final Number value) {

    ((Buyer) Utils.get(buyers, username)).addFunds(value);
    ((Seller) Utils.get(sellers, username)).reduceFunds(value);
  }

  public void verifySeller(final String username) {

    ((Seller) Utils.get(sellers, username)).setVerified();
  }

  public void addItemToSale(
      final String username,
      final String prodName,
      final Number prodPrice,
      final Object prodCategory,
      final Number prodQty) {

    if (!(Utils.equals(prodQty, -1L))) {
      ((Seller) Utils.get(sellers, username))
          .addProductToSale(new Product(prodName, prodPrice, ((Object) prodCategory), prodQty));
    } else {
      ((Seller) Utils.get(sellers, username))
          .addProductToSale(new Service(prodName, prodPrice, ((Object) prodCategory)));
    }
  }

  public VDMSet searchSalesByName(final String name) {

    VDMSet sales = SetUtil.set();
    for (Iterator iterator_2 = MapUtil.dom(Utils.copy(sellers)).iterator();
        iterator_2.hasNext();
        ) {
      String c = (String) iterator_2.next();
      sales =
          SetUtil.union(Utils.copy(sales), ((Seller) Utils.get(sellers, c)).getSalesByName(name));
    }
    return Utils.copy(sales);
  }

  public VDMSet searchSalesByCategory(final Object category) {

    VDMSet sales = SetUtil.set();
    for (Iterator iterator_3 = MapUtil.dom(Utils.copy(sellers)).iterator();
        iterator_3.hasNext();
        ) {
      String c = (String) iterator_3.next();
      sales =
          SetUtil.union(
              Utils.copy(sales),
              ((Seller) Utils.get(sellers, c)).getSalesByCategory(((Object) category)));
    }
    return Utils.copy(sales);
  }

  public void setNewProductPrice(
      final String sellerName, final String prodName, final Number prodPrice) {

    ((Seller) Utils.get(sellers, sellerName)).setNewSalePrice(prodName, prodPrice);
  }

  public void checkoutCartOfUser(
      final String userName, final Number year, final Number month, final Number day) {

    VDMSeq cartItems = ((Buyer) Utils.get(buyers, userName)).makeOrder(year, month, day);
    Number upper = cartItems.size();
    long toVar_1 = upper.longValue();

    for (Long i = 1L; i <= toVar_1; i++) {
      Buyer.cartItem cartItem = Utils.copy(((Buyer.cartItem) Utils.get(cartItems, i)));
      sellItem(cartItem.sName, cartItem.product.getName());
    }
  }

  private void sellItem(final String sName, final String pName) {

    ((Seller) Utils.get(sellers, sName)).sellProduct(pName);
  }

  public void addToCartOfUser(
      final String buyerName, final String sItemName, final String sellerName) {

    Seller seller = ((Seller) Utils.get(sellers, sellerName));
    SaleItem saleItem = seller.getSaleItem(sItemName);
    ((Buyer) Utils.get(buyers, buyerName)).addToCart(saleItem, sellerName);
  }

  public void addFundsToUser(final String userName, final Number value) {

    ((Buyer) Utils.get(buyers, userName)).addFunds(value);
  }

  public void setNewCompanyInfo(
      final String previousName, final String newCompName, final Object newCompDimension) {

    Company company = ((Company) Utils.get(companies, previousName));
    company.setName(newCompName);
    company.setDimension(newCompDimension);
    companies = MapUtil.domResBy(SetUtil.set(previousName), Utils.copy(companies));
    companies =
        MapUtil.munion(Utils.copy(companies), MapUtil.map(new Maplet(newCompName, company)));
  }

  public void changeItemSaleCategory(
      final String username, final String productName, final Object newCategory) {

    ((Seller) Utils.get(sellers, username)).changeItemSaleCategory(productName, newCategory);
  }

  public void blockSeller(final String username) {

    ((Seller) Utils.get(sellers, username)).setBlocked();
  }

  public void changeUserCompany(
      final String username, final String compName, final Object compDimension) {

    if (SetUtil.inSet(compName, MapUtil.dom(Utils.copy(companies)))) {
      final Company company = ((Company) Utils.get(companies, compName));
      {
        if (SetUtil.inSet(username, MapUtil.dom(Utils.copy(sellers)))) {
          ((Seller) Utils.get(sellers, username)).setCompany(company);
        }

        ((Buyer) Utils.get(buyers, username)).setCompany(company);
      }

    } else {
      final Company company = new Company(compName, ((Object) compDimension));
      {
        companies =
            MapUtil.munion(Utils.copy(companies), MapUtil.map(new Maplet(compName, company)));
        if (SetUtil.inSet(username, MapUtil.dom(Utils.copy(sellers)))) {
          ((Seller) Utils.get(sellers, username)).setCompany(company);
        }

        ((Buyer) Utils.get(buyers, username)).setCompany(company);
      }
    }
  }

  public static Boolean checkSellersAndBuyers(final VDMMap buyers_1, final VDMMap sellers_1) {

    return SetUtil.subset(MapUtil.dom(Utils.copy(sellers_1)), MapUtil.dom(Utils.copy(buyers_1)));
  }

  public String toString() {

    return "BuyInPortugal{"
        + "sellers := "
        + Utils.toString(sellers)
        + ", buyers := "
        + Utils.toString(buyers)
        + ", companies := "
        + Utils.toString(companies)
        + "}";
  }
}
