package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class HealthQuote {
  private static int hc = 0;
  private static HealthQuote instance = null;

  public HealthQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static HealthQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new HealthQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof HealthQuote;
  }

  public String toString() {

    return "<Health>";
  }
}
