package model;

public class GeneratedId {
    public static Long ReaderId = 0L;
    public static Long BookId = 0L;
    public static Long LibraryId = 0L;
    public static Long getReaderId(){
        return  ++ReaderId;
    }
    public static Long getBookId(){
        return  ++BookId;
    }
    public static Long getLibraryId(){
        return  ++LibraryId;
    }

}
