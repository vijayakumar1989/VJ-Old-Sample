/*
 * LDAPUserAuthenticationDAOImpl.java  
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
package com.labcorp.iris.authentication.dao.impl;

import org.acegisecurity.AuthenticationException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.ldap.LdapDataAccessException;
import org.acegisecurity.userdetails.ldap.LdapUserDetails;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.labcorp.iris.authentication.base.LDAPConnection;
import com.labcorp.iris.authentication.dao.ILDAPUserAuthenticationDAO;
import com.labcorp.iris.exception.auth.AUTHSecurityException;
  
/**
 * This is a customized <code>LdapUserAuthenticationDAOImpl</code> used for uses
 * data available in memory to authenticate the user.
 * 
 * @version 1.0
 * 
 * @date 2011/14/01     
 * 
 *    
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>LdapUserAuthenticationDAOImpl</b></code>'. <!-- end-user-doc
 *         -->
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>
 *         {@link # com.labcorp.iris.authentication.dao.impl.LDAPUserAuthenticationDAOImpl# authenticateUser
 *         <code>GrantedAuthority</code>}</li>
 *         </ul>
 *         </p>
 * 
 */
public class LDAPUserAuthenticationDAOImpl extends LDAPConnection implements ILDAPUserAuthenticationDAO {

	protected Logger log = Logger.getLogger(getClass());

	/**
	 * 
	 * <!-- begin-user-doc --> Creates a 
	 * <code>LDAPUserAuthenticationDAOImpl</code> instance.
	 * <!-- end-user-doc -->
	 *  throws {@link LdapDataAccessException}
	 * 
	 * @see com.labcorp.iris.authentication.dao.impl.LDAPUserAuthenticationDAOImpl
	 * 
	 */
	protected LDAPUserAuthenticationDAOImpl() throws LdapDataAccessException {
		super();
	}
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the '<code><b>userDetails</b></code>' containment
	 * reference. <!-- end-user-doc -->
	 * 
	 * @see org.acegisecurity.userdetails.ldap.LdapUserDetails;
	 * 
	 */
	protected LdapUserDetails userDetails;
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the '<code><b>authorities</b></code>' containment
	 * reference. <!-- end-user-doc -->
	 * 
	 * @see org.acegisecurity.GrantedAuthority;
	 * 
	 */
	protected GrantedAuthority[] authorities;
	
	@Override
	public GrantedAuthority[] authenticateUser(String userId, String password)
			throws AUTHSecurityException{
		try {
			if(log.isInfoEnabled())
			log.info("Beginning of the LdapUserAuthenticationDAOImpl # authenticateUser");
			
			try {
				userDetails =  authenticator.authenticate(userId, password);
			} catch (AuthenticationException e) {
				throw new AUTHSecurityException("Invalid User/Password Provided");
			}
			
			if (userDetails != null) {
				if(log.isInfoEnabled())
					log.info("invoking getGrantedAuthorities for userdetails");
				try {
					authorities = populator.getGrantedAuthorities(userDetails);
					if(authorities.length == 0){
						throw new AUTHSecurityException("Roles not Assigned");
					}
						
				} catch (LdapDataAccessException e) {
					throw new AUTHSecurityException("GrantedAuthorities Exception");
				}
			} else {
				if(log.isEnabledFor(Priority.WARN))
				log.warn("Invalid User Credential provided");
				throw new AUTHSecurityException("Invalid User/Password Provided");
			} 
		}
		catch (LdapDataAccessException e) {
			throw new AUTHSecurityException("Unable to connect to LDAP server");
		}
		return authorities;
	}

}
