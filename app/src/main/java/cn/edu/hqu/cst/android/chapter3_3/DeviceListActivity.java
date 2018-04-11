package cn.edu.hqu.cst.android.chapter3_3;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/3/29.
 */

public class DeviceListActivity extends ExpandableListActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            int[] logos = new int[]{
                    R.drawable.ic_computer_black_24dp,
                    R.drawable.ic_phone_android_black_24dp,
                    R.drawable.ic_speaker_black_24dp
            };
            private String[] DeviceTypes = new String[]{
                    "计算机",
                    "移动终端",
                    "外设"
            };
            private String[][] Devices = new String[][]{
                    {"笔记本", "台式机", "大型服务器"},
                    {"手机", "平板", "智能手表"},
                    {"键盘", "鼠标", "喇叭"}
            };

            @Override
            public int getGroupCount() {
                return DeviceTypes.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return Devices[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return DeviceTypes[i];
            }

            @Override
            public Object getChild(int i, int i1) {
                return Devices[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup viewGroup) {
                LinearLayout linearLayout = new LinearLayout(DeviceListActivity.this);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(DeviceListActivity.this);
                logo.setImageResource(logos[groupPosition]);
                linearLayout.addView(logo);
                TextView txtView = getTextView();
                txtView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(txtView);
                return linearLayout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
                TextView txtView = getTextView();
                txtView.setText(getChild(groupPosition, childPosition).toString());
                return txtView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }

            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(DeviceListActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;

            }
        };
        setListAdapter(adapter);
    }
}
