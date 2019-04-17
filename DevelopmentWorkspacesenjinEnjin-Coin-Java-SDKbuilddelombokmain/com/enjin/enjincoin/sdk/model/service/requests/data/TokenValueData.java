package com.enjin.enjincoin.sdk.model.service.requests.data;

public class TokenValueData {
    private String id;
    private Integer index;
    private Integer value;

    TokenValueData(final String id, final Integer index, final Integer value) {
        this.id = id;
        this.index = index;
        this.value = value;
    }


    public static class TokenValueDataBuilder {
        private String id;
        private Integer index;
        private Integer value;

        TokenValueDataBuilder() {
        }

        public TokenValueDataBuilder id(final String id) {
            this.id = id;
            return this;
        }

        public TokenValueDataBuilder index(final Integer index) {
            this.index = index;
            return this;
        }

        public TokenValueDataBuilder value(final Integer value) {
            this.value = value;
            return this;
        }

        public TokenValueData build() {
            return new TokenValueData(id, index, value);
        }

        @Override
        public String toString() {
            return "TokenValueData.TokenValueDataBuilder(id=" + this.id + ", index=" + this.index + ", value=" + this.value + ")";
        }
    }

    public static TokenValueDataBuilder builder() {
        return new TokenValueDataBuilder();
    }
}
