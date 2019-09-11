package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SportsQuote {
  private static int hc = 0;
  private static SportsQuote instance = null;

  public SportsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SportsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SportsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SportsQuote;
  }

  public String toString() {

    return "<Sports>";
  }
}
