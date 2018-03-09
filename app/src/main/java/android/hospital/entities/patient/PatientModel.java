package android.hospital.entities.patient;

import com.google.gson.Gson;

/**
 * Created by logan on 07/03/2018.
 */

public class PatientModel {
    protected Integer id;
    protected String code;
    protected String name;
    protected String email;
    protected String password;
    protected String phone;
    protected Integer doctor_id;
    protected String birthday;
    protected Integer gender;
    protected Integer room_id;
    protected String additional_info;
    protected Integer major_id;
    protected String main_disease;
    protected String additional_disease;
    protected String created_at;
    protected String end_at;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getRoomId() {
        return room_id;
    }

    public void setRoomId(Integer room_id) {
        this.room_id = room_id;
    }

    public String getAdditionalInfo() {
        return additional_info;
    }

    public void setAdditionalInfo(String additional_info) {
        this.additional_info = additional_info;
    }

    public Integer getMajorId() {
        return major_id;
    }

    public void setMajorId(Integer major_id) {
        this.major_id = major_id;
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

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
