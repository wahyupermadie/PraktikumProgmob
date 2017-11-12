package id.futnet.praktikumprogmob.model;

/**
 * Created by Devtian Dicky on 09-Nov-17.
 */

public class Member {
    private String contact_img_uri,MEMBER_name,EMAIL,PASSWORD;
    private int MEMBER_id;
    public Member(){

    }

    public Member(String contact_img_uri, String MEMBER_name, String EMAIL, String PASSWORD, int MEMBER_id) {
        this.contact_img_uri = contact_img_uri;
        this.MEMBER_name = MEMBER_name;
        this.EMAIL = EMAIL;
        this.PASSWORD = PASSWORD;
        this.MEMBER_id = MEMBER_id;
    }

    public String getContact_img_uri() {
        return contact_img_uri;
    }

    public void setContact_img_uri(String contact_img_uri) {
        this.contact_img_uri = contact_img_uri;
    }

    public String getMEMBER_name() {
        return MEMBER_name;
    }

    public void setMEMBER_name(String MEMBER_name) {
        this.MEMBER_name = MEMBER_name;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public int getMEMBER_id() {
        return MEMBER_id;
    }

    public void setMEMBER_id(int MEMBER_id) {
        this.MEMBER_id = MEMBER_id;
    }
}
