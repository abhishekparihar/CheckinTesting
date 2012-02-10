package checkinforgood.com.test;

import java.util.ArrayList;

import android.app.LauncherActivity.ListItem;
import android.test.ActivityInstrumentationTestCase2;
import android.test.IsolatedContext;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import checkinforgood.com.CheckinNativeActivity;
import checkinforgood.com.R;

import com.jayway.android.robotium.solo.Solo;

public class TestAddRemoveCauses extends ActivityInstrumentationTestCase2 {

	private Solo solo;

	public TestAddRemoveCauses() {
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

	public void testAddCauses() {

		solo.clickOnText("Causes");
		solo.clickOnText("All Causes");
		solo.waitForDialogToClose(5000);

		ArrayList<ListView> list = solo.getCurrentListViews();
		ListView lst = list.get(0);

		int cnt = lst.getChildCount();
		

		Log.v("Test add causes", "list item count =" + cnt);
		assertTrue(list.size() != 0);
		ArrayList<ImageView> imgView = solo.getCurrentImageViews();
		assertTrue(list.size() != 0);
		imgView.size();

		Log.v("Test add causes", "list size =" + list.size());
		Log.v("Test add causes", "check box =" + imgView.size());
		for (int i = 0; i < cnt; i++) {
			/*View view = lst.getChildAt(i);
			
			
			 ImageView iv = solo.getImage(i); iv.getTag();
			 Log.v("Test add causes", "image view =" + iv); 
			 			 
			 if (!iv.isPressed()) { solo.clickInList(i);
			 solo.clickOnButton("Confirm"); break; }
			*/
		}
	}

	public void testRemoveCauses() {

		solo.clickOnText("Causes");
		solo.clickOnText("All Causes");
		solo.waitForDialogToClose(5000);

		ArrayList<ListView> list = solo.getCurrentListViews();
		ListView lst = list.get(0);
		int cnt = lst.getChildCount();
		Log.v("Test add causes", "list item count =" + cnt);
		assertTrue(list.size() != 0);
		ArrayList<ImageView> imgView = solo.getCurrentImageViews();
		assertTrue(list.size() != 0);
		imgView.size();

		Log.v("Test add causes", "list size =" + list.size());
		Log.v("Test add causes", "check box =" + imgView.size());
		for (int i = 0; i < cnt; i++) {
			ImageView iv = imgView.get(i);
			// ListItem item = (ListItem) lst.isItemChecked(0);
			if (iv.isPressed()) {
				solo.clickInList(i);
				solo.clickOnButton("Confirm");
				break;
			}
		}
	}

}
