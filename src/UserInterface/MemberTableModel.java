package UserInterface;

import javax.swing.table.AbstractTableModel;
import java.util.*;
import Club.Member;

public class MemberTableModel extends AbstractTableModel {
	
	private static final int MEMBER_ID_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int LAST_NAME_COL = 2;
	private static final int EMAIL_COL = 3;
	private static final int MAJOR_COL = 4;
	private static final int STATUS_COL = 5;
	
	private String[] columnNames = { "Member ID", "First Name", "Last Name", "Email", "Major", "Status" };
	private List<Member> members;
	
	public MemberTableModel(List<Member> members) {
		this.members = members;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return members.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Member temp = members.get(row);
		
		switch(col) {
			case MEMBER_ID_COL:
				return temp.getId();
			case FIRST_NAME_COL:
				return temp.getFirstName();
			case LAST_NAME_COL:
				return temp.getLastName();
			case EMAIL_COL:
				return temp.getEmail();
			case MAJOR_COL:
				return temp.getMajor();
			case STATUS_COL:
				return temp.getStatus();
			default:
				return temp.getLastName();
		}
	}
	
	@Override
	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

}
