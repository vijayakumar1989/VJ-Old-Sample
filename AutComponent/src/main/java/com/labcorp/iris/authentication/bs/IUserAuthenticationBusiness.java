/*
 * IUserAuthenticationBusiness.java  
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
package com.labcorp.iris.authentication.bs;

import org.acegisecurity.GrantedAuthority;

import com.labcorp.iris.exception.auth.AUTHSecurityException;
 

/**
 * This is a customized <code>IUserAuthenticationBusiness</code> used for 
 * select which type of user authentication and perform the user authentication. 
 * 
 * 
 * @version 1.0
 * 
 * @date 2010/29/12
 * 
 * 
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>IUserAuthenticationBusiness</b></code>'. <!-- end-user-doc -->
 * 
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>
 *         {@link #com.labcorp.iris.authentication.bs.IUserAuthenticationBusiness# authenticateProvider<code>
 *         GrantedAuthority</code>} </li>
 *         </li>
 *         </ul>
 *         </p>
 * 
 */
public abstract interface IUserAuthenticationBusiness {
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  perform user authentication  based on the 
	 * <code>userId</code> and  <code>password</code> information.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param userId
	 *            as '<code>String</code>' containment reference.
	 * @param password
	 *            as '<code>String</code>' containment reference.
	 * @return the value of the '<code>GrantedAuthority</code>'
	 *         containment reference as array of object.
	 * @see com.labcorp.iris.authentication.bs.impl.UserAuthenticationBusinessImpl
	 * @throws AUTHSecurityException
	 * 
	 */
	public abstract GrantedAuthority[] authenticateProvider(final String userId,final String password)
			throws AUTHSecurityException;
		
}
