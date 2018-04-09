package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="timeTest")
@Entity
public class TimeTest {
	@Id
	@GeneratedValue
	private int timeTestId;
	private Date dateTimeColumn;
	private Date timeStampColumn;
	private Date dateColumn;
	
	@Temporal(TemporalType.TIME)
	@Column
	private Date timeColumn;
	private java.sql.Timestamp sqlDateTimeColumn;
	private java.sql.Timestamp sqlTimeStampColumn;
	@Column
	@Temporal(TemporalType.DATE)
	private java.sql.Date sqlDate;
	private java.sql.Time sqlTime;
	
	public TimeTest() {
		
	}
	
	public TimeTest(Date date){
		this.dateColumn=date;
		this.timeColumn = date;
		this.timeStampColumn = date;
		this.dateTimeColumn = date;
		this.sqlDate =new java.sql.Date(date.getTime());
		this.sqlDateTimeColumn=new java.sql.Timestamp(date.getTime());
		this.sqlTime = new java.sql.Time(date.getTime());
		this.sqlTimeStampColumn =new java.sql.Timestamp(date.getTime());
		
	}
	
	
	public int getTimeTestId() {
		return timeTestId;
	}
	public void setTimeTestId(int timeTestId) {
		this.timeTestId = timeTestId;
	}
	public Date getDateTimeColumn() {
		return dateTimeColumn;
	}
	public void setDateTimeColumn(Date dateTimeColumn) {
		this.dateTimeColumn = dateTimeColumn;
	}
	public Date getTimeStampColumn() {
		return timeStampColumn;
	}
	public void setTimeStampColumn(Date timeStampColumn) {
		this.timeStampColumn = timeStampColumn;
	}
	public Date getDateColumn() {
		return dateColumn;
	}
	public void setDateColumn(Date dateColumn) {
		this.dateColumn = dateColumn;
	}
	public Date getTimeColumn() {
		return timeColumn;
	}
	public void setTimeColumn(Date timeColumn) {
		this.timeColumn = timeColumn;
	}
	public java.sql.Timestamp getSqlDateTimeColumn() {
		return sqlDateTimeColumn;
	}
	public void setSqlDateTimeColumn(java.sql.Timestamp sqlDateTimeColumn) {
		this.sqlDateTimeColumn = sqlDateTimeColumn;
	}
	public java.sql.Timestamp getSqlTimeStampColumn() {
		return sqlTimeStampColumn;
	}
	public void setSqlTimeStampColumn(java.sql.Timestamp sqlTimeStampColumn) {
		this.sqlTimeStampColumn = sqlTimeStampColumn;
	}
	public java.sql.Date getSqlDate() {
		return sqlDate;
	}
	public void setSqlDate(java.sql.Date sqlDate) {
		this.sqlDate = sqlDate;
	}
	public java.sql.Time getSqlTime() {
		return sqlTime;
	}
	public void setSqlTime(java.sql.Time sqlTime) {
		this.sqlTime = sqlTime;
	}
	
//	@Override
//	public String toString() {
//		String s = "[ "+
//	" ]";
//		return super.toString();
//	}

}
