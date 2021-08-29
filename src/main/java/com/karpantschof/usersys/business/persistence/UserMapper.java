/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karpantschof.usersys.business.persistence;

import entities.User;
import java.sql.*;
import java.util.*;

/**
 *
 * @author johan
 */
public class UserMapper {

    final private Database database;

    public UserMapper(Database database) {
        this.database = database;
    }

    public void createUser(User user) {
        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO `usertable` (fname, lname, pw, phone, address) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, user.getFirstName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getPhone());
                ps.setString(5, user.getAddress());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM `usertable`";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user;
                user = new User(
                        rs.getInt("id"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("pw"),
                        rs.getString("phone"),
                        rs.getString("address"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
