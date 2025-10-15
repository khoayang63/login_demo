/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info;

import java.io.Serializable;

public class user_info implements Serializable {

    // 1. Khai báo các trường (Attributes) dựa trên các cột trong bảng employee
    private String firstName;
    private String lastName;
    private String username;
    private String password; // Thường không nên lưu mật khẩu vào Session thật, nhưng giữ ở đây để tham chiếu.
    private String address;
    private String contact;

    // 2. Constructor Mặc định (Không đối số)
    public user_info() {
    }

    // 3. Constructor Đầy đủ (Dùng để tạo đối tượng từ ResultSet)
    public user_info(String firstName, String lastName, String username, String password, String address, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.address = address;
        this.contact = contact;
    }

    // 4. Các phương thức GETTER và SETTER

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}