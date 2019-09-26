package com.enjin.enjincoin.sdk.service.roles;

import java.util.List;

import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.http.HttpCallback;
import com.enjin.enjincoin.sdk.model.service.roles.CreateRole;
import com.enjin.enjincoin.sdk.model.service.roles.DeleteRole;
import com.enjin.enjincoin.sdk.model.service.roles.GetRoles;
import com.enjin.enjincoin.sdk.model.service.roles.Role;
import com.enjin.enjincoin.sdk.model.service.roles.UpdateRole;

public interface AsynchronousRolesService {

    void getRolesAsync(GetRoles query,
                       HttpCallback<GraphQLResponse<List<Role>>> callback);

    void createRoleAsync(CreateRole query,
                         HttpCallback<GraphQLResponse<Role>> callback);

    void deleteRoleAsync(DeleteRole query,
                         HttpCallback<GraphQLResponse<Role>> callback);

    void updateRoleAsync(UpdateRole query,
                         HttpCallback<GraphQLResponse<Role>> callback);

}
