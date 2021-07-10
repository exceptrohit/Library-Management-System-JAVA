package lib_my;

import javax.swing.JOptionPane;

public class sql {

}
 class OutOfRange extends Exception
{
	 int e;
	 OutOfRange(int c)
	 {
		 //super(choice+" error:SQL");
		this.e=c;
		display_msg();
		
	 }
	 public String toString()
	 {
		 return ("Out of Range Exception no : "+e);
	 }
	 public void display_msg()
	 {
		 if(e==1)
		 {
			 JOptionPane.showMessageDialog(null,"Book id not available");
		 }
		 else if(e==2)
		 {
			 JOptionPane.showMessageDialog(null,"Student id not in record");
		 }
		 
	 }
	 
}
