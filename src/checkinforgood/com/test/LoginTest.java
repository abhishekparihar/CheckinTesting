package checkinforgood.com.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import checkinforgood.com.AppStatus;
import checkinforgood.com.R;
import checkinforgood.com.account.LoginActivity;

import com.jayway.android.robotium.solo.Solo;

public class LoginTest extends ActivityInstrumentationTestCase2<LoginActivity> {

	private Solo solo;
	Activity mActivity;

	public LoginTest() {
		super("checkinforgood.com.accounts", LoginActivity.class);
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

	public void testLogin() {

		AppStatus appStatus = AppStatus.getInstance(getActivity());
		if (!appStatus.isOnline()) {
			EditText email = (EditText) getActivity().findViewById(
					R.id.EditLoginEmail);

			email.setText("thurisazmt@gmail.com");
			EditText password = (EditText) getActivity().findViewById(
					R.id.EditLoginPassword);
			password.setText("11111111");
			if (((LoginActivity) solo.getCurrentActivity()) != null) {
				solo.clickOnButton("Sign-in");
				solo.assertCurrentActivity(
						"User entered login details and clicked login!",
						AppStatus.class);
				assertEquals("CheckinNativeActivity", solo.getCurrentActivity()
						.getClass().getSimpleName());
			} else {
				solo.assertCurrentActivity("User enterd wrong Id password!",
						LoginActivity.class);
				assertEquals("Login", solo.getCurrentActivity().getClass()
						.getSimpleName());
			}

		}

	}
}
