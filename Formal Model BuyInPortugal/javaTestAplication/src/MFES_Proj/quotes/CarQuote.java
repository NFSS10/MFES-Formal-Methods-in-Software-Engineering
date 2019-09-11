package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CarQuote {
  private static int hc = 0;
  private static CarQuote instance = null;

  public CarQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CarQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CarQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CarQuote;
  }

  public String toString() {

    return "<Car>";
  }
}
