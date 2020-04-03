package codingwithsara.com;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    private boolean table_flg = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void collapseTable(View view) {
        TableLayout table = findViewById(R.id.table);
        Button switchBtn = findViewById(R.id.switchBtn);

        // setColumnCollapsed(int columnIndex, boolean isCollapsed)
        table.setColumnCollapsed(0, table_flg);
        table.setColumnCollapsed(1, table_flg);
        table.setColumnCollapsed(2, table_flg);
        table.setColumnCollapsed(3, table_flg);
        table.setColumnCollapsed(4, table_flg);

        if (table_flg) {
            // Close
            table_flg = false;
            switchBtn.setText("coaches");
        } else {
            // Open
            table_flg = true;
            switchBtn.setText("Hide Detail");
        }

    }
}