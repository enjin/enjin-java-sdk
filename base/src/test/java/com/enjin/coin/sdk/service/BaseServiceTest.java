package com.enjin.coin.sdk.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.enjin.coin.sdk.service.IdentitiesService;

public class BaseServiceTest {

	BaseService baseAction;
	
	@Before
	public void setUp() {
		baseAction = new IdentitiesService();
	}
	
	@Test
	public void testContructor1() {
		baseAction = new IdentitiesService();
		assertNotNull(baseAction);
		assertNotNull(baseAction.toString());
	}
	
	@Test
	public void testContructor2() {
		baseAction = new IdentitiesService("http://localhost:8080");
		assertNotNull(baseAction);
		assertNotNull(baseAction.toString());
	}
	
	@Test
	public void testGetIdentitiesUrl1() {
		String identitiesURL = baseAction.getIdentitiesUrl();
		assertNotNull(identitiesURL);
	}
	
	@Test
	public void testGetIdentitiesUrl2() {
		baseAction.setTrustedPlatformUrl("http://localhost:8081");
		String identitiesURL = baseAction.getIdentitiesUrl();
		assertNotNull(identitiesURL);
	}
	
	@Test
	public void testGetIdentitiesUrl3() {
		baseAction.setTrustedPlatformUrl("http://localhost:8081/");
		String identitiesURL = baseAction.getIdentitiesUrl();
		assertNotNull(identitiesURL);
	}
	
	@Test
	public void testGetTokensUrl1() {
		String tokensURL = baseAction.getTokensUrl();
		assertNotNull(tokensURL);
	}
	
	@Test
	public void testGetTokensUrl2() {
		baseAction.setTrustedPlatformUrl("http://localhost:8081");
		String tokensURL = baseAction.getTokensUrl();
		assertNotNull(tokensURL);
	}
	
	@Test
	public void testGetTokensUrl3() {
		baseAction.setTrustedPlatformUrl("http://localhost:8081/");
		String tokensURL = baseAction.getTokensUrl();
		assertNotNull(tokensURL);
	}
	
	@Test
	public void testGetTransactionRequestsUrl1() {
		String transactionRequestsURL = baseAction.getTransactionRequestsUrl();
		assertNotNull(transactionRequestsURL);
	}
	
	@Test
	public void testGetTransactionRequestsUrl2() {
		baseAction.setTrustedPlatformUrl("http://localhost:8081");
		String transactionRequestsURL = baseAction.getTransactionRequestsUrl();
		assertNotNull(transactionRequestsURL);
	}
	
	@Test
	public void testGetTransactionRequestsUrl3() {
		baseAction.setTrustedPlatformUrl("http://localhost:8081/");
		String transactionRequestsURL = baseAction.getTransactionRequestsUrl();
		assertNotNull(transactionRequestsURL);
	}
	
	@Test
	public void testGetTrustedPlatformUrl_Null( ) {
		String trustedPlatformURL = baseAction.getTrustedPlatformUrl();
		assertNull(trustedPlatformURL);
	}
	@Test
	public void testGetTrustedPlatformUrl_Success( ) {
		baseAction.setTrustedPlatformUrl("http://localhost:8081/");
		String trustedPlatformURL = baseAction.getTrustedPlatformUrl();
		assertNotNull(trustedPlatformURL);
	}
	
}
