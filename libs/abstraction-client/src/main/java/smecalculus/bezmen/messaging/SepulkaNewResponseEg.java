package smecalculus.bezmen.messaging;

import java.util.UUID;

public class SepulkaNewResponseEg {

    public static class Pojos {

        public static SepulkaNewResponseMsg sepulkaNewResponseMsg() {
            return sepulkaNewResponseMsg(UUID.randomUUID());
        }

        public static SepulkaNewResponseMsg sepulkaNewResponseMsg(UUID id) {
            var responseMsg = new SepulkaNewResponseMsg();
            responseMsg.setId(id.toString());
            return responseMsg;
        }
    }
}
