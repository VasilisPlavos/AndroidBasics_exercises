package com.example.android.miwok;

public class Word {


    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    // this constructor contains image
    public Word(String defaultTranslation, String miwokTranslation, int ImageResourceId, int AudioResourceId){
        mImageResourceId = ImageResourceId;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = AudioResourceId;

    }

    // this constructor does not contain image
    public Word(String defaultTranslation, String miwokTranslation, int AudioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = AudioResourceId;
    }



    public int getImageResourceId() {return mImageResourceId;}

    public int getAudioResourceId(){return  mAudioResourceId;}

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }


    //Returns whether or not rhere is an image for this word.
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
