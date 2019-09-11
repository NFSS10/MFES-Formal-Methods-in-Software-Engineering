package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class HomeQuote {
  private static int hc = 0;
  private static HomeQuote instance = null;

  public HomeQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static HomeQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new HomeQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof HomeQuote;
  }

  public String toString() {

    return "<Home>";
  }
}
