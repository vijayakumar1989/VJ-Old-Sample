/*
 * LDAPConnection.java  
 * Version 1.0
 * Date 2011/14/01
 * Copyright (c) 2010 Sensiple Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary
 * information of Sensiple. ("Confidential
 * Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with
 * the terms of the license agreement you entered into
 * with Sensiple.
 * */
 
package com.labcorp.iris.authentication.base;

import org.acegisecurity.ldap.DefaultInitialDirContextFactory;
import org.acegisecurity.ldap.LdapDataAccessException;
import org.acegisecurity.ldap.search.FilterBasedLdapUserSearch;
import org.acegisecurity.providers.ldap.authenticator.BindAuthenticator;
import org.acegisecurity.providers.ldap.populator.DefaultLdapAuthoritiesPopulator;
import org.apache.log4j.Logger;

import com.labcorp.iris.exception.auth.AUTHSecurityException;
import com.labcorp.iris.util.Constants;
import com.labcorp.iris.util.EnvUtility;

/** 
 * This is a customized <code>LDAPConnection</code> used for connect to the
 * LDAP server
 * 
 * @version 1.0
 * 
 * @date 2011/14/01
 * 
 * 
 * <!-- begin-user-doc --> An implementation of the model object '
 * <code><b>UserAuthenticationDAOImpl</b></code>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li> {@link com.labcorp.iris.authentication.base.LDAPConnection#init <code>
 * DefaultInitialDirContextFactory</code>}</li>
 * *<li> {@link com.labcorp.iris.authentication.base.LDAPConnection#getBindAuthenticator <code>
 * BindAuthenticator</code>}</li>
 *  <li> {@link com.labcorp.iris.authentication.base.LDAPConnection#getDefaultLdapAuthoritiesPopulator <code>
 * DefaultLdapAuthoritiesPopulator</code>}</li>
 * </ul>
 * <li> {@link com.labcorp.iris.authentication.base.LDAPConnection#getFilterBasedLdapUserSearch <code>
 * FilterBasedLdapUserSearch</code>}</li>
 *  <li> {@link com.labcorp.iris.authentication.base.LDAPConnection#init <code>
 * </p>
 * 
 */
public abstract class LDAPConnection {
	protected EnvUtility envUtility = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the searchBase
	 * </p>
	 * <!-- end-user-doc -->
	 */protected String searchBase = null;
	 /**
		 * <!-- begin-user-doc -->
		 * <p>
		 *  This is used for assign the disName
		 * </p>
		 * <!-- end-user-doc -->
		 */
	protected String disName = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the userDnEmployees
	 * </p>
	 * <!-- end-user-doc -->
	 */protected String userDnEmployees = null;
	 /**
		 * <!-- begin-user-doc -->
		 * <p>
		 *  This is used for assign the userDnCustomers
		 * </p>
		 * <!-- end-user-doc -->
		 */
	protected String userDnCustomers = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the userDnSuppliers
	 * </p>
	 * <!-- end-user-doc -->
	 */
	protected String userDnSuppliers = null;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the ldapUrl
	 * </p>
	 * <!-- end-user-doc -->
	 */
	protected String ldapUrl = null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the ldapManagerDn
	 * </p>
	 * <!-- end-user-doc -->
	 */
	protected String ldapManagerDn = null;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the ldapManagerPassword
	 * </p>
	 * <!-- end-user-doc -->
	 */
	protected String ldapManagerPassword = null;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the groupRoleAttribute
	 * </p>
	 * <!-- end-user-doc -->
	 */
	protected String groupRoleAttribute = null;
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 *  This is used for assign the searchFilter
	 * </p>
	 * <!-- end-user-doc -->
	 */
	protected String searchFilter = null;
	
	protected Logger log = Logger.getLogger(getClass());
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the DefaultInitialDirContextFactory'
	 * <code><b>initialContext</b></code>' containment reference. <!--
	 * end-user-doc -->
	 * 
	 */
	protected DefaultInitialDirContextFactory initialContext = null;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the BindAuthenticator'
	 * <code><b>authenticator</b></code>' containment reference. <!--
	 * end-user-doc -->
	 * 
	 * @see org.acegisecurity.providers.ldap.authenticator.BindAuthenticator;
	 * 
	 */
	protected BindAuthenticator authenticator;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * Returns the value of the DefaultInitialDirContextFactory'
	 * <code><b>contextFactory</b></code>' containment reference.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see org.acegisecurity.ldap.DefaultInitialDirContextFactory
	 */
	protected DefaultInitialDirContextFactory contextFactory;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the FilterBasedLdapUserSearch'
	 * <code><b>ldapSearch</b></code>' containment reference. <!--
	 * end-user-doc -->
	 * 
	 * @see org.acegisecurity.ldap.search.FilterBasedLdapUserSearch;
	 * 
	 */
	protected FilterBasedLdapUserSearch ldapSearch;

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the '<code><b>patterns</b></code>' containment
	 * reference.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 */

	protected FilterBasedLdapUserSearch filterBasedLdapUserSearch=null;
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * 
	 * Returns the value of the DefaultLdapAuthoritiesPopulator'
	 * <code><b>populator</b></code>' containment reference. <!--
	 * end-user-doc -->
	 * 
	 * @see org.acegisecurity.providers.ldap.populator.DefaultLdapAuthoritiesPopulator;
	 * 
	 */
	protected DefaultLdapAuthoritiesPopulator populator;


	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getContextFactory</b></code>' to
	 * get the '<code><b>contextFactory</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>contextFactory</code>' containment
	 *         reference.
	 */
	public DefaultInitialDirContextFactory getContextFactory() {
		return contextFactory;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setContextFactory</b></code>' to
	 * set the '<code><b>contextFactory</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param contextFactory
	 *            as '<code>DefaultInitialDirContextFactory</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public void setContextFactory(DefaultInitialDirContextFactory contextFactory) {
		this.contextFactory = contextFactory;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getSearchBase</b></code>' to
	 * get the '<code><b>searchBase</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>searchBase</code>' containment
	 *         reference.
	 */
	public final String getSearchBase() {
		return searchBase;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setSearchBase</b></code>' to
	 * set the '<code><b>searchBase</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param contextFactory
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setSearchBase(String searchBase) {
		this.searchBase = searchBase;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getDisName</b></code>' to
	 * get the '<code><b>disName</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>disName</code>' containment
	 *         reference.
	 */
	public final String getDisName() {
		return disName;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setDisName</b></code>' to
	 * set the '<code><b>disName</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param disName
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setDisName(String disName) {
		this.disName = disName;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getUserDnEmployees</b></code>' to
	 * get the '<code><b>userDnEmployees</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>userDnEmployees</code>' containment
	 *         reference.
	 */
	public final String getUserDnEmployees() {
		return userDnEmployees;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setUserDnEmployees</b></code>' to
	 * set the '<code><b>userDnEmployees</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param userDnEmployees
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setUserDnEmployees(String userDnEmployees) {
		this.userDnEmployees = userDnEmployees;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getUserDnCustomers</b></code>' to
	 * get the '<code><b>userDnCustomers</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>userDnCustomers</code>' containment
	 *         reference.
	 */
	public final String getUserDnCustomers() {
		return userDnCustomers;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setUserDnCustomers</b></code>' to
	 * set the '<code><b>userDnCustomers</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param userDnCustomers
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setUserDnCustomers(String userDnCustomers) {
		this.userDnCustomers = userDnCustomers;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getUserDnSuppliers</b></code>' to
	 * get the '<code><b>userDnSuppliers</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>userDnSuppliers</code>' containment
	 *         reference.
	 */
	public final String getUserDnSuppliers() {
		return userDnSuppliers;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setUserDnSuppliers</b></code>' to
	 * set the '<code><b>userDnSuppliers</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param userDnSuppliers
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setUserDnSuppliers(String userDnSuppliers) {
		this.userDnSuppliers = userDnSuppliers;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getLdapUrl</b></code>' to
	 * get the '<code><b>ldapUrl</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>ldapUrl</code>' containment
	 *         reference.
	 */
	public final String getLdapUrl() {
		return ldapUrl;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setLdapUrl</b></code>' to
	 * set the '<code><b>ldapUrl</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param ldapUrl
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setLdapUrl(String ldapUrl) {
		this.ldapUrl = ldapUrl;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getLdapManagerDn</b></code>' to
	 * get the '<code><b>ldapManagerDn</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>ldapManagerDn</code>' containment
	 *         reference.
	 */
	public final String getLdapManagerDn() {
		return ldapManagerDn;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setLdapManagerDn</b></code>' to
	 * set the '<code><b>ldapManagerDn</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param ldapManagerDn
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setLdapManagerDn(String ldapManagerDn) {
		this.ldapManagerDn = ldapManagerDn;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getLdapManagerPassword</b></code>' to
	 * get the '<code><b>ldapManagerPassword</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>ldapManagerPassword</code>' containment
	 *         reference.
	 */
	public final String getLdapManagerPassword() {
		return ldapManagerPassword;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setLdapManagerPassword</b></code>' to
	 * set the '<code><b>ldapManagerPassword</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param ldapManagerPassword
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setLdapManagerPassword(String ldapManagerPassword) {
		this.ldapManagerPassword = ldapManagerPassword;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getGroupRoleAttribute</b></code>' to
	 * get the '<code><b>groupRoleAttribute</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>groupRoleAttribute</code>' containment
	 *         reference.
	 */
	public final String getGroupRoleAttribute() {
		return groupRoleAttribute;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setGroupRoleAttribute</b></code>' to
	 * set the '<code><b>groupRoleAttribute</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param groupRoleAttribute
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setGroupRoleAttribute(String groupRoleAttribute) {
		this.groupRoleAttribute = groupRoleAttribute;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getSearchFilter</b></code>' to
	 * get the '<code><b>searchFilter</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>searchFilter</code>' containment
	 *         reference.
	 */
	public final String getSearchFilter() {
		return searchFilter;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setSearchFilter</b></code>' to
	 * set the '<code><b>searchFilter</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param searchFilter
	 *            as '<code>String</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getContextFactory</b></code>' to
	 * get the '<code><b>contextFactory</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>initialContext</code>' containment
	 *         reference is DefaultInitialDirContextFactory.
	 */
	public final DefaultInitialDirContextFactory getInitialContext() {
		return initialContext;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setInitialContext</b></code>' to
	 * set the '<code><b>initialContext</b></code>' containment reference.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param initialContext
	 *            as '<code>DefaultInitialDirContextFactory</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setInitialContext(
			DefaultInitialDirContextFactory initialContext) {
		this.initialContext = initialContext;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getAuthenticator</b></code>' to
	 * get the '<code><b>authenticator</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>authenticator</code>' containment
	 *         reference.
	 */
	public final BindAuthenticator getAuthenticator() {
		return authenticator;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setAuthenticator</b></code>' to
	 * set the '<code><b>authenticator</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param authenticator
	 *            as '<code>BindAuthenticator</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setAuthenticator(BindAuthenticator authenticator) {
		this.authenticator = authenticator;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getLdapSearch</b></code>' to
	 * set the '<code><b>ldapSearch</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param ldapSearch
	 *            as '<code>FilterBasedLdapUserSearch</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final FilterBasedLdapUserSearch getLdapSearch() {
		return ldapSearch;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setLdapSearch</b></code>' to
	 * set the '<code><b>ldapSearch</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param contextFactory
	 *            as '<code>FilterBasedLdapUserSearch</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setLdapSearch(FilterBasedLdapUserSearch ldapSearch) {
		this.ldapSearch = ldapSearch;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getPatterns</b></code>' to
	 * get the '<code><b>patterns</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>patterns</code>'  array list containment
	 *         reference.
	 */
	public final String[] getPatterns() {
		return patterns;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setPatterns</b></code>' to
	 * set the '<code><b>patterns</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param patterns
	 *            as '<code>String</code>' array list
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setPatterns(String[] patterns) {
		this.patterns = patterns;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getFilterBasedLdapUserSearch</b></code>' to
	 * get the '<code><b>filterBasedLdapUserSearch</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>filterBasedLdapUserSearch</code>' containment
	 *         reference.
	 */
	public final FilterBasedLdapUserSearch getFilterBasedLdapUserSearch() {
		return filterBasedLdapUserSearch;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setFilterBasedLdapUserSearch</b></code>' to
	 * set the '<code><b>filterBasedLdapUserSearch</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param filterBasedLdapUserSearch
	 *            as '<code>FilterBasedLdapUserSearch</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setFilterBasedLdapUserSearch(
			FilterBasedLdapUserSearch filterBasedLdapUserSearch) {
		this.filterBasedLdapUserSearch = filterBasedLdapUserSearch;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>getPopulator</b></code>' to
	 * get the '<code><b>populator</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>populator</code>' containment
	 *         reference.
	 */
	public final DefaultLdapAuthoritiesPopulator getPopulator() {
		return populator;
	}
	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of this ' <code><b>setPopulator</b></code>' to
	 * set the '<code><b>populator</b></code>' containment reference..
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @param contextFactory
	 *            as '<code>DefaultLdapAuthoritiesPopulator</code>'
	 *            containment reference.
	 * @return the value of the '<code>void</code>' containment reference is
	 *         void.
	 * 
	 */
	public final void setPopulator(DefaultLdapAuthoritiesPopulator populator) {
		this.populator = populator;
	}

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * <p>
	 * Returns the  array value of the '<code><b>patterns</b></code>' containment
	 * reference.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * 
	 */
	protected String[] patterns = {
			EnvUtility.getInstance().getProperty("userDn.employees"),
			EnvUtility.getInstance().getProperty("userDn.customers"),
			EnvUtility.getInstance().getProperty("userDn.suppliers")};

	/**
	 * 
	 * <!-- begin-user-doc -->
	 * Creates a  instance for LDAPConnection 
	 * <!-- end-user-doc -->
	 * @see com.labcorp.iris.auth.util.LDAPConnection
	 * 
	 */
	protected LDAPConnection() {
		envUtility = EnvUtility.getInstance();
		this.searchBase =  envUtility.getProperty("search.base");
		this.searchFilter = envUtility.getProperty("search.filter");
		this.groupRoleAttribute = envUtility.getProperty("groupRoleAttribute");

		/*this.userDnEmployees = envUtility.getProperty("userDn.employees");
		this.userDnCustomers = envUtility.getProperty("userDn.customers");
		this.userDnSuppliers = envUtility.getProperty("userDn.suppliers");*/

		this.ldapUrl = envUtility.getProperty("ldap.url");
		this.ldapManagerDn = envUtility.getProperty("ldap.managerDn");
		this.ldapManagerPassword = envUtility.getProperty("ldap.managerPassword");

		this.contextFactory = init(ldapUrl,ldapManagerDn,ldapManagerPassword);
		this.filterBasedLdapUserSearch=getFilterBasedLdapUserSearch(contextFactory, searchBase, searchFilter);
		this.authenticator=getBindAuthenticator(contextFactory, searchBase, patterns);
		this.populator=getDefaultLdapAuthoritiesPopulator(contextFactory, searchBase, groupRoleAttribute);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of the method ' <code><b>init</b></code>' to
	 * perform the connection with LDAP based on url, managerDistinguisedName
	 * and ManagerPassword .
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>DefaultInitialDirContextFactory</code>'
	 *         containment reference.
	 * @see com.labcorp.iris.auth.util.LDAPConnection
	 * @throws AUTHSecurityException
	 * 
	 */
	protected DefaultInitialDirContextFactory init(String ldapUrl,String ldapManagerDisName, String password)
	throws LdapDataAccessException {
		if(log.isInfoEnabled())
			log.info("Beginning of the DefaultInitialDirContextFactory#init");
		initialContext = new DefaultInitialDirContextFactory(ldapUrl);
		initialContext.setManagerDn(ldapManagerDisName);
		initialContext.setManagerPassword(password);
		if(log.isInfoEnabled())
			log.info("End of the DefaultInitialDirContextFactory.init");
		return initialContext;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of the method ' <code><b>getBindAuthenticator</b></code>'  simply attempts to bind as the user based on the dirContextFactory,searchBase, patterns.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<code>BindAuthenticator</code>'
	 *         containment reference.
	 * @see com.labcorp.iris.authentication.base.LDAPConnection
	 * 
	 */
	protected BindAuthenticator getBindAuthenticator(
			DefaultInitialDirContextFactory dirContextFactory,
			String searchBase, String[] patterns) {
		if(log.isInfoEnabled())
			log.info("Beginning of the BindAuthenticator#getBindAuthenticator");
		authenticator = new BindAuthenticator(dirContextFactory);
		authenticator.setUserDnPatterns(patterns);
		authenticator.setUserSearch(ldapSearch);
		if(log.isInfoEnabled())
			log.info("End of the BindAuthenticator.getBindAuthenticator");
		return authenticator;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of the method ' <code><b>getFilterBasedLdapUserSearch</b></code>' to perform filter based 
	 * ldap search operation based on the search base ,search filter,directory context factory 
	 * and which can be supplied to the getBindAuthenticator method.
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>FilterBasedLdapUserSearch</code>'
	 *         containment reference.
	 *  @see com.labcorp.iris.authentication.base.LDAPConnection
	 * 
	 */
	protected FilterBasedLdapUserSearch getFilterBasedLdapUserSearch(
			DefaultInitialDirContextFactory dirContextFactory,
			String searchBase, String searchFilter) {
		if(log.isInfoEnabled())
			log.info("Beginning of the FilterBasedLdapUserSearch#getFilterBasedLdapUserSearch");
		ldapSearch = new FilterBasedLdapUserSearch(searchBase, searchFilter,dirContextFactory);
		ldapSearch.setSearchSubtree(true);
		if(log.isInfoEnabled())
			log.info("End of the FilterBasedLdapUserSearch.getFilterBasedLdapUserSearch");
		return ldapSearch;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * An implementation of the method ' <code><b>getDefaultLdapAuthoritiesPopulator</b></code>' to
	 * load the authorities by searching the directory for groups of which the user is a member 
	 * 
	 * </p>
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * 
	 * @return the value of the '<code>DefaultLdapAuthoritiesPopulator</code>'
	 *         containment reference.
	 * @see com.labcorp.iris.authentication.base.LDAPConnection
	 * 
	 */
	protected DefaultLdapAuthoritiesPopulator getDefaultLdapAuthoritiesPopulator(
			DefaultInitialDirContextFactory dirContextFactory,
			String searchBase, String groupRoleAttribute) {
		if(log.isInfoEnabled())
			log.info("Beginning of the DefaultLdapAuthoritiesPopulator#getDefaultLdapAuthoritiesPopulator");
		populator = new DefaultLdapAuthoritiesPopulator(dirContextFactory,searchBase);
		populator.setGroupRoleAttribute(groupRoleAttribute);
		populator.setSearchSubtree(true);
		if(log.isInfoEnabled())
			log.info("End of the DefaultLdapAuthoritiesPopulator.getDefaultLdapAuthoritiesPopulator");
		return populator;
	}
}
