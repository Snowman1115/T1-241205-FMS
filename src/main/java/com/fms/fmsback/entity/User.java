package com.fms.fmsback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * User Account and Details
 * @author Sn0w_15
 * @since 2024-12-05
 */
@Getter
@Setter
@TableName("fms_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * User ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Account Username
     */
    private String username;

    /**
     * Account Password
     */
    private String password;

    /**
     * Account isNotExpired (0:NO, 1:YES)
     */
    private Integer isAccountNonExpired;

    /**
     * Account isNotLock (0:NO, 1:YES)
     */
    private Integer isAccountNonLocked;

    /**
     * Password isNotExpired (0:NO, 1:YES)
     */
    private Integer isCredentialsNonExpired;

    /**
     * Account isEnable (0:NO, 1:YES)
     */
    private Integer isEnabled;

    /**
     * User First Name
     */
    private String firstName;

    /**
     * User Last Name
     */
    private String lastName;

    /**
     * User Nickname
     */
    private String nickname;

    /**
     * Department ID
     */
    private Long departmentId;

    /**
     * Department Name
     */
    private String departmentName;

    /**
     *  Email
     */
    private String email;

    /**
     * Mobile Number
     */
    private String phone;

    /**
     * 0 = MALE : 1 = FEMALE
     */
    private Integer gender;

    /**
     * User Avatar Url
     */
    private String avatar;

    /**
     * 0 = NO : 1 = YES (SUPER_ADMIN)
     */
    private Integer isAdmin;

    /**
     * Last Login Date
     */
    private LocalDateTime loginDate;

    /**
     * 0 = isActive : 1 isDeleted
     */
    private Integer isDelete;

    /**
     * Remarks
     */
    private String remark;

    /**
     * Create Time
     */
    private LocalDateTime createTime;

    /**
     * Update Time
     */
    private LocalDateTime updateTime;


}
