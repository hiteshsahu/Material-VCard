package social_handle.withprojects;

import java.util.ArrayList;

/**
 * Created by Hitesh on 15-09-2016.
 */
public class CollectionHandle {

    /**
     * Say somethings about your work , what drives you and what you like to do
     */
    private String introText;
    /**
     * Give Url of your Social media page
     */
    private String handleUrl;
    private ArrayList<String> listOfProjects = new ArrayList<>();

    /**
     * Use it if you have no projects
     *
     * @param introText
     * @param handleUrl
     */
    @Deprecated
    public CollectionHandle(String introText, String handleUrl) {
        this.introText = introText;
        this.handleUrl = handleUrl;
    }

    /**
     * Give your intro, url and list of projects images for slide show
     *
     * @param introText      - what you did
     * @param handleUrl      - your social media URL
     * @param listOfProjects image Urls support all image formats include Gif
     */
    public CollectionHandle(String introText, String handleUrl, ArrayList<String> listOfProjects) {
        this.introText = introText;
        this.handleUrl = handleUrl;
        this.listOfProjects = listOfProjects;
    }
}
