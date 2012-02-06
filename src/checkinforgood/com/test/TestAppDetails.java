package checkinforgood.com.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import checkinforgood.com.AppStatus;
import checkinforgood.com.CheckinNativeActivity;
import checkinforgood.com.R;

import com.jayway.android.robotium.solo.Solo;

public class TestAppDetails extends ActivityInstrumentationTestCase2 {

	TestCheckin checkin;
	LoginTest loginTest;
	private Solo solo;
	Activity mActivity;

	public TestAppDetails() {
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

	public void appTestSequence() {
		AppStatus appStatus = AppStatus.getInstance(getActivity());
		if (!appStatus.isOnline()) {
			loginTest.testLogin();
		}
		testBusinessesButtons();
		testCausesListItems();
		checkin.testPublicCheckin();
		//testTabs();
		

	}

	/*public void testTabs() {
		solo.clickOnText("Settings");
		solo.clickOnText("Businesses");
		solo.clickOnText("Causes");

	}*/

	public void testBusinessesButtons() {
		solo.clickOnButton("All");
		solo.clickOnButton("Supporting My Causes");
		solo.clickOnImage(0);
		

	}

	public void testCausesListItems() {
		solo.clickOnText("Causes");
		solo.clickOnText("Causes I'm supporting", 0);
		// solo.waitForDialogToClose(5000);
		solo.clickOnText("Causes");
		// solo.waitForDialogToClose(5000);
		solo.clickOnText("All Causes");
		solo.clickOnText("Causes");
		// solo.waitForDialogToClose(5000);
		solo.clickOnText("Learn how Check-in for Good works");

	}

	
	
}
