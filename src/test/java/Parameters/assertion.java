package Parameters;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class assertion {
@Test
public void assert1() {
	int a=1;
	int b=10;
	SoftAssert as=new SoftAssert();
	as.assertEquals(a,b);
	System.out.println(a+b);
	System.out.println(a);
	Assert.assertEquals(a,b);
}
}
