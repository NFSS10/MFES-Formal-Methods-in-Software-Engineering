package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ToysQuote {
  private static int hc = 0;
  private static ToysQuote instance = null;

  public ToysQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ToysQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ToysQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ToysQuote;
  }

  public String toString() {

    return "<Toys>";
  }
}
