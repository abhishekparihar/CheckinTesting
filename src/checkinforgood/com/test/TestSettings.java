package checkinforgood.com.test;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.ListView;
import android.widget.ToggleButton;
import checkinforgood.com.CheckinNativeActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestSettings extends ActivityInstrumentationTestCase2 {
	private Solo solo;

	public TestSettings() {
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

	public void testSettingstTabItems() {
		solo.clickOnText("Settings");
		assertNotNull(solo.getCurrentListViews());
		ArrayList<ListView> list = solo.getCurrentListViews();
		ListView lst = list.get(0);
		int cnt = lst.getChildCount();
		for (int i = 0; i < cnt; i++) {

			solo.clickInList(i);
			solo.clickOnText("Settings");
			assertNotSame("Clicked on Settings tab",
					solo.getCurrentListViews(), list);
		}

	}

	public void testSharingSettings() {

		solo.clickLongOnText("Settings");
		solo.clickOnText("Sharing Settings");
		assertNotNull(solo.getCurrentImageViews());
		ArrayList<ToggleButton> tb = solo.getCurrentToggleButtons();
		int size = tb.size();
		for (int i = 0; i < size; i++) {
			ToggleButton btn = tb.get(0);
			String str = btn.getText().toString();
			Log.v("share settings", "t_btn name =" + str);
			Log.v("share settings", "t_btn cnt =" + size);
			solo.clickOnToggleButton(str);
			assertNotSame("Clicked toggle button", btn.getText().toString(),
					str);
		}

	}
	
	/*public void testHowItWorks(){
		
		solo.clickLongOnText("Settings");
		solo.clickLongOnText("How Check-in for Good Works");
		ArrayList<ImageView>img = solo.getCurrentImageViews();
		ImageView a =  img.get(0);
		int cnt = img.size();
		Log.v("How Check-in for Good Works", "image view cnt =" + cnt);
		Log.v("How Check-in for Good Works", "image view cnt =" + a.getTag(0));
		for(int i=0;i<cnt;i++){
			img.get(index)
			solo.clickOnImage(i);
		}
	}*/
}




