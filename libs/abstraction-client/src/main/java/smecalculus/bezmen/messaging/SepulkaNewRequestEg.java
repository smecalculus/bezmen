package smecalculus.bezmen.messaging;

public class SepulkaNewRequestEg {
    public static final String NAME = "foo";

    public static class Pojos {

        public static SepulkaNewRequestMsg sepulkaNewRequestMsg() {
            var requestMsg = new SepulkaNewRequestMsg();
            requestMsg.setName(NAME);
            return requestMsg;
        }
    }
}
