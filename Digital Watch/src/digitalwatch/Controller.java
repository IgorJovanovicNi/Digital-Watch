package digitalwatch;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Controller{
    @FXML
    private TextArea textArea;
    private  String time;
    private Calendar calendar;
    private SimpleDateFormat sdf;
    private Date date;


    @FXML
    public void initialize(){
        sdf=new SimpleDateFormat("hh:mm");


        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (true){
                        calendar=Calendar.getInstance();
                        date=calendar.getTime();
                        time= sdf.format(date);

                        if (time.equals(textArea.getText())){
                            Thread.sleep(15000);
                        }else{
                            textArea.setText(time.toString());
                        }
                    }
                }catch (InterruptedException e){
                    e.getStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }).start();
    }
}
