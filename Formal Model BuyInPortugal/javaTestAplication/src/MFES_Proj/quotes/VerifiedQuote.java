package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class VerifiedQuote {
  private static int hc = 0;
  private static VerifiedQuote instance = null;

  public VerifiedQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static VerifiedQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new VerifiedQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof VerifiedQuote;
  }

  public String toString() {

    return "<Verified>";
  }
}
