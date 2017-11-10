package com.enjin.coin.sdk;

import java.util.logging.Logger;

import com.enjin.coin.sdk.config.EnjinConfig;
import com.enjin.coin.sdk.service.EventsService;
import com.enjin.coin.sdk.service.IdentitiesService;
import com.enjin.coin.sdk.service.TokensService;
import com.enjin.coin.sdk.service.TransactionRequestsService;

public class EnjinService {

	private static final Logger LOGGER = Logger.getLogger(EnjinService.class.getName());
	
	private EnjinConfig enjinConfig;
	private EventsService eventsService;
	private IdentitiesService identitiesService;
	private TokensService tokensService;
	private TransactionRequestsService transactionRequestsService;
	/**
	 * Class constructor
	 */
	public EnjinService(EnjinConfig enjinConfig) {
		if (enjinConfig == null) {
			LOGGER.warning("The enjinConfig passed in is null");
		}
		
		this.enjinConfig = enjinConfig;
	}
	
	/**
	 * Method to get the eventsService
	 * @return
	 */
	public EventsService getEventsService() {
		if (eventsService == null) {
			eventsService = new EventsService(enjinConfig);
		}
		return eventsService;
	}
	
	/**
	 * Method to get the identitiesService
	 * @return
	 */
	public IdentitiesService getIdentitiesService() {
		if (identitiesService == null) {
			identitiesService = new IdentitiesService(enjinConfig);
		}
		return identitiesService;
	}
	
	/**
	 * Method to get the tokensService
	 * @return
	 */
	public TokensService getTokensService() {
		if (tokensService == null) {
			tokensService = new TokensService(enjinConfig);
		}
		return tokensService;
	}
	/**
	 * Method to get the transactionRequestsService
	 * @return
	 */
	public TransactionRequestsService getTransactionRequestsService() {
		if (transactionRequestsService == null) {
			transactionRequestsService = new TransactionRequestsService(enjinConfig);
		}
		return transactionRequestsService;
	}
}
