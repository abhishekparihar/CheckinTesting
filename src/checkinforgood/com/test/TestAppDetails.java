package checkinforgood.com.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import checkinforgood.com.AppStatus;
import checkinforgood.com.CheckinNativeActivity;

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
		assertTrue(appStatus.isRegistered());
		testBusinessesButtons();
		testCausesListItems();
		checkin.testPublicCheckin();
		testTabs();

	}

	public void testTabs() {
		solo.clickOnText("Settings");
		solo.clickOnText("Businesses");
		solo.clickOnText("Causes");

	}

	public void testBusinessesButtons() {
		solo.clickOnButton("All");
		assert (solo.getCurrentListViews()) != null;
		solo.clickOnButton("Supporting My Causes");
		assert (solo.getCurrentListViews()) != null;
		solo.clickOnImage(0);

	}

	public void testCausesListItems() {
		solo.clickOnText("Causes");
		solo.clickOnText("Causes I'm supporting", 0);
		solo.clickOnText("Causes");
		solo.clickOnText("All Causes");
		assertTrue(solo.getCurrentListViews() != null);
		solo.clickOnText("Causes");
		solo.clickOnText("Learn how Check-in for Good works");
	}

}
