package com.enjin.sdk.services;

import com.enjin.sdk.models.Player;

/**
 * Used internally for player requests.
 */
public interface PlayerService extends Auth, Delete, GetOne<Player>, GetMany<Player> {
}
