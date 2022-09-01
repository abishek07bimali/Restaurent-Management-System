package view;

import java.awt.*;
import java.net.URL;

public class For_link {
    public void gitLink_frame(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/softwarica-github/st4009cem-cw-31a-group1").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void youTubeLink_frame(){
        try {
            Desktop.getDesktop().browse(new URL("https://youtu.be/9SV0d70PD00").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
