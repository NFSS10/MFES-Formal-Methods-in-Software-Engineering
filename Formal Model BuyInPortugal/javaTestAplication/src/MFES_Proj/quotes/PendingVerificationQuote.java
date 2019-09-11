package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PendingVerificationQuote {
  private static int hc = 0;
  private static PendingVerificationQuote instance = null;

  public PendingVerificationQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PendingVerificationQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PendingVerificationQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PendingVerificationQuote;
  }

  public String toString() {

    return "<PendingVerification>";
  }
}
