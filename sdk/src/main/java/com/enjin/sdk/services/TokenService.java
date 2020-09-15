package com.enjin.sdk.services;

import com.enjin.sdk.models.Token;

/**
 * Used internally for token requests.
 */
public interface TokenService extends GetOne<Token>, GetMany<Token> {
}
