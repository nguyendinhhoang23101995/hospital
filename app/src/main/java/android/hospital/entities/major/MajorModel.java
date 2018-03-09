package android.hospital.entities.major;

/**
 * Created by logan on 09/03/2018.
 */

public class MajorModel {
    protected Integer id;
    protected String name;
    protected String created_at;

    public MajorModel(Integer id, String name, String created_at) {
        this.id = id;
        this.name = name;
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

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }
}
