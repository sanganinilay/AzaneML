//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Authors : Nilay Sangani, Haroot Zarger
// Version : 0.1
// Email : sanganinilay@hotmail.com,harootz@gmail.com
// Twitter : @outlawzter,@harootz
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;

public class appsecml {

	public static void main(String[] args) throws IOException {
		
		//Training
		BufferedReader objBreader = null;
		try{

			
		System.out.println("Supplying Training Set................");
		System.out.println();
		objBreader = new BufferedReader(new FileReader("D:/MLNH/Trainingdata.arff"));
		Instances objTrain = new Instances(objBreader);
		objTrain.setClassIndex(objTrain.numAttributes()-1);
		objBreader.close();
		NaiveBayes objNB = new NaiveBayes();
		try {
			System.out.println("Applying Naive Bayes algorithm.... ");
			System.out.println();
			objNB.buildClassifier(objTrain); // trained
		} catch (Exception e) {
			e.printStackTrace();
		}
		Evaluation objEval = new Evaluation(objTrain);
		
		objEval.crossValidateModel(objNB, objTrain, 2, new Random(1), args);
		System.out.println(objNB.toString());
		System.out.println(objEval.toSummaryString());
		
		//Test
		System.out.println("Supplying Test Set................");
		System.out.println();
		BufferedReader objBreaderTest = null;
		objBreaderTest =  new BufferedReader(new FileReader("D:/MLNH/testfile.arff"));
		Instances objTest = new Instances(objBreaderTest);
		
		objTest.setClassIndex(objTrain.numAttributes()-1);
		objBreaderTest.close();
		
		
		//0
		double labelIndexZero = objNB.classifyInstance(objTest.instance(0));
		objTest.instance(0).setClassValue(labelIndexZero);
		//1
		double labelIndexOne = objNB.classifyInstance(objTest.instance(1));
		objTest.instance(1).setClassValue(labelIndexOne);
		//2
		double labelIndexTwo = objNB.classifyInstance(objTest.instance(2));
		objTest.instance(2).setClassValue(labelIndexTwo);
		//3
		double labelIndexThree = objNB.classifyInstance(objTest.instance(3));
		objTest.instance(3).setClassValue(labelIndexThree);
		//4
		double labelIndexFour = objNB.classifyInstance(objTest.instance(4));
		objTest.instance(4).setClassValue(labelIndexFour);
		
		System.out.println("Predictions................");
		System.out.println();
		System.out.println("Predicted Value" + " " + objTest.instance(0).stringValue(7));
		System.out.println("Predicted Value" + " " + objTest.instance(1).stringValue(7));
		System.out.println("Predicted Value" + " " + objTest.instance(2).stringValue(7));
		System.out.println("Predicted Value" + " " + objTest.instance(3).stringValue(7));
		System.out.println("Predicted Value" + " " + objTest.instance(4).stringValue(7));
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
