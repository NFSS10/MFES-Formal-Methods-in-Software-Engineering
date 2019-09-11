package MFES_Proj.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BlockedQuote {
  private static int hc = 0;
  private static BlockedQuote instance = null;

  public BlockedQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BlockedQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BlockedQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BlockedQuote;
  }

  public String toString() {

    return "<Blocked>";
  }
}
