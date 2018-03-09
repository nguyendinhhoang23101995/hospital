package android.hospital.ux.fragments.patientmanagement;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.hospital.MyApplication;
import android.hospital.R;
import android.hospital.db.entity.DbPatient;
import android.hospital.entities.patient.PatientModel;
import android.hospital.interfaces.patientmanagement.PatientManagementRecyclerViewInterface;
import android.hospital.listeners.OnSingleClickListener;
import android.hospital.utils.MyUtils;
import android.hospital.utils.RecyclerNullDecorator;
import android.hospital.ux.MainActivity;
import android.hospital.ux.adapters.patientmanagement.PatientRecyclerViewAdapter;
import android.hospital.viewModel.DbPatientViewModel;
import android.hospital.viewModel.DbViewModelFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
 * Created by logan on 07/03/2018.
 */

public class PatientManagementFragment extends Fragment implements PatientManagementRecyclerViewInterface {
    //data
    @Inject
    public DbViewModelFactory dbViewModelFactory;
    protected View view;
    protected DbPatientViewModel dbPatientViewModel;

    protected ArrayList<PatientModel> currentPatients = new ArrayList<>();

    //recycler
    protected RecyclerView recycler_view;
    protected PatientRecyclerViewAdapter patientRecyclerViewAdapter;

    //add new patient
    protected RelativeLayout layout_add_new_patient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_patient_management, container, false);
            initView();
            initData();
            observeData();
        }
        return view;
    }

    protected void initView() {
        recycler_view = view.findViewById(R.id.recycler_view);
        patientRecyclerViewAdapter = new PatientRecyclerViewAdapter(getContext(), this);
        recycler_view.addItemDecoration(new RecyclerNullDecorator(getActivity(), RecyclerNullDecorator.ORIENTATION.VERTICAL));
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_view.setAdapter(patientRecyclerViewAdapter);


        layout_add_new_patient = view.findViewById(R.id.layout_add_new_patient);
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
        dbPatientViewModel = ViewModelProviders.of(this, dbViewModelFactory).get(DbPatientViewModel.class);
        dbPatientViewModel.getAllPatient().observe(this, new PatientObserver());
    }

    @Override
    public void onPatientUpdate(PatientModel patientModel) {
        ((MainActivity) getActivity()).onPatientUpdate(patientModel);
    }

    @Override
    public void onPatientReportSelected(PatientModel patientModel) {
        ((MainActivity) getActivity()).onPatientReportSelected(patientModel);
    }

    @Override
    public void onPatientDelete(final PatientModel patientModel) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        dbPatientViewModel.deletePatient(patientModel);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }

    protected class PatientObserver implements Observer<List<DbPatient>> {
        @Override
        public void onChanged(@Nullable List<DbPatient> dbPatients) {
            currentPatients.clear();
            if (dbPatients != null) {
                for (DbPatient dbPatient : dbPatients) {
                    String patientInfo = dbPatient.info;
                    PatientModel patientModel = MyUtils.getGsonParser().fromJson(patientInfo, PatientModel.class);
                    if (patientModel != null && patientModel.getCode() != null) {
                        currentPatients.add(patientModel);
                    }
                }
                patientRecyclerViewAdapter.setPatients(currentPatients);
            }
        }
    }
}

