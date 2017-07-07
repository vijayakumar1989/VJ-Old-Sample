/*
 * LoginDetail.java  
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

/**
 * This DTO contains the information related to user . It contains user
 * information along with allocated roles.
 *
 * 
 * @version 1.0
 * 
 * @date 2010/29/12  
 * 
 *  
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>LoginDetail</b></code>'. <!--
 *         end-user-doc -->
 * 
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#getRegno}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#setRegno}</li>
 *         </li>
 *        <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#getName}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#setName}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#getUsername}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#setUsername}</li>
 *         </li>
 *        <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#getPassword}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#setPassword}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#getRole}</li>
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.dto.LoginDetail#setRole}</li>
 *         </li>
 *         </ul>
 *         </p>
 * */
public class LoginDetail extends AuthDTO{

	private static final long serialVersionUID = 1L;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the regno
	 * </p>
	 * <!-- end-user-doc -->
	 */
	private Integer regno;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the name
	 * </p>
	 * <!-- end-user-doc -->
	 */
	private String name;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the username
	 * </p>
	 * <!-- end-user-doc -->
	 */
	private String username;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the password 
	 * </p>
	 * <!-- end-user-doc -->
	 */
	private String password;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the role
	 * </p>
	 * <!-- end-user-doc -->
	 */
	private String role;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Creates a default LoginDetail constructor
	 * 
	 * <!-- end-user-doc -->
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 * 
	 */
	public LoginDetail() {
		
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getRegno</b></code>' to get the
	 *   '<code><b>regno</b></code>'
	 * containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>regno</code>' containment reference is
	 *        Integer.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 * 
	 */
	public Integer getRegno() {
		return regno;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this '
	 * <code><b>setRegno</b></code>' to set the
	 *   '<code><b>roles</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param  regno as '<code>Integer</code>' containment reference.
	 * @return the value of the '<code>regno</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 *  
	 */
	public void setRegno(Integer regno) {
		this.regno = regno;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getName</b></code>' to get the
	 *   '<code><b>name</b></code>'
	 * containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>name</code>' containment reference is
	 *        String.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 * 
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this '
	 * <code><b>setName</b></code>' to set the
	 *   '<code><b>name</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param  name as '<code>String</code>' containment reference.
	 * @return the value of the '<code>name</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 *  
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getUsername</b></code>' to get the
	 *   '<code><b>username</b></code>'
	 * containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>username</code>' containment reference is
	 *        String.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 * 
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this '
	 * <code><b>setUsername</b></code>' to set the
	 *   '<code><b>roles</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param  username as '<code>String</code>' containment reference.
	 * @return the value of the '<code>username</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 *  
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
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
	 *   '<code><b>roles</b></code>'
	 * containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param  password as '<code>String</code>' containment reference.
	 * @return the value of the '<code>password</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 *  
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getRole</b></code>' to get the
	 *   '<code><b>role</b></code>'
	 * containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>role</code>' containment reference is
	 *        String.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 * 
	 */
	public String getRole() {
		return role;
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
	 * @param  role as '<code>void</code>' containment reference.
	 * @return the value of the '<code>role</code>' containment reference is
	 *        void.
	 * @see com.labcorp.iris.authentication.dto.LoginDetail
	 *  
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	 
	
}
