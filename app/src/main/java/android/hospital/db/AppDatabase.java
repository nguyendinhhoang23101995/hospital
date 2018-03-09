package android.hospital.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.hospital.db.dao.DbPatientDao;
import android.hospital.db.entity.DbPatient;

/**
 * Created by logan on 01/03/2018.
 */

@Database(
        entities = {DbPatient.class},
        version = 1,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static AppDatabase getInStance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "magenest").allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract DbPatientDao patientDao();
}
