package checkinforgood.com.test;

import java.util.ArrayList;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter.ViewBinder;
import checkinforgood.com.CheckinNativeActivity;

import com.jayway.android.robotium.solo.Solo;

public class TestAddRemoveCauses extends ActivityInstrumentationTestCase2 {

	private Solo solo;
	ViewBinder holder;

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

	// ///////////// In progress

	/*
	 * //////////////////////////// To test add causes 
	 * public void testAddCauses() {
	 * 
	 * solo.clickOnText("Causes"); solo.clickOnText("All Causes");
	 * solo.waitForDialogToClose(5000);
	 * 
	 * ArrayList<ListView> list = solo.getCurrentListViews(); ListView lst =
	 * list.get(0); int cnt = lst.getChildCount(); assertTrue(list.size() != 0);
	 * Log.v("Test add causes", "list size =" + list.size()); for (int i = 0; i
	 * < cnt; i++) { RelativeLayout view = (RelativeLayout) lst.getChildAt(i);
	 * Log.v("Test add causes", "view =" + view); ImageView imgV = (ImageView)
	 * view.getChildAt(1); String checkBoxBtn = imgV.getResources()
	 * .getResourceEntryName(imgV.getId()).toString();
	 * 
	 * Log.v("Test add causes", "image =" + solo.getImage(i)); if
	 * (imgV.getBackground().toString() == "btn_check_off") {
	 * solo.clickInList(i); solo.clickOnButton("Confirm"); break; }
	 * 
	 * } }
	 * 
	 *  ////////////////To test Remove causes
	 * 
	 * public void testRemoveCauses() {
	 * 
	 * solo.clickOnText("Causes"); solo.clickOnText("All Causes");
	 * solo.waitForDialogToClose(5000);
	 * 
	 * ArrayList<ListView> list = solo.getCurrentListViews(); ListView lst =
	 * list.get(0); int cnt = lst.getChildCount(); Log.v("Test add causes",
	 * "list item count =" + cnt); assertTrue(list.size() != 0);
	 * ArrayList<ImageView> imgView = solo.getCurrentImageViews();
	 * assertTrue(list.size() != 0); imgView.size();
	 * 
	 * Log.v("Test add causes", "list size =" + list.size());
	 * Log.v("Test add causes", "check box =" + imgView.size()); for (int i = 0;
	 * i < cnt; i++) { ImageView iv = imgView.get(i); // ListItem item =
	 * (ListItem) lst.isItemChecked(0); if (iv.isPressed()) {
	 * solo.clickInList(i); solo.clickOnButton("Confirm"); break; } } }
	 */
}
