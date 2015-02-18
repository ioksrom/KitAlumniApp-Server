package edu.kit.isco.KitAlumniApp.server.dataobject;

import java.util.Calendar;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "event")
public class DataAccessEvent implements DataAccessObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "short_info", length = 500)
	private String shortInfo;
	
	@Column(name = "all_text", length = 10000)
	private String allText;

	@Column(name = "url", length = 1000)
	private String url;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Calendar date;
	
	public DataAccessEvent() {}
	public DataAccessEvent(String title, String shortInfo, String allText, String url, Calendar date) {
		this.title = title;
		this.shortInfo = shortInfo;
		this.allText = allText;
		this.url = url;
		this.date = date;
	}
	
	public long getId() {return Id;}
	public String getTitle() {return title;}
	public String getShortInfo() {return shortInfo;}
	public String getAllText() {return allText;}
	public String getUrl() {return url;}
	public Calendar getDate() {return date;}
	public void setId(long id) {Id = id;}
	public void setTitle(String title) {this.title = title;}
	public void setShortInfo(String shortInfo) {this.shortInfo = shortInfo;}
	public void setAllText(String allText) {this.allText = allText;}
	public void setUrl(String url) {this.url = url;}
	public void setDate(Calendar date) {this.date = date;}	
	
	@Override
	public String toString() {
		return new StringBuffer("ID : ").append(this.Id)
						.append(" Title : ").append(this.title)
						.append(" Short Info : ").append(this.shortInfo)
						.append(" All Text : ").append(this.allText)
						.append(" URL : ").append(this.url)
						.append(" Date : ").append(this.date.toString())
						.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DataAccessEvent other = (DataAccessEvent) obj;
		if (shortInfo == null) {
			if (other.shortInfo != null) {
				return false;
			}
		} else if (!shortInfo.equals(other.shortInfo)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		if (date == null) {
			if (other.date != null) {
				return false;
			}
		} else if (date.get(Calendar.YEAR) != other.date.get(Calendar.YEAR)
				|| date.get(Calendar.MONTH) != other.date.get(Calendar.MONTH)
				|| date.get(Calendar.DAY_OF_MONTH) != other.date.get(Calendar.DAY_OF_MONTH)) {
			return false;
		}
		return true;
	}
}
