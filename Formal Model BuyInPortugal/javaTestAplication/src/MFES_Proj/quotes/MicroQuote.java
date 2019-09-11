package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MicroQuote {
  private static int hc = 0;
  private static MicroQuote instance = null;

  public MicroQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MicroQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MicroQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MicroQuote;
  }

  public String toString() {

    return "<Micro>";
  }
}
