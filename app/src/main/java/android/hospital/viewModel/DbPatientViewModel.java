package android.hospital.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.hospital.db.entity.DbPatient;
import android.hospital.db.repository.DbPatientRepository;
import android.hospital.entities.patient.PatientModel;

import java.util.List;

/**
 * Created by logan on 01/03/2018.
 */

public class DbPatientViewModel extends ViewModel {

    private DbPatientRepository dbPatientRepository;

    public DbPatientViewModel(DbPatientRepository dbPatientRepository) {
        this.dbPatientRepository = dbPatientRepository;
    }

    public LiveData<DbPatient> getPatientByCode(String code) {
        return dbPatientRepository.getPatientById(code);
    }

    public LiveData<List<DbPatient>> getAllPatient() {
        return dbPatientRepository.getAllPatient();
    }

    public void insertPatient(PatientModel patientModel) {
        DbPatient dbPatient = new DbPatient();
        dbPatient.code = patientModel.getCode();
        dbPatient.info = patientModel.toJson();
        dbPatientRepository.insertPatient(dbPatient);
    }

    public void deletePatient(PatientModel patientModel) {
        dbPatientRepository.deletePatient(patientModel.getCode());
    }

}
