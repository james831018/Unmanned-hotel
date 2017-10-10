package natrual_language;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;


import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import com.google.cloud.language.v1.Token;
import com.google.cloud.language.v1.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.LanguageServiceClient;


public class Analyzing_syntax {

	public static  void main(String[] args) throws Exception, Exception {
		//post connect
		//LCD.drawString("Waiting", 1, 1);
//=============================================================http connect
	      int port = 8898;   //Port的位址
	      ServerSocket serversocket = new ServerSocket(port);   //將EV3設為server
	      System.out.printf("Waiting...\n");
	      Socket server = serversocket.accept();  //持續listen 從 client 的連線請求
	      System.out.printf("success\n");
	      
	      PrintStream writer;//在此我使用PrintStream將字串進行編寫和送出
	      BufferedReader reader;//在此我使用BufferedReader將資料進行接收和讀取
	      writer = new PrintStream(server.getOutputStream());
	      reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
		  System.out.printf("the connect success\n");
//=====================================================================================================		
//===============================EV3====================================================	
		  String host = "192.168.208.248";
	      String msg;
	      int port2 = 8897;
	      Socket client = new Socket(host, port2);  // 設定要連線server的位址
	      
	      DataOutputStream client_out;//在此我使用PrintStream將字串進行編寫和送出
	      DataInputStream client_in;//在此我使用BufferedReader將資料進行接收和讀取
	      client_out =new  DataOutputStream(client.getOutputStream());
	      client_in = new DataInputStream(client.getInputStream());
//==============================EV3================================================================	

		// TODO Auto-generated method stub
		try (LanguageServiceClient language = LanguageServiceClient.create()) {
			  
			   //String text = "i love you and please go ahead";
			for(;;){
			   String text= reader.readLine();
			   System.out.printf("the text: %s\n",text);
			   if(text.equals("End"))break;
			   //text= reader.readLine();
			   //System.out.printf("the text: %s\n",text);
			   //text= reader.readLine();
			   //System.out.printf("the text: %s\n",text);
			   //text= reader.readLine();
			   //System.out.printf("the text: %s\n",text);
			   
			   String Verb[]= new String[10];	int verb_num=0;
			   String Adv[]=new String[10];		int adv_num=0;
			   String Num[]=new String[10];		int num_num=0;
			   
			   

			Document doc = Document.newBuilder()
			      .setContent(text)
			      .setType(Type.PLAIN_TEXT)
			      .build();
			  com.google.cloud.language.v1.AnalyzeSyntaxRequest request = AnalyzeSyntaxRequest.newBuilder()
			      .setDocument(doc)
			      .setEncodingType(EncodingType.UTF16)
			      .build();
			  // analyze the syntax in the given text
			  AnalyzeSyntaxResponse response = language.analyzeSyntax(request);
//==============================================================================================			  
			  float sentiment_detect;
			  // Detects the sentiment of the text  偵測情緒
			  Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();
			  //Sentiment sentiment2 = language.analyzeSentiment(doc).
			  System.out.printf("Text: %s%n", text);
			  System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
			  
			  sentiment_detect=sentiment.getMagnitude();
			  System.out.printf("semtiment_detect:%f\n",sentiment_detect);
//==============================================================================================
			  // print the response
			  for (Token token : response.getTokensList()) {
			    System.out.printf("\tText: %s\n", token.getText().getContent());
			    //System.out.printf("\tBeginOffset: %d\n", token.getText().getBeginOffset());
			    //System.out.printf("Lemma: %s\n", token.getLemma());
			    System.out.printf("PartOfSpeechTag: %s\n", token.getPartOfSpeech().getTag());
			    //System.out.printf("\tAspect: %s\n", token.getPartOfSpeech().getAspect());
			    //System.out.printf("\tCase: %s\n", token.getPartOfSpeech().getCase());
			    //System.out.printf("\tForm: %s\n", token.getPartOfSpeech().getForm());
			    //System.out.printf("\tGender: %s\n", token.getPartOfSpeech().getGender());
			    //System.out.printf("\tMood: %s\n", token.getPartOfSpeech().getMood());
			    //System.out.printf("\tNumber: %s\n", token.getPartOfSpeech().getNumber());
			    //System.out.printf("\tPerson: %s\n", token.getPartOfSpeech().getPerson());
			    //System.out.printf("\tProper: %s\n", token.getPartOfSpeech().getProper());
			    //System.out.printf("\tReciprocity: %s\n", token.getPartOfSpeech().getReciprocity());
			    //System.out.printf("\tTense: %s\n", token.getPartOfSpeech().getTense());
			    //System.out.printf("\tVoice: %s\n", token.getPartOfSpeech().getVoice());
			    //System.out.println("DependencyEdge");
			    //System.out.printf("\tHeadTokenIndex: %d\n", token.getDependencyEdge().getHeadTokenIndex());
			    //System.out.printf("\tLabel: %s\n\n", token.getDependencyEdge().getLabel());
			    
			    if(token.getPartOfSpeech().getTag().toString().equals("VERB")||token.getPartOfSpeech().getTag().toString().equals("ADV")||token.getPartOfSpeech().getTag().toString().equals("ADJ")){
			    	Verb[verb_num]=token.getText().getContent();
				    verb_num++;
			    }
			    else if(token.getPartOfSpeech().getTag().toString().equals("ADV")){
			    	Adv[adv_num]=token.getText().getContent();
			    	adv_num++;
			    }
			    else if(token.getPartOfSpeech().getTag().toString().equals("NUM")){
			    	Num[num_num]=token.getText().getContent();
			    	num_num++;
			    }
			  }//syntax parser


		      client_out.writeFloat(sentiment_detect);
		      //client_out.writeUTF("Go");
		      //client_out.writeUTF("Back");
		      //client_out.writeUTF("Close");
		      
		      
		      
		      for(int i=0;i<verb_num;i++){
				  System.out.printf("Verb: %s\n",Verb[i]);
				  client_out.writeUTF(Verb[i]);   //傳送testFromeClient給server
				  //msg = client_in.readUTF();  //讀取從server來的資料
				  //client.close();
			  }
			  for(int i=0;i<adv_num;i++){
				  System.out.printf("ADV: %s\n",Adv[i]);
			  }
			  for(int i=0;i<num_num;i++){
				  System.out.printf("NUM: %s\n",Num[i]);
				  client_out.writeUTF("NUM");
				  System.out.printf("Num float:%f\n",Float.parseFloat(Num[i]));
				  client_out.writeFloat(Float.parseFloat(Num[i]));
			  }
			  
			  client_out.writeUTF("Close");
			  

		   }
			  client.close();
		      server.close();    //關閉server
		      serversocket.close();
		}
		

	}

}
