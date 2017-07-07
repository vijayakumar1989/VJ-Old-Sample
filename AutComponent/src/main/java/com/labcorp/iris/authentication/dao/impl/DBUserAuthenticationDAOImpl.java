/*
 * DBUserAuthenticationDAOImpl.java  
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
package com.labcorp.iris.authentication.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

import com.labcorp.iris.authentication.dao.IDBUserAuthenticationDAO;
import com.labcorp.iris.authentication.dto.LoginDetail;
import com.labcorp.iris.dao.bs.impl.DAOBusinessServiceImpl;
import com.labcorp.iris.exception.auth.AUTHSecurityException;
import com.labcorp.iris.exception.connectivity.dao.DAOException;
import com.labcorp.iris.util.Constants;
 
/**
 * This is a customized <code>UserAuthenticationDAOImpl</code> used for uses
 * data available in memory to authenticate the user.
 * 
 * @version 1.0
 * 
 * @date 2010/29/12       
 * 
 *     
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>UserAuthenticationDAOImpl</b></code>'. <!-- end-user-doc
 *         -->
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>
 *         {@link #com.labcorp.iris.authentication.dao.impl.DBUserAuthenticationDAOImpl # authenticateUser <code>
 *         GrantedAuthority</code>}</li>
 *         </ul>
 *         </p>
 * 
 */
public class DBUserAuthenticationDAOImpl extends DAOBusinessServiceImpl implements
		IDBUserAuthenticationDAO {

	protected Logger log = Logger.getLogger(getClass());
	
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
	protected GrantedAuthority[] authorities = null;
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the GrantedAuthority list of the value is '<code><b>list</b></code>' containment
	 * reference. <!-- end-user-doc -->
	 * 
	 * @see org.acegisecurity.GrantedAuthority;
	 * 
	 */
	protected List<GrantedAuthority> list;
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the '<code><b>loginDetail</b></code>' containment
	 * reference. <!-- end-user-doc -->
	 * 
	 * @see  com.labcorp.iris.authentication.dto.LoginDetail;
	 * 
	 */
	protected LoginDetail loginDetail;
	
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the parameters '<code><b>parameters</b></code>' containment
	 * reference. <!-- end-user-doc -->
	 * 
	 */
	protected String[] parameters;
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the '<code><b>roles</b></code>' containment
	 * reference. <!-- end-user-doc -->
	 * 
	 */
	protected String roles = null;
	
	@Override
	public GrantedAuthority[] authenticateUser(String userId, String password)
			throws AUTHSecurityException {
	    if(log.isInfoEnabled())
		log.info("Beginning of the method UserAuthenticationDAOImpl # authenticateUser :"+userId+","+password);
		loginDetail = new LoginDetail();
		list = new ArrayList<GrantedAuthority>();
		try {
			parameters = new String[2];
			parameters[0] = userId;
			parameters[1] = password;
			loginDetail = (LoginDetail) this.getTransformedObject(parameters, Constants.SP_GETLOGIN, loginDetail);
			if (loginDetail != null) {
				roles = loginDetail.getRole();
					if (roles == null || roles.equals("")){
						throw new AUTHSecurityException("Roles not Assigned");
					}
					else{
						list.add(new GrantedAuthorityImpl(roles));
						authorities = (GrantedAuthority[]) (GrantedAuthority[]) list
								.toArray(new GrantedAuthority[list.size()]);
					}
			} else {
				throw new AUTHSecurityException("Invalid User/Password Provided");
			}
		} catch (DAOException e) {
			if(log.isEnabledFor(Priority.ERROR))
			log.error("Data base connection Exception occured in authenticateUser method: "+ e.getMessage());
			throw new AUTHSecurityException("Connection Invalid");
		}
		 if(log.isInfoEnabled())
		log.info("End of the method UserAuthenticationDAOImpl # authenticateUser ");
		return authorities;
	}

}
