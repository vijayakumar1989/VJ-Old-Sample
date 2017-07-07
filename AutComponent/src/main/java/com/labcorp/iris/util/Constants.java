/*
 * Constants.java  
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
package com.labcorp.iris.util;
 
import java.util.ResourceBundle;
/**
 * 
 * This is a customized <code>Constants</code>Contains common constants related 
 * to application properties .
 * @version 1.0
 * 
 * @date 2010/29/12  
 * 
 * 
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>Constants</b></code>'. <!-- end-user-doc -->
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         <li>{@link com.labcorp.iris.util.Constants#IS_LDAP }</li>
 *         <li>{@link com.labcorp.iris.util.Constants#IS_DB }</li>
 *         <li>{@link com.labcorp.iris.util.Constants#AUTH_PROVIDER_TYPE }</li>
 *         </ul>
 *         </p>
 * 
 */
public final class Constants {
	/**
	 * A return code for authentication provider type.
	 */
	public static String  AUTH_PROVIDER_TYPE ;
	/**
	 * A return code for IS_LDAP.
	 */
	public static String  IS_LDAP = "LDAP";  
	/**
	 * A return code for IS_DB.
	 */
	public static String  IS_DB = "DB";  
	/**
	 * A return code for SP_GETLOGIN.
	 */
	public final static String SP_GETLOGIN;
	
	/**
	 * A return the authentication provider type
	 */
	static {

		String BUNDLE_NAME = "application";
		ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
		AUTH_PROVIDER_TYPE = RESOURCE_BUNDLE.getString("auth.provider.type").trim();
		SP_GETLOGIN = "GetLogin";
	}
	

}
