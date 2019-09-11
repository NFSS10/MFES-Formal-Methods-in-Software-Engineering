package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MoviesQuote {
  private static int hc = 0;
  private static MoviesQuote instance = null;

  public MoviesQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MoviesQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MoviesQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MoviesQuote;
  }

  public String toString() {

    return "<Movies>";
  }
}
