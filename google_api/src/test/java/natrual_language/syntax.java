package natrual_language;



//Imports the Google Cloud client library
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.Document.Type;
import com.google.cloud.language.v1.EncodingType;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import com.google.cloud.language.v1.Token;
import com.google.cloud.language.v1beta2.AnalyzeSyntaxRequest;
import com.google.cloud.language.v1beta2.AnalyzeSyntaxResponse;
import com.google.cloud.language.v1.LanguageServiceClient;

public class syntax {
public static void main(String[] args) throws Exception {
 // Instantiates a client
 try (LanguageServiceClient language = LanguageServiceClient.create()) {

   // The text to analyze
   String text = "i love you";
   Document doc = Document.newBuilder()
       .setContent(text).setType(Type.PLAIN_TEXT).build();

   // Detects the sentiment of the text
   Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();
   //Sentiment sentiment2 = language.analyzeSentiment(doc).
   System.out.printf("Text: %s%n", text);
   System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
 }

 
}
}