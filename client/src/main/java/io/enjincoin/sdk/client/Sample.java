package io.enjincoin.sdk.client;

import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

public class Sample {

    public static void main(String... args) {
        ClientImpl client = new ClientImpl("http://enjin.v16studios.co.uk");
        IdentitiesService service = client.getIdentitiesService();
        service.getIdentitiesAsync(new Callback<GetIdentityResponseVO[]>() {
            @Override
            public void onResponse(Call<GetIdentityResponseVO[]> call, Response<GetIdentityResponseVO[]> response) {
                System.out.println("1. Response received :)");
                for (GetIdentityResponseVO vo : response.body()) {
                    System.out.println(vo.toString());
                }
            }

            @Override
            public void onFailure(Call<GetIdentityResponseVO[]> call, Throwable t) {
                System.out.println("1. Error received :(");
                t.printStackTrace();
            }
        });

        service.getIdentitiesAsync(new HashMap<String, Object>() {{
            put("player_name", "Player Ten");
            put("New Field", "New Field Data");
        }}, new Callback<GetIdentityResponseVO[]>() {
            @Override
            public void onResponse(Call<GetIdentityResponseVO[]> call, Response<GetIdentityResponseVO[]> response) {
                System.out.println("2. Response received :)");
                System.out.println(call.request().toString());
                for (GetIdentityResponseVO vo : response.body()) {
                    System.out.println(vo.toString());
                }
            }

            @Override
            public void onFailure(Call<GetIdentityResponseVO[]> call, Throwable t) {
                System.out.println("2. Error received :(");
                t.printStackTrace();
            }
        });

        service.getIdentityAsync(1, new Callback<GetIdentityResponseVO>() {
            @Override
            public void onResponse(Call<GetIdentityResponseVO> call, Response<GetIdentityResponseVO> response) {
                System.out.println("3. Response received :)");
                System.out.println(call.request().toString());
                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(Call<GetIdentityResponseVO> call, Throwable t) {
                System.out.println("3. Error received :(");
                t.printStackTrace();
            }
        });
    }

}
