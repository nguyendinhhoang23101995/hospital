package android.hospital.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.hospital.db.entity.DbPatient;

import java.util.List;

/**
 * Created by logan on 08/03/2018.
 */

@Dao
public interface DbPatientDao {
    @Query("SELECT * FROM patients WHERE code = :code LIMIT 1")
    LiveData<DbPatient> getPatientByCode(String code);

    @Query("SELECT * FROM patients")
    LiveData<List<DbPatient>> getAllPatient();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPatient(DbPatient dbPatient);

    @Query("DELETE from patients WHERE code = :code")
    void deletePatient(String code);
}
