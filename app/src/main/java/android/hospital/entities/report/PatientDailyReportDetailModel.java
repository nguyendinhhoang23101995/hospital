package android.hospital.entities.report;

import android.hospital.utils.MyUtils;

import com.google.gson.Gson;

/**
 * Created by logan on 09/03/2018.
 */

public class PatientDailyReportDetailModel {
    protected Integer id;
    protected Integer patient_id;
    protected String patient_heart_beat;
    protected String patient_body_temperature;
    protected String patient_blood_pressure;
    protected String patient_status;
    protected String doctor_diagnostic;
    protected String doctor_command;
    protected String doctor_note;
    protected String nurse_note;
    protected String nurse_progress;
    protected Integer report_status;
    protected String doctor_created_at;
    protected String nurse_created_at;
    protected String created_at;

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patient_id;
    }

    public void setPatientId(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatientHeartBeat() {
        return patient_heart_beat;
    }

    public void setPatientHeartBeat(String patient_heart_beat) {
        this.patient_heart_beat = patient_heart_beat;
    }

    public String getPatientBodyTemperature() {
        return patient_body_temperature;
    }

    public void setPatientBodyTemperature(String patient_body_temperature) {
        this.patient_body_temperature = patient_body_temperature;
    }

    public String getPatientBloodPressure() {
        return patient_blood_pressure;
    }

    public void setPatientBloodPressure(String patient_blood_pressure) {
        this.patient_blood_pressure = patient_blood_pressure;
    }

    public String getPatientStatus() {
        return patient_status;
    }

    public void setPatientStatus(String patient_status) {
        this.patient_status = patient_status;
    }

    public String getDoctorDiagnostic() {
        return doctor_diagnostic;
    }

    public void setDoctorDiagnostic(String doctor_diagnostic) {
        this.doctor_diagnostic = doctor_diagnostic;
    }

    public String getDoctorCommand() {
        return doctor_command;
    }

    public void setDoctorCommand(String doctor_command) {
        this.doctor_command = doctor_command;
    }

    public String getDoctorNote() {
        return doctor_note;
    }

    public void setDoctorNote(String doctor_note) {
        this.doctor_note = doctor_note;
    }

    public String getNurseNote() {
        return nurse_note;
    }

    public void setNurseNote(String nurse_note) {
        this.nurse_note = nurse_note;
    }

    public String getNurseProgress() {
        return nurse_progress;
    }

    public void setNurseProgress(String nurse_progress) {
        this.nurse_progress = nurse_progress;
    }

    public Integer getReportStatus() {
        return report_status;
    }

    public void setReportStatus(Integer report_status) {
        this.report_status = report_status;
    }

    public String getDoctorCreatedAt() {
        return doctor_created_at;
    }

    public void setDoctorCreatedAt(String doctor_created_at) {
        this.doctor_created_at = doctor_created_at;
    }

    public String getNurseCreatedAt() {
        return nurse_created_at;
    }

    public void setNurseCreatedAt(String nurse_created_at) {
        this.nurse_created_at = nurse_created_at;
    }

    public String getPatientIdCreatedAt() {
        return patient_id + "_" + MyUtils.convertTimeToDisplayTextDMY(getCreatedAt());
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
