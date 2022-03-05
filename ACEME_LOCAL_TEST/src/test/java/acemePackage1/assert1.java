package acemePackage1;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assert1 {
  @Test
  public void assertdemo1() {
	  
	  Assert.assertEquals(13,13,"actual and expected does not match, please investigate ");
	  Assert.assertEquals(13,14,"actual and expected does not match, please investigate ");
	  Assert.assertEquals(11,12,"actual and expected does not match, please investigate ");

  }
			  
  @Test 
  public void assertdemo2() {
	  
	  SoftAssert sa=new SoftAssert();
	  sa.assertEquals(100,100,"actual and expected does not match, please investigate ");
	  sa.assertEquals(100,200,"actual and expected does not match, please investigate ");
	  sa.assertEquals(100,101,"actual and expected does not match, please investigate ");
	  sa.assertAll();
  }
			  
			  
}
