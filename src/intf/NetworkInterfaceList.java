package intf;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkInterfaceList {
    public static void main(String[] args) throws Exception {
        Enumeration interfaces
            = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {
            NetworkInterface intf
                = (NetworkInterface)interfaces.nextElement();
            
            System.out.println(intf);

            Enumeration addresses = intf.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress address
                    = (InetAddress)addresses.nextElement();
                
                System.out.println("\t" + address);
            }
        }
    }
}