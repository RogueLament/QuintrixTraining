import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {
	@Override
	public void onFinish(ITestContext Result) 					
	{

	}

	@Override
	public void onStart(ITestContext Result)					
	{

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{

	}

	@Override
	public void onTestFailure(ITestResult Result) 					
	{
		System.out.println("Test case: " + Result.getName() + " failed");					
	}

	@Override
	public void onTestSkipped(ITestResult Result)					
	{
		System.out.println("Skipped test case: " + Result.getName());					
	}

	@Override
	public void onTestStart(ITestResult Result)					
	{
		System.out.println("Test case: " + Result.getName() + " started");					
	}

	@Override
	public void onTestSuccess(ITestResult Result)					
	{
		System.out.println("Test case: " + Result.getName() + " passed");					
	}
}
