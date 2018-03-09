package io.enjincoin.sdk.client;

import java.io.IOException;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.IdentityField;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identity.IdentityService;
import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityRequestBody;
import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityResponseBody;
import retrofit2.Response;

public class Sample {

    public static void main(String... args) {
        if (args.length == 0)
            return;
        try (Client client = new ClientImpl(args[0])) {
            IdentitiesService identitiesService = client.getIdentitiesService();
            IdentityService identityService = client.getIdentityService();

            System.out.println(String.format("%s...", "creating"));
            Response<CreateIdentityResponseBody> create = identitiesService.createIdentitySync(1);
            if (create.isSuccessful()) {
                System.out.println(String.format("%s was successful", "creating"));
                System.out.println(String.format("%s...", "updating"));
                Response<UpdateIdentityResponseBody> update = identitiesService.updateIdentitySync(create.body().getId(),
                        new UpdateIdentityRequestBody(new IdentityField[]{
                                new IdentityField("player_name", "l33t gamer")
                        }));
                if (update.isSuccessful()) {
                    System.out.println(String.format("%s was successful", "updating"));
                    System.out.println(String.format("%s...", "linking"));
                    Response<LinkIdentityResponseBody> link = identityService.linkIdentitySync(create.body().getLinkingCode(),
                            new LinkIdentityRequestBody("0xc5C2a211c1B1c262481801bfdb5f7970f72b9a88"));
                    if (link.isSuccessful()) {
                        System.out.println(String.format("%s was successful", "linking"));
                        System.out.println(String.format("%s...", "deleting"));
                        Response<Boolean> delete = identitiesService.deleteIdentitySync(create.body().getId());
                        if (delete.isSuccessful()) {
                            System.out.println(String.format("%s was successful", "deleting"));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
