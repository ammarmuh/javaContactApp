/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactpack;

/**
 *
 * @author HP
 */
public class contact {
    private Integer cid;
    private String name;
    private String email;
    private String phone;
    private String groupc;
    private String address;
    private byte[] pic;
    private int uid;
    
    // alt + ins 
    // to generate contrustor & getter & setter
    
    public contact(){}

    public contact(Integer cid, String name, String email, String phone, String groupc, String address, byte[] pic, int uid) {
        this.cid = cid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.groupc = groupc;
        this.address = address;
        this.pic = pic;
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public String getGroupc() {
        return groupc;
    }

    public void setGroupc(String groupc) {
        this.groupc = groupc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    
    
    
}
