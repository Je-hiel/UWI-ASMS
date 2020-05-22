package UserInterface;

import javax.swing.table.AbstractTableModel;
import java.util.*;
import Club.Event;

public class EventTableModel extends AbstractTableModel {
	
	private static final int EVENT_ID_COL = 0;
	private static final int EVENT_NAME_COL = 1;
	private static final int EVENT_LOCATION_COL = 2;
	private static final int EVENT_TIME_COL = 3;
	
	private String[] columnNames = { "Event ID", "Name", "Location", "Time" };
	private List<Event> events;
	
	public EventTableModel(List<Event> events) {
		this.events = events;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return events.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Event temp = events.get(row);
		
		switch(col) {
			case EVENT_ID_COL:
				return temp.getId();
			case EVENT_NAME_COL:
				return temp.getName();
			case EVENT_LOCATION_COL:
				return temp.getLocation();
			case EVENT_TIME_COL:
				return temp.getDateTime();
			default:
				return temp.getName();		
		}
	}
	
	@Override
	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

}
