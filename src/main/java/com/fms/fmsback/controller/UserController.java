package com.fms.fmsback.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fms.fmsback.common.constants.ResultConstants;
import com.fms.fmsback.common.result.Result;
import com.fms.fmsback.exception.ServiceException;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import java.util.List;

import com.fms.fmsback.service.IUserService;
import com.fms.fmsback.entity.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Account and Details Controller
 * @author Sn0w_15
 * @since 2024-12-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * Get All User
     * @return Result
     */
    @GetMapping
    public Result getAllUser() {
        return Result.success(userService.list());
    }

    /**
     * Get User By Id
     * @param id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable Integer id) {
        return Result.success(userService.getById(id));
    }

    /**
     * Save Or Update User
     * @param user
     * @return Result
     */
    @PostMapping
    public Result save(@RequestBody User user) {
        try {
            userService.save(user);
            return Result.success(null, "user Saved Successfully");
        } catch (Exception e) {
            throw new ServiceException(ResultConstants.INTERNAL_SERVER_ERROR, "Server Error, Failed to Save user. Please Try Again.");
        }
    }

    /**
     * Update User
     * @param user
     * @return Result
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        if (userService.updateById(user)) {
            return Result.success(null, "User Updated Successfully");
        }
        throw new ServiceException(ResultConstants.NOT_FOUND, "Update Fail, User Not Found. Please Try Again.");
    }

    /**
     * Delete Specific User
     * @param id
     * @return Result
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        if (userService.removeById(id)) {
            return Result.success(ResultConstants.OK,"User Removed Successfully");
        }
        return Result.error(ResultConstants.INTERNAL_SERVER_ERROR,"Server Error, Failed to Delete User. Please Try Again.");
    }

    /**
     * Batch Delete User
     * @param ids
     * @return Result
     */
    @DeleteMapping("/del/batch/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        if (userService.removeByIds(ids)) {
            return Result.success(ResultConstants.OK,"Users Removed Successfully");
        }
        return Result.error(ResultConstants.INTERNAL_SERVER_ERROR,"Server Error, Failed to Remove  Users. Please Try Again.");
    }

    /**
     * Page Query
     * @param pageNum
     * @param pageSize
     * @return Result
     */
    @GetMapping("/page")
    public Result getPage(@RequestParam Integer pageNum,
                          @RequestParam Integer pageSize) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        return Result.success(userService.page(new Page<>(pageNum,pageSize), queryWrapper));
    }

}

