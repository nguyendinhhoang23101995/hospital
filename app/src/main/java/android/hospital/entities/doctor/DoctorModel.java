package android.hospital.entities.doctor;

/**
 * Created by logan on 09/03/2018.
 */

public class DoctorModel {
    protected Integer id;
    protected String name;
    protected String email;
    protected String phone;
    protected Integer room_id;
    protected String birthday;
    protected Integer gender;
    protected Integer major_id;
    protected String created_at;

    public DoctorModel() {

    }

    public DoctorModel(String name, String email, String phone, Integer room_id, String birthday, Integer gender, Integer major_id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.room_id = room_id;
        this.birthday = birthday;
        this.gender = gender;
        this.major_id = major_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoomId() {
        return room_id;
    }

    public void setRoomId(Integer room_id) {
        this.room_id = room_id;
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

    public Integer getMajorId() {
        return major_id;
    }

    public void setMajorId(Integer major_id) {
        this.major_id = major_id;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }
}
