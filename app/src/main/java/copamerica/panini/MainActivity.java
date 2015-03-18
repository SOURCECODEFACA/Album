package copamerica.panini;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimerTask task =new TimerTask() {
            @Override
            public void run() {

                Intent t = new Intent(MainActivity.this,Laminas.class);
                startActivity(t);

                finish();

            }
        };

        Timer timer = new Timer();
        timer.schedule(task,3000);
    }

}
