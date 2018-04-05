package info.laht.yaj_rpc;

import info.laht.yaj_rpc.net.AbstractRpcClient;
import info.laht.yaj_rpc.net.RpcServer;
import info.laht.yaj_rpc.net.http.RpcHttpClient;
import info.laht.yaj_rpc.net.http.RpcHttpServer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

class HttpDemo {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        RpcHandler handler = new RpcHandler(new SampleService());
        RpcServer server = new RpcHttpServer(handler);
        int port = server.start();

        AbstractRpcClient client = new RpcHttpClient("localhost", port);

        DemoBase.run(server, client);

    }

}
