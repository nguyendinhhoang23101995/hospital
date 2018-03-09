package android.hospital.di;

import android.hospital.module.RoomModule;
import android.hospital.ux.MainActivity;
import android.hospital.ux.fragments.patientinfo.PatientInfoFragment;
import android.hospital.ux.fragments.patientmanagement.PatientManagementFragment;
import android.hospital.viewModel.DbViewModelFactory;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by logan on 01/03/2018.
 */

@Singleton
@Component(modules = {RoomModule.class})
public interface ApplicationComponent {

    void inject(DbViewModelFactory factory);

    void inject(MainActivity activity);

    void inject(PatientManagementFragment patientManagementFragment);

    void inject(PatientInfoFragment patientInfoFragment);
}
