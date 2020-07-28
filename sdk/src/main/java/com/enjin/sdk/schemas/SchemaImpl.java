package com.enjin.sdk.schemas;

import com.enjin.sdk.TrustedPlatformMiddleware;
import com.enjin.sdk.schemas.player.PlayerSchema;
import com.enjin.sdk.schemas.project.ProjectSchema;

public class SchemaImpl extends GraphQLBaseService implements PlayerSchema, ProjectSchema {

    private final PlayerService playerService;
    private final ProjectService projectService;

    public SchemaImpl(TrustedPlatformMiddleware middleware) {
        super(middleware);
        this.playerService = (PlayerService) createService(PlayerService.class);
        this.projectService = (ProjectService) createService(ProjectService.class);
    }

}
