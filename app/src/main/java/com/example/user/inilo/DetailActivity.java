package com.example.user.inilo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ACCOUNT = "extra_account";

    ImageView ivDetail;
    TextView tvUserNameDetail;
    TextView tvIdDetail;
    TextView tvFollowerDetail;
    TextView tvFollowingDetail;
    TextView tvProjectDetail;
    TextView tvCompanyDetail;
    TextView tvLocationDetail;

    String receiveDataUsername;
    String receiveDataId;
    String receiveDataCompany;
    String receiveDataLocation;
    Integer receiveDataImage;
    Integer receiveDataFollower;
    Integer receiveDataFollowing;
    Integer receiveDataProject;

    RecyclerView rclistproject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivDetail = findViewById(R.id.ivPPDetail);
        tvUserNameDetail = findViewById(R.id.tvUsernameDetail);
        tvIdDetail = findViewById(R.id.tvIdDetail);
        tvFollowerDetail = findViewById(R.id.tvFollowerDetail);
        tvFollowingDetail = findViewById(R.id.tvFollowingDetail);
        tvProjectDetail = findViewById(R.id.tvProjectDetail);
        tvCompanyDetail = findViewById(R.id.tvCompanyDetail);
        tvLocationDetail = findViewById(R.id.tvLocationDetail);

        getData();
        setData();

        rclistproject = findViewById(R.id.rcListProject);

        MyAdapterListDetail myAdapterListDetail = new MyAdapterListDetail(this, DataUser.projectNameArray, DataUser.projectDetailArray, DataUser.projectLangArray, DataUser.projectUpdateArray );
        rclistproject.setAdapter(myAdapterListDetail);
        rclistproject.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getData(){
        try {
            Account account = getIntent().getParcelableExtra(EXTRA_ACCOUNT);
            receiveDataUsername = account.getUsername();
            receiveDataId = account.getId();
            receiveDataImage = account.getImg();
            receiveDataFollower = account.getFollower();
            receiveDataFollowing = account.getFollowing();
            receiveDataProject = account.getProject();
            receiveDataCompany = account.getCompany();
            receiveDataLocation = account.getLocation();
        }
        catch(Exception e) {
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        ivDetail.setImageResource(receiveDataImage);
        tvUserNameDetail.setText(receiveDataUsername);
        tvIdDetail.setText(receiveDataId);
        tvFollowerDetail.setText(String.valueOf(receiveDataFollower));
        tvFollowingDetail.setText(String.valueOf(receiveDataFollowing));
        tvProjectDetail.setText(String.valueOf(receiveDataProject));
        tvCompanyDetail.setText(receiveDataCompany);
        tvLocationDetail.setText(receiveDataLocation);
    }
}