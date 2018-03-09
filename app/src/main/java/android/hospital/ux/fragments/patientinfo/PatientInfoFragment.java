package android.hospital.ux.fragments.patientinfo;

import android.arch.lifecycle.ViewModelProviders;
import android.hospital.MyApplication;
import android.hospital.R;
import android.hospital.entities.patient.PatientModel;
import android.hospital.lib.edittext.MyCustomEditText;
import android.hospital.listeners.OnSingleClickListener;
import android.hospital.ux.MainActivity;
import android.hospital.viewModel.DbPatientViewModel;
import android.hospital.viewModel.DbViewModelFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

/**
 * Created by logan on 08/03/2018.
 */

public class PatientInfoFragment extends Fragment {

    //observer
    @Inject
    public DbViewModelFactory dbViewModelFactory;
    protected View view;
    //button
    protected TextView apply;
    //data
    protected PatientModel currentPatientModel = new PatientModel();
    //edittext
    protected MyCustomEditText patient_code, patient_name, patient_birth_day, patient_gender, patient_room, patient_main_diseases, patient_additional_diseases;
    protected DbPatientViewModel dbPatientViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_patient_info, container, false);
            initView();
            initData();
            observeData();
        }
        return view;
    }

    protected void initView() {
        apply = view.findViewById(R.id.apply);

        patient_code = view.findViewById(R.id.patient_code);
        patient_name = view.findViewById(R.id.patient_name);
        patient_birth_day = view.findViewById(R.id.patient_birth_day);
        patient_gender = view.findViewById(R.id.patient_gender);
        patient_room = view.findViewById(R.id.patient_room);
        patient_main_diseases = view.findViewById(R.id.patient_main_diseases);
        patient_additional_diseases = view.findViewById(R.id.patient_additional_diseases);

        apply.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                ((MainActivity) getActivity()).hideKeyBoard();
                if (patient_code.getText().toString().length() > 0) {
                    currentPatientModel.setCode(patient_code.getText().toString());
                }
                currentPatientModel.setName(patient_name.getText().toString());
                currentPatientModel.setBirthDay(patient_birth_day.getText().toString());
                currentPatientModel.setGender(patient_gender.getText().toString());
                currentPatientModel.setRoom(patient_room.getText().toString());
                currentPatientModel.setMainDisease(patient_main_diseases.getText().toString());
                currentPatientModel.setAdditionalDisease(patient_additional_diseases.getText().toString());
                dbPatientViewModel.insertPatient(currentPatientModel);
                getActivity().onBackPressed();
            }
        });
    }

    protected void initData() {
        if (currentPatientModel.getCode() != null) {
            patient_code.setText(currentPatientModel.getCode());
        }
        if (currentPatientModel.getName() != null) {
            patient_name.setText(currentPatientModel.getName());
        }
        if (currentPatientModel.getBirthDay() != null) {
            patient_birth_day.setText(currentPatientModel.getBirthDay());
        }
        if (currentPatientModel.getRoom() != null) {
            patient_room.setText(currentPatientModel.getRoom());
        }
        if (currentPatientModel.getGender() != null) {
            patient_gender.setText(currentPatientModel.getGender());
        }
        if (currentPatientModel.getMainDisease() != null) {
            patient_main_diseases.setText(currentPatientModel.getMainDisease());
        }
        if (currentPatientModel.getAdditionalDisease() != null) {
            patient_additional_diseases.setText(currentPatientModel.getAdditionalDisease());
        }
    }

    public void setCurrentPatientModel(PatientModel currentPatientModel) {
        this.currentPatientModel = currentPatientModel;
    }

    protected void observeData() {
        ((MyApplication) getActivity().getApplication()).getApplicationComponent().inject(this);
        dbPatientViewModel = ViewModelProviders.of(this, dbViewModelFactory).get(DbPatientViewModel.class);
    }
}
