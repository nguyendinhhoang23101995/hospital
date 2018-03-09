package android.hospital.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by logan on 08/03/2018.
 */

@Entity(tableName = "patient_daily_reports")
public class DbPatientDailyReport {
    @PrimaryKey
    @NonNull
    public Integer patient_id;

    //    1_01012018
    @PrimaryKey
    @NonNull
    public String patient_id_created_at;

    public String info;
}
