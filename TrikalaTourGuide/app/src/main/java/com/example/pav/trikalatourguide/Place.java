package com.example.pav.trikalatourguide;

public class Place {

    private int mPlaceTitleId;

    private int mPlaceDescriptionId;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;


    // Constructor with image

    public Place(int placeTitleId, int placeDescriptionId, int  imageResourceId){
        mPlaceTitleId = placeTitleId;
        mPlaceDescriptionId = placeDescriptionId;
        mImageResourceId = imageResourceId;
    }


    // Constructor with no image

    public Place(int placeTitleId, int placeDescriptionId){
        mPlaceTitleId = placeTitleId;
        mPlaceDescriptionId = placeDescriptionId;
    }


    // Getters

    public int getPlaceTitleId(){
        return mPlaceTitleId;
    }

    public int getPlaceDescriptionId(){
        return mPlaceDescriptionId;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }


    // Return if there is image for this word

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }




}
