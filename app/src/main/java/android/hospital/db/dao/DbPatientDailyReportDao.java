package android.hospital.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.hospital.db.entity.DbPatientDailyReport;

import java.util.List;

/**
 * Created by logan on 08/03/2018.
 */

@Dao
public interface DbPatientDailyReportDao {
    @Query("SELECT * FROM patient_daily_reports WHERE patient_id = :patient_id")
    LiveData<List<DbPatientDailyReport>> getDailyReportByPatientId(Integer patient_id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPatientDailyReport(DbPatientDailyReport dbPatientDailyReport);

    @Query("SELECT * FROM patient_daily_reports WHERE patient_id_created_at = :patient_id_created_at LIMIT 1")
    LiveData<DbPatientDailyReport> getDailyReportByPatientIdCreatedAt(String patient_id_created_at);
}
