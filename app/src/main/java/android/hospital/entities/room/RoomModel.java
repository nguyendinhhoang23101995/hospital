package android.hospital.entities.room;

/**
 * Created by logan on 09/03/2018.
 */

public class RoomModel {
    protected Integer id;
    protected String room_number;
    protected String room_location;
    protected String created_at;

    public RoomModel(Integer id, String room_number, String room_location, String created_at) {
        this.id = id;
        this.room_number = room_number;
        this.room_location = room_location;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return room_number;
    }

    public void setRoomNumber(String room_number) {
        this.room_number = room_number;
    }

    public String getRoomLocation() {
        return room_location;
    }

    public void setRoomLocation(String room_location) {
        this.room_location = room_location;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }
}
