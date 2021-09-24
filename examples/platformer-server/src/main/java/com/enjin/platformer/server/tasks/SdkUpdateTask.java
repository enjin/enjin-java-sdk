/* Copyright 2021 Enjin Pte Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
