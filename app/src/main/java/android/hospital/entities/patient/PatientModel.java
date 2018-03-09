package android.hospital.entities.patient;

import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by logan on 07/03/2018.
 */

public class PatientModel {
    protected Integer doctor_id;
    protected String name;
    protected String code;
    protected String birth_day;
    protected String gender;
    protected String additional_info;
    protected String room;
    protected String main_disease;
    protected String additional_disease;
    protected String created_at;
    protected String end_at;
    protected ArrayList<PatientDailyReportModel> daily_report;
    protected String update_at;

    public PatientModel() {

    }

    public PatientModel(String name, String code, String birth_day, String gender, String additional_info, String room, String main_disease, String additional_disease, String created_at) {
        this.name = name;
        this.code = code;
        this.birth_day = birth_day;
        this.gender = gender;
        this.additional_info = additional_info;
        this.room = room;
        this.main_disease = main_disease;
        this.additional_disease = additional_disease;
        this.created_at = created_at;
    }

    public Integer getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBirthDay() {
        return birth_day;
    }

    public void setBirthDay(String birth_day) {
        this.birth_day = birth_day;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdditionalInfo() {
        return additional_info;
    }

    public void setAdditionalInfo(String additional_info) {
        this.additional_info = additional_info;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMainDisease() {
        return main_disease;
    }

    public void setMainDisease(String main_disease) {
        this.main_disease = main_disease;
    }

    public String getAdditionalDisease() {
        return additional_disease;
    }

    public void setAdditionalDisease(String additional_disease) {
        this.additional_disease = additional_disease;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getEndAt() {
        return end_at;
    }

    public void setEndAt(String end_at) {
        this.end_at = end_at;
    }

    public ArrayList<PatientDailyReportModel> getDailyReport() {
        return daily_report;
    }

    public void setDailyReport(ArrayList<PatientDailyReportModel> daily_report) {
        this.daily_report = daily_report;
    }

    public String getUpdateAt() {
        return update_at;
    }

    public void setUpdateAt(String update_at) {
        this.update_at = update_at;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
