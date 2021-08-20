import java.net.*;
import java.io.IOException;
import javax.swing.*;

/** Enter an IP address and a port range where the program will then attempt to find open ports on the given 
 * computer by connecting to each of them. On any successful connections mark the port as open. */

    class PortScanner {
         public static void main(String[] args) {
         InetAddress ia=null;
         String host=null;
             try {
             
             host=JOptionPane.showInputDialog("Enter the Host name to scan:\n example: xxx.com");
                 if(host!=null){
                 ia = InetAddress.getByName(host);
             scan(ia); }
         }
             catch (UnknownHostException e) {
             System.err.println(e );
         }
         System.exit(0);
     }
     
        public static void scan(final InetAddress remote) {
         
         
        int port=0;
        String hostname = remote.getHostName();
         
                for ( port = 0; port < 65536; port++) {
                 try {
                 Socket s = new Socket(remote,port);
                 System.out.println("Server is listening on port " + port+ " of " + hostname);
                 s.close();
             }
                 catch (IOException ex) {
                 // The remote host is not listening on this port
                 System.out.println("Server is not listening on port " + port+ " of " + hostname);
             }
         }
     }
}