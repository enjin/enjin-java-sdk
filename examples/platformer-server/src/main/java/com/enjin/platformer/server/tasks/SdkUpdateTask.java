package com.enjin.platformer.server.tasks;

import com.enjin.platformer.server.App;
import com.enjin.platformer.server.conf.Config;
import com.enjin.sdk.ProjectClient;
import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.models.AccessToken;
import com.enjin.sdk.schemas.project.queries.AuthProject;

import java.util.TimerTask;

public class SdkUpdateTask extends TimerTask {

    private ProjectClient sdk;
    private Config config;

    public SdkUpdateTask(ProjectClient sdk, Config config) {
        this.sdk = sdk;
        this.config = config;
    }

    @Override
    public void run() {
        AuthProject request = new AuthProject().uuid(config.getAppUuid())
                                               .secret(config.getAppSecret());
        GraphQLResponse<AccessToken> response = sdk.authProject(request);
        if (!response.isSuccess())
            App.getInstance().exit();

        AccessToken accessToken = response.getData();
        sdk.auth(accessToken.getToken());
        if (!sdk.isAuthenticated())
            App.getInstance().exit();
    }

}
