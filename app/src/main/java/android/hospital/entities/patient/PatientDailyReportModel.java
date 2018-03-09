package android.hospital.entities.patient;

/**
 * Created by logan on 07/03/2018.
 */

public class PatientDailyReportModel {
    protected String created_at;
    protected String blood_pressure;
    protected String heart_beat;
    protected String body_temprature;
    protected String status;
    protected String treatment;

    public PatientDailyReportModel(String created_at, String blood_pressure, String heart_beat, String body_temprature, String status, String treatment) {
        this.created_at = created_at;
        this.blood_pressure = blood_pressure;
        this.heart_beat = heart_beat;
        this.body_temprature = body_temprature;
        this.status = status;
        this.treatment = treatment;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getBloodPressure() {
        return blood_pressure;
    }

    public void setBloodPressure(String blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public String getHeartBeat() {
        return heart_beat;
    }

    public void setHeartBeat(String heart_beat) {
        this.heart_beat = heart_beat;
    }

    public String getBodyTemprature() {
        return body_temprature;
    }

    public void setBodyTemprature(String body_temprature) {
        this.body_temprature = body_temprature;
    }
}
