package android.hospital.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.hospital.db.entity.DbPatientDailyReport;
import android.hospital.db.repository.DbPatientDailyReportRepository;
import android.hospital.entities.report.PatientDailyReportDetailModel;

import java.util.List;

/**
 * Created by logan on 01/03/2018.
 */

public class DbPatientDailyReportViewModel extends ViewModel {

    private DbPatientDailyReportRepository dbPatientDailyReportRepository;

    public DbPatientDailyReportViewModel(DbPatientDailyReportRepository dbPatientDailyReportRepository) {
        this.dbPatientDailyReportRepository = dbPatientDailyReportRepository;
    }

    public LiveData<List<DbPatientDailyReport>> getDailyReportByPatientId(Integer patient_id) {
        return dbPatientDailyReportRepository.getDailyReportByPatientId(patient_id);
    }

    public LiveData<DbPatientDailyReport> getDailyReportByPatientIdCreatedAt(String patient_id_created_at) {
        return dbPatientDailyReportRepository.getDailyReportByPatientIdCreatedAt(patient_id_created_at);
    }

    public void insertPatientDailyReport(PatientDailyReportDetailModel patientDailyReportDetailModel) {
        DbPatientDailyReport dbPatientDailyReport = new DbPatientDailyReport();
        dbPatientDailyReport.patient_id = patientDailyReportDetailModel.getPatientId();
        dbPatientDailyReport.patient_id_created_at = patientDailyReportDetailModel.getPatientIdCreatedAt();
        dbPatientDailyReport.info = patientDailyReportDetailModel.toJson();
        dbPatientDailyReportRepository.insertPatientDailyReport(dbPatientDailyReport);
    }

}
