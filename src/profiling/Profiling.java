/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package profiling;

/**
 *
 * @author Konoe
 */
public class Profiling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Splash splash = new Splash();
        splash.setVisible(true);
        
        try {
            for(int i = 0; i <= 100; ++i) {
                Thread.sleep(60);
                splash.percentageSplash.setText(Integer.toString(i)+"%");
                splash.progressSplashBar.setValue(i);

                
                if(i == 100) {
                    splash.dispose();
                    Login login = new Login();
                    login.setVisible(true);
                }
            }
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
