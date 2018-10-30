package com.example.developer.ziptown.models.forms;

import com.example.developer.ziptown.models.baseClasses.BasePost;

public class CreateRequest extends BasePost{

    private String URL = "";
    public CreateRequest(String city, String contact, String postType, String publisherId, String publisher,
                         String returnTime, String destination, String days, String origin, String depatureTime ){
        super(city, contact, postType, publisherId, publisher, returnTime, destination, days, origin, depatureTime);
    }

    @Override
    public String getCity() {
        return super.getCity();
    }

    @Override
    public String getContact() {
        return super.getContact();
    }

    @Override
    public String getReturnTime() {
        return super.getReturnTime();
    }

    @Override
    public String getPublisherId() {
        return super.getPublisherId();
    }

    @Override
    public String getPublisher() {
        return super.getPublisher();
    }

    @Override
    public String getPostType() {
        return super.getPostType();
    }

    @Override
    public String getOrigin() {
        return super.getOrigin();
    }

    @Override
    public String getDestination() {
        return super.getDestination();
    }

    @Override
    public String getDepatureTime() {
        return super.getDepatureTime();
    }

    @Override
    public String getDays() {
        return super.getDays();
    }
    @Override
    public void setDestination(String destination) {
        super.setDestination(destination);
    }

    @Override
    public void setReturnTime(String returnTime) {
        super.setReturnTime(returnTime);
    }

    @Override
    public void setPublisherId(String publisherId) {
        super.setPublisherId(publisherId);
    }

    @Override
    public void setPublisher(String publisher) {
        super.setPublisher(publisher);
    }

    @Override
    public void setPostType(String postType) {
        super.setPostType(postType);
    }

    @Override
    public void setOrigin(String origin) {
        super.setOrigin(origin);
    }

    @Override
    public void setDepatureTime(String depatureTime) {
        super.setDepatureTime(depatureTime);
    }

    @Override
    public void setDays(String days) {
        super.setDays(days);
    }

    @Override
    public void setContact(String contact) {
        super.setContact(contact);
    }

    @Override
    public void setCity(String city) {
        super.setCity(city);
    }

    public String getURL() {
        return URL;
    }


}