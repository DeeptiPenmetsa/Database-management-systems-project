import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Date;
import java.io.BufferedWriter.*;
import java.io.File;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.text.*;
import java.util.logging.*;


public class new_client {

  public final static int SOCKET_PORT = 13267;      // you may change this

 public final static String SERVER[] = {"planetlab2.unl.edu","planetlab1.unr.edu","planetlab2.cs.uml.edu","planetlab-03.cs.princeton.edu","planetlab1.rutgers.edu","planetlab3.ucsd.edu","pl3.cs.unm.edu","planetlab2.cs.pitt.edu","planetlab2.cs.uoregon.edu","planetlab2.tsuniv.edu","planetlab2.cs.ucla.edu","planetlab1.cs.du.edu","planetlab2.citadel.edu","planetlab2.rutgers.edu","node1.planetlab.mathcs.emory.edu","ricepl-5.cs.rice.edu","planetlab2.cs.prudue.edu","planetlab2.utdallas.edu","planetlab1.ucsd.edu","pl1.eecs.utk.edu","planetlab1.cs.unc.edu","planetlab2.unr.edu","planetlab3.eecs.umich.edu","planetlab1.emich.edu","planetlab1.csuohio.edu","planetlab2.acis.ufl.edu","planetlab1.unl.edu","planetlab2.clemson.edu","planetlab3.cnds.jhu.edu","planetlab2.temple.edu","planetlab-02.bu.edu","planetlab5.eecs.umich.edu","planetlab4.tamu.edu","flow.colgate.edu","planetlab2.uta.edu","plab3.eece.ksu.edu","planetlabone.ccs.neu.edu","planetlabtwo.ccs.neu.edu","planetlab1.cs.prudue.edu","planetlab3.wail.wisc.edu","salt.planetlab.cs.umd.edu","y"};
  public final static String[] FILE_TO_RECEIVED = {"32byte.txt","1KB.txt","512KB.txt","1MB.txt","y"};

  public final static  int FILE_SIZE = 6022386;
 


  public static void main (String [] args ) throws IOException {
      InetAddress ip;
        String hostname;
     int i=0;
      int j=0;
    while(SERVER[i]!= "y" ){
        while( FILE_TO_RECEIVED[j]!= "y"){
  
int bytesRead;
FileOutputStream fos = null;
    BufferedOutputStream bos = null;
    int current = 0;
   
    Socket sock = null;
      sock = new Socket(args[0], SOCKET_PORT);
   
System.out.println(sock);
      System.out.println("Connecting...");
Date date1= new Date();
long time = date1.getTime();
         Timestamp ts = new Timestamp(time);
     System.out.println("Current Time Stamp: "+ts);


      // receive file
 // receive file
      byte [] mybytearray  = new byte [FILE_SIZE];
      InputStream is = sock.getInputStream();
System.out.println(is);
System.out.println(sock.getInputStream());
      fos = new FileOutputStream(FILE_TO_RECEIVED[j],true);
     // bos = new BufferedOutputStream(fos);
      System.out.println(mybytearray.length);
//System.out.println(is.read(mybytearray,0,mybytearray.length));
      bytesRead = (int)(is.read(mybytearray,0,mybytearray.length));
System.out.println(bytesRead);
       System.out.println(FILE_TO_RECEIVED[j]
          );
      current = bytesRead;
 System.out.println( current );

      do {
         bytesRead =
            is.read(mybytearray, current, (mybytearray.length-current));
         if(bytesRead >= 0) current += bytesRead;
      } while(bytesRead > -1);

     // bos.write(mybytearray, 0 , current);
      //bos.flush();
      System.out.println("File " + FILE_TO_RECEIVED[j]
          + " downloaded (" + current + " bytes read)");
Date date2= new Date();
long timee = date2.getTime();
         Timestamp tss = new Timestamp(timee);
     System.out.println("Current Time Stamp: "+tss);
   


DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

String s=sdf.format(date1);
String s2=sdf.format(date2);
System.out.println("response-->"+s);
System.out.println("request-->"+s2);
System.out.println("diff-->"+(date2.getTime()-date1.getTime()));
   Long d= date2.getTime()-date1.getTime();
try {
      

            File file = new File("log.txt");
 // if file doesnt exists, then create it
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("host:"+hostname);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("Date Difference:"+d +" "+ "Source IP:" + SERVER[i] +" "+ "Destination IP:" + hostname + " " + "filename" + FILE_TO_RECEIVED[j]);
            bw.newLine();
            bw.flush();
            bw.close();
            System.out.println("Done");



        } catch (IOException e) {
            e.printStackTrace();
        }

finally {
      if (fos != null) fos.close();
      if (bos != null) bos.close();
      if (sock != null) sock.close();
    }
 System.out.println(i);
  j++;}
 
  j=0;i++;}
i=0;}
}