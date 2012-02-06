package checkinforgood.com.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import checkinforgood.com.CheckinNativeActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestCheckin extends ActivityInstrumentationTestCase2 {

	//LoginTest loginTest;
	private Solo solo;
	Activity mActivity;

	public TestCheckin() {
		super("checkinforgood.com", CheckinNativeActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	protected void tearDown() throws Exception {
		try {
			solo.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		getActivity().finish();
		super.tearDown();
	}
	
	
	public void testPublicCheckin(){
		solo.clickOnButton("Supporting My Causes");
		solo.clickOnText("Business1");
		solo.clickOnText("NO");
		solo.clickOnButton("CHECK-IN FOR GOOD!");
	}
	
	public void testPrivateCheckin(){
		
	}
	
	
}