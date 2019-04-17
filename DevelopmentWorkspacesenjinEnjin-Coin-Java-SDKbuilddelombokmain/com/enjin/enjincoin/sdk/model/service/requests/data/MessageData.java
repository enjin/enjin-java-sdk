package com.enjin.enjincoin.sdk.model.service.requests.data;

public class MessageData {
    private String message;

    MessageData(final String message) {
        this.message = message;
    }


    public static class MessageDataBuilder {
        private String message;

        MessageDataBuilder() {
        }

        public MessageDataBuilder message(final String message) {
            this.message = message;
            return this;
        }

        public MessageData build() {
            return new MessageData(message);
        }

        @Override
        public String toString() {
            return "MessageData.MessageDataBuilder(message=" + this.message + ")";
        }
    }

    public static MessageDataBuilder builder() {
        return new MessageDataBuilder();
    }
}
