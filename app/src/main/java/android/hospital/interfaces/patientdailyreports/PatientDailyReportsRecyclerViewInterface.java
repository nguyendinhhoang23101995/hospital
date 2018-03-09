package android.hospital.interfaces.patientdailyreports;

import android.hospital.entities.report.PatientDailyReportDetailModel;

/**
 * Created by logan on 09/03/2018.
 */

public interface PatientDailyReportsRecyclerViewInterface {
    void onNotifyNurse(PatientDailyReportDetailModel patientDailyReportDetailModel);

    void onUpdateReport(PatientDailyReportDetailModel patientDailyReportDetailModel);
}
