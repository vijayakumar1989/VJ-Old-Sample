/*
 * IDBAuthenticationAttributeMapper.java  
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
package com.labcorp.iris.authentication.dao.mapper;

import com.labcorp.iris.authentication.dto.LoginDetail;
import com.labcorp.iris.dao.bs.impl.DAOBusinessServiceImpl;
import com.labcorp.iris.exception.auth.AUTHSecurityException;
import com.labcorp.iris.exception.connectivity.dao.DAOException;
import com.labcorp.iris.util.Constants;

public class DBAuthenticationAttributeMapper extends DAOBusinessServiceImpl
		implements IDBAuthenticationAttributeMapper {
  
	/**        
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the '<code><b>loginDetail</b></code>'
	 * containment reference. <!-- end-user-doc -->
	 * 
	 * @see com.labcorp.iris.authentication.dto.LoginDetail;
	 * 
	 */
	public LoginDetail loginDetail = null;
	
	public DBAuthenticationAttributeMapper() {
		super();
	}
	

	/**
	 * @return the loginDetail
	 */
	public LoginDetail getLoginDetail() {
		return loginDetail;
	}

	/**
	 * @param loginDetail the loginDetail to set
	 */
	public void setLoginDetail(LoginDetail loginDetail) {
		this.loginDetail = loginDetail;
	}



	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the parameters '<code><b>parameters</b></code>'
	 * containment reference. <!-- end-user-doc -->
	 * 
	 */
	protected Object[] parameters;
	
	public DBAuthenticationAttributeMapper(String userId, String password) throws  AUTHSecurityException {
		log.info("this.loginDetail 1:");
		log.info("test 1 userId :"+userId+" and   password : "+password);
		this.loginDetail = getAuthenticatedUserDetails(userId, password);
		log.info("this.loginDetail 1:"+this.loginDetail);
	}

	protected LoginDetail getAuthenticatedUserDetails(String userId,
			String password) throws AUTHSecurityException {
		log.info("getAuthenticatedUserDetails : "+userId+"   and "+password);
		LoginDetail loginDetails = new LoginDetail();
		parameters = new Object[2];
		parameters[0] = userId;
		parameters[1] = password;
		log.info("test point 11");
		try {
			log.info("test 1:"+userId+"  ....,"+password);
			loginDetail = (LoginDetail) this.getTransformedObject(parameters,Constants.SP_GETLOGIN, loginDetails);
			log.info("test 2:"+loginDetail);
		} catch (DAOException e) {
			throw new AUTHSecurityException("Invalid operation:getAuthenticatedUserDetails");
		}
		return loginDetail;
	}
}
