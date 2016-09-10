import java.io.BufferedInputStream;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.OutputStream;

import java.net.ServerSocket;

import java.net.Socket;

import java.sql.Timestamp;

import java.util.Date;



public class Server {



  public final static int SOCKET_PORT = 13267;

  public final static String[] FILE_TO_SEND = {"32byte.txt","1KB.txt","512KB.txt","1MB.txt","y"};  



  public static void main (String [] args ) throws IOException {

    
    int i=0;

    FileInputStream fis = null;

    BufferedInputStream bis = null;

    OutputStream os = null;

    ServerSocket servsock = null;

    Socket sock = null;
  while(!"y".equals(FILE_TO_SEND[i])){

    try {

      servsock = new ServerSocket(SOCKET_PORT);

      while (true) {

        System.out.println("Waiting...");

        try {

          sock = servsock.accept();

          System.out.println("Accepted connection : " + sock);

Date date= new Date();

long time = date.getTime();

  Timestamp ts = new Timestamp(time);

 System.out.println("Current Time Stamp: "+ts);

          // send file
          
    File myFile = new File (FILE_TO_SEND[i]);
          
    if (!myFile.exists()) {
          
    myFile.createNewFile();

   }
        //myFile.setWritable(false);                                      
        //myFile.setReadOnly();
          
   byte [] mybytearray  = new byte [(int)myFile.length()];
          
      fis = new FileInputStream(myFile);
          
       bis = new BufferedInputStream(fis);
          
      bis.read(mybytearray,0,mybytearray.length);
          
        os = sock.getOutputStream();
          
    System.out.println("Sending " + FILE_TO_SEND[i] + "(" + mybytearray.length + " bytes)");
          
      os.write(mybytearray,0,mybytearray.length);
          
         os.flush();
          
    System.out.println("Done.");
          
       Date datee= new Date();
          
      long timee = datee.getTime();
          
    Timestamp tss = new Timestamp(timee);
          
     System.out.println("Current Time Stamp: "+tss);
          
      i++; }
          
    finally {
          
    if (bis != null) bis.close();
          
    if (os != null) os.close();
          
    if (sock!=null) sock.close();
        
        }
        
   if("y".equals(FILE_TO_SEND[i])){i=0;} }
          
    }
     
  finally {
      
 if (servsock != null) servsock.close();
          
}
}
}
}
