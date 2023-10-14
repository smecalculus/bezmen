package smecalculus.bezmen.messaging;

import java.util.UUID;

public class SepulkaNewResponseEg {

    public static class Pojos {

        public static SepulkaNewResponseMsg sepulkaNewResponseMsg() {
            var responseMsg = new SepulkaNewResponseMsg();
            responseMsg.setId(UUID.randomUUID().toString());
            return responseMsg;
        }

        public static SepulkaNewResponseMsg sepulkaNewResponseMsg(UUID id) {
            var responseMsg = sepulkaNewResponseMsg();
            responseMsg.setId(id.toString());
            return responseMsg;
        }
    }
}
