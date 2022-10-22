package collection;

import java.util.List;
import java.util.ArrayList;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    if (input.isEmpty()){
      return new ArrayList<Double>();
    }
    else {
      List<Double> output = new ArrayList<Double>();
      for (Integer element : input){
        output.add(operation1(element));
      }
      return output;
    }
  }

  public static Double operation1(Integer element) {
    int exp = element * 2;
    exp = exp + 3;
    Double res = 1.0;
    for (int i = 0; i < 5; i ++){
      res = res * exp;
    }
    return res;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    if (input.isEmpty()){
      return new ArrayList<String>();
    }
    else {
      List<String> output = new ArrayList<String>();
      for (String element : input){
        output.add(operation2(element));
      }
      return output;
    }
  }

  public static String operation2(String element){
    String maj = element.substring(0,1);
    maj.toUpperCase();
    String res = maj + element.substring(1);
    res.concat(res);
    return res;
  }

}
