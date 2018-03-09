package android.hospital.ux.fragments.patientreport;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.hospital.MyApplication;
import android.hospital.R;
import android.hospital.db.entity.DbPatientDailyReport;
import android.hospital.entities.report.PatientDailyReportDetailModel;
import android.hospital.interfaces.patientdailyreports.PatientDailyReportsRecyclerViewInterface;
import android.hospital.listeners.OnSingleClickListener;
import android.hospital.utils.MyUtils;
import android.hospital.utils.RecyclerNullDecorator;
import android.hospital.ux.MainActivity;
import android.hospital.ux.adapters.patientreport.PatientReportRecyclerViewAdapter;
import android.hospital.viewModel.DbPatientDailyReportViewModel;
import android.hospital.viewModel.DbViewModelFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by logan on 09/03/2018.
 */

public class PatientDailyReportFragment extends Fragment implements PatientDailyReportsRecyclerViewInterface {
    //data
    @Inject
    public DbViewModelFactory dbViewModelFactory;
    protected View view;
    protected DbPatientDailyReportViewModel dbPatientViewModel;
    protected Integer current_patient_id;

    protected ArrayList<PatientDailyReportDetailModel> currentPatients = new ArrayList<>();

    //recycler
    protected RecyclerView recycler_view;
    protected PatientReportRecyclerViewAdapter patientReportRecyclerViewAdapter;

    //add new patient
    protected RelativeLayout layout_add_new_patient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_patient_report, container, false);
            initView();
            initData();
            observeData();
        }
        return view;
    }

    protected void initView() {
        recycler_view = view.findViewById(R.id.recycler_view);
        patientReportRecyclerViewAdapter = new PatientReportRecyclerViewAdapter(getContext(), this);
        recycler_view.addItemDecoration(new RecyclerNullDecorator(getActivity(), RecyclerNullDecorator.ORIENTATION.VERTICAL));
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_view.setAdapter(patientReportRecyclerViewAdapter);

    }

    protected void initData() {
        layout_add_new_patient.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                ((MainActivity) getActivity()).onAddNewPatient();
            }
        });
    }

    protected void observeData() {
        ((MyApplication) getActivity().getApplication()).getApplicationComponent().inject(this);
        dbPatientViewModel = ViewModelProviders.of(this, dbViewModelFactory).get(DbPatientDailyReportViewModel.class);
        dbPatientViewModel.getDailyReportByPatientId(current_patient_id).observe(this, new PatientDailyReportFragment.PatientDailyReportObserver());
    }

    @Override
    public void onNotifyNurse(PatientDailyReportDetailModel patientDailyReportDetailModel) {

    }

    @Override
    public void onUpdateReport(PatientDailyReportDetailModel patientDailyReportDetailModel) {

    }

    public void setCurrent_patient_id(Integer current_patient_id) {
        this.current_patient_id = current_patient_id;
    }

    protected class PatientDailyReportObserver implements Observer<List<DbPatientDailyReport>> {
        @Override
        public void onChanged(@Nullable List<DbPatientDailyReport> dbPatientDailyReports) {
            currentPatients.clear();
            if (dbPatientDailyReports != null) {
                for (DbPatientDailyReport dbPatientDailyReport : dbPatientDailyReports) {
                    String info = dbPatientDailyReport.info;
                    PatientDailyReportDetailModel patientDailyReportDetailModel = MyUtils.getGsonParser().fromJson(info, PatientDailyReportDetailModel.class);
                    if (patientDailyReportDetailModel != null && patientDailyReportDetailModel.getPatientId() != null) {
                        currentPatients.add(patientDailyReportDetailModel);
                    }
                }
                patientReportRecyclerViewAdapter.setPatientDailyReports(currentPatients);
            }
        }
    }
}
