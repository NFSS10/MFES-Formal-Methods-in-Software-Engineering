package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ElectronicQuote {
  private static int hc = 0;
  private static ElectronicQuote instance = null;

  public ElectronicQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ElectronicQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ElectronicQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ElectronicQuote;
  }

  public String toString() {

    return "<Electronic>";
  }
}
