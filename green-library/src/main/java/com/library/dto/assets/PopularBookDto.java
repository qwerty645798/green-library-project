package com.library.dto.assets;

public class PopularBookDto {

	private int book_id;
	private String img;
	private String title;
    private String authorName;
    private String publisherName;
    private String availability;
    
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "PopularBookDto [book_id=" + book_id + ", img=" + img + ", title=" + title + ", authorName=" + authorName
				+ ", publisherName=" + publisherName + ", availability=" + availability + "]";
	}
    
	
}
