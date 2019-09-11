package MFES_Proj;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Order {
  private VDMSeq saleItems;
  private Date date;

  public void cg_init_Order_1(
      final VDMSeq sib, final Number year, final Number month, final Number day) {

    saleItems = Utils.copy(sib);
    date = new Date(year, month, day);
    return;
  }

  public Order(final VDMSeq sib, final Number year, final Number month, final Number day) {

    cg_init_Order_1(Utils.copy(sib), year, month, day);
  }

  public VDMSeq getSaleItemsBought() {

    return Utils.copy(saleItems);
  }

  public Date getDate() {

    return Utils.copy(date);
  }

  public Order() {}

  public static Number DaysOfMonth(final Number year, final Number month) {

    Boolean orResult_1 = false;

    if (Utils.equals(month, 4L)) {
      orResult_1 = true;
    } else {
      Boolean orResult_2 = false;

      if (Utils.equals(month, 6L)) {
        orResult_2 = true;
      } else {
        Boolean orResult_3 = false;

        if (Utils.equals(month, 9L)) {
          orResult_3 = true;
        } else {
          orResult_3 = Utils.equals(month, 11L);
        }

        orResult_2 = orResult_3;
      }

      orResult_1 = orResult_2;
    }

    if (orResult_1) {
      return 30L;

    } else {
      if (Utils.equals(month, 2L)) {
        Boolean orResult_4 = false;

        Boolean andResult_9 = false;

        if (Utils.equals(Utils.mod(year.longValue(), 4L), 0L)) {
          if (!(Utils.equals(Utils.mod(year.longValue(), 100L), 0L))) {
            andResult_9 = true;
          }
        }

        if (andResult_9) {
          orResult_4 = true;
        } else {
          orResult_4 = Utils.equals(Utils.mod(year.longValue(), 400L), 0L);
        }

        final Boolean leapyear = orResult_4;

        Number ternaryIfExp_5 = null;

        if (Utils.equals(leapyear, false)) {
          ternaryIfExp_5 = 28L;
        } else {
          ternaryIfExp_5 = 29L;
        }

        return ternaryIfExp_5;

      } else {
        return 31L;
      }
    }
  }

  public String toString() {

    return "Order{"
        + "saleItems := "
        + Utils.toString(saleItems)
        + ", date := "
        + Utils.toString(date)
        + "}";
  }

  public static class Date implements Record {
    public Number year;
    public Number month;
    public Number day;

    public Date(final Number _year, final Number _month, final Number _day) {

      year = _year;
      month = _month;
      day = _day;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Date)) {
        return false;
      }

      Date other = ((Date) obj);

      return (Utils.equals(year, other.year))
          && (Utils.equals(month, other.month))
          && (Utils.equals(day, other.day));
    }

    public int hashCode() {

      return Utils.hashCode(year, month, day);
    }

    public Date copy() {

      return new Date(year, month, day);
    }

    public String toString() {

      return "mk_Order`Date" + Utils.formatFields(year, month, day);
    }
  }

  public static Boolean inv_Date(final Date recordPattern_1) {

    Boolean success_1 = true;
    Number y = null;
    Number m = null;
    Number d = null;
    y = recordPattern_1.year;
    m = recordPattern_1.month;
    d = recordPattern_1.day;

    if (!(success_1)) {
      throw new RuntimeException("Record pattern match failed");
    }

    Boolean andResult_10 = false;

    if (m.longValue() <= 12L) {
      if (d.longValue() <= DaysOfMonth(y, m).longValue()) {
        andResult_10 = true;
      }
    }

    return andResult_10;
  }
}
