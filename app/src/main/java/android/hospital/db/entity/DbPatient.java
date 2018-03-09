package android.hospital.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by logan on 08/03/2018.
 */

@Entity(tableName = "patients")
public class DbPatient {
    @PrimaryKey
    @NonNull
    public String code;

    @ColumnInfo(name = "info")
    public String info;
}
