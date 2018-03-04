package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.vo.CreateIdentityResponseBody;
import io.enjincoin.sdk.client.service.identities.vo.GetIdentityResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;

public class Sample {

    public static void main(String... args) {
        if (args.length == 0)
            return;
        try (Client client = new ClientImpl(args[0])) {
            IdentitiesService service = client.getIdentitiesService();

            service.getIdentitiesAsync(new Callback<GetIdentityResponseBody[]>() {
                @Override
                public void onResponse(Call<GetIdentityResponseBody[]> call, Response<GetIdentityResponseBody[]> response) {
                    System.out.println("1. Response received :)");
                    for (GetIdentityResponseBody vo : response.body()) {
                        System.out.println(vo.toString());
                    }
                }

                @Override
                public void onFailure(Call<GetIdentityResponseBody[]> call, Throwable t) {
                    System.out.println("1. Error received :(");
                    t.printStackTrace();
                }
            });

            service.getIdentitiesAsync(new HashMap<String, Object>() {{
                put("player_name", "Player Ten");
                put("New Field", "New Field Data");
            }}, new Callback<GetIdentityResponseBody[]>() {
                @Override
                public void onResponse(Call<GetIdentityResponseBody[]> call, Response<GetIdentityResponseBody[]> response) {
                    System.out.println("2. Response received :)");
                    System.out.println(call.request().toString());
                    for (GetIdentityResponseBody vo : response.body()) {
                        System.out.println(vo.toString());
                    }
                }

                @Override
                public void onFailure(Call<GetIdentityResponseBody[]> call, Throwable t) {
                    System.out.println("2. Error received :(");
                    t.printStackTrace();
                }
            });

            service.getIdentityAsync(1, new Callback<GetIdentityResponseBody>() {
                @Override
                public void onResponse(Call<GetIdentityResponseBody> call, Response<GetIdentityResponseBody> response) {
                    System.out.println("3. Response received :)");
                    System.out.println(call.request().toString());
                    System.out.println(response.body().toString());
                }

                @Override
                public void onFailure(Call<GetIdentityResponseBody> call, Throwable t) {
                    System.out.println("3. Error received :(");
                    t.printStackTrace();
                }
            });

            service.createIdentityAsync(new Callback<CreateIdentityResponseBody>() {
                @Override
                public void onResponse(Call<CreateIdentityResponseBody> call, Response<CreateIdentityResponseBody> response) {
                    System.out.println("4. Response received :)");
                    System.out.println(call.request().toString());
                    System.out.println(response.body().toString());
                }

                @Override
                public void onFailure(Call<CreateIdentityResponseBody> call, Throwable t) {
                    System.out.println("4. Error received :(");
                    t.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
