/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploswing01;

public class ExemploSwing01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame1 frame1 = new JFrame1();
        frame1.setSize(300, 100);
        int i=0;
        frame1.setLocation(50 * i, 50 * i);
        frame1.setVisible(true);
        for (i = 1; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            frame1.setLocation(50 * i, 20 * i);
            frame1.setSize(300+i*30, 200+i*40);
        }
       frame1.setLocationRelativeTo(null); 
    }
}
