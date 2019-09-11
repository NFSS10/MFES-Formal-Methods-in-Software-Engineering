package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClothesQuote {
  private static int hc = 0;
  private static ClothesQuote instance = null;

  public ClothesQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ClothesQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ClothesQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ClothesQuote;
  }

  public String toString() {

    return "<Clothes>";
  }
}
