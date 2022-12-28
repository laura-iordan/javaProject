/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.library.dao;

import com.library.books.exceptions.NonexistentEntityException;
import com.library.entities.User;
import com.library.jpacontrollers.UserJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author laura
 */
public class UserDAO {
    private final UserJpaController userController;
    
    private final EntityManagerFactory emf;
    
    public UserDAO(){
        
        emf=Persistence.createEntityManagerFactory("com.library_books_jar_1.0-SNAPSHOTPU");
        userController = new UserJpaController(emf);
    }
    
    public void addUser(User user) throws Exception{
        userController.create(user); 
    }
    
    public void editUser(User user) throws Exception{
        userController.edit(user);
    }
    
    public void removeUser(long userID) throws NonexistentEntityException{
        userController.destroy(userID);
    }
    
    public List<User> getAllUser(){
        return userController.findUserEntities();
    }
    
    public User getUserById(long userID){
        return userController.findUser(userID);
    }
}
