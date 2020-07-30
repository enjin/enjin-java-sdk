package com.enjin.sdk.schemas.project.mutations;

import com.enjin.sdk.graphql.GraphQLRequest;
import com.enjin.sdk.schemas.shared.fragments.TokenSupplyModel;
import com.enjin.sdk.schemas.shared.fragments.TokenTransferFeeSettings;
import com.enjin.sdk.schemas.shared.fragments.TokenTransferable;
import com.enjin.sdk.schemas.shared.fragments.inputs.TransactionRequestArguments;

/**
 * TODO
 */
public class CreateToken
        extends GraphQLRequest<CreateToken>
        implements TransactionRequestArguments<CreateToken> {

    /**
     * TODO
     * @param name
     * @return
     */
    public CreateToken name(String name) {
        return set("name", name);
    }

    /**
     * TODO
     * @param totalSupply
     * @return
     */
    public CreateToken totalSupply(String totalSupply) {
        return set("totalSupply", totalSupply);
    }

    /**
     * TODO
     * @param initialReserve
     * @return
     */
    public CreateToken initialReserve(String initialReserve) {
        return set("initialReserve", initialReserve);
    }

    /**
     * TODO
     * @param supplyModel
     * @return
     */
    public CreateToken supplyModel(TokenSupplyModel supplyModel) {
        return set("supplyModel", supplyModel);
    }

    /**
     * TODO
     * @param meltValue
     * @return
     */
    public CreateToken meltValue(String meltValue) {
        return set("meltValue", meltValue);
    }

    /**
     * TODO
     * @param meltFeeRatio
     * @return
     */
    public CreateToken meltFeeRatio(int meltFeeRatio) {
        return set("meltFeeRatio", meltFeeRatio);
    }

    /**
     * TODO
     * @param transferable
     * @return
     */
    public CreateToken transferable(TokenTransferable transferable) {
        return set("transferable", transferable);
    }

    /**
     * TODO
     * @param transferFeeSettings
     * @return
     */
    public CreateToken transferFeeSettings(TokenTransferFeeSettings transferFeeSettings) {
        return set("transferFeeSettings", transferFeeSettings);
    }

    /**
     * TODO
     * @param nonfungible
     * @return
     */
    public CreateToken nonfungible(boolean nonfungible) {
        return set("nonfungible", nonfungible);
    }

}
