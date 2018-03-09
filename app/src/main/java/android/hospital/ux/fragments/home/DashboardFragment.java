package android.hospital.ux.fragments.home;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hospital.R;
import android.hospital.entities.campaign.CampaignItemModel;
import android.hospital.lib.chartmarker.MyMarkerView;
import android.hospital.listeners.OnSingleClickListener;
import android.hospital.ux.adapters.CampaignReportPagerAdapter;
import android.hospital.views.loopViewPager.LoopViewPager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

/**
 * Created by logan on 06/03/2018.
 */

public class DashboardFragment extends Fragment {
    protected View view;

    //loop campaign
    protected LoopViewPager campaign_report_loop_view;
    protected PagerAdapter mPagerAdapter;
    //dot

    protected LinearLayout ll_dots;
    protected ImageView[] dots;

    //data
    protected ArrayList<CampaignItemModel> campaignReports = new ArrayList<>();

    //last 7 30 90 days
    protected TextView campaign_last_7, campaign_last_30, campaign_last_90;

    //campaign_sale_chart
    protected LineChart campaign_sale_chart;

    protected Typeface mTfLight, mTfRegular;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_dashboard, container, false);
            initView();
            initData();
        }
        return view;
    }

    protected void initView() {
        ll_dots = view.findViewById(R.id.ll_dots);
        campaign_report_loop_view = view.findViewById(R.id.campaign_report_loop_view);
        campaignReports.add(new CampaignItemModel("1", 4, 6, 10));
        campaignReports.add(new CampaignItemModel("1", 4, 6, 10));
        campaignReports.add(new CampaignItemModel("1", 4, 6, 10));
        campaignReports.add(new CampaignItemModel("1", 4, 6, 10));
        campaignReports.add(new CampaignItemModel("1", 4, 6, 10));
        mPagerAdapter = new CampaignReportPagerAdapter(getContext(), campaignReports);
        campaign_report_loop_view.setAdapter(mPagerAdapter);
        campaign_report_loop_view.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        campaign_last_7 = view.findViewById(R.id.campaign_last_7);
        campaign_last_30 = view.findViewById(R.id.campaign_last_30);
        campaign_last_90 = view.findViewById(R.id.campaign_last_90);
        campaign_last_7.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                campaign_last_7.setTextColor(getResources().getColor(R.color.white));
                campaign_last_7.setBackground(getResources().getDrawable(R.drawable.capsule_selected_background));
                campaign_last_30.setTextColor(getResources().getColor(R.color.grey));
                campaign_last_30.setBackgroundColor(getResources().getColor(R.color.transparent));
                campaign_last_90.setTextColor(getResources().getColor(R.color.grey));
                campaign_last_90.setBackgroundColor(getResources().getColor(R.color.transparent));
            }
        });
        campaign_last_30.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                campaign_last_30.setTextColor(getResources().getColor(R.color.white));
                campaign_last_30.setBackground(getResources().getDrawable(R.drawable.capsule_selected_background));
                campaign_last_7.setTextColor(getResources().getColor(R.color.grey));
                campaign_last_7.setBackgroundColor(getResources().getColor(R.color.transparent));
                campaign_last_90.setTextColor(getResources().getColor(R.color.grey));
                campaign_last_90.setBackgroundColor(getResources().getColor(R.color.transparent));
            }
        });
        campaign_last_90.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                campaign_last_90.setTextColor(getResources().getColor(R.color.white));
                campaign_last_90.setBackground(getResources().getDrawable(R.drawable.capsule_selected_background));
                campaign_last_7.setTextColor(getResources().getColor(R.color.grey));
                campaign_last_7.setBackgroundColor(getResources().getColor(R.color.transparent));
                campaign_last_30.setTextColor(getResources().getColor(R.color.grey));
                campaign_last_30.setBackgroundColor(getResources().getColor(R.color.transparent));
            }
        });
        campaign_sale_chart = view.findViewById(R.id.campaign_sale_chart);
        prepareCampaignSaleChartView();
    }

    protected void initData() {
        initActiveCampaignViewPager();
        prepareCampaignSaleChartData();

    }

    protected void initActiveCampaignViewPager() {
        addBottomDots(0);


    }

    protected void addBottomDots(int currentPage) {
        dots = new ImageView[campaignReports.size()];
        ll_dots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getContext());
            if (i != currentPage) {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.ic_dot));
            } else {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_selected));
            }
            if (i < dots.length) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_dot_space));
                ll_dots.addView(imageView);
            }
            ll_dots.addView(dots[i]);
        }
    }

    protected void prepareCampaignSaleChartView() {
        if (mTfLight == null) {
            mTfLight = Typeface.createFromAsset(getContext().getAssets(), "OpenSans-Light.ttf");
        }
        if (mTfRegular == null) {
            mTfRegular = Typeface.createFromAsset(getContext().getAssets(), "OpenSans-Regular.ttf");
        }
        campaign_sale_chart.getDescription().setEnabled(false);
        campaign_sale_chart.setTouchEnabled(true);
        campaign_sale_chart.setDragDecelerationFrictionCoef(0.9f);
        campaign_sale_chart.setDragEnabled(true);
        campaign_sale_chart.setScaleEnabled(true);
        campaign_sale_chart.setDrawGridBackground(false);
        campaign_sale_chart.setHighlightPerDragEnabled(false);
        campaign_sale_chart.setBackgroundColor(getResources().getColor(R.color.white));
        campaign_sale_chart.setViewPortOffsets(40f, 40f, 40f, 40f);

        Legend l = campaign_sale_chart.getLegend();
        l.setEnabled(false);
        XAxis xAxis = campaign_sale_chart.getXAxis();
        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(10f);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(getResources().getColor(R.color.grey));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return "Jan " + (int) (value + 1);
            }
        });

        YAxis leftAxis = campaign_sale_chart.getAxisLeft();
        leftAxis.setTypeface(mTfLight);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setAxisMaximum(60f);
        leftAxis.setYOffset(0f);
        leftAxis.setTextColor(getResources().getColor(R.color.grey));
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setDrawAxisLine(false);
        YAxis rightAxis = campaign_sale_chart.getAxisRight();
        rightAxis.setEnabled(false);
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
        mv.setChartView(campaign_sale_chart); // For bounds control
        campaign_sale_chart.setMarker(mv);

    }

    protected void prepareCampaignSaleChartData() {
        ArrayList<Entry> values = new ArrayList<Entry>();
        String test = "2018-02-02 03:00:08";
        values.add(new Entry(0, 0));
        values.add(new Entry(1, 25));
        values.add(new Entry(2, 16));
        values.add(new Entry(3, 45));
        values.add(new Entry(4, 25));
        values.add(new Entry(5, 35));
        values.add(new Entry(6, 35));
        values.add(new Entry(7, 42));
        LineDataSet set1 = new LineDataSet(values, "");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(getResources().getColor(R.color.blue_light));
        set1.setLineWidth(0.5f);
        set1.setDrawCircles(true);
        set1.setCircleRadius(2f);
        set1.setCircleColor(getResources().getColor(R.color.blue_dark_dark));
        set1.setDrawCircleHole(false);
        set1.setDrawValues(false);
        set1.setDrawFilled(true);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_blue_light);
        set1.setFillDrawable(drawable);
        set1.setHighLightColor(getResources().getColor(R.color.transparent));
        LineData data = new LineData(set1);
        data.setValueTextColor(getResources().getColor(R.color.grey));
        data.setValueTextSize(9f);
        campaign_sale_chart.setData(data);
        campaign_sale_chart.invalidate();
    }
}
