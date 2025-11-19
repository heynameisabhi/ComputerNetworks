public class main {

    public static void main(String[] args) {

        // 1. Client first packet
        Client.firstPacket();
        Server.lastReceivedClientSeq = Client.seq;

        // 2. Server first packet
        Server.firstPacket();
        Client.lastReceivedServerSeq = Server.seq;

        // 3. Client subsequent
        Client.nextPacket();
        Server.lastReceivedClientSeq = Client.seq;

        // 4. Server subsequent
        Server.nextPacket();
        Client.lastReceivedServerSeq = Server.seq;

        // 5. Client subsequent
        Client.nextPacket();
        Server.lastReceivedClientSeq = Client.seq;

        // 6. Server subsequent
        Server.nextPacket();
        Client.lastReceivedServerSeq = Server.seq;

        // 7. Client subsequent
        Client.nextPacket();
        Server.lastReceivedClientSeq = Client.seq;

        // 8. Server subsequent
        Server.nextPacket();
    }
}
