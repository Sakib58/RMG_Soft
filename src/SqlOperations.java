import java.sql.*;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
public class SqlOperations {
	Connection conn;
	public SqlOperations(){
		conn=SqliteConnection.dbConnector();
	}
	public void createAllTable() {
		String query6="PRAGMA foreign_keys = ON;";
		String query="drop table employeeInfo;";
		String query5="drop table basicInfo;";
		String query1="create table if not exists basicInfo(grade int primary key,BS int,MA int,CA int,FA int,MoneyPerOTH int,mxLeavePY int);";
		String query2="create table if not exists employeeInfo(e_id integer primary key AUTOINCREMENT,name varchar2(50),mobile varchar2(20),nid varchar2(20),address varchar2(50),grade int(1), foreign key(grade) references basicInfo(grade));";
		String query3="create table if not exists leaveInfo(e_id integer,total_leave int,date date,foreign key(e_id) references employeeInfo(e_id));";
		String query4="create table if not exists OvertimeInfo(e_id integer,total_overtime int,date date,foreign key(e_id) references employeeInfo(e_id));";
		
		
		try {
			Statement st=conn.createStatement();
			st.executeUpdate(query6);
			//st.executeUpdate(query);
			//st.executeUpdate(query5);
			st.executeUpdate(query1);
			st.executeUpdate(query2);
			st.executeUpdate(query3);
			st.executeUpdate(query4);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void addNewEmployee(String name,String mobile,String nid,String address,int grade) {
		String query="insert into employeeInfo('name','mobile','nid','address','grade') values ('"+name+"','"+mobile+"','"+nid+"','"+address+"','"+String.valueOf(grade)+"');";
		try {
			Statement st=conn.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Added Successful");
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void setSalaryInfo(int grade, int bs, int ma, int ca, int fa, int moh,int mlpy) {
		String query="insert into basicInfo values('"+String.valueOf(grade)+"','"+String.valueOf(bs)+"','"+String.valueOf(ma)+"','"+String.valueOf(ca)+"','"+String.valueOf(fa)+"','"+String.valueOf(moh)+"','"+String.valueOf(mlpy)+"');";
		try {
			Statement st=conn.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Save successful");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	public void removeEmployee(String eid) {
		String query="delete from employeeInfo where e_id="+String.valueOf(eid)+";";
		try {
			Statement st=conn.createStatement();
			st.execute(query);
			JOptionPane.showMessageDialog(null, "Remove successful");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	public void setOvertimeHour(int e_id, int oth) {
		String query="insert into OvertimeInfo values('"+String.valueOf(e_id)+"','"+String.valueOf(oth)+"',date('now'));";
		Statement st;
		try {
			st = conn.createStatement();
			st.execute(query);
			JOptionPane.showMessageDialog(null, "Save Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
	public int getOnesSalary(int e_id) {
		int bs=0,ma=0,ca=0,fa=0,oth=0,otr=0,grade=0;
		String query1="select grade from employeeInfo where e_id="+String.valueOf(e_id)+";";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query1);
			while (rs.next()) {
				grade=rs.getInt("grade");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		String query2="select * from basicInfo where grade="+String.valueOf(grade)+";";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query2);
			while (rs.next()) {
				bs=rs.getInt("BS");
				ma=rs.getInt("MA");
				ca=rs.getInt("CA");
				fa=rs.getInt("FA");
				otr=rs.getInt("MoneyPerOTH");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		String query3 = "select sum(total_overtime) from overtimeInfo where e_id="+String.valueOf(e_id)+";";
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query3);
			while (rs.next()) {
				oth=rs.getInt("sum(total_overtime)");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		int total_salary=bs+(bs/2)+ma+ca+fa+(oth*otr);
		return total_salary;
	}
	public void getAllSalary() {
		try{
		    FileWriter myObj = new FileWriter("D:\\5th Semester\\Design project\\data\\allSalary.txt");
		    myObj.write("Serial    ID    Name          Salary\n");
		    int salary=0,e_id=0;
		    String name=null,sSerial=null,sEid=null,sSalary;
		    String query1="select e_id,name from employeeInfo;";
		    try {
		    	Statement st=conn.createStatement();
		    	ResultSet rs=st.executeQuery(query1);
		    	int i=0;
		    	while(rs.next()) {
		    		i++;
		    		name=rs.getString("name");
		    		e_id=rs.getInt("e_id");
		    		salary=getOnesSalary(e_id);
		    		sSerial=String.format("%-8s", String.valueOf(i)).replace(' ', ' ');
		    		sEid=String.format("%-5s", String.valueOf(e_id)).replace(' ', ' ');
		    		name=String.format("%-15s", name).replace(' ', ' ');
		    		sSalary=String.format("%-15s", String.valueOf(salary)).replace(' ', ' ');
		    		String line="   "+sSerial+sEid+name+sSalary+"\n";
		    		myObj.write(line);
		    	}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		    myObj.close();
		    JOptionPane.showMessageDialog(null, "File Location: D:\\5th Semester\\Design project\\data");
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	public String setLeave(int e_id, int leaveDays) {
		int mlpy=0,totalLeave=0,grade=0;
		String query="select grade from employeeInfo where e_id="+e_id;
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query);
			while (rs.next()) {
				grade=rs.getInt("grade");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		String query2="select mxLeavePY from basicInfo where grade="+grade;
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query2);
			while (rs.next()) {
				mlpy=rs.getInt("mxLeavePY");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		String query3="select sum(total_leave) from leaveInfo where e_id="+e_id;
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(query3);
			while (rs.next()) {
				totalLeave=rs.getInt("sum(total_leave)");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		if (totalLeave+leaveDays<=mlpy) {
			String query4="insert into leaveInfo values("+e_id+","+leaveDays+",date('now'));";
			try {
				Statement st=conn.createStatement();
				st.executeUpdate(query4);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
			String res="Leave successful! He/She can take "+(mlpy-totalLeave-leaveDays)+" more days";
			return res;
		}
		else {
			String res="Leave unsuccessful! He/She can take maximum "+(mlpy-totalLeave)+" days";
			return res;
		}
		
		
	}
	public void getAllEmployeeInfo() {
		try{
		    FileWriter myObj = new FileWriter("D:\\5th Semester\\Design project\\data\\allEmployee.txt");
		    myObj.write("Serial     ID   Name           Phone          NID          Grade\n");
		    String name=null,phone=null,nid=null;
		    int e_id=0,grade=0;
		    String sSerial=null,sEid=null,sGrade=null;
		    String query1="select e_id,name,mobile,nid,grade from employeeInfo;";
		    try {
		    	Statement st=conn.createStatement();
		    	ResultSet rs=st.executeQuery(query1);
		    	int i=0;
		    	while(rs.next()) {
		    		i++;
		    		name=rs.getString("name");
		    		e_id=rs.getInt("e_id");
		    		phone=rs.getString("mobile");
		    		nid=rs.getString("nid");
		    		grade=rs.getInt("grade");
		    		sSerial=String.format("%-8s", String.valueOf(i)).replace(' ', ' ');
		    		sEid=String.format("%-5s", String.valueOf(e_id)).replace(' ', ' ');
		    		name=String.format("%-15s", name).replace(' ', ' ');
		    		phone=String.format("%-15s", phone).replace(' ', ' ');
		    		nid=String.format("%-15s", nid).replace(' ', ' ');
		    		sGrade=String.format("%-10s", String.valueOf(grade)).replace(' ', ' ');
		    		String line="   "+sSerial+sEid+name+phone+nid+sGrade+"\n";
		    		myObj.write(line);
		    	}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }
		    myObj.close();
		    JOptionPane.showMessageDialog(null, "File Location: D:\\5th Semester\\Design project\\data");
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
