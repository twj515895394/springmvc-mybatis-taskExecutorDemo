package com.isea533.mybatis.model;

import java.util.Date;

public class UserLoginInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user login info.Id
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user login info.username
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user login info.logindate
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    private Date logindate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user login info.loginip
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    private String loginip;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user login info.Id
     *
     * @return the value of user login info.Id
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user login info.Id
     *
     * @param id the value for user login info.Id
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user login info.username
     *
     * @return the value of user login info.username
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user login info.username
     *
     * @param username the value for user login info.username
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user login info.logindate
     *
     * @return the value of user login info.logindate
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    public Date getLogindate() {
        return logindate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user login info.logindate
     *
     * @param logindate the value for user login info.logindate
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    public void setLogindate(Date logindate) {
        this.logindate = logindate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user login info.loginip
     *
     * @return the value of user login info.loginip
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    public String getLoginip() {
        return loginip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user login info.loginip
     *
     * @param loginip the value for user login info.loginip
     *
     * @mbggenerated Sat Mar 11 00:45:04 CST 2017
     */
    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }
}