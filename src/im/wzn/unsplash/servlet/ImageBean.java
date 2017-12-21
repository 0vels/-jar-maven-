package im.wzn.unsplash.servlet;

import java.util.List;

import com.google.gson.JsonObject;

public class ImageBean {

	/**
	 * Auto-generated: 2017-12-19 17:42:58
	 *
	 * @author bejson.com (i@bejson.com)
	 * @website http://www.bejson.com/java2pojo/
	 */
	

	    private String id;
	    private String created_at;
	    private String updated_at;
	    private int width;
	    private int height;
	    private String color;
	    private String description;
	    private Urls urls;
	    private List<String> categories;
	    private JsonObject links;
	    private boolean liked_by_user;
	    private int likes;
	    private JsonObject user;
	    private List<String> current_user_collections;
	    private String slug;
	    private JsonObject location;
	    private JsonObject exif;
	    private int views;
	    private int downloads;
	    public void setId(String id) {
	         this.id = id;
	     }
	     public String getId() {
	         return id;
	     }

	    public void setCreated_at(String created_at) {
	         this.created_at = created_at;
	     }
	     public String getCreated_at() {
	         return created_at;
	     }

	    public void setUpdated_at(String updated_at) {
	         this.updated_at = updated_at;
	     }
	     public String getUpdated_at() {
	         return updated_at;
	     }

	    public void setWidth(int width) {
	         this.width = width;
	     }
	     public int getWidth() {
	         return width;
	     }

	    public void setHeight(int height) {
	         this.height = height;
	     }
	     public int getHeight() {
	         return height;
	     }

	    public void setColor(String color) {
	         this.color = color;
	     }
	     public String getColor() {
	         return color;
	     }

	    public void setDescription(String description) {
	         this.description = description;
	     }
	     public String getDescription() {
	         return description;
	     }

	    public void setUrls(Urls urls) {
	         this.urls = urls;
	     }
	     public Urls getUrls() {
	         return urls;
	     }

	    public void setCategories(List<String> categories) {
	         this.categories = categories;
	     }
	     public List<String> getCategories() {
	         return categories;
	     }

	    public void setLinks(JsonObject links) {
	         this.links = links;
	     }
	     public JsonObject getLinks() {
	         return links;
	     }

	    public void setLiked_by_user(boolean liked_by_user) {
	         this.liked_by_user = liked_by_user;
	     }
	     public boolean getLiked_by_user() {
	         return liked_by_user;
	     }

	    public void setLikes(int likes) {
	         this.likes = likes;
	     }
	     public int getLikes() {
	         return likes;
	     }

	    public void setUser(JsonObject user) {
	         this.user = user;
	     }
	     public JsonObject getUser() {
	         return user;
	     }

	    public void setCurrent_user_collections(List<String> current_user_collections) {
	         this.current_user_collections = current_user_collections;
	     }
	     public List<String> getCurrent_user_collections() {
	         return current_user_collections;
	     }

	    public void setSlug(String slug) {
	         this.slug = slug;
	     }
	     public String getSlug() {
	         return slug;
	     }

	    public void setLocation(JsonObject location) {
	         this.location = location;
	     }
	     public JsonObject getLocation() {
	         return location;
	     }

	    public void setExif(JsonObject exif) {
	         this.exif = exif;
	     }
	     public JsonObject getExif() {
	         return exif;
	     }

	    public void setViews(int views) {
	         this.views = views;
	     }
	     public int getViews() {
	         return views;
	     }

	    public void setDownloads(int downloads) {
	         this.downloads = downloads;
	     }
	     public int getDownloads() {
	         return downloads;
	     }

	
}
