package com.enjin.sdk.schemas;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.schemas.player.PlayerSchema;
import com.enjin.sdk.schemas.project.ProjectSchema;

public class SchemaImpl extends BaseService implements PlayerSchema, ProjectSchema {

    public SchemaImpl(TrustedPlatformMiddleware middleware) {
        super(middleware);
    }

}
