package com.rillsoft.stackpoadmin.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.fullname
     *
     * @mbg.generated
     */
    private String fullname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.user_email
     *
     * @mbg.generated
     */
    private String user_email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.user_phone
     *
     * @mbg.generated
     */
    private String user_phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.last_login
     *
     * @mbg.generated
     */
    private Date last_login;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.date_joined
     *
     * @mbg.generated
     */
    private Date date_joined;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_auth_users.user_status
     *
     * @mbg.generated
     */
    private Integer user_status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tbl_auth_users
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_auth_users
     *
     * @mbg.generated
     */
    public User(Integer id, String username, String password, String fullname, String user_email, String user_phone, Date last_login, Date date_joined, Integer user_status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.user_email = user_email;
        this.user_phone = user_phone;
        this.last_login = last_login;
        this.date_joined = date_joined;
        this.user_status = user_status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_auth_users
     *
     * @mbg.generated
     */
    public User() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.id
     *
     * @return the value of tbl_auth_users.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.id
     *
     * @param id the value for tbl_auth_users.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.username
     *
     * @return the value of tbl_auth_users.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.username
     *
     * @param username the value for tbl_auth_users.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.password
     *
     * @return the value of tbl_auth_users.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.password
     *
     * @param password the value for tbl_auth_users.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.fullname
     *
     * @return the value of tbl_auth_users.fullname
     *
     * @mbg.generated
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.fullname
     *
     * @param fullname the value for tbl_auth_users.fullname
     *
     * @mbg.generated
     */
    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.user_email
     *
     * @return the value of tbl_auth_users.user_email
     *
     * @mbg.generated
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.user_email
     *
     * @param user_email the value for tbl_auth_users.user_email
     *
     * @mbg.generated
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email == null ? null : user_email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.user_phone
     *
     * @return the value of tbl_auth_users.user_phone
     *
     * @mbg.generated
     */
    public String getUser_phone() {
        return user_phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.user_phone
     *
     * @param user_phone the value for tbl_auth_users.user_phone
     *
     * @mbg.generated
     */
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone == null ? null : user_phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.last_login
     *
     * @return the value of tbl_auth_users.last_login
     *
     * @mbg.generated
     */
    public Date getLast_login() {
        return last_login;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.last_login
     *
     * @param last_login the value for tbl_auth_users.last_login
     *
     * @mbg.generated
     */
    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.date_joined
     *
     * @return the value of tbl_auth_users.date_joined
     *
     * @mbg.generated
     */
    public Date getDate_joined() {
        return date_joined;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.date_joined
     *
     * @param date_joined the value for tbl_auth_users.date_joined
     *
     * @mbg.generated
     */
    public void setDate_joined(Date date_joined) {
        this.date_joined = date_joined;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tbl_auth_users.user_status
     *
     * @return the value of tbl_auth_users.user_status
     *
     * @mbg.generated
     */
    public Integer getUser_status() {
        return user_status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tbl_auth_users.user_status
     *
     * @param user_status the value for tbl_auth_users.user_status
     *
     * @mbg.generated
     */
    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_auth_users
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getFullname() == null ? other.getFullname() == null : this.getFullname().equals(other.getFullname()))
            && (this.getUser_email() == null ? other.getUser_email() == null : this.getUser_email().equals(other.getUser_email()))
            && (this.getUser_phone() == null ? other.getUser_phone() == null : this.getUser_phone().equals(other.getUser_phone()))
            && (this.getLast_login() == null ? other.getLast_login() == null : this.getLast_login().equals(other.getLast_login()))
            && (this.getDate_joined() == null ? other.getDate_joined() == null : this.getDate_joined().equals(other.getDate_joined()))
            && (this.getUser_status() == null ? other.getUser_status() == null : this.getUser_status().equals(other.getUser_status()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_auth_users
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getFullname() == null) ? 0 : getFullname().hashCode());
        result = prime * result + ((getUser_email() == null) ? 0 : getUser_email().hashCode());
        result = prime * result + ((getUser_phone() == null) ? 0 : getUser_phone().hashCode());
        result = prime * result + ((getLast_login() == null) ? 0 : getLast_login().hashCode());
        result = prime * result + ((getDate_joined() == null) ? 0 : getDate_joined().hashCode());
        result = prime * result + ((getUser_status() == null) ? 0 : getUser_status().hashCode());
        return result;
    }
}