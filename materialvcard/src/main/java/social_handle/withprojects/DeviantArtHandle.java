package social_handle.withprojects;

import java.util.ArrayList;

/**
 * Created by Hitesh on 15-09-2016.
 */
public class DeviantArtHandle extends CollectionHandle {

    public DeviantArtHandle(String introText, String handleUrl) {
        super(introText, handleUrl);
    }

    public DeviantArtHandle(String introText, String handleUrl, ArrayList<String> listOfProjects) {
        super(introText, handleUrl, listOfProjects);
    }
}
