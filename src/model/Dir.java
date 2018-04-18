package model;

public enum  Dir {
    UP(-1,0),
    RIGHT(0,1),
    DOWN(1,0),
    LEFT(0,-1);

    public final int deltaLine, deltaCol;

    Dir(int dLine, int dCol){
        deltaLine=dLine;
        deltaCol=dCol;
    }

    public Dir nextPos(){
        return values()[(this.ordinal()+1)%values().length];
    }

    public static Dir randomDir(){
        int randomValue= (int) (Math.random()*3);
        return values()[randomValue];
    }

    public Dir opposite() {
        if(this.deltaLine == -1) return DOWN;
        if(this.deltaLine == 1) return UP;
        if(this.deltaCol == -1) return RIGHT;
        return LEFT;
    }
}
