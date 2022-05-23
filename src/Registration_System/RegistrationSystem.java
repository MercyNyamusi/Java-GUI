package Q2;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class RegistrationSystem implements ActionListener {
	private static final String Conn = null;
	private static final Statement Stmt = null;
	private static Statement queryResult = null;
	static JFrame signin, signup, status,register,courseDisplay,PAdm,PCompSci,PBiz,PGlobal;
	static JPanel text,credentials,intro, Fintro,titleText,alt1,alt2,firstname,midname,lastname;	
	static JTextField name,fnameText,mnameText,lnameText,markText,signame;
	static JLabel title, label, nameText, Mess,passwordText,altText1,altText2,fname,mname,lname,studentName,id,nameTitle,idTitle;
	static String result = "", course="", Admstatus="",state="",query,dbname,dbpass,signupPass, loginName,signupName,FName,loginPass,MName,LName,GradeMark,Snum,Sname;
	static JButton signButton,submit,login,alt1Button,alt2Button,logout,courses,Adm,CompSci,Biz,Global;
	static JPasswordField signpass,password;
	static JLabel comp,busi,globe;
	int rollno,dbid;
	int count=-1;
	int check=0;
	int number;
	ResultSet ans,prod,tmp,answer;
	String srollno,stored,retrieve,enrol,degree;
	String[] place;
	
		
	public static void main(String[] args) {
		new RegistrationSystem("SIGN UP");
	
	}
	//Lists Computer Science students
	public void CCompSci() {
		title.setText("ALU COMPUTER SCIENCE STUDENTS");
		status.getContentPane().removeAll();
		status.repaint();
		status.add(title);
		status.add(Adm);
		status.add(Global);
		status.add(CompSci);
		status.add(Biz);
		
	
	}
	
	public void CBiz() {
		title.setText("ALU BUSINESS STUDIES STUDENTS");
		status.getContentPane().removeAll();
		status.repaint();
		status.add(title);
		status.add(Adm);
		status.add(Global);
		status.add(CompSci);
		status.add(Biz);
		
		
	}
	
	public void CGlobal() {
		title.setText("ALU GLOBAL CHALLENGES STUDENTS");
		status.getContentPane().removeAll();
		status.repaint();
		status.add(title);
		status.add(Adm);
		status.add(Global);
		status.add(CompSci);
		status.add(Biz);
	}
	
	public void signIn(String Mess2){
		signin = new JFrame("SIGN IN");
		signin.setLayout(null);
		signin.setBounds(500, 100, 500, 500);
		
		//intro title
		intro = new JPanel();
		intro.setBounds(40, 40, 400, 40);
		
		
		title= new JLabel();
		title.setBounds(100, 60, 400, 40);
		title.setText("WELCOME TO ALU REGISTRATION SYSTEM");
		
		//SIGNIN Title
		titleText= new JPanel();
		titleText.setBounds(80, 90, 300, 40);
		
		label= new JLabel();
		label.setBounds(80, 90, 300, 40);
		label.setText(Mess2);
		
		//name
		text = new JPanel();
		text.setLayout(null);
		text.setBounds(40, 150, 400, 40);
		
		nameText=new JLabel();
		nameText.setLayout(null);
		nameText.setBounds(40, 0, 100, 30);
		nameText.setText("Username/Email");
		
		
		name=new JTextField();		
		name.setLayout(null);		
		name.setBounds(150, 0, 200, 30);
		
		//password
		credentials = new JPanel();
		credentials.setLayout(null);		
		credentials.setBounds(40, 200, 400, 40);
		
		passwordText = new JLabel();		
		passwordText.setLayout(null);
		passwordText.setBounds(40, 0, 100, 30);			
		passwordText.setText("Password");
		
		
		password=new JPasswordField();
		password.setLayout(null);
		password.setBounds(150, 0, 200, 30);	
		
		// try again button
		login=new JButton("SIGN IN");
		login.setBounds(200, 260, 100, 30);
		login.addActionListener(this);

		alt1 = new JPanel();
		alt1.setLayout(null);
		alt1.setBounds(80, 320, 400, 40);
		
		altText1=new JLabel();
		altText1.setLayout(null);
		altText1.setBounds(80,0, 400, 40);
		altText1.setText("Don't have an account?");

		alt1Button=new JButton("SIGN UP");
		alt1Button.setBounds(215, 10, 80, 20);
		alt1Button.addActionListener(this);
		
		intro.add(title);
		titleText.add(label);
		text.add(nameText);
		text.add(name);		
		credentials.add(passwordText);
		credentials.add(password);
		alt1.add(altText1);
		alt1.add(alt1Button);
		
		signin.add(intro);
		signin.add(titleText);	
		signin.add(text);	
		signin.add(credentials);
		signin.add(login);
		signin.add(alt1);
		signin.setVisible(true);
		
		
		
		
	}
	
	public RegistrationSystem(String Mess1){
		//title of the frame
		signup = new JFrame("SIGN UP");
		signup.setLayout(null);
		signup.setBounds(500, 100, 500, 500);
		
		//title panel
		intro = new JPanel();
		intro.setBounds(40, 40, 400, 40);
		
		//title panel text
		title= new JLabel();
		title.setBounds(100, 60, 400, 40);
		title.setText("WELCOME TO ALU REGISTRATION SYSTEM");
		
		//Signup Subtitle panel
		titleText= new JPanel();
		titleText.setBounds(80, 90, 300, 40);
		
		//Signup Subtitle text
		label= new JLabel();
		label.setBounds(80, 90, 300, 40);
		label.setText(Mess1);
		
		//Username panel
		text = new JPanel();
		text.setLayout(null);
		text.setBounds(40, 150, 400, 40);
		
		//Username label
		nameText=new JLabel();
		nameText.setLayout(null);
		nameText.setBounds(40, 0, 100, 30);
		nameText.setText("Username/Email");
		
		//Username field
		signame=new JTextField();		
		signame.setLayout(null);		
		signame.setBounds(150, 0, 200, 30);
		
		//password panel
		credentials = new JPanel();
		credentials.setLayout(null);		
		credentials.setBounds(40, 200, 400, 40);
		
		//password label
		passwordText = new JLabel();		
		passwordText.setLayout(null);
		passwordText.setBounds(40, 0, 100, 30);			
		passwordText.setText("Password");
		
		//password field
		signpass=new JPasswordField();
		signpass.setLayout(null);
		signpass.setBounds(150, 0, 200, 30);	
		
		//SignUp/Register Button
		signButton=new JButton("REGISTER");
		signButton.setBounds(200, 260, 100, 30);		
		signButton.addActionListener(this);
		
		//signin panel
		alt2 = new JPanel();
		alt2.setLayout(null);
		alt2.setBounds(80, 320, 400, 40);
		
		//signin label
		altText2=new JLabel();
		altText2.setLayout(null);
		altText2.setBounds(80,0, 400, 40);
		altText2.setText("Already have an account?");
		
		//signin button
		alt2Button=new JButton("LOGIN");
		alt2Button.setBounds(230, 10, 70, 20);
		alt2Button.addActionListener(this);
		
		//adding components to panel
		intro.add(title);
		titleText.add(label);
		text.add(nameText);
		text.add(signame);		
		credentials.add(passwordText);
		credentials.add(signpass);
		alt2.add(altText2);
		alt2.add(alt2Button);
		
		//adding panels to frame
		signup.add(intro);
		signup.add(titleText);	
		signup.add(text);	
		signup.add(credentials);
		signup.add(signButton);
		signup.add(alt2);
		signup.setVisible(true);
		
		
	}
	
	public void register(){
		register = new JFrame("REGISTRATION");
		register.setLayout(null);
		register.setBounds(500, 100, 500, 500);
		
		//intro title
		intro = new JPanel();
		intro.setBounds(40, 40, 400, 40);
		
		
		title= new JLabel();
		title.setBounds(100, 60, 400, 40);
		title.setText("Please enter your details below");
		
	
		
		//First name
		firstname = new JPanel();
		firstname.setLayout(null);
		firstname.setBounds(40, 110, 400, 40);
		
		fname=new JLabel();
		fname.setLayout(null);
		fname.setBounds(40, 0, 100, 30);
		fname.setText("First Name");
		
		
		fnameText=new JTextField();		
		fnameText.setLayout(null);		
		fnameText.setBounds(150, 0, 200, 30);
		
		//Middle name
		midname = new JPanel();
		midname.setLayout(null);
		midname.setBounds(40, 160, 400, 40);
		
		mname=new JLabel();
		mname.setLayout(null);
		mname.setBounds(40, 0, 100, 30);
		mname.setText("Middle Name");
		
		
		mnameText=new JTextField();		
		mnameText.setLayout(null);		
		mnameText.setBounds(150, 0, 200, 30);
		
		
		// Last name
		lastname = new JPanel();
		lastname.setLayout(null);
		lastname.setBounds(40, 210, 400, 40);
		
		lname=new JLabel();
		lname.setLayout(null);
		lname.setBounds(40, 0, 100, 30);
		lname.setText("Surname");
		
		
		lnameText=new JTextField();		
		lnameText.setLayout(null);		
		lnameText.setBounds(150, 0, 200, 30);
		
		//Grade
		credentials = new JPanel();
		credentials.setLayout(null);		
		credentials.setBounds(40, 260, 400, 40);
		
		passwordText = new JLabel();		
		passwordText.setLayout(null);
		passwordText.setBounds(40, 0, 100, 30);			
		passwordText.setText("Mark");
		
		
		markText=new JTextField();
		markText.setLayout(null);
		markText.setBounds(150, 0, 200, 30);	
		
		// try again button
		submit=new JButton("SUBMIT");
		submit.setBounds(200, 340, 100, 30);
		submit.addActionListener(this);

		

		
		intro.add(title);
		firstname.add(fname);
		firstname.add(fnameText);
		midname.add(mname);
		midname.add(mnameText);
		lastname.add(lname);
		lastname.add(lnameText);			
		credentials.add(passwordText);
		credentials.add(markText);
		
		register.add(intro);
		register.add(firstname);	
		register.add(midname);
		register.add(lastname);
		register.add(credentials);
		register.add(submit);
		register.setVisible(true);
		
		
		
	}
	
	public void reject(String SName, String SRoll,String SMark, String SCourse) {
		status = new JFrame("ADMISSION STATUS");
		status.setLayout(null);
		status.setBounds(50, 100, 500, 500);
		
		title.setBounds(80, 50, 500, 40);
		
		
		//Name
		firstname = new JPanel();
		firstname.setLayout(null);
		firstname.setBounds(40, 110, 500, 40);
		
		fname=new JLabel();
		fname.setLayout(null);
		fname.setBounds(40, 0,500, 30);
		String sname = "Student Name: " +SName;
		fname.setText(sname);		
		
		//Roll NO
		midname = new JPanel();
		midname.setLayout(null);
		midname.setBounds(40, 160, 500, 40);
		
		mname=new JLabel();
		mname.setLayout(null);
		mname.setBounds(40, 0, 500, 30);
		String sno = "Roll No: " +SRoll;
		mname.setText(sno);	
		
		
		
		// Grade
		lastname = new JPanel();
		lastname.setLayout(null);
		lastname.setBounds(40, 210, 500, 40);
		
		lname=new JLabel();
		lname.setLayout(null);
		lname.setBounds(40, 0, 500, 30);
		String smark = "Mark: " +SMark;
		lname.setText(smark);
		
		
		
		
		//Course
		credentials = new JPanel();
		credentials.setLayout(null);		
		credentials.setBounds(40, 260, 500, 40);
		
		passwordText = new JLabel();		
		passwordText.setLayout(null);
		passwordText.setBounds(40, 0, 500, 30);
		String scourse = "Status: " +SCourse;
		passwordText.setText(scourse);
		
	
		
		logout=new JButton("LOGOUT");
		logout.setBounds(200, 340, 100, 30);
		logout.addActionListener(this);

		
		firstname.add(fname);
		midname.add(mname);
		lastname.add(lname);
		credentials.add(passwordText);
		
		status.add(title);
		status.add(firstname);
		status.add(midname);
		status.add(lastname);
		status.add(credentials);
		
		status.add(logout);
		
		status.setVisible(true);
	}
	public void placer(String SName, String SRoll,String SMark, String SCourse){
		status = new JFrame("ADMISSION STATUS");
		status.setLayout(null);
		status.setBounds(50, 100, 500, 500);
		
		
		Adm= new JButton();
		Adm.setBounds(20, 50, 110, 30);
		Adm.setText("MY STATUS");
		Adm.addActionListener(this);
		
		CompSci= new JButton();
		CompSci.setBounds(130, 50, 110, 30);
		CompSci.setText("COMPUTER");
		CompSci.addActionListener(this);
		
		
		Global= new JButton();
		Global.setBounds(240, 50, 110, 30);
		Global.setText("GLOBAL.C");
		Global.addActionListener(this);
		
		Biz= new JButton();
		Biz.setBounds(350, 50, 110, 30);
		Biz.setText("BUSINESS");
		Biz.addActionListener(this);
		
		//Name
		firstname = new JPanel();
		firstname.setLayout(null);
		firstname.setBounds(40, 110, 500, 40);
		
		fname=new JLabel();
		fname.setLayout(null);
		fname.setBounds(40, 0,500, 30);
		String sname = "Student Name: " +SName;
		fname.setText(sname);		
		
		//Roll NO
		midname = new JPanel();
		midname.setLayout(null);
		midname.setBounds(40, 160, 500, 40);
		
		mname=new JLabel();
		mname.setLayout(null);
		mname.setBounds(40, 0, 500, 30);
		String sno = "Roll No: " +SRoll;
		mname.setText(sno);	
		
		
		
		// Grade
		lastname = new JPanel();
		lastname.setLayout(null);
		lastname.setBounds(40, 210, 500, 40);
		
		lname=new JLabel();
		lname.setLayout(null);
		lname.setBounds(40, 0, 500, 30);
		String smark = "Mark: " +SMark;
		lname.setText(smark);
		
		
		
		
		//Course
		credentials = new JPanel();
		credentials.setLayout(null);		
		credentials.setBounds(40, 260, 500, 40);
		
		passwordText = new JLabel();		
		passwordText.setLayout(null);
		passwordText.setBounds(40, 0, 500, 30);
		String scourse = "Course: " +SCourse;
		passwordText.setText(scourse);
		
	
		
		logout=new JButton("LOGOUT");
		logout.setBounds(200, 340, 100, 30);
		logout.addActionListener(this);

		
		firstname.add(fname);
		midname.add(mname);
		lastname.add(lname);
		credentials.add(passwordText);
		
		status.add(firstname);
		status.add(midname);
		status.add(lastname);
		status.add(credentials);
		status.add(Adm);
		status.add(Global);
		status.add(CompSci);
		status.add(Biz);
		status.add(logout);
		
		status.setVisible(true);
		
	}
	
	public ResultSet connect(String query){
		try {
			Connection Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registartionsystem_javasummative", "root", "");
			
						
			java.sql.Statement Stmt= Conn.createStatement();

			ResultSet res= Stmt.executeQuery(query);
			
			return res;	
			
		} catch (SQLException e) {
			
//			System.err.println("connect" + e.getMessage());
		
			return null;
		}
		
	}
	
	public int saveLogin(String username, String password){
		int find_entry = check_entry(username);
		if(find_entry == 0) {		
						
			query ="INSERT INTO login_details(UserName, Password)VALUES ('"+username+"', '"+password+"')";	
			count= store(query);
			if (count>=0) {		
				ResultSet confirm= connect("SELECT UserName FROM login_details WHERE UserName = '"+username+"' and Password ='"+password+"'");
				
				if (confirm!=null) 
					return 0;
				
				else 
					return -1;
			}
			else 
				return -1;
		}
		else 
			return -1;
		
	}
		
	public int store(String query){
		try {
			Connection Conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/registartionsystem_javasummative", "root", "");
			if (Conn!=null){
				java.sql.Statement Stmt= Conn.createStatement();
				int res= Stmt.executeUpdate(query);				
				return res;
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
//			System.err.println(e.getMessage());
//			System.err.println("Unsuccessful SignUp Upload");
		
		}
		return -1;
		
	}
	
	public int check_entry(String username){
		query = "SELECT UserName FROM login_details WHERE UserName='"+username+"'";
		
		ans = connect(query);
		
		try {
			while(ans.next()) {
				dbname= ans.getString("UserName");
	
			}
			if (dbname == null) {
				return 0;
			}
			else {
				signup.dispose();
				new RegistrationSystem("UserName Taken. Please try Again");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.err.println("Problem here: "+e.getMessage());
		}
		return -1;
	}
	
	public int verification(String username, String password){
		query = "SELECT * FROM login_details WHERE UserName='"+username+"' and Password ='"+password+"'";
		
		ans = connect(query);
		
		try {
			while(ans.next()) {
				dbname= ans.getString("UserName");
				dbpass=ans.getString("Password");
				dbid=ans.getInt("ID");
			}
			if (dbname != null && dbpass !=null) {
				return dbid;
			}
			else if(dbname == null){
				signin.dispose();
				signIn("Incorrect Username. Please Try again.");
				return -1;
			}
			else {
				signin.dispose();
				signIn("Incorrect Password. Please Try again.");
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			System.err.println("Login Issue: "+e.getMessage());
		}
		return -1;
	}
	
	public void saveDetails(int ID,String firstname, String middlename, String lastname, String grade,String Course,String enrolment){
		query ="INSERT INTO student_details(ID,FirstName, MiddleName, LastName, Mark, Course,Status)VALUES ('"+ID+"','"+firstname+"', '"+middlename+"', '"+lastname+"', '"+grade+"','"+Course+"','"+enrolment+"')";
		int count =store(query);
	}
	
	public ResultSet getDetails(int ID){
		query = "select * from student_details WHERE ID='"+ID+"'";
		ans = connect(query);		
		return ans;
						
	}
	
	public void displayStudents(int rows, String[][] details) {
		JPanel title = new JPanel();
		title.setBounds(50, 150, 300,30);
		title.setLayout(new GridLayout(1,2,10,10));
		
		nameTitle = new JLabel();
		idTitle = new JLabel();
		
		idTitle.setText("Roll No");
		nameTitle.setText("Student Name");
		
		title.add(idTitle);
		title.add(nameTitle);
		
		
		Fintro=new JPanel();
		Fintro.setBounds(50, 190, 300,(30*rows));
		Fintro.setLayout(new GridLayout(rows,2,10,10));
		JLabel[] namelabel = new JLabel[rows];
		JLabel[] idlabel = new JLabel[rows];
			
		for (int i = 0;i<rows;i++) {			
			namelabel[i] = new JLabel();
			idlabel[i] = new JLabel();	
			
			idlabel[i].setText(details[i][0]);
			namelabel[i].setText(details[i][1]);
			Fintro.add(idlabel[i]);
			Fintro.add(namelabel[i]);	
			
		}
		status.add(title);
		status.add(Fintro);
		status.setVisible(true);
	}
	
	public void showDetails(ResultSet value){
		
		try {
			while(value.next()) {
				rollno = value.getInt("ID");				
				FName = value.getString("FirstName");
				MName = value.getString("MiddleName");
				LName= value.getString("LastName");
				GradeMark=value.getString("Mark");
				degree=value.getString("Course");
				enrol=value.getString("Status");
				
			}		
			srollno ="2022/0"+ Integer.toString(rollno);
			Snum=srollno;			
			Sname =FName+" "+ MName +" "+LName;
			if (enrol.equals("Enrolled")) {
				placer(Sname,srollno,GradeMark,degree);
			}
			else if(enrol.equals("Not Enrolled")){
				reject(Sname,srollno,GradeMark,enrol);
			}
			
			
		}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
//				System.err.println("Unsuccessful Details Capture");
			}
	}

	public String[][] students(int len,String course) {
		int counter=0;		
		retrieve = "select * from student_details WHERE Course='"+course+"'";
		answer=connect(retrieve);
		try {
			String[] details_list = new String[2], final_list[] =new String[len][2];
			while(answer.next()) {
				rollno = answer.getInt("ID");				
				FName = answer.getString("FirstName");
				MName = answer.getString("MiddleName");
				LName= answer.getString("LastName");
				
				srollno ="2022/0"+ Integer.toString(rollno);
				Snum=srollno;			
				Sname =FName+" "+ MName +" "+LName;				
				details_list[0] = Snum;
				details_list[1] = Sname;
				final_list[counter][0] = details_list[0];	
				final_list[counter][1] = details_list[1];
				counter++;
			}	
			
			return final_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int rows(String course) {
		retrieve = "select COUNT(*) AS count from student_details WHERE Course='"+course+"'";
		answer=connect(retrieve);
		try {
			while(answer.next()) {
				number = answer.getInt("count");
				return number;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;		
	}
	
 	public String[] classifier(int mark) {
 		String[] output = new String[2];
		if (mark>=18 && mark <=20) {
			course= "Computer Science";
			Admstatus="Enrolled";
			
		}
		else if (mark>=15 && mark <=17) {
			course= "Global Challenges";
			Admstatus="Enrolled";
		}
		else if (mark>=12 && mark <=14) {
			course= "Business Studies";
			Admstatus="Enrolled";
		}
		else {
			course= "Sorry! Your mark score is below admission requirements.";
			Admstatus="Not Enrolled";
		}
		output[0] =course;
		output[1]=Admstatus;
		return output;
		
	}
 	
 	
	@Override
	
	
	public void actionPerformed(ActionEvent e) {
		//Choosing Sign up
		if (e.getSource()== alt1Button) {
			signin.dispose();
			new RegistrationSystem("SIGN UP");
		}
		//Choosing Sign IN
		if (e.getSource()== alt2Button) {
			signup.dispose();
			signIn("SIGN IN");
		}
		//Logging in
		if (e.getSource()== login) {
			loginName= name.getText();
			loginPass= String.valueOf(password.getPassword());
			int state = verification(loginName,loginPass);
			if (state > -1) {
				signin.dispose();
				prod = getDetails(dbid);				
				try {		
					
					while(prod.next()) {
						stored = prod.getString("FirstName");
						if(stored!=null) {
						check++;	
						break;
						}
					}							
					if(check==0) {
					register();
					}
					else {
						tmp= getDetails(dbid);
						showDetails(tmp);
					}
										
				}
				catch (SQLException e1) {
						// TODO Auto-generated catch block
//					System.err.println("prod" +e1.getMessage());
				}		
											
			}
		}		
			
		
		//Signing up button
		if (e.getSource()== signButton) {
			signupName= signame.getText();//UserName input
			signupPass= String.valueOf(signpass.getPassword());

			
			int res = saveLogin(signupName,signupPass);//inserts new info in database
			if (res>=0) {
				signup.dispose();
				signIn("SIGN IN");
			}
			
			
		}
		//logging out
		if (e.getSource()== logout) {
			status.dispose();
			signIn("SIGN IN");
		}
		
		
		//registering courses
		if (e.getSource()== submit) {
			FName = fnameText.getText();
			MName = mnameText.getText();
			LName= lnameText.getText();
			GradeMark=markText.getText();
			int newMark=Integer.valueOf(GradeMark);
			place = classifier(newMark);
			degree=place[0];
			enrol=place[1];
			
			saveDetails(dbid, FName,MName,LName,GradeMark,degree,enrol);
			register.dispose();
			
			ans= getDetails(dbid);
			showDetails(ans);
			
		}
		if (e.getSource()== Adm) {	
			status.dispose();
			placer(Sname,srollno,GradeMark,degree);
		}
		if (e.getSource()== Biz) {
			int num = rows("Business Studies");
			if(num>-1) {
			String[][] results = students(num,"Business Studies");
//			System.out.println(results);
			if(results!=null) {
				title.setBounds(100, 100, 400, 40);
				CBiz();
				displayStudents(num,results);
			}
//			else
//				System.err.print("Could not retrieve records");
			}
//			else
//				System.err.print("Could not retrieve record count");
//		
		}
		if (e.getSource()== Global) { 
			int num = rows("Global Challenges");
			if(num>-1) {
			String[][] results = students(num,"Global Challenges");
//			System.out.println(results);
			if(results!=null) {
				title.setBounds(100, 100, 400, 40);
				CGlobal();
				displayStudents(num,results);
			}
//			else
//				System.err.print("Could not retrieve records");
			}
//			else
//				System.err.print("Could not retrieve record count");
		
			
		}
		if (e.getSource()== CompSci) {
			int num = rows("Computer Science");
			if(num>-1) {
			String[][] results = students(num,"Computer Science");
//			System.out.println(results);
			if(results!=null) {
				title.setBounds(100, 100, 400, 40);
				CCompSci();
				displayStudents(num,results);
			}
//			else
//				System.err.print("Could not retrieve records");
			}
			
		}
	}
}
