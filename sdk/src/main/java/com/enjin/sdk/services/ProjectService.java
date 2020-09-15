package com.enjin.sdk.services;

import com.enjin.sdk.models.Project;

/**
 * Used internally for project requests.
 */
public interface ProjectService extends Auth, Delete, GetOne<Project> {
}
