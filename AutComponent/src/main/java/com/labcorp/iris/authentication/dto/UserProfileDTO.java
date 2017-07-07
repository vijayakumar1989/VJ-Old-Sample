/*
 * UserProfileDTO.java  
 * Version 1.0
 * Date 2010/29/12
 * Copyright (c) 2010 Sensiple Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Sensiple. ("Confidential
 * Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with
 * the terms of the license agreement you entered into
 * with Sensiple.
 * */
package com.labcorp.iris.authentication.dto;

import java.util.List;

/**
 * This DTO contains the information related to user profile. It contains user
 * information along with allocated roles.
 *
 * 
 * @version 1.0
 * 
 * @date 2010/29/12  
 * 
 * 
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>UserProfileDTO</b></code>'. <!--
 *         end-user-doc -->
 * 
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.UserProfileDTO#getUserId}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.UserProfileDTO#setUserId}</li>
 *         </li>
 *        <li>
 *         {@link com.labcorp.iris.authentication.dto.UserProfileDTO#getPassword}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.UserProfileDTO#setPassword}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.UserProfileDTO#isActive}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.UserProfileDTO#setActive}</li>
 *         </li>
 *        <li>
 *         {@link com.labcorp.iris.authentication.dto.UserProfileDTO#getRoles}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.UserProfileDTO#setRoles}</li>
 *         </li>
 *         </ul>
 *         </p>
 * */
public class UserProfileDTO extends AuthDTO {

	private static final long serialVersionUID = 1L;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the user id
	 * </p>
	 * <!-- end-user-doc -->
	 */
	private String userId;
	
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the password of the user.
	 * </p>
	 * <!-- end-user-doc -->
	 */
	private String password;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the password of the user.
	 * </p>
	 * <!-- end-user-doc -->
	 */
	private boolean active;

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is user for assign the user role to the list.
	 * </p>
	 * <!-- end-user-doc -->
	 */
	List<String> roles;
	
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Creates a UserProfileDTO with <code>userId</code>,
	 * <code>password</code>, <code>active</code>, and <code>roles</code>
	 * params.
	 * <!-- end-user-doc -->
	 * 
	 * @param userId  
	 *           as '<code>String</code>' containment reference.
	 * @param password
	 *            as '<code>String</code>' containment reference.
	 * @param active
	 *            as<code>boolean</code> {@value<code><b>0</code></b>} containment
	 * reference.
	 * @param roles 
	 *             as <code>List<Sting></code> containment reference.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 * 
	 */
	public UserProfileDTO(String userId, String password, boolean active,
			List<String> roles) {
		this.userId = userId;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public UserProfileDTO() {
		super();
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getUserId</b></code>' to get the
	 * '<code><b>userId</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>userId</code>' containment reference is
	 *        String.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 * 
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>setUserId</b></code>' to set the
	 *   '<code><b>userId</b></code>'
	 * containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param  userId as '<code>Strig</code>' containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 *  
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getPassword</b></code>' to get the
	 *   '<code><b>password</b></code>'
	 * containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>password</code>' containment reference is
	 *        String.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this '
	 * <code><b>setPassword</b></code>' to set the
	 *   '<code><b>password</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param  password as '<code>Strig</code>' containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 *  
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this '
	 * <code><b>isActive</b></code>' to get the
	 * '<code><b>active</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>active</code>' containment reference is
	 *        Boolean.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 * 
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this '
	 * <code><b>setActive</b></code>' to set the
	 *  '<code><b>active</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param  active as '<code>boolean</code>' containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 *  
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this '
	 * <code><b>getRoles</b></code>' to get the
	 * '<code><b>roles</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>roles</code>' containment reference is
	 *       List.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 * 
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this '
	 * <code><b>setRoles</b></code>' to set the
	 *   '<code><b>roles</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param  role as '<code>List</code>' containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.UserProfileDTO
	 *  
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}