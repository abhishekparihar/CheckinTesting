package checkinforgood.com.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import checkinforgood.com.CheckinNativeActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestCheckin extends ActivityInstrumentationTestCase2 {

	// LoginTest loginTest;
	private Solo solo;
	private Boolean cndtn;
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

	public void testPublicCheckin() {
		solo.clickOnButton("All");
		assertNotNull(solo.getCurrentListViews());
		if(solo.getCurrentListViews().get(0).getChildAt(0)!=null){
			solo.clickOnView(solo.getCurrentListViews().get(0).getChildAt(0));
			assertNotNull(solo.getCurrentListViews());
			solo.clickInList(0);
			solo.clickOnText("NO");
			solo.clickOnButton("CHECK-IN FOR GOOD!");

			boolean txt = solo.searchText("thank you.");
			if (txt) {
				solo.waitForDialogToClose(5000);
				assertTrue(solo.searchText("thank you."));
				solo.waitForDialogToClose(5000);
			} else {
				assertFalse(solo.searchText("thank you."));
				solo.clickOnText("OK");
			}

		}
	}

	public void testPrivateCheckin() {
		solo.clickOnButton("Supporting My Causes");
		assertTrue(solo.getCurrentListViews() != null);
		solo.clickOnText("Morgan's Pet Palace");
		assertTrue(solo.getCurrentListViews() != null);
		solo.clickInList(0);
		solo.clickOnText("YES");
		solo.clickOnButton("CHECK-IN FOR GOOD!");
		cndtn = solo.searchText("SETTINGS");
		boolean txt = solo.searchText("thank you.");
		if (txt) {
			solo.waitForDialogToClose(5000);
			assertTrue(solo.searchText("thank you."));
			solo.waitForDialogToClose(5000);

		} else if (cndtn) {
			assertTrue(solo.searchText("SETTINGS"));
			solo.clickOnText("SETTINGS");

		} else {
			assertFalse(solo.searchText("SETTINGS"));

		}

	}

}