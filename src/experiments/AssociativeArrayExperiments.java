package experiments;

import java.io.PrintWriter;
import java.math.BigInteger;

import structures.AssociativeArray;
import structures.KeyNotFoundException;

/**
 * Experiments with our AssociativeArray class.
 *
 * @author Shibam Mukhopadhyay
 * @author Samuel A. Rebelsky
 */
public class AssociativeArrayExperiments {

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run the experiments.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    divider(pen);
    experimentStringsToStrings(pen);
    divider(pen);
    experimentBigIntToBigInt(pen);
    divider(pen);
    experimentBigIntToStrings(pen);
  } // main(String[])

  // +-------------+-------------------------------------------------
  // | Experiments |
  // +-------------+

  /**
   * Our first experiment: Associative arrays with strings as both keys 
   * and values.
   */
  public static void experimentStringsToStrings(PrintWriter pen) throws Exception {
    AssociativeArray<String,String> s2s = 
      new ReportingAssociativeArray<String,String>("s2s", pen);
    s2s.size();
    s2s.set("a", "apple");
    s2s.set("A", "aardvark");
    s2s.size();
    s2s.hasKey("a");
    s2s.hasKey("A");
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
    s2s.remove("a");
    s2s.size();
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
    s2s.remove("aardvark");
    s2s.size();
    try { s2s.get("a"); } catch (Exception e) { }
    try { s2s.get("A"); } catch (Exception e) { }
  } // experimentStringsToStrings

  /**
   * Our second experiment: Associative arrays with big integers as
   * keys and values.
   */
  public static void experimentBigIntToBigInt(PrintWriter pen) throws Exception {
    AssociativeArray<BigInteger,BigInteger> b2b =
      new ReportingAssociativeArray<BigInteger,BigInteger>("b2b", pen);

    // Set some values
    for (int i = 0; i < 11; i++) {
      b2b.set(BigInteger.valueOf(i), BigInteger.valueOf(i*i));
    } // for

    // Then get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for

    // Then remove some of them
    for (int i = 1; i < 11; i += 2) {
      b2b.remove(BigInteger.valueOf(i));
    } // for

    // Then see what happens when we get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for

    // Then reset or set some values
    for (int i = 0; i < 11; i += 3) {
      b2b.set(BigInteger.valueOf(i), BigInteger.valueOf(i + 10));
    } // for

    // Then see what happens when we get them
    for (int i = 0; i < 11; i++) {
      try { b2b.get(BigInteger.valueOf(i)); } catch (Exception e) { }
    } // for
  } // experimentBigIntToBigInt
  /**
   * My own experiment/implementation of an AssociativeArray with BigIntegers as 
   * keys and Strings as values (Based on my graph theory class)
   * @param pen
   * @throws Exception
   */
  public static void experimentBigIntToStrings(PrintWriter pen) throws Exception {
    AssociativeArray<BigInteger,String> b2s = 
      new ReportingAssociativeArray<BigInteger,String>("b2s", pen);
    b2s.size();
    b2s.set(BigInteger.valueOf(1), "Vertex A");
    b2s.set(BigInteger.valueOf(2), "Vertex B");
    b2s.size();
    b2s.hasKey(BigInteger.valueOf(1));
    b2s.hasKey(BigInteger.valueOf(2));
    try { b2s.get(BigInteger.valueOf(1)); } catch (Exception e) { }
    try { b2s.get(BigInteger.valueOf(2)); } catch (Exception e) { }
    b2s.remove(BigInteger.valueOf(1));
    b2s.size();
    try { b2s.get(BigInteger.valueOf(1)); } catch (Exception e) { }
    try { b2s.get(BigInteger.valueOf(2)); } catch (Exception e) { }
    b2s.remove(BigInteger.valueOf(4));
    b2s.size();
    try { b2s.get(BigInteger.valueOf(1)); } catch (Exception e) { }
    try { b2s.get(BigInteger.valueOf(2)); } catch (Exception e) { }
  } // experimentBigIntToStrings

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Print a divider.
   */
  public static void divider(PrintWriter pen) {
    pen.println();
    pen.println("------------------------------------------------");
    pen.println();
  } // divider(PrintWriter)

} // AssociativeArrayExperiments
