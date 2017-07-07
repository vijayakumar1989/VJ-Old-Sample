/*
 * UserAuthenticationBusinessImpl.java  
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
package com.labcorp.iris.authentication.bs.impl;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.log4j.Logger;

import com.labcorp.iris.authentication.bs.IUserAuthenticationBusiness;
import com.labcorp.iris.authentication.dao.IDBUserAuthenticationDAO;
import com.labcorp.iris.authentication.dao.ILDAPUserAuthenticationDAO;
import com.labcorp.iris.exception.auth.AUTHSecurityException;
import com.labcorp.iris.util.Constants;
import com.labcorp.iris.util.EnvUtility;
 
/**
 * This is a customized <code>UserAuthenticationBusinessImpl</code> used for
 * dynamic data based authentication for IRIS application.
 * 
 * @version 1.0
 * 
 * @date 2010/29/12     
 * 
 * 
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>UserAuthenticationBusinessImpl</b></code>'. <!--
 *         end-user-doc -->
 * 
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>
 *         {@link com.labcorp.iris.authentication.bs.impl.UserAuthenticationBusinessImpl#getDbUserAuthenticationDAO
 *         <code>IDBUserAuthenticationDAO</code>}</li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.bs.impl.UserAuthenticationBusinessImpl#authenticateProvider
 *         <code>GrantedAuthority</code>}</li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.bs.impl.UserAuthenticationBusinessImpl#setDbUserAuthenticationDAO
 *         <code>void</code>}</li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.bs.impl.UserAuthenticationBusinessImpl#setLdapUserAuthenticationDAO
 *         <code>void</code>}</li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.bs.impl.UserAuthenticationBusinessImpl#getLdapUserAuthenticationDAO
 *         <code>ILDAPUserAuthenticationDAO</code>}</li>
 *         </ul>
 *         </p>
 * 
 */

public class UserAuthenticationBusinessImpl implements
IUserAuthenticationBusiness {

	protected  Logger log = Logger.getLogger(getClass());
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the IUserAuthenticationDAO'
	 * <code><b>dbUserAuthenticationDAO</b></code>' containment reference. <!--
	 * end-user-doc -->
	 * 
	 * @see com.labcorp.iris.authentication.dao.IDBUserAuthenticationDAO
	 * 
	 */
	protected IDBUserAuthenticationDAO dbUserAuthenticationDAO;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the LdapUserAuthenticationDAO'
	 * <code><b>ldapUserAuthenticationDAO</b></code>' containment reference.
	 * <!-- end-user-doc -->
	 * 
	 * @see com.labcorp.iris.authentication.dao.ILDAPUserAuthenticationDAO
	 * 
	 */
	protected ILDAPUserAuthenticationDAO ldapUserAuthenticationDAO;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getLdapUserAuthenticationDAO</b></code>' to get the '
	 * <code><b>ldapUserAuthenticationDAO</b></code>' containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>ldapUserAuthenticationDAO</code>'
	 *         containment reference is LdapUserAuthenticationDAO
	 * 
	 */
	public ILDAPUserAuthenticationDAO getLdapUserAuthenticationDAO() {
		return ldapUserAuthenticationDAO;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>setLdapUserAuthenticationDAO</b></code>' to set the '
	 * <code><b>ldapUserAuthenticationDAO</b></code>' containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param ldapUserAuthenticationDAO
	 *            as '<code>LdapUserAuthenticationDAO</code>' containment
	 *            reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public void setLdapUserAuthenticationDAO(
			ILDAPUserAuthenticationDAO ldapUserAuthenticationDAO) {
		this.ldapUserAuthenticationDAO = ldapUserAuthenticationDAO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the Granted Authority '
	 * <code><b>authorities</b></code>' containment reference. <!-- end-user-doc
	 * -->
	 * 
	 * @see org.acegisecurity.GrantedAuthority
	 */
	protected GrantedAuthority[] authorities;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the UserDetails ' <code><b>user</b></code>'
	 * containment reference. <!-- end-user-doc -->
	 * 
	 * @see org.acegisecurity.userdetails.UserDetails
	 */
	protected UserDetails user = null;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getDbUserAuthenticationDAO</b></code>' to get the '
	 * <code><b>IDBUserAuthenticationDAO</b></code>' containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>dbUserAuthenticationDAO</code>'
	 *         containment reference is IDBUserAuthenticationDAO
	 * 
	 */
	public IDBUserAuthenticationDAO getDbUserAuthenticationDAO() {
		return dbUserAuthenticationDAO;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>setDbUserAuthenticationDAO</b></code>' to set the '
	 * <code><b>dbUserAuthenticationDAO</b></code>' containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param dbUserAuthenticationDAO
	 *            as '<code>IDBUserAuthenticationDAO</code>' containment
	 *            reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public void setDbUserAuthenticationDAO(
			IDBUserAuthenticationDAO dbUserAuthenticationDAO) {
		this.dbUserAuthenticationDAO = dbUserAuthenticationDAO;
	}

	

	@Override
	public GrantedAuthority[] authenticateProvider(String userId,
			String password) throws AUTHSecurityException {
		if (log.isInfoEnabled())
			log.info("Beginning of UserAuthenticationBusinessImpl # authenticateProvider");
		log.info("Invoking AUTH_PROVIDER_TYPE : "+ Constants.AUTH_PROVIDER_TYPE);

		if (Constants.AUTH_PROVIDER_TYPE != null
				&& Constants.AUTH_PROVIDER_TYPE
						.equalsIgnoreCase(Constants.IS_LDAP)) {
			authorities = ldapUserAuthenticationDAO.authenticateUser(userId,password);
		} 

		else if (Constants.AUTH_PROVIDER_TYPE != null
				&& Constants.AUTH_PROVIDER_TYPE
						.equalsIgnoreCase(Constants.IS_DB)) {
			authorities = dbUserAuthenticationDAO.authenticateUser(userId,password);
		} else {
			throw new AUTHSecurityException("Authenticate Provider not available");
		}
		if (log.isInfoEnabled())
			log.info("End of the method UserAuthenticationBusinessImpl#authenticateProvider");
		return authorities;
	}

}
