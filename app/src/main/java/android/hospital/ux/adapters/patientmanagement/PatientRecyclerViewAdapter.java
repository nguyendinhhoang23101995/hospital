package android.hospital.ux.adapters.patientmanagement;

import android.content.Context;
import android.hospital.R;
import android.hospital.entities.patient.PatientModel;
import android.hospital.interfaces.patientmanagement.PatientManagementRecyclerViewInterface;
import android.hospital.listeners.OnSingleClickListener;
import android.hospital.utils.MyUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by logan on 08/03/2018.
 */

public class PatientRecyclerViewAdapter extends RecyclerView.Adapter<PatientRecyclerViewAdapter.ViewHolder> {

    private final PatientManagementRecyclerViewInterface patientManagementRecyclerViewInterface;
    protected ArrayList<PatientModel> patientModels = new ArrayList<>();
    protected Context context;
    protected boolean selectable = false;
    private LayoutInflater layoutInflater;

    public PatientRecyclerViewAdapter(Context context, PatientManagementRecyclerViewInterface patientManagementRecyclerViewInterface) {
        this.context = context;
        this.patientManagementRecyclerViewInterface = patientManagementRecyclerViewInterface;
    }

    @Override
    public PatientRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_patient, parent, false);
        return new PatientRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PatientRecyclerViewAdapter.ViewHolder holder, int position) {
        final PatientModel patientModel = patientModels.get(position);
        holder.patient_name.setText(patientModel.getName());
        holder.patient_code.setText(patientModel.getCode());
        holder.patient_birth_day.setText(MyUtils.convertTimeToDisplayTextMDY(patientModel.getBirthday()));
        holder.patient_update_info.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                patientManagementRecyclerViewInterface.onPatientUpdate(patientModel);
            }
        });
        holder.patient_view_report.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                patientManagementRecyclerViewInterface.onPatientReportSelected(patientModel);
            }
        });
        holder.patient_remove.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                patientManagementRecyclerViewInterface.onPatientDelete(patientModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return patientModels.size();
    }

    public void setPatients(ArrayList<PatientModel> patients) {
        this.patientModels = patients;
        notifyDataSetChanged();
    }

    public void setSelectable(boolean status) {
        selectable = status;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView patient_update_info, patient_view_report, patient_remove, patient_name, patient_code, patient_birth_day;

        public ViewHolder(View itemView) {
            super(itemView);
            patient_update_info = itemView.findViewById(R.id.patient_update_info);
            patient_view_report = itemView.findViewById(R.id.patient_view_report);
            patient_name = itemView.findViewById(R.id.patient_name);
            patient_code = itemView.findViewById(R.id.patient_code);
            patient_birth_day = itemView.findViewById(R.id.patient_birth_day);
            patient_remove = itemView.findViewById(R.id.patient_remove);
        }
    }
}
