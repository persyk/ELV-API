package service;


import javax.net.ssl.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.params.HttpParams;

public class GatewaySslSocketFactory extends SSLSocketFactory {

    public GatewaySslSocketFactory(SSLContext sslContext, X509HostnameVerifier hostnameVerifier) {
        super(sslContext, hostnameVerifier);
    }

    @Override
    public Socket createSocket(HttpParams params) throws IOException {
        SSLSocket sslSocket = (SSLSocket) super.createSocket(params);

        // Set the encryption protocol
        sslSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

        // Configure SNI
//        SNIHostName serverName = new SNIHostName("elevateapp.cc");
//        SSLParameters sslParams = sslSocket.getSSLParameters();
//        sslParams.setServerNames(Collections.<SNIServerName>singletonList(serverName));
//        sslSocket.setSSLParameters(sslParams);

        return sslSocket;
    }
}