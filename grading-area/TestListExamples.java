import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }  
  
  
  @Test(timeout = 500)
  public void testMergeRightEnd1() {
    List<String> left = Arrays.asList("a", "b");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "d");
    assertEquals(expected, merged);
  }
  
  @Test(timeout = 500)
  public void testMergeRightEnd2() {
    List<String> left = Arrays.asList();
    List<String> right = Arrays.asList();
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList();
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilterRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.filter(left, new IsMoon());
    List<String> expected = Arrays.asList("a", "b", "c");
    assertEquals(expected, merged);
  }  

  //  @Test(timeout = 500)
  // public void testFilterRightEnd1() {
  //   List<String> left = Arrays.asList("a", "b", "c", 1);
  //   StringChecker right;
  //   List<String> merged = ListExamples.filter(left, right);
  //   List<String> expected = Arrays.asList("a", "b", "c");
  //   assertEquals(expected, merged);
  // }  
}
