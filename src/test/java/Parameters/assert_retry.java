package Parameters;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class assert_retry implements IRetryAnalyzer {
	int retry=5;
	int max=9;
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
				if(retry<max) {
					retry++;
					System.out.println(retry);
					result.setStatus(ITestResult.FAILURE);
					return true;
					
				}
				else{
					result.setStatus(ITestResult.FAILURE);
				}
		}
		else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}
	
}
