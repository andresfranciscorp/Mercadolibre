package com.franciscorp.meli.pruebameli.common.bases;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

//    protected ManagerSharedPreferences managerSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        managerSharedPreferences = new ManagerSharedPreferences(getContext());
    }

    /**
     * Navigates to other fragment
     *
     * @param f the other fragment to navigate
     */
    public void navigateToFragment(Fragment f) {

        Activity baseNavigableAct = getActivity();

        if (baseNavigableAct instanceof BaseActivity) {
//            closeKeyboard();// no need to leave the keyboard open if it was open when navigating
            ((BaseActivity) baseNavigableAct).navigateToFragment(f);
        }
    }
    /**
     * remove all fragments
     */
    public void removeAllFragment() {

        Activity baseNavigableAct = getActivity();

        if (baseNavigableAct instanceof BaseActivity) {
//            closeKeyboard();// no need to leave the keyboard open if it was open when navigating
            ((BaseActivity) baseNavigableAct).removeAllFragments();
        }
    }

    /**
     * Gets Base activity of fragment
     *
     * @return base activity or null
     */
    public BaseActivity getBaseActivity() {

        Activity activity = getActivity();
        if (activity instanceof BaseActivity) {
            return (BaseActivity) activity;
        }
        return null;
    }

    /**
     * Navigates back to previous fragment in the stack, if it exists
     */
    protected void onBackPressed() {
        Activity act = getActivity();
        if (act != null) {
            act.onBackPressed();
        }
    }

    public void hideKeyboard() {
        Activity activity = getBaseActivity();
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
