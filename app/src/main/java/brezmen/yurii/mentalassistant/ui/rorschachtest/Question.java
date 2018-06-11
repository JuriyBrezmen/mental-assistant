package brezmen.yurii.mentalassistant.ui.rorschachtest;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;

public class Question implements Parcelable{

    public Question(@DrawableRes int pictureId) {
        this.pictureId = pictureId;
    }

    @DrawableRes
    private int pictureId;
    private WhatYouSee whatYouSee;
    private VividOrClear vividOrClear;

    // true -  образ знаходиться в русі
    private boolean isMotion;

    // true - асоціація стосується зображення загалом, false - асоціація стосується окремого фрагменту
    private boolean associationIsGeneral;

    public int getPictureId() {
        return pictureId;
    }

    public WhatYouSee getWhatYouSee() {
        return whatYouSee;
    }

    public void setWhatYouSee(WhatYouSee whatYouSee) {
        this.whatYouSee = whatYouSee;
    }

    public VividOrClear getVividOrClear() {
        return vividOrClear;
    }

    public void setVividOrClear(VividOrClear vividOrClear) {
        this.vividOrClear = vividOrClear;
    }

    public boolean isMotion() {
        return isMotion;
    }

    public void setMotion(boolean motion) {
        isMotion = motion;
    }

    public boolean isAssociationIsGeneral() {
        return associationIsGeneral;
    }

    public void setAssociationIsGeneral(boolean associationIsGeneral) {
        this.associationIsGeneral = associationIsGeneral;
    }

    /**
     * HUMAN - людські образи
     * ANIMAL - будь-які представники тваринного світу
     * THINGS - предмети неживої природи
     * FANTASTIC - інші фантастичні предмети
     */
    enum WhatYouSee {
        HUMAN, ANIMAL, THINGS, FANTASTIC
    }

    /**
     * NEITHER - образ нечітки та неяскравий
     * VIVID - образ в першу чергу яскравий
     * CLEAR - образ в першу чергу чіткий
     */
    enum VividOrClear {
        NEITHER, VIVID, CLEAR
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.pictureId);
        dest.writeInt(this.whatYouSee == null ? -1 : this.whatYouSee.ordinal());
        dest.writeInt(this.vividOrClear == null ? -1 : this.vividOrClear.ordinal());
        dest.writeByte(this.isMotion ? (byte) 1 : (byte) 0);
        dest.writeByte(this.associationIsGeneral ? (byte) 1 : (byte) 0);
    }

    protected Question(Parcel in) {
        this.pictureId = in.readInt();
        int tmpWhatYouSee = in.readInt();
        this.whatYouSee = tmpWhatYouSee == -1 ? null : WhatYouSee.values()[tmpWhatYouSee];
        int tmpVividOrClear = in.readInt();
        this.vividOrClear = tmpVividOrClear == -1 ? null : VividOrClear.values()[tmpVividOrClear];
        this.isMotion = in.readByte() != 0;
        this.associationIsGeneral = in.readByte() != 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
