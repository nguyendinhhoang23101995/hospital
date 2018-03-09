package android.hospital.entities.nurse;

/**
 * Created by logan on 09/03/2018.
 */

public class NurseModel {
    protected Integer id;
    protected String name;
    protected String email;
    protected Integer major_id;
    protected Integer gender_id;
    protected String phone;
    protected String created_at;

    public NurseModel(String name, String email, Integer major_id, Integer gender_id, String phone, String created_at) {
        this.name = name;
        this.email = email;
        this.major_id = major_id;
        this.gender_id = gender_id;
        this.phone = phone;
        this.created_at = created_at;
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

    public Integer getMajorId() {
        return major_id;
    }

    public void setMajorId(Integer major_id) {
        this.major_id = major_id;
    }

    public Integer getGenderId() {
        return gender_id;
    }

    public void setGenderId(Integer gender_id) {
        this.gender_id = gender_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }
}
