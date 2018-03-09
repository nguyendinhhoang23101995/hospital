package android.hospital.ux.adapters.patientreport;

import android.content.Context;
import android.hospital.R;
import android.hospital.entities.report.PatientDailyReportDetailModel;
import android.hospital.interfaces.patientdailyreports.PatientDailyReportsRecyclerViewInterface;
import android.hospital.utils.MyUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by logan on 09/03/2018.
 */

public class PatientReportRecyclerViewAdapter extends RecyclerView.Adapter<PatientReportRecyclerViewAdapter.ViewHolder> {

    private final PatientDailyReportsRecyclerViewInterface patientDailyReportsRecyclerViewInterface;
    protected ArrayList<PatientDailyReportDetailModel> patientDailyReportDetailModels = new ArrayList<>();
    protected Context context;
    protected boolean selectable = false;
    private LayoutInflater layoutInflater;

    public PatientReportRecyclerViewAdapter(Context context, PatientDailyReportsRecyclerViewInterface patientDailyReportsRecyclerViewInterface) {
        this.context = context;
        this.patientDailyReportsRecyclerViewInterface = patientDailyReportsRecyclerViewInterface;
    }

    @Override
    public PatientReportRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_patient_report, parent, false);
        return new PatientReportRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PatientReportRecyclerViewAdapter.ViewHolder holder, int position) {
        final PatientDailyReportDetailModel patientDailyReportDetailModel = patientDailyReportDetailModels.get(position);
        String status = "Done";
        if (patientDailyReportDetailModel.getReportStatus().equals(100)) {
            status = "Done";
        } else {
            status = "In progress";
        }
        holder.report_created_at.setText(MyUtils.convertTimeToDisplayTextMDY(patientDailyReportDetailModel.getDoctorCreatedAt()) + "  - ");
        if (patientDailyReportDetailModel.getDoctorDiagnostic() != null) {
            holder.report_doctor_diagnostic.setText("diagnostic: " + patientDailyReportDetailModel.getDoctorDiagnostic());
        } else {
            holder.report_doctor_diagnostic.setText("diagnostic: ?");
        }
        if (patientDailyReportDetailModel.getDoctorCommand() != null) {
            holder.report_doctor_diagnostic.setText("command: " + patientDailyReportDetailModel.getDoctorCommand());
        } else {
            holder.report_doctor_diagnostic.setText("command: ?");
        }
        if (patientDailyReportDetailModel.getPatientBloodPressure() != null) {
            holder.patient_blood_pressure.setText("blood pressure: " + patientDailyReportDetailModel.getPatientBloodPressure());
        } else {
            holder.patient_blood_pressure.setText("blood pressure: ?");
        }
        if (patientDailyReportDetailModel.getPatientBodyTemperature() != null) {
            holder.patient_blood_pressure.setText("body temperature: " + patientDailyReportDetailModel.getPatientBodyTemperature());
        } else {
            holder.patient_blood_pressure.setText("body temperature: ?");
        }
        if (patientDailyReportDetailModel.getPatientHeartBeat() != null) {
            holder.patient_blood_pressure.setText("heart beat: " + patientDailyReportDetailModel.getPatientHeartBeat());
        } else {
            holder.patient_blood_pressure.setText("heart beat: ?");
        }
        if (patientDailyReportDetailModel.getNurseNote() != null) {
            holder.patient_blood_pressure.setText("nurse note: " + patientDailyReportDetailModel.getNurseNote());
        }

    }

    @Override
    public int getItemCount() {
        return patientDailyReportDetailModels.size();
    }

    public void setPatientDailyReports(ArrayList<PatientDailyReportDetailModel> patientDailyReportDetailModels) {
        this.patientDailyReportDetailModels = patientDailyReportDetailModels;
        notifyDataSetChanged();
    }

    public void setSelectable(boolean status) {
        selectable = status;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView report_created_at, report_doctor_diagnostic, report_doctor_command, patient_heart_beat, patient_body_temperature, patient_blood_pressure, patient_nurse_note;
        public ImageView layout_notification_send_image;
        public TextView layout_notification_send_text;
        public TextView update_report, send_notification;

        public ViewHolder(View itemView) {
            super(itemView);
            report_created_at = itemView.findViewById(R.id.report_created_at);
            report_doctor_diagnostic = itemView.findViewById(R.id.report_doctor_diagnostic);
            report_doctor_command = itemView.findViewById(R.id.report_doctor_command);
            patient_heart_beat = itemView.findViewById(R.id.patient_heart_beat);
            patient_body_temperature = itemView.findViewById(R.id.patient_body_temperature);
            patient_blood_pressure = itemView.findViewById(R.id.patient_blood_pressure);
            patient_nurse_note = itemView.findViewById(R.id.patient_nurse_note);
            layout_notification_send_image = itemView.findViewById(R.id.layout_notification_send_image);
            layout_notification_send_text = itemView.findViewById(R.id.layout_notification_send_text);
            update_report = itemView.findViewById(R.id.update_report);
            send_notification = itemView.findViewById(R.id.send_notification);
        }
    }
}
