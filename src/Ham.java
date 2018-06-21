import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class Ham {
     private int i =0;
     private ArrayList testList;

     @Before
    public void executedBeforeEach() {
      testList = new ArrayList();
      testList .add(1);
     System.out.println("@Before: executedBeforeEach");
     }
     
           
     
      @Test
      public void EmptyCollection() {
    	  testList = new ArrayList();
        
       assertTrue(testList.isEmpty());
       System.out.println("@Test: EmptyArrayList");
       }

}
