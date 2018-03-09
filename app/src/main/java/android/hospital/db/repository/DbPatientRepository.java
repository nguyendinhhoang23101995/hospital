package android.hospital.db.repository;

import android.arch.lifecycle.LiveData;
import android.hospital.db.dao.DbPatientDao;
import android.hospital.db.entity.DbPatient;

import java.util.List;

/**
 * Created by logan on 01/03/2018.
 */

public class DbPatientRepository {

    private DbPatientDao dao;

    public DbPatientRepository(DbPatientDao dao) {
        this.dao = dao;
    }

    public LiveData<DbPatient> getPatientById(String code) {
        return dao.getPatientByCode(code);
    }

    public LiveData<List<DbPatient>> getAllPatient() {
        return dao.getAllPatient();
    }

    public void insertPatient(DbPatient dbPatient) {
        dao.insertPatient(dbPatient);
    }

    public void deletePatient(String code) {
        dao.deletePatient(code);
    }
}
