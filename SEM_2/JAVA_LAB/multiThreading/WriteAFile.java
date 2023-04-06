import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

class WriteOnFile extends Thread {
	private String mssg, fileName;

    public WriteOnFile(String mssg, String fileName)
	{
		this.mssg = mssg;
		this.fileName = fileName;
	}

	// read text of file and returns it so that we can
	// append our string to this text
	private String readFile()
	{
		String currText = "";
		try {
			// object of File class
			File myFile = new File(this.fileName);
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
				// reads lines of text file and concatenate
				// it to currText
				currText += myReader.nextLine();
				currText += "\n";
			}
		}
		catch (Exception err) {
		}
		return currText;
	}

	// helps to write on file
	private void write()
	{
		// writes until Main.stop is false. if it's value
		// becomes true then it will stop writing
		while (WriteAFile.stop == false) {
			try {
				// gives the current text present in our
				// file. It will help us to append the text
				// in our text file and not overwriting on
				// file
				String currText = readFile();

				// object of FileWriter class which helps to
				// write on file
				FileWriter myWriter
					= new FileWriter(fileName);

				// writes on given file
				myWriter.write(currText + this.mssg);

				// closing the writing stream
				myWriter.close();

				// puts this thread on sleep state for 1.5
				// seconds...it will gives more good
				// experience of writing
				Thread.sleep(1500);
			}
			catch (Exception err) {
			}
		}
		return;
	}

	// constructor
	// start method calls this method (start calling is at
	// Main.java)
	public void run()
	{
		// run method calls write method which writes on
		// file
		this.write();
	}
}


public class WriteAFile {
    // turned to be true when user entered
    // something on terminal
    public static boolean stop = false;
 
    // Parent thread
    public static void main(String args[])
    {
        // object of class which do writing task.
        WriteOnFile newFile = new WriteOnFile("i am writing something", "File.txt");
        WriteOnFile newFile1 = new WriteOnFile("i am writing something", "File1.txt");

        // execute it on different thread...child
        // thread...it will execute run method of
        // WriteOnFile class
        newFile.start();
        newFile1.start();
 
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Enter Something : ");
        // waits for user input
        sc.nextLine();
        // turned on after entering input by user and it
        // tells another thread to stop writing
        WriteAFile.stop = true;
 
        return;
    }
}
