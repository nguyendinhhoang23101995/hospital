package android.hospital.ux;

import android.content.Context;
import android.hospital.R;
import android.hospital.entities.patient.PatientModel;
import android.hospital.listeners.OnSingleClickListener;
import android.hospital.utils.MyUtils;
import android.hospital.ux.fragments.home.DashboardFragment;
import android.hospital.ux.fragments.patientinfo.PatientInfoFragment;
import android.hospital.ux.fragments.patientmanagement.PatientManagementFragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //toolbar

    protected DrawerLayout mDrawerLayout;
    protected ActionBarDrawerToggle mDrawerToggle;
    protected RelativeLayout layout_menu;
    protected boolean navigationEnabled = false;

    //nav bar
    protected NavigationView nav_view;
    protected TextView nav_patient_management;
    protected RelativeLayout nav_layout_notification;
    //handler
    protected Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    protected void initView() {
        mDrawerLayout = findViewById(R.id.main_drawer_layout);
        layout_menu = findViewById(R.id.layout_menu);

        nav_view = findViewById(R.id.nav_view);
        nav_patient_management = nav_view.getHeaderView(0).findViewById(R.id.nav_patient_management);
        nav_layout_notification = nav_view.getHeaderView(0).findViewById(R.id.nav_layout_notification);
    }

    protected void initData() {
        MyUtils.changeLang(getApplicationContext(), "en_US");
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.content_description_open_navigation_drawer,
                R.string.content_description_close_navigation_drawer
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        layout_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyBoard();
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });
        DashboardFragment dashboardFragment = new DashboardFragment();
        FragmentManager frgManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = frgManager.beginTransaction();
        fragmentTransaction.add(R.id.main_content_frame, dashboardFragment).commit();
        frgManager.executePendingTransactions();


        handler = new Handler();
        nav_patient_management.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                mDrawerLayout.closeDrawer(Gravity.START);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onPatientManagementSelected();
                    }
                }, 300);
                onPatientManagementSelected();
            }
        });
        nav_layout_notification.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                mDrawerLayout.closeDrawer(Gravity.START);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onPatientManagementSelected();
                    }
                }, 300);
                onPatientManagementSelected();
            }
        });
    }

    public void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getRootView().getWindowToken(), 0);
    }

    protected void onPatientManagementSelected() {
        PatientManagementFragment patientManagementFragment = new PatientManagementFragment();
        replaceFragment(patientManagementFragment, PatientManagementFragment.class.getSimpleName());
    }

    public void replaceFragment(Fragment newFragment, String transactionTag) {
        hideKeyBoard();
        FragmentManager frgManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = frgManager.beginTransaction();
        fragmentTransaction.setAllowOptimization(false);
        fragmentTransaction.addToBackStack(transactionTag);
        fragmentTransaction.replace(R.id.main_content_frame, newFragment).commit();
        frgManager.executePendingTransactions();
    }

    public void onPatientUpdate(PatientModel patientModel) {
        PatientInfoFragment patientInfoFragment = new PatientInfoFragment();
        patientInfoFragment.setCurrentPatientModel(patientModel);
        replaceFragment(patientInfoFragment, PatientInfoFragment.class.getSimpleName());
    }

    public void onPatientReportSelected(PatientModel patientModel) {

    }

    public void onAddNewPatient() {
        PatientInfoFragment patientInfoFragment = new PatientInfoFragment();
        replaceFragment(patientInfoFragment, PatientInfoFragment.class.getSimpleName());
    }
}
