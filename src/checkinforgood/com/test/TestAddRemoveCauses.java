package checkinforgood.com.test;

import java.util.ArrayList;

import android.app.LauncherActivity.ListItem;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ListView;
import checkinforgood.com.CheckinNativeActivity;

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
	
	public void testAddCauses(){
		//ArrayList<E>
		solo.clickOnText("Causes");
		solo.clickOnText("All Causes");
		ArrayList<ListView> list = solo.getCurrentListViews();
		list.size();
		
		assertTrue(list.size()!=0);
		ArrayList<CheckBox> checkbox = solo.getCurrentCheckBoxes();
		assertTrue(list.size()!=0);
		checkbox.size();
		
		Log.v ("Test add causes", "list size ="+list.size());
		Log.v ("Test add causes", "check box ="+checkbox.size());
		for(int i =0;i<checkbox.size(); i++)
		{
			if(solo.isCheckBoxChecked(i))
			{
				solo.clickOnCheckBox(i);
				solo.clickOnButton("Confirm");
				break;
			}
		}
	}


}












