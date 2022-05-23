package model;

public class User {
    private int user_id;
private String full_name;
private String email;
private String password;
private String phone;
private int role;
private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String full_name, String email, String password, String phone, int role, String address) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.address = address;
    }

    public User(int user_id, String full_name, String email, String password, String phone, int role, String address) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.address = address;
    }

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String full_name, String email, String password, String phone) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(int user_id, String full_name, String email, String password, String phone, int role) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public User(String email, String password, int role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String full_name, String email, String password, String phone, int role) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", full_name='" + full_name + '\'' +
                ", user_name='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
