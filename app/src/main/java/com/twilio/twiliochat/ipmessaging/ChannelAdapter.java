package com.twilio.twiliochat.ipmessaging;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.twilio.ipmessaging.Channel;
import com.twilio.twiliochat.R;

import java.util.List;

public class ChannelAdapter extends BaseAdapter {
  private LayoutInflater layoutInflater;
  private List<Channel> channels;

  public ChannelAdapter() {}

  public ChannelAdapter(Activity activity, List<Channel> channels) {
    this.layoutInflater = activity.getLayoutInflater();
    this.channels = channels;
  }

  @Override
  public int getCount() {
    return channels.size();
  }

  @Override
  public Object getItem(int position) {
    return channels.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int i, View convertView, ViewGroup viewGroup) {
    if (convertView == null) {
      int res = R.layout.channel;
      convertView = layoutInflater.inflate(res, viewGroup, false);
    }
    Channel channel = channels.get(i);
    TextView channelTextView = (TextView) convertView.findViewById(R.id.textViewChannel);
    channelTextView.setText(channel.getFriendlyName());
    return convertView;
  }
}