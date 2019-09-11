package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AgricultureQuote {
  private static int hc = 0;
  private static AgricultureQuote instance = null;

  public AgricultureQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static AgricultureQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new AgricultureQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof AgricultureQuote;
  }

  public String toString() {

    return "<Agriculture>";
  }
}
