// JEFF BORDIGA
// PROGRAM06
// 10/30/17
// see lines 32-34 for file names
// go to output.txt for results

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class GraphMain {

	private static final String OUTPUT = "output.txt"; // output file
	
	public static void main(String[] args) {
		

		int inputSize = 0;
		boolean correctFile = false;
		boolean withinRange  = false;
		int sourceNumber = 0;
		Vertex sourceVertex = null;
		Vertex endVertex = null;
		String chosenFile = null;
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		Scanner inFile = null;
		
		String[] files = new String[3]; // list of input files is used for whole output file
		
		files[0] = "graph22_3.txt"; // storing files as a group
		files[1] = "graph23_4.txt";
		files[2] = "graph101.txt";
		
		PrintWriter outputStream = null;
		
		try{
		
			outputStream = new PrintWriter(new FileOutputStream(OUTPUT));
			correctFile = false;
			withinRange = false;
			chosenFile = null;
				
			AdjacencyListGraph aLG = null;
			
			while(correctFile == false) { // user input phase
					
				System.out.println("Choose a file to use: ");
					
				chosenFile = keyboard.next();
					
				for(int b = 0; b < files.length; b++) {
					if(chosenFile.equals(files[b])) {
						correctFile = true;
					}
				}
					
				if(correctFile == false) {
					System.out.println("ERROR: the file \"" + chosenFile + "\" could not be found" + "\n");
				}
					
			}
				
			try{ // file input phase
						
				inFile = new Scanner(new FileInputStream(chosenFile));
				inputSize = inFile.nextInt(); // reading input size
				aLG = new AdjacencyListGraph(inFile, inputSize);
					
			} catch(FileNotFoundException e){
				System.out.println("ERROR: unable to open file " + chosenFile);
				System.exit(0);
			}
				
			BreadthFirstSearch bFS = new BreadthFirstSearch(aLG);
				
			while(withinRange == false) {
					
				System.out.println("Choose a source vertex (counting from 0 to " + (inputSize - 1) + "): ");
				
				sourceNumber = keyboard.nextInt();
					
				if((sourceNumber< 0) || (sourceNumber > inputSize)) {
					System.out.println("ERROR: no such vertex exists" + "\n");
				} else {
					sourceVertex = aLG.getVertexList().get(sourceNumber);
					withinRange = true;
				}
					
			}
				
			bFS.breadthFirstSearch(aLG.getGraph(), sourceVertex);
				
			for(int c = 0; c < inputSize; c++) { // printing results
					
				endVertex = aLG.getVertexList().get(c);
				outputStream.println(aLG.getVertexList().get(c).getVNumber() + " " + aLG.getVertexList().get(c).getDistance() + " " + bFS.printPath(aLG.getGraph(), sourceVertex, endVertex));
					
			}
				
			outputStream.println();
			outputStream.close();
			System.out.println("Search complete");
			
		} catch(FileNotFoundException e){
			System.out.println("ERROR: unable to open file " + OUTPUT);
			System.exit(0);
		}
		
	}

}
