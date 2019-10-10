package com.enjin.sdk.service.roles;

import java.io.IOException;
import java.util.List;

import com.enjin.sdk.graphql.GraphQLResponse;
import com.enjin.sdk.http.HttpResponse;
import com.enjin.sdk.model.service.roles.CreateRole;
import com.enjin.sdk.model.service.roles.DeleteRole;
import com.enjin.sdk.model.service.roles.GetRoles;
import com.enjin.sdk.model.service.roles.Role;
import com.enjin.sdk.model.service.roles.UpdateRole;

public interface SynchronousRolesService {

    HttpResponse<GraphQLResponse<List<Role>>> getRolesSync(GetRoles query) throws IOException;

    HttpResponse<GraphQLResponse<Role>> createRoleSync(CreateRole query) throws IOException;

    HttpResponse<GraphQLResponse<Role>> deleteRoleSync(DeleteRole query) throws IOException;

    HttpResponse<GraphQLResponse<Role>> updateRoleSync(UpdateRole query) throws IOException;

}
