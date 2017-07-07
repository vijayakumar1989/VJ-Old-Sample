
/*
 * ILDAPUserAuthenticationDAO.java  
 * Version 1.0
 * Date  2011/14/01
 * Copyright (c) 2010 Sensiple Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Sensiple. ("Confidential
 * Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with
 * the terms of the license agreement you entered into
 * with Sensiple.
 * */
package com.labcorp.iris.authentication.dao;

import org.acegisecurity.GrantedAuthority;

import com.labcorp.iris.exception.auth.AUTHSecurityException;

 
/**
 * This is a customized <code>LdapUserAuthenticationDAO</code> used for user
 * authentication. 
 * 
 * @version 1.0
 * 
 * @date 2011/14/01   
 * 
 * 
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>LdapUserAuthenticationDAO</b></code>'. <!-- end-user-doc -->
 * 
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>
 *         {@link #com.labcorp.iris.authentication.dao.ILDAPUserAuthenticationDAO# authenticateUser<code>
 *         GrantedAuthority</code>} </li>
 *         </li>
 *         </ul>
 *         </p>
 * 
 */
public abstract interface ILDAPUserAuthenticationDAO {

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * This method is going to perform authentication for user <code>userId</code> and 
	 * <code>password</code> and it returns the user granted authorities using LDAP.
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
	 * @see com.labcorp.iris.authentication.dao.impl.LDAPUserAuthenticationDAOImpl
	 * @throws AUTHSecurityException
	 * 
	 */
	public abstract GrantedAuthority[] authenticateUser(final String userId,
			final String password) throws AUTHSecurityException;

}
