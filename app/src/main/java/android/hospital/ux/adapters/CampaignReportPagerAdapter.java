package android.hospital.ux.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.hospital.R;
import android.hospital.entities.campaign.CampaignItemModel;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

/**
 * Adapter handling list of product images.
 */
public class CampaignReportPagerAdapter extends PagerAdapter {

    private final Context context;
    protected Typeface mTfLight, mTfRegular;
    ArrayList<CampaignItemModel> campaignReports = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public CampaignReportPagerAdapter(Context context, ArrayList<CampaignItemModel> campaignReports) {
        this.context = context;
        this.campaignReports = campaignReports;
    }

    @Override
    public int getCount() {
        return this.campaignReports.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (layoutInflater == null)
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (mTfLight == null) {
            mTfLight = Typeface.createFromAsset(context.getAssets(), "OpenSans-Light.ttf");
        }
        if (mTfRegular == null) {
            mTfRegular = Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");
        }
        CampaignItemModel campaignItemModel = campaignReports.get(position);


        View viewLayout = layoutInflater.inflate(R.layout.list_item_campaign_cicle_report, container, false);
        PieChart mChart = viewLayout.findViewById(R.id.chart);
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);
        mChart.setDragDecelerationFrictionCoef(0.95f);
        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);
        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);
        mChart.setHoleRadius(75f);
        mChart.setDrawCenterText(false);
        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(false);
        mChart.setHighlightPerTapEnabled(false);
        mChart.setDrawEntryLabels(false);

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        entries.add(new PieEntry(40, "", context.getResources().getDrawable(R.drawable.ic_g)));
        entries.add(new PieEntry(60, "", context.getResources().getDrawable(R.drawable.ic_g)));
        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setDrawIcons(false);
        dataSet.setSliceSpace(0);
        dataSet.setValueTextColor(context.getResources().getColor(R.color.transparent));
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.parseColor("#fa0000"));
        colors.add(Color.parseColor("#22ff00"));
        dataSet.setColors(colors);
        PieData data = new PieData(dataSet);
        mChart.setData(data);
        mChart.highlightValues(null);
        Legend l = mChart.getLegend();
        l.setEnabled(false);
        mChart.invalidate();

        TextView redeemed_count = viewLayout.findViewById(R.id.redeemed_count);
        redeemed_count.setText(campaignItemModel.getRedeemed() + "");
        TextView available_count = viewLayout.findViewById(R.id.available_count);
        available_count.setText(campaignItemModel.getAvailable() + "");
        TextView sold_count = viewLayout.findViewById(R.id.sold_count);
        if (campaignItemModel.getSold().compareTo(1) > 0) {
            sold_count.setText(campaignItemModel.getSold() + " patients total");
        } else {
            sold_count.setText(campaignItemModel.getSold() + " patient total");
        }

        container.addView(viewLayout);
        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}