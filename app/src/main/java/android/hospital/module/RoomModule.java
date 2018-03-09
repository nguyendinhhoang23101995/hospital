package android.hospital.module;

import android.app.Application;
import android.hospital.db.AppDatabase;
import android.hospital.db.repository.DbPatientRepository;
import android.hospital.viewModel.DbViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by logan on 01/03/2018.
 */

@Module
public class RoomModule {

    private Application application;
    private AppDatabase database;

    public RoomModule(Application application) {
        this.application = application;
        this.database = AppDatabase.getInStance(application);
    }

    @Provides
    @Singleton
    public DbPatientRepository provideProductRepository() {
        return new DbPatientRepository(database.patientDao());
    }

    @Provides
    @Singleton
    public DbViewModelFactory provideViewModelFactory() {
        return new DbViewModelFactory(application);
    }
}
