package checkinforgood.com.test;

import java.util.ArrayList;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ListView;
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
		testTopNavigation();

	}

	public void testTopNavigation() {

		solo.waitForDialogToClose(5000);
		ArrayList<ListView> oldList = solo.getCurrentListViews();
		solo.clickOnText("Causes");
		assertNotSame("Clicked Causes Tab", solo.getCurrentListViews(), oldList);
		oldList = solo.getCurrentListViews();
		solo.clickOnText("Settings");
		assertNotSame("Clicked Settings Tab", solo.getCurrentListViews(),
				oldList);
		oldList = solo.getCurrentListViews();
		solo.clickOnText("Businesses");
		assertNotSame("Clicked Businesses Tab", solo.getCurrentListViews(),
				oldList);

	}

	public void testBusinessesButtons() {
		solo.clickOnText("Businesses");
		ArrayList<ListView> oldList = solo.getCurrentListViews();
		solo.clickOnButton("Supporting My Causes");
		assertNotSame("Clicked Supporting My Causes Button",
				solo.getCurrentListViews(), oldList);
		oldList = solo.getCurrentListViews();
		assertTrue(solo.getCurrentListViews() != null);
		solo.clickOnButton("All");
		assertNotSame("Clicked All button", solo.getCurrentListViews(), oldList);
		assertTrue(solo.getCurrentListViews() != null);
		solo.clickOnImage(0);

	}

	public void testCausesListItems() {
		solo.clickOnText("Causes");
		ArrayList<ListView> oldList = solo.getCurrentListViews();
		solo.clickOnText("Causes I'm supporting", 0);
		// assertNotSame("Clicked Causes I'm supporting item",
		// solo.getCurrentListViews(), oldList);
		oldList = solo.getCurrentListViews();
		assertTrue(solo.getCurrentListViews() != null);
		solo.clickOnText("Causes");
		solo.clickOnText("All Causes");
		assertNotSame("Clicked All Causes item", solo.getCurrentListViews(),
				oldList);
		assertTrue(solo.getCurrentListViews() != null);
		solo.clickOnText("Causes");
		solo.clickOnText("Learn how Check-in for Good works");
	}

}
