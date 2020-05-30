import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class HotKey {
    private int time = 500;
    private Runnable timer;

    private int first = 0;
    private int second = 1;

    HotKey(Display display, Shell shell, ArrayList<Group> groups) {

        Menu menuBar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menuBar);

        MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
        fileItem.setText("File");

        MenuItem editItem = new MenuItem(menuBar, SWT.CASCADE);
        editItem.setText("Edit");

        Menu submenu = new Menu(shell, SWT.DROP_DOWN);
        fileItem.setMenu(submenu);

        MenuItem item = new MenuItem(submenu, SWT.PUSH);
        item.setText("Start\tCtrl+R");
        item.setAccelerator(SWT.MOD1 + 'R');
        item.addListener(SWT.Selection, new Listener() {


            @Override
            public void handleEvent(Event e) {
                timer = new Runnable() {
                    @Override
                    public void run() {

                        Point firstpoint = new Point(0,0);
                        firstpoint = groups.get(0).getLocation();
                        for (int i = 0; i< groups.size(); i++){
                            if(i == 4){
                                groups.get(4).setLocation(firstpoint);
                                display.update();
                            }else{
                                groups.get(i).setLocation(groups.get(i+1).getLocation());
                                display.update();
                            }

                        }


                        display.timerExec(time, this);

                    }
                };

                display.timerExec(time, timer);


            }
        });
        MenuItem item2 = new MenuItem(submenu, SWT.PUSH);
        item2.setText("Stop\tCtrl+S");
        item2.setAccelerator(SWT.MOD1 + 'S');
        item2.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event e) {
                display.timerExec(-1, timer);
            }
        });
    }
}
