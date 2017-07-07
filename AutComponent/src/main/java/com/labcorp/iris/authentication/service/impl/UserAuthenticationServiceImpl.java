/*
 * UserAuthenticationServiceImpl.java  
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
package com.labcorp.iris.authentication.service.impl;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.userdetails.User;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.log4j.Logger;

import com.labcorp.iris.authentication.bs.IUserAuthenticationBusiness;
import com.labcorp.iris.exception.auth.AUTHSecurityException;
 
/**
 * This is a customized <code>UserAuthenticationServiceImpl</code> used for
 * dynamic data based authentication for IRIS application.
 * 
 * @version 1.0
 * 
 * @date 2010/29/12  
 * 
 * 
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>UserAuthenticationServiceImpl</b></code>'. <!-- end-user-doc
 *         -->
 * 
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>
 *         {@link com.labcorp.iris.authentication.service.impl.UserAuthenticationServiceImpl#getUserAuthenticationBusiness
 *         <code>IUserAuthenticationBusiness</code>}</li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.service.impl.UserAuthenticationServiceImpl#setUserAuthenticationBusiness
 *         <code>void</code>}</li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.service.impl.UserAuthenticationServiceImpl#supports
 *         <code>Boolean</code>}</li>
 *         <li>
 *         {@link com.labcorp.iris.authentication.service.impl.UserAuthenticationServiceImpl#authenticate
 *         <code>Authentication</code>}</li>
 *         </ul>
 *         </p>
 * 
 */
public class UserAuthenticationServiceImpl implements AuthenticationProvider {

	protected Logger log = Logger.getLogger(getClass());

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the IUserAuthenticationBusiness'
	 * <code><b>iUserAuthenticationBusiness</b></code>' containment reference.
	 * <!-- end-user-doc -->
	 * 
	 * @see com.labcorp.iris.authentication.bs.IUserAuthenticationBusiness
	 * 
	 */
	protected IUserAuthenticationBusiness userAuthenticationBusiness;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the UserDetails'<code><b>userDetails</b></code>'
	 * containment reference. <!-- end-user-doc -->
	 * 
	 * @see org.acegisecurity.userdetails.UserDetails;
	 * 
	 */
	protected UserDetails userDetails = null;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the GrantedAuthority arrays'
	 * <code><b>authorities</b></code>' containment reference. <!-- end-user-doc
	 * -->
	 * 
	 * @see org.acegisecurity.GrantedAuthority
	 * 
	 */
	protected GrantedAuthority[] authorities;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>getUserAuthenticationBusiness</b></code>' to get the '
	 * <code><b>userAuthenticationBusiness</b></code>' containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>userAuthenticationBusiness</code>'
	 *         containment reference is '
	 *         <code>IUserAuthenticationBusiness</code>'
	 * 
	 */
	public IUserAuthenticationBusiness getUserAuthenticationBusiness() {
		return userAuthenticationBusiness;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this method'
	 * <code><b>setUserAuthenticationBusiness</b></code>' to set the '
	 * <code><b>userAuthenticationBusiness</b></code>' containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param userAuthenticationBusiness
	 *            as '<code>IUserAuthenticationBusiness</code>' containment
	 *            reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */

	public void setUserAuthenticationBusiness(
			IUserAuthenticationBusiness userAuthenticationBusiness) {
		this.userAuthenticationBusiness = userAuthenticationBusiness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of the authenticate service '
	 * <code><b>authenticate</b></code>' to perform the authentication based on
	 * the user data provided.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param authentication
	 *            as '<code>Authentication</code>' containment reference.
	 * @return the value of the '<code>Authentication</code>' containment
	 *         reference.
	 * @see org.acegisecurity.providers.AuthenticationProvider#authenticate(org.acegisecurity.Authentication)
	 * @throws AuthenticationException
	 * 
	 */
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		if(log.isInfoEnabled())
		log.info("Beginning of the UserAuthenticationServiceImpl#authenticate : " + authentication);
		String userId = null;
		String password = null;

		userId = authentication.getPrincipal().toString();
		password = authentication.getCredentials().toString();

		if (userId != null && !userId.equals("") && password != null
				&& !password.equals("")) {
			try {
				authorities = userAuthenticationBusiness.authenticateProvider(userId, password);
				userDetails = new User(authentication.getPrincipal().toString(),
						authentication.getCredentials().toString(), true, true, true, true, authorities);
				UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
						userDetails, authentication.getCredentials(), userDetails.getAuthorities());
				result.setDetails(authentication.getDetails());
				if(log.isInfoEnabled())
				log.info("End of UserAuthenticationServiceImpl#authenticate");
				return result;
			} catch (AUTHSecurityException e) {
				log.error("AUTHSecurityException " + e.getMessage());
				throw new BadCredentialsException(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of the supports service '<code><b>supports</b></code>'
	 * to provide the UsernamePasswordAuthenticationToken.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param authentication
	 *            as '<code>Class</code>' containment reference.
	 * @return the value of the '<code>boolean</code>' containment true or
	 *         false} .
	 * @see org.acegisecurity.providers.AuthenticationProvider#supports(java.lang.Class)
	 * 
	 */

	public boolean supports(Class authentication) {
		return (UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(authentication));
	}

}
