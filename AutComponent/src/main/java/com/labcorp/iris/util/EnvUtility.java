/*
 * EnvUtility.java  
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

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
/**
 *  
 * @version 1.0 
 * 
 * @date 2010/29/12  
 * 
 * 
 *         <!-- begin-user-doc --> An implementation of the model object '
 *         <code><b>EnvUtility</b></code>'. <!--
 *         end-user-doc -->
 * 
 *         <p>
 *         The following features are implemented:
 *         <ul>
 *         
 *         <li>
 *         {@link com.labcorp.iris.util.EnvUtility#getInstance <code>EnvUtility</code>}
 *         </li>
 *         <li>
 *         {@link com.labcorp.iris.util.EnvUtility#getProperty <code>String</code>}
 *         </li><li>
 *         {@link com.labcorp.iris.util.EnvUtility#createBundle <code>PropertyResourceBundle</code>}
 *         </li>
 *         </ul>
 *         </p>
 * 
 */
public class EnvUtility {
	protected  Logger log = Logger.getLogger(getClass());
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * This is used to create a EnvUtility object envInstance.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 */
	protected static EnvUtility envInstance = null;
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * This is used to create a PropertyResourceBundle variable bundle.
	 * <!-- end-user-doc -->
	 * 
	 */
	protected PropertyResourceBundle bundle = null;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getInstance</b></code>' to create an instace for 
	 * the '<code><b>EnvUtility</b></code>' 
	 * 
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * @return the value of the '<code>EnvUtility</code>' containment reference.
	 * 
	 */
	public static EnvUtility getInstance()
	{  
		if( envInstance == null )
		{
			envInstance = new EnvUtility();
		}
		return envInstance;
	}


	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getProperty</b></code>' to get
	 * the '<code><b>strKey</b></code>' from bundle 
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>strKey</code>' containment reference
	 *         is String.
	 * 
	 */
	public String getProperty( String strKey)
	{   if(log.isInfoEnabled())
		log.info("Beginning of the EnvUtility#getInstance ");
	if( bundle == null )
	{
		bundle = createBundle();
	}
	if(log.isInfoEnabled())
		log.info("End of the EnvUtility.getInstance ");
	return bundle.getString(strKey);
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>createBundle</b></code>' to load
	 * the properties using getResourceAsStream and getClassLoader 
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>PropertyResourceBundle</code>' containment reference
	 *         
	 * throws Runtime Exception
	 * 
	 */
	public synchronized PropertyResourceBundle createBundle()
	{
		try {
			if(log.isInfoEnabled())
				log.info("Beginning of the EnvUtility#createBundle ");
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("application.properties");
			if(log.isInfoEnabled())
				log.info("End of the EnvUtility.createBundle ");
			return new PropertyResourceBundle(is);
		} catch (IOException e) {
			if(log.isEnabledFor(Priority.ERROR));
			log.error("property file  is not loaded :"+e.getMessage());
			throw new RuntimeException( e.getMessage() );

		}

	}

}
