import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class RadioButtonCheck {
    private Button button;
    private Label label;
    private Text text;
    private Group group;

    public Group getGroup() {
        return group;
    }

    RadioButtonCheck(Display display, Shell shell){

         group = new Group(shell, SWT.NONE);
        group.setLayoutData(new GridData(SWT.HORIZONTAL, SWT.HORIZONTAL, true, true));
        group.setLayout(new GridLayout(2, true));
        group.setText("Group3");

        label = new Label(group, SWT.NONE);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        label.setText("Your Text: ");
        display.update();


        // Text
        text = new Text(group, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        text.setText("");
        display.update();

        button = new Button(group,SWT.NONE);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button.setText("Enter:");
        display.update();

        Group radioButtonGroup = new Group(group, SWT.NONE);
        radioButtonGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        radioButtonGroup.setLayout(new RowLayout(SWT.HORIZONTAL));
        radioButtonGroup.setText("Chose");

        Button radioButton1 = new Button(radioButtonGroup, SWT.RADIO);
        radioButton1.setText("First");

        Button radioButton2 = new Button(radioButtonGroup, SWT.RADIO);
        radioButton2.setText("Second");

        Button radioButton3 = new Button(radioButtonGroup, SWT.RADIO);
        radioButton3.setText("Third");




        button.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                if(text.getText().equals(radioButton1.getText())){
                    radioButton1.setSelection(true);
                    radioButton2.setSelection(false);
                    radioButton3.setSelection(false);
                    display.update();
                }else{
                    if(text.getText().equals(radioButton2.getText())){
                    radioButton1.setSelection(false);
                    radioButton2.setSelection(true);
                    radioButton3.setSelection(false);
                        display.update();
                }else{
                        if(text.getText().equals(radioButton3.getText())){
                            radioButton1.setSelection(false);
                            radioButton2.setSelection(false);
                            radioButton3.setSelection(true);
                            display.update();
                        }else{
                            MessageBox messageBox = new MessageBox(shell,SWT.CANCEL);
                            messageBox.setMessage("Error");
                            messageBox.setText("Something went wrong");
                            int response = messageBox.open();
                            display.update();
                        }
                    }}

            }

        });
    }
}
