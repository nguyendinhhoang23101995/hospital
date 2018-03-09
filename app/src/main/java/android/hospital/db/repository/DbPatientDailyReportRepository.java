package android.hospital.db.repository;

import android.arch.lifecycle.LiveData;
import android.hospital.db.dao.DbPatientDailyReportDao;
import android.hospital.db.entity.DbPatientDailyReport;

import java.util.List;

/**
 * Created by logan on 01/03/2018.
 */

public class DbPatientDailyReportRepository {

    private DbPatientDailyReportDao dao;

    public DbPatientDailyReportRepository(DbPatientDailyReportDao dao) {
        this.dao = dao;
    }

    public LiveData<List<DbPatientDailyReport>> getDailyReportByPatientId(Integer patient_id) {
        return dao.getDailyReportByPatientId(patient_id);
    }

    public LiveData<DbPatientDailyReport> getDailyReportByPatientIdCreatedAt(String patient_id_created_at) {
        return dao.getDailyReportByPatientIdCreatedAt(patient_id_created_at);
    }

    public void insertPatientDailyReport(DbPatientDailyReport dbPatientDailyReport) {
        dao.insertPatientDailyReport(dbPatientDailyReport);
    }
}
