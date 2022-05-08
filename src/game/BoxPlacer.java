//package game;
//
//import city.cs.engine.BoxShape;
//import city.cs.engine.StaticBody;
//import org.jbox2d.common.Vec2;
//
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//public class BoxPlacer implements MouseListener {
//
//    private final GameView view;
//    private final GameLevel world;
//
//    public BoxPlacer(GameView v, GameLevel w){
//        view = v;
//        world = w;
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        Vec2 worldPas = view.viewToWorld(e.getPoint());
//
//        StaticBody box = new StaticBody(world, new BoxShape(1f,1f));
//        box.setPosition(worldPas);
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//}
