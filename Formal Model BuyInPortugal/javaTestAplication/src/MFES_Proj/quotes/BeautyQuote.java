package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BeautyQuote {
  private static int hc = 0;
  private static BeautyQuote instance = null;

  public BeautyQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BeautyQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BeautyQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BeautyQuote;
  }

  public String toString() {

    return "<Beauty>";
  }
}
