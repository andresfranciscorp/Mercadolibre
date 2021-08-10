package com.franciscorp.meli.pruebameli.common.bases;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.franciscorp.meli.pruebameli.R;
import com.franciscorp.meli.pruebameli.common.managers.ManagerProgressDialog;

public abstract class BaseActivity extends AppCompatActivity {

    protected boolean activityHasContent = true;
    protected ManagerProgressDialog mManagerProgressDialog;
    //protected ManagerSharedPreferences managerSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mManagerProgressDialog = new ManagerProgressDialog(this);
//        managerSharedPreferences = new ManagerSharedPreferences(this);
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    public boolean isActivityHasContent() {
        return activityHasContent;
    }

    public void setActivityHasContent(boolean activityHasContent) {
        this.activityHasContent = activityHasContent;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (getTopFragment() != null) {
            getTopFragment().onActivityResult(requestCode, resultCode, data);
        }
    }

    /**
     * Try to get fragment in the top of the stack
     *
     * @return BaseFragment if found or null
     */
    protected BaseFragment getTopFragment() {

        BaseFragment result = null;

        FragmentManager fm = getSupportFragmentManager();
        // If there are remaining fragment on the stack try to set the new title
        int backStackEntryCount = fm.getBackStackEntryCount();
        if (backStackEntryCount > 0) {

            FragmentManager.BackStackEntry backStackEntry = fm.getBackStackEntryAt(backStackEntryCount - 1);
            if (backStackEntry != null) {

                String name = backStackEntry.getName();
                Fragment fragmentByTag = fm.findFragmentByTag(name);
                result = (fragmentByTag instanceof BaseFragment) ? (BaseFragment) fragmentByTag : null;

            }
        }
        return result;
    }

    /**
     * Returns an int of the container to attach fragments
     *
     * @return the ID of a container for attach fragmetns
     */
    protected abstract int getIdRootFragmentContainer();

    /**
     * Navigates to a fragment adding to back stack with default animation
     *
     * @param bf base fragment to navigate
     */
    public void navigateToFragment(Fragment bf) {

        addFragmentToStack(bf, bf.getClass().getSimpleName(), true);

    }
    /**
     * remove all fragments
     */
    public void removeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }

    /**
     * remove all fragments
     */
    public void removeAllFragments() {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    /**
     * Navigates to a fragment adding to back stack with default animation
     *
     * @param bf base fragment to navigate
     */
    public void navigateToFragment(Fragment bf, boolean addToBackStack) {
        addFragmentToStack(bf, bf.getClass().getSimpleName(), addToBackStack);
    }

    /**
     * Fragment to stack addition
     *
     * @param f              the fragment
     * @param tag            the tag
     * @param addToBackStack true if must be added to back stack
     */
    protected void addFragmentToStack(Fragment f, String tag, boolean addToBackStack) {
        addFragmentToStackWithAnimations(f, tag, addToBackStack,
                R.anim.card_slide_right_in, R.anim.card_slide_left_out,
                R.anim.card_slide_left_in, R.anim.card_slide_right_out);
    }

    /**
     * Fragment to stack addition
     *
     * @param fragment       the fragment
     * @param tag            the tag
     * @param addToBackStack true if must be added to back stack
     * @param anim1          first animation
     * @param anim2          second animation
     * @param anim3          third animation
     * @param anim4          fourth animation
     */
    protected void addFragmentToStackWithAnimations(Fragment fragment, String tag, boolean addToBackStack, int anim1, int anim2, int anim3, int anim4) {

        if ((fragment != null) && (tag != null)) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction trans = fm.beginTransaction();

            if (addToBackStack) {
                trans.addToBackStack(tag);
            }
            trans.setCustomAnimations(anim1, anim2, anim3, anim4);

            trans.replace(getIdRootFragmentContainer(), fragment, tag);
            trans.commit();
            try {
                fm.executePendingTransactions();
            } catch (Exception e) {
                if (e != null && e.getLocalizedMessage() != null) {
                    Log.e(tag, e.getLocalizedMessage());
                }
            }
            invalidateOptionsMenu();
        }
    }


    @Override
    public void onBackPressed() {

        Application application = getApplication();
        if (application != null) {

            // The first back press key (only when not have backStack)
            // needs to be handle equals to close button, the rest can behive normally
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager != null) {
                if (fragmentManager.getBackStackEntryCount() == 1) {
                    if (activityHasContent) {
                        super.onBackPressed();
                    } else {
                        finish();
                    }
                } else {
                    super.onBackPressed();
                }
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            if (fragmentManager.getBackStackEntryCount() >= 1) {
                BaseFragment baseFragment = getTopFragment();
                baseFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }
    public void hideKeyboard() {
        Activity activity = this;
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