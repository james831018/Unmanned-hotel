package natrual_language;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

import java.util.Scanner;

public class test_test {
	
	 public static void main(String args[]) throws UnknownHostException, IOException {
	      String host = "192.168.208.248";   
		  //String host = "127.0.0.1";//try
	      String msg;
	      int port = 8897;
	      //int port = 8000;//try
	      Socket client = new Socket(host, port);  // 設定要連線server的位址
	      DataInputStream client_in = new DataInputStream(client.getInputStream());  //讀取字串的工具
	      DataOutputStream client_out = new DataOutputStream(client.getOutputStream()); //傳送字串的工具
	      client_out.writeUTF("testFromClient\n");   //傳送testFromeClient給server
	      msg = client_in.readUTF();  //讀取從server來的資料

	      client.close();
	   } 

}
