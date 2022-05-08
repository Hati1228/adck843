///*package game;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ControlPanel {
//    private JPanel mainPanel;
//    private JButton startButton;
//    private JLabel ControlPanel;
//    private JButton pauseButton;
//    private JButton quitButton;
//
//    private GameLevel currentLevel;
//    private final Game game;
//    private GameView view;
//
//    public ControlPanel(Game game, GameView view) {
//        this.game = game;
//
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                game.start();
//            }
//        });
//
//        pauseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentLevel.stop();
//            }
//        });
//
//        quitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//
//    }
//
//    public JPanel getMainPanel() {
//        return mainPanel;
//    }
//
//}
//*/

package game;

        import javax.swing.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class ControlPanel {
    public JPanel mainPanel;
    private JButton quitButton;
    private JButton muteButton;
    private JButton nextLevelButton;
    private Game game;

   // private PlayerController controller;

    //private final Game game;
    //private GameView view;

    public ControlPanel(Game game){
        this.game = game;

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        muteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.gameMusic.pause();

            }
        });
        nextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.goToNextLevel();

            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
