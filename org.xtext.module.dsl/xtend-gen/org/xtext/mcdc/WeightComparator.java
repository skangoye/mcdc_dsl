package org.xtext.mcdc;

import java.util.Comparator;
import org.xtext.helper.Couple;

@SuppressWarnings("all")
public class WeightComparator implements Comparator<Couple<Couple<String, Integer>, Couple<String, Integer>>> {
  public int compare(final Couple<Couple<String, Integer>, Couple<String, Integer>> cp1, final Couple<Couple<String, Integer>, Couple<String, Integer>> cp2) {
    Couple<String, Integer> _first = cp1.getFirst();
    Integer _second = _first.getSecond();
    Couple<String, Integer> _second_1 = cp1.getSecond();
    Integer _second_2 = _second_1.getSecond();
    int _plus = ((_second).intValue() + (_second_2).intValue());
    final int cp1Weight = Integer.valueOf(_plus).intValue();
    Couple<String, Integer> _first_1 = cp2.getFirst();
    Integer _second_3 = _first_1.getSecond();
    Couple<String, Integer> _second_4 = cp2.getSecond();
    Integer _second_5 = _second_4.getSecond();
    int _plus_1 = ((_second_3).intValue() + (_second_5).intValue());
    final int cp2Weight = Integer.valueOf(_plus_1).intValue();
    if ((cp1Weight > cp2Weight)) {
      return (-1);
    } else {
      if ((cp1Weight < cp2Weight)) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
