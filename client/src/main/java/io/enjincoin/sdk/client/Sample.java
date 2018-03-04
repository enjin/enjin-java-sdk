package io.enjincoin.sdk.client;

import java.io.IOException;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.IdentityField;
import io.enjincoin.sdk.client.service.identities.vo.LinkIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.LinkIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityRequestBody;
import io.enjincoin.sdk.client.service.identities.vo.UpdateIdentityResponseBody;
import retrofit2.Response;

public class Sample {

    public static void main(String... args) {
        if (args.length == 0)
            return;
        try (Client client = new ClientImpl(args[0])) {
            IdentitiesService service = client.getIdentitiesService();

            System.out.println(String.format("%s...", "creating"));
            Response<CreateIdentityResponseBody> create = service.createIdentitySync();
            if (create.isSuccessful()) {
                System.out.println(String.format("%s was successful", "creating"));
                System.out.println(String.format("%s...", "updating"));
                Response<UpdateIdentityResponseBody> update = service.updateIdentitySync(create.body().getId().get(),
                        new UpdateIdentityRequestBody(java.util.Optional.of(new IdentityField[]{
                                new IdentityField("player_name", "l33t gamer")
                        })));
                if (update.isSuccessful()) {
                    System.out.println(String.format("%s was successful", "updating"));
                    System.out.println(String.format("%s...", "linking"));
                    Response<LinkIdentityResponseBody> link = service.linkIdentitySync(create.body().getLinkingCode().get(),
                            new LinkIdentityRequestBody("0xc5C2a211c1B1c262481801bfdb5f7970f72b9a88"));
                    if (link.isSuccessful()) {
                        System.out.println(String.format("%s was successful", "linking"));
                        System.out.println(String.format("%s...", "deleting"));
                        Response<Boolean> delete = service.deleteIdentitySync(create.body().getId().get());
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
