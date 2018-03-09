package android.hospital.interfaces.patientmanagement;

import android.hospital.entities.patient.PatientModel;

/**
 * Created by logan on 08/03/2018.
 */

public interface PatientManagementRecyclerViewInterface {
    void onPatientUpdate(PatientModel patientModel);

    void onPatientReportSelected(PatientModel patientModel);

    void onPatientDelete(PatientModel patientModel);
}
