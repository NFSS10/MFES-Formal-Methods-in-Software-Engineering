package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FoodQuote {
  private static int hc = 0;
  private static FoodQuote instance = null;

  public FoodQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FoodQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FoodQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FoodQuote;
  }

  public String toString() {

    return "<Food>";
  }
}
