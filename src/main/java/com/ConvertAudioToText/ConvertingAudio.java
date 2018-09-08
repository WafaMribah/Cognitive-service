package com.ConvertAudioToText;

import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;

public class ConvertingAudio extends ResultAdapter{
	public static Recognizer rec;

	// Receives RESULT_ACCEPTED event: print it, clean up, exit
	public void resultAccepted(ResultEvent e) {
		Result r = (Result)(e.getSource());
		ResultToken tokens[] = r.getBestTokens();

		for (int i = 0; i < tokens.length; i++)
			System.out.print(tokens[i].getSpokenText() + " ");
		System.out.println();

		// Deallocate the recognizer and exit
		try {
			rec.deallocate();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		System.exit(0);
	}

	public static void main(String args[]) {
		try {
			// Create a recognizer that supports English.
			rec = Central.createRecognizer(
							new EngineModeDesc(Locale.ENGLISH));
			
			if (rec != null) {
			    System.out.println(rec);
			}
			else {
			    System.out.println("rec is null");   
				//System.exit(0);
			}

			// Start up the recognizer
			rec.allocate();  // <-- This is the line that's blowing out (I assume)
	 
			// Load the grammar from a file, and enable it
			FileReader reader = new FileReader(args[0]);
			RuleGrammar gram = rec.loadJSGF(reader);
			gram.setEnabled(true);
	
			// Add the listener to get results
			rec.addResultListener(new ConvertingAudio());
	
			// Commit the grammar
			rec.commitChanges();
	
			// Request focus and start listening
			rec.requestFocus();
			rec.resume();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*//Imports the Google Cloud client library
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.protobuf.ByteString;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ConvertingAudio {
public static void main(String... args) throws Exception {
 // Instantiates a client
 SpeechClient speech = SpeechClient.create();

 // The path to the audio file to transcribe
 String fileName = "sample.mp3";

 // Reads the audio file into memory
 Path path = Paths.get(fileName);
 byte[] data = Files.readAllBytes(path);
 ByteString audioBytes = ByteString.copyFrom(data);

 // Builds the sync recognize request
 RecognitionConfig config = RecognitionConfig.newBuilder()
     .setEncoding(AudioEncoding.LINEAR16)
     .setSampleRateHertz(16000)
     .setLanguageCode("en-US")
     .build();
 RecognitionAudio audio = RecognitionAudio.newBuilder()
     .setContent(audioBytes)
     .build();

 // Performs speech recognition on the audio file
 RecognizeResponse response = speech.recognize(config, audio);
 List<SpeechRecognitionResult> results = response.getResultsList();

 for (SpeechRecognitionResult result: results) {
   List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
   for (SpeechRecognitionAlternative alternative: alternatives) {
     System.out.printf("Transcription: %s%n", alternative.getTranscript());
   }
 }
 speech.close();
}
}*/

/*import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class ConvertingAudio {       
                                     
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/acoustic/wsj");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/acoustic/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/acoustic/en-us/en-us.lm.bin");
        
	StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
	InputStream stream = new FileInputStream(new File("sample.mp3"));
	
        recognizer.startRecognition(stream);
	SpeechResult result;
        while ((result = recognizer.getResult()) != null) {
	    System.out.format("Hypothesis: %s\n", result.getHypothesis());
	}
	recognizer.stopRecognition();
    }
}*/

