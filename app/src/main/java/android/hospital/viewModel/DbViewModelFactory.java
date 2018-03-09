package android.hospital.viewModel;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.hospital.MyApplication;
import android.hospital.db.repository.DbPatientRepository;
import android.support.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by logan on 01/03/2018.
 */

public class DbViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    public DbPatientRepository dbPatientRepository;

    public DbViewModelFactory(Application application) {
        ((MyApplication) application).getApplicationComponent().inject(this);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DbPatientViewModel.class)) {
            return (T) new DbPatientViewModel(dbPatientRepository);
        } else {
            throw new IllegalArgumentException("Invalid view model");
        }
    }
}
